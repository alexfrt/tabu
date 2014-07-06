package br.uece.tabusearch;

import java.util.Iterator;

import org.apache.commons.collections4.queue.CircularFifoQueue;

public final class StaticTabuList implements TabuList {
	
	private CircularFifoQueue<Solution> tabuList;
	
	public StaticTabuList(Integer size) {
		this.tabuList = new CircularFifoQueue<Solution>(size);
	}

	@Override
	public void add(Solution solution) {
		tabuList.add(solution);
	}

	@Override
	public Boolean contains(Solution solution) {
		return tabuList.contains(solution);
	}
	
	@Override
	public Iterator<Solution> iterator() {
		return tabuList.iterator();
	}

	@Override
	public void updateSize(Integer currentIteration, Solution bestSolutionFound) {
		//Do nothing, this implementation has a fixed size
	}

}
