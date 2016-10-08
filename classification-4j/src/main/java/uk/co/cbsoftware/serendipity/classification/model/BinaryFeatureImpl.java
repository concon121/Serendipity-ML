package uk.co.cbsoftware.serendipity.classification.model;

import uk.co.cbsoftware.serendipity.classification.api.Feature;
import uk.co.cbsoftware.serendipity.classification.exceptions.InvalidArgumentException;

/**
 * BinaryFeatureImpl is an implementation of the Feature interface which
 * supports boolean values.
 * 
 * @author Connor Bray
 */
public class BinaryFeatureImpl implements Feature {

	private Boolean value;
	private String featureName;

	public BinaryFeatureImpl() {

	}

	public BinaryFeatureImpl(String featureName, Boolean value)
			throws InvalidArgumentException {
		setValue(value);
		setFeatureName(featureName);
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) throws InvalidArgumentException {
		if (value instanceof Boolean) {
			this.value = (Boolean) value;
		} else {
			throw new InvalidArgumentException(Boolean.class, value.getClass());
		}
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public int compareTo(Feature other, int dataSetSize)
			throws InvalidArgumentException {

		if (other instanceof BinaryFeatureImpl) {

			Boolean otherValue = (Boolean) other.getValue();

			if (this.value.booleanValue() == otherValue.booleanValue()) {
				return 0;
			} else {
				return 1;
			}

		} else {
			throw new InvalidArgumentException(BinaryFeatureImpl.class,
					other.getClass());
		}

	}

	public int compareValues(Feature other, int dataSetSize)
			throws InvalidArgumentException {

		if (other instanceof BinaryFeatureImpl) {

			Boolean otherValue = (Boolean) other.getValue();

			if (this.value.booleanValue() == otherValue.booleanValue()) {
				return 1;
			} else {
				return 0;
			}

		} else {
			throw new InvalidArgumentException(BinaryFeatureImpl.class,
					other.getClass());
		}

	}

}
