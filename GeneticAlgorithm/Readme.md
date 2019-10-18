
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
