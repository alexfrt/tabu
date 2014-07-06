package br.uece.tabusearch;

public interface TabuList extends Iterable<Solution> {
	
	void add(Solution solution);
	Boolean contains(Solution solution);
	void updateSize(Integer currentIteration, Solution bestSolutionFound);

}