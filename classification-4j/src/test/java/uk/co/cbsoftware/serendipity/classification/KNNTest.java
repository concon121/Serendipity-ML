package uk.co.cbsoftware.serendipity.classification;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import uk.co.cbsoftware.serendipity.classification.api.Instance;
import uk.co.cbsoftware.serendipity.classification.exceptions.InvalidArgumentException;
import uk.co.cbsoftware.serendipity.classification.exceptions.InvalidDataSetException;
import uk.co.cbsoftware.serendipity.classification.exceptions.InvalidInstanceException;
import uk.co.cbsoftware.serendipity.classification.testclasses.ClassifierOne;

public class KNNTest {
	
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
		
		uk.co.cbsoftware.serendipity.classification.impl.Classification4J.classify(unclassified, dataSet);
		
		assertEquals(ClassifierOne.class, unclassified.getClassifier());
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
		
		uk.co.cbsoftware.serendipity.classification.impl.Classification4J.classify(unclassified, dataSet);
		
		assertEquals(ClassifierOne.class, unclassified.getClassifier());
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
		
		uk.co.cbsoftware.serendipity.classification.impl.Classification4J.classify(unclassified, dataSet);
		
		assertEquals(ClassifierOne.class, unclassified.getClassifier());
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
		
		uk.co.cbsoftware.serendipity.classification.impl.Classification4J.classify(unclassified, dataSet);
		
		assertEquals(ClassifierOne.class, unclassified.getClassifier());
	}
	
}
