package uk.co.cbray.msc.ml4j.api;

import java.util.List;

/**
 * An instance associates a set of features with a particular classification.
 * 
 * @author Connor Bray
 */
public interface Instance {

	public void addFeature(Feature feature);
	public void setClassifier(Classifier classifier);
	public Object getClassifier();
	public Feature getFeature(String name);
	public List<Feature> getFeatures();
	
}
