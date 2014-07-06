package br.uece.tabusearch;

import java.util.List;

/**
 * Common interface to be implemented by the evaluators of the best neighbor generated in each
 * iteration of the tabu search algorithm. The subclasses should use an desired Aspiration Criteria
 * here, and exclude (if necessary) the solutions that were added to the tabu list.
 * 
 * @author Alex Ferreira
 *
 */
public interface BestNeighborSolutionLocator {

	/**
	 * Select the best neighbor of a given list, using an Aspiration Criteria or not
	 * @param neighborsSolutions the current algorithm iteration generated neighbors
	 * @param solutionsInTabu the solutions that are in the tabu list
	 * @return the best solution
	 */
	Solution findBestNeighbor(List<Solution> neighborsSolutions, List<Solution> solutionsInTabu);
	
}
