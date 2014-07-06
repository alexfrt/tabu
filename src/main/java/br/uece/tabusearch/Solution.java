package br.uece.tabusearch;

import java.util.List;

public interface Solution {
	
	Double getValue();
	List<Solution> getNeighbors();
	
}
