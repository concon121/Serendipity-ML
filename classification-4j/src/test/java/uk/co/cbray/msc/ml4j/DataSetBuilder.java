package uk.co.cbray.msc.ml4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import uk.co.cbray.msc.ml4j.api.Classifier;
import uk.co.cbray.msc.ml4j.api.Feature;
import uk.co.cbray.msc.ml4j.api.Instance;
import uk.co.cbray.msc.ml4j.exceptions.InvalidArgumentException;
import uk.co.cbray.msc.ml4j.model.BinaryFeatureImpl;
import uk.co.cbray.msc.ml4j.model.ClassifierImpl;
import uk.co.cbray.msc.ml4j.model.InstanceImpl;
import uk.co.cbray.msc.ml4j.model.LiteralFeatureImpl;
import uk.co.cbray.msc.ml4j.model.NumericalFeatureImpl;
import uk.co.cbray.msc.ml4j.testclasses.ClassifierOne;
import uk.co.cbray.msc.ml4j.testclasses.ClassifierThree;
import uk.co.cbray.msc.ml4j.testclasses.ClassifierTwo;

public class DataSetBuilder {
	
	private static final String f1 = "Feature One";
	private static final String f2 = "Feature Two";
	private static final String f3 = "Feature Three";
	
	public static Instance getUnclassifiedBooleanInstance() throws InvalidArgumentException {
		
		Instance one = new InstanceImpl();
		
		Feature fOne = new BinaryFeatureImpl(f1, false);
		Feature fTwo = new BinaryFeatureImpl(f2, false);
		Feature fThree = new BinaryFeatureImpl(f3, false);
		Feature fFour = new BinaryFeatureImpl(f1, true);
		Feature fFive = new BinaryFeatureImpl(f2, true);
		Feature fSix = new BinaryFeatureImpl(f3, true);
		
		one.addFeature(fOne);
		one.addFeature(fFive);
		one.addFeature(fSix);
		
		return one;
		
	}
	
	public static List<Instance> buildBooleanSet() throws InvalidArgumentException {
		List<Instance> dataSet = new ArrayList<Instance>();
		
		Instance one = new InstanceImpl();
		Instance two = new InstanceImpl();
		Instance three = new InstanceImpl();
		Instance four = new InstanceImpl();
		Instance five = new InstanceImpl();
		Instance six = new InstanceImpl();
		
		Feature fOne = new BinaryFeatureImpl(f1, false);
		Feature fTwo = new BinaryFeatureImpl(f2, false);
		Feature fThree = new BinaryFeatureImpl(f3, false);
		Feature fFour = new BinaryFeatureImpl(f1, true);
		Feature fFive = new BinaryFeatureImpl(f2, true);
		Feature fSix = new BinaryFeatureImpl(f3, true);
		
		Classifier cOne = new ClassifierImpl(ClassifierOne.class);
		Classifier cTwo = new ClassifierImpl(ClassifierTwo.class);
		Classifier cThree = new ClassifierImpl(ClassifierThree.class);
		
		one.addFeature(fOne);
		one.addFeature(fFive);
		one.addFeature(fSix);
		one.setClassifier(cOne);
		
		two.addFeature(fOne);
		two.addFeature(fFive);
		two.addFeature(fSix);
		two.setClassifier(cOne);
		
		three.addFeature(fOne);
		three.addFeature(fFive);
		three.addFeature(fSix);
		three.setClassifier(cOne);
		
		four.addFeature(fOne);
		four.addFeature(fTwo);
		four.addFeature(fSix);
		four.setClassifier(cTwo);
		
		five.addFeature(fOne);
		five.addFeature(fTwo);
		five.addFeature(fSix);
		five.setClassifier(cTwo);
		
		six.addFeature(fOne);
		six.addFeature(fTwo);
		six.addFeature(fThree);
		six.setClassifier(cThree);
		
		dataSet.add(one);
		dataSet.add(two);
		dataSet.add(three);
		dataSet.add(four);
		dataSet.add(five);
		dataSet.add(six);
		
		return dataSet;
	}
	
