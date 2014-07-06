package br.uece.tabusearch;

import java.util.List;

/**
 * Common interface for tabu search solutions.<br>
 * Subclasses must use the objective function to calculate the value of the objects of this interface,
 * while the neighbors generations also must be performed here.<br>
 * The {@link #equals()} and {@link #hashCode()} methods must be overridden to ensure the algorithm
 * correctness.
 * 
 * @author Alex Ferreira
 *
 */
public interface Solution {
	
	/**
	 * Get the value of this solution.<br>
	 * Is the same value returned by the {@link Solution} objective function
	 * @return the value of this solution
	 */
	Double getValue();
	
	/**
	 * Get the neighbors of this solution
	 * @return the neighbors of this solution
	 */
	List<Solution> getNeighbors();
	
}
