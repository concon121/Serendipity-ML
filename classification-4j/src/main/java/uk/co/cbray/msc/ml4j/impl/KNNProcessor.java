package uk.co.cbray.msc.ml4j.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.cbray.msc.ml4j.api.Feature;
import uk.co.cbray.msc.ml4j.api.Instance;
import uk.co.cbray.msc.ml4j.exceptions.InvalidArgumentException;

public class KNNProcessor {
	
	private static final Logger LOG = LoggerFactory.getLogger(KNNProcessor.class);
	
	protected static void processDataSet(List<Instance> dataSet,
			Instance unclassified, List<DistanceHolder> distances) throws InvalidArgumentException {
		
		int dataSetSize = dataSet.size();
		
		// For each instance in the data set
		for (Instance current : dataSet) {

			LOG.debug("Begin processing Instance: " + current);

			// Declare current distance
			int distance = 0;
			// For each feature in the unclassified instance
			for (Feature unclassifiedFeature : unclassified.getFeatures()) {

				LOG.debug("Begin processing Feature: " + unclassifiedFeature);

				// Get the corresponding feature from the current instance
				Feature instanceFeature = current
						.getFeature(unclassifiedFeature.getFeatureName());
				if (instanceFeature == null) {
					distance++;
				} else {
					distance += instanceFeature.compareTo(unclassifiedFeature,
							dataSetSize);
				}
				LOG.debug("Total calculated distance: " + distance);

				LOG.debug("End processing Feature: " + unclassifiedFeature);

			}

			DistanceHolder holder = new DistanceHolder(current, distance);
			distances.add(holder);

			LOG.debug("End processing Instance: " + current);

		}

	}

	protected static void collectVotes(Map<Object, Integer> classifierCount,
			List<DistanceHolder> kNN) {
		for (DistanceHolder holder : kNN) {
			Object currentClass = holder.getInstance().getClassifier();
			Integer value = 0;
			if (classifierCount.containsKey(currentClass)) {
				value = classifierCount.get(currentClass);
			}
			value++;
			classifierCount.put(currentClass, value);
		}
	}

	/**
	 * Returns the classifier which has the most votes against it.
	 * 
	 * @param classifierCount
	 * @return
	 */
	protected static Object findMostVotedClass(Map<Object, Integer> classifierCount) {

		Object votedClass = null;
		int mostVotes = -1;

		Set<Entry<Object, Integer>> entrySet = classifierCount.entrySet();

		for (Entry<Object, Integer> entry : entrySet) {
			if (entry.getValue() > mostVotes) {
				mostVotes = entry.getValue();
				votedClass = entry.getKey();
			}
		}
		return votedClass;

	}
}
