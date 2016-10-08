package uk.co.cbsoftware.serendipity.classification.model;

import uk.co.cbsoftware.serendipity.classification.api.Feature;
import uk.co.cbsoftware.serendipity.classification.exceptions.InvalidArgumentException;

/**
 * LiteralFeatureImpl is an implementation of the Feature interface which
 * supports String values.
 * 
 * @author Connor Bray
 */
public class LiteralFeatureImpl implements Feature {

	private String value;
	private String featureName;

	public LiteralFeatureImpl() {

	}

	public LiteralFeatureImpl(String featureName, String value)
			throws InvalidArgumentException {
		setValue(value);
		setFeatureName(featureName);
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) throws InvalidArgumentException {
		if (value instanceof String) {
			this.value = (String) value;
		} else if (value instanceof StringBuilder) {
			StringBuilder builder = (StringBuilder) value;
			this.value = builder.toString();
		} else if (value instanceof StringBuffer) {
			StringBuffer buffer = (StringBuffer) value;
			this.value = buffer.toString();
		} else {
			throw new InvalidArgumentException(String.class, value.getClass());
		}
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public int compareTo(Feature other, int dataSetSize) throws InvalidArgumentException {
		
		if (other instanceof LiteralFeatureImpl) {

			String otherValue = (String) other.getValue();

			if (this.value.equalsIgnoreCase(otherValue)) {
				return 0;
			} else {
				return 1;
			}

		} else {
			throw new InvalidArgumentException(LiteralFeatureImpl.class, other.getClass());
		}
	}
	
	public int compareValues(Feature other, int dataSetSize) throws InvalidArgumentException {
		
		if (other instanceof LiteralFeatureImpl) {

			String otherValue = (String) other.getValue();

			if (this.value.equalsIgnoreCase(otherValue)) {
				return 1;
			} else {
				return 0;
			}

		} else {
			throw new InvalidArgumentException(LiteralFeatureImpl.class, other.getClass());
		}
	}

}
