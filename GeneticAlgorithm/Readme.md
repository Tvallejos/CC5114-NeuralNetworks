
# Homework 2

## Analysis

The GeneticAlgorithm was implemented with a modular approach, it has different classes with their own tasks.
Here the most important classes with their roles.
* Genetic Algorithm: control the flow process.
* Population: keep track of the individuals, the population size and to manage the GeneGenerationFunction.
* Fitness Function: give score for every individual performance.
* Selector: select the individuals for the next generation population.
* Genetic Operator: reproduce individuals making cross overs and mutations.

the most dificult part was to test the project since the genetics algorithms use a lot of random numbers and 
seeded methods call other seeded methods, so it was hard to keep track of the expected values.

Here are the asked plots that were made with the data of the word finding excercise with 'helloworld' as the solution.

### Fitness maximum, mean and minimum curve

![alt text](https://github.com/Tvallejos/CC5114-NeuralNetworks/blob/master/GeneticAlgorithm/fitnessVsIter.png)

We can tell that the three curves get high pretty quickly at the first 25 generations, and then the maximum curve get stuck
between the scores 9 and 8, it took over 250 generations to get to the solution, and we can assume that was product of a mutation.

### Configuration Heatmap

![alt text](https://github.com/Tvallejos/CC5114-NeuralNetworks/blob/master/GeneticAlgorithm/heatMap.png)

Here we have the heatmap of the configurations for the same problem, each cell contains the number of iterations
it took to the Algorithm to converge, the end condition was to reach 1000 iterations, 
and that means that the cell with that number
either didn't converge or less probably found the solution at the last iteration.

With that in count we can see that a mutation rate between 1.0 and 0.8 doesn't fit our problem since for even bigger populations it
doesnt find the solution.

In the other hand we got that for a population with less than 50 individuals the algorithm is not likely to converge,
we can say that our best configuration spectrum is with at least 300 individuals and a mutation rate with a maximum value
of 0.5

## Choosen problem: 0-1-Knapsack

I implemented the representation with the individual as bitmap of items so each gene was either a 0 or 1, with 1 to represent that the item with that index was contained in the knapsack and 0 if it wasn't <br/>
then the fitness was calculated this way: <br/>
calculate the sum of the values of the items which were carried by the individual <br/>
calculate the sum of weights that the individual carried<br/>
if the sum of weights exceeded the maximum capacity fitness score is 0 <br/>
else sum of the values<br/>

according to this the items on the bag were treated as Pairs weight,value

finnaly, excercises are located at Test/Excercises, just run the main method of the excercise to check.

# Homework 3
## Code
these parts of the code can be checked at:
* [Tree Library](https://github.com/Tvallejos/CC5114-NeuralNetworks/tree/master/GeneticAlgorithm/src/GP/Tree)
* [Random Tree Generator](https://github.com/Tvallejos/CC5114-NeuralNetworks/tree/master/GeneticAlgorithm/src/GA/Functions)
* [Genetic operators](https://github.com/Tvallejos/CC5114-NeuralNetworks/blob/master/GeneticAlgorithm/src/GA/GeneticOperators/NodeGeneticOperator.java)

## Excercises
1. Find an AST which evaluates to a number by a given set of functions and terminals, the AST can be constructed without limit of repetition.

For the following graph the number to find was 65346 set of function was {+,-,*,max(·)} and terminals were {25,7,8,100,4,2}

![alt text](https://github.com/Tvallejos/CC5114-NeuralNetworks/blob/master/GeneticAlgorithm/FitnessVsIterNumFind.png "Fitness over generation")

2. fitness
Program a fitness function which punishes bigger trees gets too big, my solution was to substract from the fitness score the cuadratic value of the depth so as the tree gets bigger it gets lesser fitness.

* these part of the code can be found at:
[Punish Depth](https://github.com/Tvallejos/CC5114-NeuralNetworks/blob/master/GeneticAlgorithm/src/GA/Functions/numberFindingPlusPunishFitnessFunction.java)

3. no repetition
This Fitness function collects all terminals used and checks if it were used more than once, if so it punishes the tree

[fitness function no repetition](https://github.com/Tvallejos/CC5114-NeuralNetworks/blob/master/GeneticAlgorithm/src/GA/Functions/numberFindingNoRep.java)

## Analysis

![alt text](https://github.com/Tvallejos/CC5114-NeuralNetworks/blob/master/GeneticAlgorithm/HeatMapNumFind.png "HeatMap GP")
from this graph there is nothing we can conclude, here isn't perceptible a pattern as it was in the GA.

