Tabu
=========

This is a simple Java implementation of the Tabu Search metaheuristic

Content about Tabu Search:
--------
* [The author's tutorial]
* [Principles of Tabu Search]
* [Wikipedia] (don't trust them)

Basic use steps:
--------
You may want to check the Javadocs for detailed informations

1. Implement the 'Solution' interface according to the problem
2. Setup your problem instance and the initial solution
3. Setup the environment to the problem characteristcs
    1. Select (or implement) your 'StopCondition'
    2. Select (or implement) your 'TabuList'
    3. Select (but probably you'll implement) your 'BestNeighborSolutionLocator'
4. Create a new instance of 'TabuSearch' class and execute the algorithm

License
--------
MIT

[Wikipedia]:http://en.wikipedia.org/wiki/Tabu_search
[The author's tutorial]:http://pubsonline.informs.org/doi/abs/10.1287/inte.20.4.74
[Principles of Tabu Search]:http://www.uv.es/rmarti/paper/docs/ts1.pdf