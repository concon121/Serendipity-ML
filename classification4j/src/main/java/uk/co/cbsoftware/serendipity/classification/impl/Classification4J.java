package uk.co.cbsoftware.serendipity.classification.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.cbsoftware.serendipity.classification.api.Feature;
import uk.co.cbsoftware.serendipity.classification.api.Instance;
import uk.co.cbsoftware.serendipity.classification.exceptions.InvalidArgumentException;
import uk.co.cbsoftware.serendipity.classification.exceptions.InvalidDataSetException;
import uk.co.cbsoftware.serendipity.classification.exceptions.InvalidInstanceException;
import uk.co.cbsoftware.serendipity.classification.model.ClassifierImpl;

/**
 * The Classification4J class provides static methods for classifying data. The
 * methods in this class should be considered controller methods which delegate
 * the bulk of the processing to the BayesProcessor and KNNProcessor classes.
 * 
 * @author Connor Bray
 */
public class Classification4J {

	public static final Logger LOG = LoggerFactory
			.getLogger(Classification4J.class);

	/**
	 * Allows the user to classify their instance based on the training set
	 * provided. This method uses the K nearest neighbours algorithm, which
	 * finds the top matches based on distance from the unclassified instance
	 * and then allows the K top matches to vote on the most likely
	 * classification.
	 * 
	 * @param unclassified
	 *            The instance to classify.
	 * @param dataSet
	 *            The training set.
	 * @return The classified instance.
	 * @throws InvalidInstanceException
	 * @throws InvalidDataSetException
	 * @throws InvalidArgumentException
	 */
	public static Instance classify(Instance unclassified,
			List<Instance> dataSet) throws InvalidInstanceException,
			InvalidDataSetException, InvalidArgumentException {

		LOG.trace("Starting classification of instance.");

		if (unclassified.getClassifier() != null) {
			LOG.warn("Instance was already classified.");
			throw new InvalidInstanceException(
					"Instance has already been classified.");
		}

		if (dataSet.size() == 0) {
			LOG.error("There was no instances in the provided data set.");
			throw new InvalidDataSetException(
					"The data set should contain at least one Instance.");
		}

		List<DistanceHolder> distances = new ArrayList<DistanceHolder>();

		KNNProcessor.processDataSet(dataSet, unclassified, distances);

		// Set k to 5% of the size of the data set
		BigDecimal k = new BigDecimal((dataSet.size() / 100) * 5);
		if (k.doubleValue() < 1) {
			k = new BigDecimal(1);
		}

		// Sort the distances, lowest distance first
		Collections.sort(distances);

		// Retrieve the k lowest distances and identify their class
		List<DistanceHolder> kNN = distances.subList(0, k.intValue());
		Map<Object, Integer> classifierCount = new HashMap<Object, Integer>();
		KNNProcessor.collectVotes(classifierCount, kNN);

		Object votedClass = KNNProcessor.findMostVotedClass(classifierCount);
		if (votedClass != null) {
			unclassified.setClassifier(new ClassifierImpl(votedClass));
			LOG.trace("Instance classified as: " + votedClass);
		} else {
			LOG.error("Classification returned null for expcted class.");
		}

		LOG.trace("Ending classification of instance.");

		return unclassified;

	}

	/**
	 * Allows the user to find the relative probabilities that their instance
	 * will be classified as any of the classifications in the training set.
	 * This method uses the naive bayes classification algorithm.
	 * 
	 * @param unclassified
	 *            The instance to classify.
	 * @param dataSet
	 *            The training set.
	 * @return A map containing all of the given classifications and the
	 *         calculated probabilities.
	 * @throws InvalidArgumentException
	 */
	public static Map<Object, Double> classifyWithProbabilities(
			Instance unclassified, List<Instance> dataSet)
			throws InvalidArgumentException {

		LOG.trace("Starting classification with probabilities.");

		int dataSetSize = dataSet.size();

		Map<Object, Double> probabilities = new HashMap<Object, Double>();

		Map<Object, Integer> count = BayesProcessor
				.countInstancesPerClass(dataSet);

		int totalFeatures = 0;

		Map<Object, List<Instance>> classInstances = BayesProcessor
				.sortByClass(dataSet);
		Set<Entry<Object, List<Instance>>> entrySet = classInstances.entrySet();

		Map<Object, Map<String, Integer>> countMap = new HashMap<Object, Map<String, Integer>>();

		// For each class
		for (Entry<Object, List<Instance>> entry : entrySet) {

			LOG.trace("Begin class: " + entry.getKey());

			Map<String, Integer> featureCount = new HashMap<String, Integer>();
			List<Instance> instances = entry.getValue();

			if (instances != null) {

				// for each instance
				for (Instance instance : instances) {
					LOG.trace("Begin instance: " + instance);

					// for reach feature
					for (Feature feature : instance.getFeatures()) {
						LOG.trace("Begin feature: " + feature.getFeatureName());
						Feature unclassifiedFeature = unclassified
								.getFeature(feature.getFeatureName());

						if (unclassifiedFeature != null) {

							Integer currentFeatureCount = featureCount
									.get(feature.getFeatureName());

							if (currentFeatureCount == null) {
								currentFeatureCount = 0;
							}

							currentFeatureCount += unclassifiedFeature
									.compareValues(feature, dataSetSize);
							LOG.trace(feature.getFeatureName() + ": "
									+ currentFeatureCount);
							featureCount.put(feature.getFeatureName(),
									currentFeatureCount);
							totalFeatures++;

						}

					}

				}

			}

			countMap.put(entry.getKey(), featureCount);

		}

		Set<Entry<Object, Map<String, Integer>>> countMapEntries = countMap
				.entrySet();

		for (Entry<Object, Map<String, Integer>> entry : countMapEntries) {

			double conditionalProbability = 0;

			Map<String, Integer> currentCount = entry.getValue();
			if (currentCount != null) {
				Set<Entry<String, Integer>> currentFeatureCount = currentCount
						.entrySet();
				for (Entry<String, Integer> featureEntry : currentFeatureCount) {
					conditionalProbability += ((double) featureEntry.getValue())
							/ totalFeatures;
					LOG.trace(featureEntry.getKey() + ": "
							+ featureEntry.getValue() + "/" + totalFeatures
							+ "=" + conditionalProbability);
				}
			}

			probabilities.put(entry.getKey(), conditionalProbability);

		}

		LOG.trace("Ending classification with probabilities.");

		return probabilities;
	}

}
