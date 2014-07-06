package br.uece.tabusearch;

import java.util.List;

import org.apache.commons.collections4.IteratorUtils;

public class TabuSearch {
	
	private TabuList tabuList;
	private StopCondition stopCondition;
	private BestNeighborSolutionLocator solutionLocator;
	
	public TabuSearch(TabuList tabuList, StopCondition stopCondition, BestNeighborSolutionLocator solutionLocator) {
		this.tabuList = tabuList;
		this.stopCondition = stopCondition;
		this.solutionLocator = solutionLocator;
	}
	
	public Solution run(Solution initialSolution) {
		Solution bestSolution = initialSolution;
		Solution currentSolution = initialSolution;
		
		Integer currentIteration = 0;
		while (!stopCondition.mustStop(++currentIteration, bestSolution)) {
			
			List<Solution> candidateNeighbors = currentSolution.getNeighbors();
			List<Solution> solutionsInTabu = IteratorUtils.toList(tabuList.iterator());
			
			Solution bestNeighborFound = solutionLocator.findBestNeighbor(candidateNeighbors, solutionsInTabu);
			if (bestNeighborFound.getValue() < bestSolution.getValue()) {
				bestSolution = bestNeighborFound;
			}
			
			currentSolution = bestNeighborFound;
			
			tabuList.add(currentSolution);
			tabuList.updateSize(currentIteration, bestSolution);
		}
		
		return bestSolution;
	}
	
}
