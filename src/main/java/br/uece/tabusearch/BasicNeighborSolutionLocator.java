package br.uece.tabusearch;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

/**
 * Basic implementation of {@link BasicNeighborSolutionLocator}, that doensn't have any Aspiration Criteria
 * and simply returns the non-tabu {@link Solution} with the lowest value.
 * 
 * @author Alex Ferreira
 *
 */
public class BasicNeighborSolutionLocator implements BestNeighborSolutionLocator {

	/**
	 * Find the non-tabu {@link Solution} with the lowest value.<br>
	 * This method doesn't use any Aspiration Criteria.
	 */
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
