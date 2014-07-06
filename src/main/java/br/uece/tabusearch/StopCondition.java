package br.uece.tabusearch;

public interface StopCondition {
	
	Boolean mustStop(Integer currentIteration, Solution bestSolutionFound);

}
