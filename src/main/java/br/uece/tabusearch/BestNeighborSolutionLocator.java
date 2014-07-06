package br.uece.tabusearch;

import java.util.List;

public interface BestNeighborSolutionLocator {

	Solution findBestNeighbor(List<Solution> neighborsSolutions, List<Solution> solutionsInTabu);
	
}
