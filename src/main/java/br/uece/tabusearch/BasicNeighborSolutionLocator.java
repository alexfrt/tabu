package br.uece.tabusearch;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

public class BasicNeighborSolutionLocator implements BestNeighborSolutionLocator {

	@Override
	public Solution findBestNeighbor(List<Solution> neighborsSolutions, final List<Solution> solutionsInTabu) {
		//remove any neighbor that is in tabu list
		CollectionUtils.filterInverse(neighborsSolutions, new Predicate<Solution>() {
			@Override
			public boolean evaluate(Solution neighbor) {
				return solutionsInTabu.contains(neighbor);
			}
		});
		
		//sort the neighbors
		Collections.sort(neighborsSolutions, new Comparator<Solution>() {
			@Override
			public int compare(Solution a, Solution b) {
				return a.getValue().compareTo(b.getValue());
			}
		});
		
		//get the neighbor with lowest value
		return neighborsSolutions.get(0);
	}

}
