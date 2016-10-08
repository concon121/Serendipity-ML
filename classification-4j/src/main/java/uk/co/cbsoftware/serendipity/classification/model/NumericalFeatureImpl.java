package uk.co.cbsoftware.serendipity.classification.model;

import java.math.BigDecimal;

import uk.co.cbsoftware.serendipity.classification.api.Feature;
import uk.co.cbsoftware.serendipity.classification.exceptions.InvalidArgumentException;

/**
 * NumericalFeatureImpl is an implementation of the Feature interface which
 * supports number values.
 * 
 * @author Connor Bray
 */
public class NumericalFeatureImpl implements Feature {

	private BigDecimal value;
	private String featureName;

	public NumericalFeatureImpl() {

	}

	public NumericalFeatureImpl(String featureName, BigDecimal value)
			throws InvalidArgumentException {
		setValue(value);
		setFeatureName(featureName);
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) throws InvalidArgumentException {
		if (value instanceof BigDecimal) {
			this.value = (BigDecimal) value;
		} else if (value instanceof Integer) {
			this.value = new BigDecimal((Integer) value);
		} else if (value instanceof Double) {
			this.value = new BigDecimal((Double) value);
		} else if (value instanceof Float) {
			this.value = new BigDecimal((Float) value);
		} else if (value instanceof Long) {
			this.value = new BigDecimal((Long) value);
		} else {
			throw new InvalidArgumentException(BigDecimal.class,
					value.getClass());
		}
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public int compareTo(Feature other, int dataSetSize) throws InvalidArgumentException {
		if (other instanceof NumericalFeatureImpl) {

			BigDecimal otherValue = (BigDecimal) other.getValue();
			double distance = otherValue.doubleValue() - this.value.doubleValue();
			if (distance > 0) {
				distance = distance / dataSetSize;
			}
			if (distance < 1 && distance != 0) {
				return 1;
			} else {
				return (int) distance;
			}
			
		} else {
			throw new InvalidArgumentException(NumericalFeatureImpl.class, other.getClass());
		}
	}
	
	public int compareValues(Feature other, int dataSetSize) throws InvalidArgumentException {
		if (other instanceof NumericalFeatureImpl) {

			double otherValue = ((BigDecimal)other.getValue()).doubleValue();
			double thisValue = this.value.doubleValue();
			double segment = (this.value.doubleValue() / 100) * 5;
			
			if (otherValue < thisValue + segment &&
				otherValue > thisValue - segment) {
				return 1;
			} else {
				return 0;
			}
			
		} else {
			throw new InvalidArgumentException(NumericalFeatureImpl.class, other.getClass());
		}
	}

}
