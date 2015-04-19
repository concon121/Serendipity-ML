package uk.co.cbray.msc.ml4j.model;

import uk.co.cbray.msc.ml4j.api.Classifier;

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
