package uk.co.cbsoftware.serendipity.classification.api;

import uk.co.cbsoftware.serendipity.classification.exceptions.InvalidArgumentException;

/**
 * A feature describes an attribute of the entity being classified. For example,
 * if the entity is a person, then a feature may be their height or weight.
 * 
 * @author Connor Bray
 */
public interface Feature {

	public Object getValue();

	public void setValue(Object value) throws InvalidArgumentException;

	public String getFeatureName();

	public void setFeatureName(String featureName);

	public int compareTo(Feature other, int dataSetSize)
			throws InvalidArgumentException;

	public int compareValues(Feature other, int dataSize)
			throws InvalidArgumentException;

}
