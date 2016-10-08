package uk.co.cbsoftware.serendipity.classification.api;

/**
 * The classifier is what the entity actually is. For example if the current
 * instance has feature NoOfLegs = 2, NoOfHands = 2, CanTalk = true, then the
 * classifier might be "Person".
 * 
 * @author Connor Bray
 */
public interface Classifier {

	public Object getClassifier();

	public void setClassifier(Object classifier);

}
