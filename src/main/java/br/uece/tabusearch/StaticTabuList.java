package br.uece.tabusearch;

import java.util.Iterator;

import org.apache.commons.collections4.queue.CircularFifoQueue;

/**
 * Basic fixed size implementation of {@link TabuList}
 * @author Alex Ferreira
 *
 */
public final class StaticTabuList implements TabuList {
	
	private CircularFifoQueue<Solution> tabuList;
	
	/**
	 * Construct a new {@link StaticTabuList}
	 * @param size the size of the tabu list
	 */
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

	/**
	 * This method does not perform any update in the tabu list,
	 * due to the fixed size nature of this implementation
	 */
	@Override
	public void updateSize(Integer currentIteration, Solution bestSolutionFound) {
		//Do nothing, this implementation has a fixed size
	}

}
