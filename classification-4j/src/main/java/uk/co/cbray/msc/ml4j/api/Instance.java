package uk.co.cbray.msc.ml4j.api;

import java.util.List;


public interface Instance {

	public void addFeature(Feature feature);
	public void setClassifier(Classifier classifier);
	public Object getClassifier();
	public Feature getFeature(String name);
	public List<Feature> getFeatures();
	
}
