package uk.co.cbray.msc.ml4j.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.cbray.msc.ml4j.api.Instance;

public class BayesProcessor {
	
	private static final Logger LOG = LoggerFactory.getLogger(BayesProcessor.class);

	protected static Map<Object, Integer> countInstancesPerClass(
			List<Instance> dataSet) {
		
		Map<Object, Integer> count = new HashMap<Object, Integer>();
		
		for (Instance i : dataSet) {
			
			Object currentClassifier = i.getClassifier();
			int c = 0;
			
			if (count.containsKey(currentClassifier)) {
				c = count.get(currentClassifier);
			}
			
			c++;
			count.put(currentClassifier, c);
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Data Set contains:");
			
			Set<Entry<Object, Integer>> entries = count.entrySet();
			
			for (Entry<Object, Integer> entry : entries) {
				LOG.debug(entry.getKey() + ": " + entry.getValue());
			}
		}
		
		return count;
	}

	protected static Map<Object, List<Instance>> sortByClass(
			List<Instance> dataSet) {
		
		Map<Object, List<Instance>> ordered = new HashMap<Object, List<Instance>>();
		
		for (Instance i : dataSet) {
			Object classifier = i.getClassifier();
			
			List<Instance> instances = ordered.get(classifier);
			
			if (instances == null) {
				instances = new ArrayList<Instance>();
			}
			
			instances.add(i);
			ordered.put(classifier, instances);
			
		}
		
		return ordered;
	}

}