	public static Instance getUnclassifiedLiteralInstance() throws InvalidArgumentException {
		
		Instance one = new InstanceImpl();
		
		Feature fOne = new LiteralFeatureImpl(f1, "One");
		Feature fTwo = new LiteralFeatureImpl(f2, "Two");
		Feature fThree = new LiteralFeatureImpl(f3, "Three");
		Feature fFour = new LiteralFeatureImpl(f1, "Four");
		Feature fFive = new LiteralFeatureImpl(f2, "Five");
		Feature fSix = new LiteralFeatureImpl(f3, "Six");
		
		one.addFeature(fOne);
		one.addFeature(fFive);
		one.addFeature(fSix);
		
		return one;
		
	}
	
	public static List<Instance> buildLiteralSet() throws InvalidArgumentException {
		List<Instance> dataSet = new ArrayList<Instance>();
		
		Instance one = new InstanceImpl();
		Instance two = new InstanceImpl();
		Instance three = new InstanceImpl();
		Instance four = new InstanceImpl();
		Instance five = new InstanceImpl();
		Instance six = new InstanceImpl();
		
		Feature fOne = new LiteralFeatureImpl(f1, "One");
		Feature fTwo = new LiteralFeatureImpl(f2, "Two");
		Feature fThree = new LiteralFeatureImpl(f3, "Three");
		Feature fFour = new LiteralFeatureImpl(f1, "Four");
		Feature fFive = new LiteralFeatureImpl(f2, "Five");
		Feature fSix = new LiteralFeatureImpl(f3, "Six");
		
		Classifier cOne = new ClassifierImpl(ClassifierOne.class);
		Classifier cTwo = new ClassifierImpl(ClassifierTwo.class);
		Classifier cThree = new ClassifierImpl(ClassifierThree.class);
		
		one.addFeature(fOne);
		one.addFeature(fFive);
		one.addFeature(fSix);
		one.setClassifier(cOne);
		
		two.addFeature(fOne);
		two.addFeature(fFive);
		two.addFeature(fSix);
		two.setClassifier(cOne);
		
		three.addFeature(fOne);
		three.addFeature(fTwo);
		three.addFeature(fSix);
		three.setClassifier(cTwo);
		
		four.addFeature(fOne);
		four.addFeature(fTwo);
		four.addFeature(fSix);
		four.setClassifier(cTwo);
		
		five.addFeature(fOne);
		five.addFeature(fTwo);
		five.addFeature(fSix);
		five.setClassifier(cTwo);
		
		six.addFeature(fOne);
		six.addFeature(fTwo);
		six.addFeature(fThree);
		six.setClassifier(cThree);
		
		dataSet.add(one);
		dataSet.add(two);
		dataSet.add(three);
		dataSet.add(four);
		dataSet.add(five);
		dataSet.add(six);
		
		return dataSet;
	}
	
	public static Instance getUnclassifiedNumericalInstance() throws InvalidArgumentException {
		
		Instance one = new InstanceImpl();
		
		Feature fOne = new NumericalFeatureImpl(f1, new BigDecimal(1));
		Feature fTwo = new NumericalFeatureImpl(f2, new BigDecimal(2));
		Feature fThree = new NumericalFeatureImpl(f3, new BigDecimal(3));
		Feature fFour = new NumericalFeatureImpl(f1, new BigDecimal(4));
		Feature fFive = new NumericalFeatureImpl(f2, new BigDecimal(5));
		Feature fSix = new NumericalFeatureImpl(f3, new BigDecimal(6));
		
		one.addFeature(fOne);
		one.addFeature(fFive);
		one.addFeature(fSix);
		
		return one;
		
	}
	
