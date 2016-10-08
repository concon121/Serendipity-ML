package uk.co.cbsoftware.serendipity.classification.model;

import java.util.ArrayList;
import java.util.List;

import uk.co.cbsoftware.serendipity.classification.api.Classifier;
import uk.co.cbsoftware.serendipity.classification.api.Feature;
import uk.co.cbsoftware.serendipity.classification.api.Instance;

/**
 * InstanceImpl is an implementation of the Instance interface.
 * 
 * @author Connor Bray
 */
public class InstanceImpl implements Instance{
	
	private List<Feature> features;
	private Classifier classifier;
	
	public void addFeature(Feature feature) {
		
		if (features == null) {
			features = new ArrayList<Feature>();
		}
		features.add(feature);
		
	}

	public void setClassifier(Classifier classifier) {
		
		this.classifier = classifier;
		
	}
	
	public Object getClassifier() {
		
		if (classifier != null) {
			return classifier.getClassifier();
		} else {
			return null;
		}
		
		
	}
	
	public List<Feature> getFeatures() {
		
		if (features == null) {
			features = new ArrayList<Feature>();
		}
		
		return features;
		
	}
	
	public void setFeatures(List<Feature> features) {
		this.features= features;
	}

	public Feature getFeature(String name) {
		
		for (Feature feature : getFeatures()) {
			if (feature.getFeatureName().equalsIgnoreCase(name)) {
				return feature;
			}
		}
		
		return null;
	}

}
