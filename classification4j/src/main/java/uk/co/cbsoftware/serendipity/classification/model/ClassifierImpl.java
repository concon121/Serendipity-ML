package uk.co.cbsoftware.serendipity.classification.model;

import uk.co.cbsoftware.serendipity.classification.api.Classifier;

/**
 * ClassifierImpl is an implementation of the Classifier interface.
 * 
 * @author Connor Bray
 */
public class ClassifierImpl implements Classifier{
	
	private Object classifier;

	public ClassifierImpl() {
		
	}
	
	public ClassifierImpl(Object classifier) {
		setClassifier(classifier);
	}
	
	public Object getClassifier() {
		return classifier;
	}

	public void setClassifier(Object classifier) {
		this.classifier = classifier;
	}
	
}
