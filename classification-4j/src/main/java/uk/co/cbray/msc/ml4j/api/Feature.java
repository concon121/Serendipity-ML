package uk.co.cbray.msc.ml4j.api;

import uk.co.cbray.msc.ml4j.exceptions.InvalidArgumentException;

public interface Feature {
	
	public Object getValue();
	public void setValue(Object value) throws InvalidArgumentException;
	public String getFeatureName();
	public void setFeatureName(String featureName);
	public int compareTo(Feature other, int dataSetSize) throws InvalidArgumentException;
	public int compareValues(Feature other, int dataSize) throws InvalidArgumentException;

}
