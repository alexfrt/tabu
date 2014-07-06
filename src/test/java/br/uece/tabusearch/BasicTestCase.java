package br.uece.tabusearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class BasicTestCase {
	
	private List<Solution> solutions;
	
	@Test
	public void runAlgorithm() {
		Solution initialSolution = solutions.get(new Random().nextInt(solutions.size()));
		
		for (int s = 5; s <= 10; s++) { //the size of the tabu list
			for (double i = 0.5; i <= 2; i += 0.5) { //the amount of iterations (50%, 100%, 150% and 200%)
				Integer maxIterations = new Double(solutions.size() * i).intValue();
				
				System.out.println(String.format("Running TS with tabu list size [%s] and [%s] iterations. Instance size [%s]", s, maxIterations, solutions.size()));
				
				TabuSearch ts = setupTS(s, maxIterations);
				Solution returnValue = ts.run(initialSolution);
			
				Integer returnedValueIndex = solutions.indexOf(returnValue);
				System.out.println(String.format("The algorithm returned a result with [%s] units of distance of the best solution", returnedValueIndex));
			}
		}
	}
	
	public TabuSearch setupTS(Integer tabuListSize, Integer iterations) {
		return new TabuSearch(new StaticTabuList(tabuListSize), new IterationsStopCondition(iterations), new BasicNeighborSolutionLocator());
	}
	
	@Before
	public void buildInstance() {
		Integer instanceSize = 1000;
		
		solutions = new ArrayList<>();
		Random random = new Random();
		
		for (int i = 0; i < instanceSize; i++) {
			Double currentValue = random.nextDouble() * instanceSize;
			
			SomeSolution solution = new SomeSolution();
			solution.neighbors = new LinkedList<>();
			solution.value = currentValue;
			
			solutions.add(solution);
		}
		
		Collections.shuffle(solutions);
		
		for (int i = 0; i < instanceSize; i++) {
			Solution solution = solutions.get(i);
			
			Integer neighborsCount = random.nextInt(7) + 3;
			
			for (int j = 0; j < neighborsCount; j++) {
				Solution randomNeighbor = solutions.get(random.nextInt(instanceSize));
				solution.getNeighbors().add(randomNeighbor);
			}
		}
		
		Collections.sort(solutions, new Comparator<Solution>() {
			@Override
			public int compare(Solution a, Solution b) {
				return a.getValue().compareTo(b.getValue());
			}
		});
	}

	private static class SomeSolution implements Solution {
		
		Double value;
		List<Solution> neighbors;

		@Override
		public Double getValue() {
			return value;
		}

		@Override
		public List<Solution> getNeighbors() {
			return neighbors;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SomeSolution other = (SomeSolution) obj;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return value.toString();
		}
		
	}
}
