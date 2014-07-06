package br.uece.tabusearch;

/**
 * Simple implementation of {@link StopCondition} that limits the amount of performed iterations
 * @author Alex Ferreira
 *
 */
public class IterationsStopCondition implements StopCondition {

	private final Integer maxIterations;
	
	/**
	 * Construct a {@link IterationsStopCondition}
	 * @param maxIterations the amount of allowed iterations
	 */
	public IterationsStopCondition(Integer maxIterations) {
		this.maxIterations = maxIterations;
	}
	
	/**
	 * Check if the current iteration is gte than the given {@code maxIterations}
	 */
	@Override
	public Boolean mustStop(Integer currentIteration, Solution bestSolutionFound) {
		return currentIteration >= maxIterations;
	}

}
