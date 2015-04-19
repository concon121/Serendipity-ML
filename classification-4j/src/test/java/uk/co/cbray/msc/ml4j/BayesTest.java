package uk.co.cbray.msc.ml4j;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import uk.co.cbray.msc.ml4j.api.Instance;
import uk.co.cbray.msc.ml4j.exceptions.InvalidArgumentException;
import uk.co.cbray.msc.ml4j.exceptions.InvalidDataSetException;
import uk.co.cbray.msc.ml4j.exceptions.InvalidInstanceException;

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
		
		Map<Object, Double> probabilities = uk.co.cbray.msc.ml4j.impl.Classification4J.classifyWithProbabilities(unclassified, dataSet);
		Set<Entry<Object, Double>> entrySet = probabilities.entrySet();
		
		System.out.println("Binary: ");
		for (Entry<Object, Double> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
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
		
		Map<Object, Double> probabilities = uk.co.cbray.msc.ml4j.impl.Classification4J.classifyWithProbabilities(unclassified, dataSet);
		Set<Entry<Object, Double>> entrySet = probabilities.entrySet();
		
		System.out.println("Literal: ");
		for (Entry<Object, Double> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
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
		
		Map<Object, Double> probabilities = uk.co.cbray.msc.ml4j.impl.Classification4J.classifyWithProbabilities(unclassified, dataSet);
		Set<Entry<Object, Double>> entrySet = probabilities.entrySet();
		
		System.out.println("Number: ");
		for (Entry<Object, Double> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
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
		
		Map<Object, Double> probabilities = uk.co.cbray.msc.ml4j.impl.Classification4J.classifyWithProbabilities(unclassified, dataSet);
		Set<Entry<Object, Double>> entrySet = probabilities.entrySet();
		
		System.out.println("Mixed: ");
		for (Entry<Object, Double> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
}
