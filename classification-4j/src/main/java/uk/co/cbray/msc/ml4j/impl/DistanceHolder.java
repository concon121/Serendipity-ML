package uk.co.cbray.msc.ml4j.impl;

import uk.co.cbray.msc.ml4j.api.Instance;

public class DistanceHolder implements Comparable<DistanceHolder>{
	
	private Instance instance;
	private int distance;
	
	public DistanceHolder() {
		
	}
	
	public DistanceHolder(Instance instance, int distance) {
		this.instance = instance;
		this.distance = distance;
	}
	
	/**
	 * @return the instance
	 */
	public Instance getInstance() {
		return instance;
	}
	/**
	 * @param instance the instance to set
	 */
	public void setInstance(Instance instance) {
		this.instance = instance;
	}
	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int compareTo(DistanceHolder other) {
		
		if (this.distance == other.distance) {
			return 0;
		} else if (this.distance < other.distance) {
			return -1;
		} else {
			return 1;
		}
		
	}
	
}
