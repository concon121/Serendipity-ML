package uk.co.cbsoftware.serendipity.classification;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import uk.co.cbsoftware.serendipity.classification.api.Instance;
import uk.co.cbsoftware.serendipity.classification.exceptions.InvalidArgumentException;
import uk.co.cbsoftware.serendipity.classification.exceptions.InvalidDataSetException;
import uk.co.cbsoftware.serendipity.classification.exceptions.InvalidInstanceException;
import uk.co.cbsoftware.serendipity.classification.testclasses.ClassifierOne;
import uk.co.cbsoftware.serendipity.classification.testclasses.ClassifierThree;
import uk.co.cbsoftware.serendipity.classification.testclasses.ClassifierTwo;

public class BayesTest {
	
	/**
	 * Data set contains 6 instances:
	 * 		- 3 ClassifierOne
	 * 		- 2 ClassifierTwo
	 * 		- 1 ClassifierThree
	 * @throws InvalidArgumentException
	 * @throws InvalidInstanceException
	 * @throws InvalidDataSetException
	 */
	@Test
	public void testClassificationWithBooleanDataSet() throws InvalidArgumentException, InvalidInstanceException, InvalidDataSetException {
		List<Instance> dataSet = DataSetBuilder.buildBooleanSet();
		Instance unclassified = DataSetBuilder.getUnclassifiedBooleanInstance();
		
		Map<Object, Double> probabilities = uk.co.cbsoftware.serendipity.classification.impl.Classification4J.classifyWithProbabilities(unclassified, dataSet);
		Set<Entry<Object, Double>> entrySet = probabilities.entrySet();
		
		double classOne = 0;
		double classTwo = 0;
		double classThree = 0;
		
		for (Entry<Object, Double> entry : entrySet) {
			if (((Class<?>)entry.getKey()) == ClassifierOne.class) {
				classOne = entry.getValue();
			} else if (((Class<?>)entry.getKey()) == ClassifierTwo.class) {
				classTwo = entry.getValue();
			} else if (((Class<?>)entry.getKey()) == null) {
				classThree = entry.getValue();
			}
		}
		
		// cOne = 9
		// cTwo = 4
		// cThree = 1
		
		assertTrue(classOne > classTwo);
		assertTrue(classOne > classThree);
		assertTrue(classTwo > classThree);
		
	}
	
	/**
	 * Data set contains 6 instances:
	 * 		- 2 ClassifierOne
	 * 		- 3 ClassifierTwo
	 * 		- 1 ClassifierThree
	 * @throws InvalidArgumentException
	 * @throws InvalidInstanceException
	 * @throws InvalidDataSetException
	 */
	@Test
	public void testClassificationWithLiteralDataSet() throws InvalidArgumentException, InvalidInstanceException, InvalidDataSetException {
		List<Instance> dataSet = DataSetBuilder.buildLiteralSet();
		Instance unclassified = DataSetBuilder.getUnclassifiedLiteralInstance();
		
		Map<Object, Double> probabilities = uk.co.cbsoftware.serendipity.classification.impl.Classification4J.classifyWithProbabilities(unclassified, dataSet);
		Set<Entry<Object, Double>> entrySet = probabilities.entrySet();
		
		double classOne = 0;
		double classTwo = 0;
		double classThree = 0;
		
		for (Entry<Object, Double> entry : entrySet) {
			if (((Class<?>)entry.getKey()) == ClassifierOne.class) {
				classOne = entry.getValue();
			} else if (((Class<?>)entry.getKey()) == ClassifierTwo.class) {
				classTwo = entry.getValue();
			} else if (((Class<?>)entry.getKey()) == ClassifierThree.class) {
				classThree = entry.getValue();
			}
		}
		
		// cOne = 6
		// cTwo = 6
		// cThree = 1
		
		assertTrue(classTwo == classOne);
		assertTrue(classTwo > classThree);
		assertTrue(classOne > classThree);
	}
	/**
	 * Data set contains 6 instances:
	 * 		- 1 ClassifierOne
	 * 		- 2 ClassifierTwo
	 * 		- 3 ClassifierThree
	 * @throws InvalidArgumentException
	 * @throws InvalidInstanceException
	 * @throws InvalidDataSetException
	 */
	@Test
	public void testClassificationWithNumericalDataSet() throws InvalidArgumentException, InvalidInstanceException, InvalidDataSetException {
		List<Instance> dataSet = DataSetBuilder.buildNumericalSet();
		Instance unclassified = DataSetBuilder.getUnclassifiedNumericalInstance();
		
		Map<Object, Double> probabilities = uk.co.cbsoftware.serendipity.classification.impl.Classification4J.classifyWithProbabilities(unclassified, dataSet);
		Set<Entry<Object, Double>> entrySet = probabilities.entrySet();
		
		double classOne = 0;
		double classTwo = 0;
		double classThree = 0;
		
		for (Entry<Object, Double> entry : entrySet) {
			if (((Class<?>)entry.getKey()) == ClassifierOne.class) {
				classOne = entry.getValue();
			} else if (((Class<?>)entry.getKey()) == ClassifierTwo.class) {
				classTwo = entry.getValue();
			} else if (((Class<?>)entry.getKey()) == ClassifierThree.class) {
				classThree = entry.getValue();
			}
		}
		
		// cOne = 3
		// cTwo = 4
		// cThree = 3
		
		assertTrue(classTwo > classOne);
		assertTrue(classTwo > classThree);
		assertTrue(classOne == classThree);
	}
	
	/**
	 * Data set contains 6 instances:
	 * 		- 1 ClassifierOne
	 * 		- 4 ClassifierTwo
	 * 		- 0 ClassifierThree
	 * 		- 1 null
	 * @throws InvalidArgumentException
	 * @throws InvalidInstanceException
	 * @throws InvalidDataSetException
	 */
	@Test
	public void testClassificationWithMixedDataSet() throws InvalidArgumentException, InvalidInstanceException, InvalidDataSetException {
		List<Instance> dataSet = DataSetBuilder.buildMixedSet();
		Instance unclassified = DataSetBuilder.getUnclassifiedMixedInstance();
		
		Map<Object, Double> probabilities = uk.co.cbsoftware.serendipity.classification.impl.Classification4J.classifyWithProbabilities(unclassified, dataSet);
		Set<Entry<Object, Double>> entrySet = probabilities.entrySet();
		
		double classOne = 0;
		double classTwo = 0;
		double classThree = 0;
		
		for (Entry<Object, Double> entry : entrySet) {
			if (((Class<?>)entry.getKey()) == ClassifierOne.class) {
				classOne = entry.getValue();
			} else if (((Class<?>)entry.getKey()) == ClassifierTwo.class) {
				classTwo = entry.getValue();
			} else if (((Class<?>)entry.getKey()) == null) {
				classThree = entry.getValue();
			}
		}
		
		// cOne = 3
		// cTwo = 8
		// null = 2
		
		assertTrue(classTwo > classOne);
		assertTrue(classTwo > classThree);
		assertTrue(classOne > classThree);
	}
	
}