	public static List<Instance> buildNumericalSet() throws InvalidArgumentException {
		List<Instance> dataSet = new ArrayList<Instance>();
		
		Instance one = new InstanceImpl();
		Instance two = new InstanceImpl();
		Instance three = new InstanceImpl();
		Instance four = new InstanceImpl();
		Instance five = new InstanceImpl();
		Instance six = new InstanceImpl();
		
		Feature fOne = new NumericalFeatureImpl(f1, new BigDecimal(1));
		Feature fTwo = new NumericalFeatureImpl(f2, new BigDecimal(2));
		Feature fThree = new NumericalFeatureImpl(f3, new BigDecimal(3));
		Feature fFour = new NumericalFeatureImpl(f1, new BigDecimal(4));
		Feature fFive = new NumericalFeatureImpl(f2, new BigDecimal(5));
		Feature fSix = new NumericalFeatureImpl(f3, new BigDecimal(6));
		
		Classifier cOne = new ClassifierImpl(ClassifierOne.class);
		Classifier cTwo = new ClassifierImpl(ClassifierTwo.class);
		Classifier cThree = new ClassifierImpl(ClassifierThree.class);
		
		one.addFeature(fOne);
		one.addFeature(fFive);
		one.addFeature(fSix);
		one.setClassifier(cOne);
		
		two.addFeature(fOne);
		two.addFeature(fTwo);
		two.addFeature(fThree);
		two.setClassifier(cThree);
		
		three.addFeature(fOne);
		three.addFeature(fTwo);
		three.addFeature(fThree);
		three.setClassifier(cThree);
		
		four.addFeature(fOne);
		four.addFeature(fTwo);
		four.addFeature(fSix);
		four.setClassifier(cTwo);
		
		five.addFeature(fOne);
		five.addFeature(fTwo);
		five.addFeature(fSix);
		five.setClassifier(cTwo);
		
		six.addFeature(fOne);
		six.addFeature(fTwo);
		six.addFeature(fThree);
		six.setClassifier(cThree);
		
		dataSet.add(one);
		dataSet.add(two);
		dataSet.add(three);
		dataSet.add(four);
		dataSet.add(five);
		dataSet.add(six);
		
		return dataSet;
	}
	
	public static Instance getUnclassifiedMixedInstance() throws InvalidArgumentException {
		
		Instance one = new InstanceImpl();
		
		Feature fOne = new BinaryFeatureImpl(f1, false);
		Feature fTwo = new BinaryFeatureImpl(f1, true);
		Feature fThree = new LiteralFeatureImpl(f2, "Three");
		Feature fFour = new LiteralFeatureImpl(f2, "Four");
		Feature fFive = new NumericalFeatureImpl(f3, new BigDecimal(5));
		Feature fSix = new NumericalFeatureImpl(f3, new BigDecimal(6));
		
		one.addFeature(fOne);
		one.addFeature(fThree);
		one.addFeature(fSix);
		
		return one;
		
	}
	
	public static List<Instance> buildMixedSet() throws InvalidArgumentException {
		List<Instance> dataSet = new ArrayList<Instance>();
		
		Instance one = new InstanceImpl();
		Instance two = new InstanceImpl();
		Instance three = new InstanceImpl();
		Instance four = new InstanceImpl();
		Instance five = new InstanceImpl();
		Instance six = new InstanceImpl();
		
		Feature fOne = new BinaryFeatureImpl(f1, false);
		Feature fTwo = new BinaryFeatureImpl(f1, true);
		Feature fThree = new LiteralFeatureImpl(f2, "Three");
		Feature fFour = new LiteralFeatureImpl(f2, "Four");
		Feature fFive = new NumericalFeatureImpl(f3, new BigDecimal(5));
		Feature fSix = new NumericalFeatureImpl(f3, new BigDecimal(6));
		
		Classifier cOne = new ClassifierImpl(ClassifierOne.class);
		Classifier cTwo = new ClassifierImpl(ClassifierTwo.class);
		Classifier cThree = new ClassifierImpl(ClassifierThree.class);
		
		one.addFeature(fOne);
		one.addFeature(fThree);
		one.addFeature(fFive);
		one.setClassifier(cTwo);
		
		two.addFeature(fOne);
		two.addFeature(fThree);
		two.addFeature(fSix);
		two.setClassifier(cOne);
		
		three.addFeature(fOne);
		three.addFeature(fThree);
		three.addFeature(fFive);
		three.setClassifier(cTwo);
		
		four.addFeature(fOne);
		four.addFeature(fThree);
		four.addFeature(fFive);
		four.setClassifier(cTwo);
		
		five.addFeature(fOne);
		five.addFeature(fThree);
		five.addFeature(fFive);
		five.setClassifier(cTwo);
		
		six.addFeature(fOne);
		six.addFeature(fTwo);
		six.addFeature(fThree);
		six.setClassifier(null);
		
		dataSet.add(one);
		dataSet.add(two);
		dataSet.add(three);
		dataSet.add(four);
		dataSet.add(five);
		dataSet.add(six);
		
		return dataSet;
	}
	
}
