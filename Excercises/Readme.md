# Homework 1

## Analysis

The Neural Network was implemented as a set of Layers which are a set of neurons,
the most dificult part was to backpropagate errors sience i had a bug and i wasted a lot of time searching for it.
I used the [dataset](https://archive.ics.uci.edu/ml/datasets/iris)
proposed on class 6 and since the output class was labeled i had to implement the one-hot enconding.
I used the argmax function of the output to predict the class of each flower.

### The error curve
![alt text](https://github.com/Tvallejos/CC5114-NeuralNetworks/blob/master/Excercises/ErrorGraph.png)

As you can see while the epoch increments the error is getting lower, this is very good, it means out Neural Network is able to learn.

### The Accuracy curve

![alt text](https://github.com/Tvallejos/CC5114-NeuralNetworks/blob/master/Excercises/AccuracyGraph.png)


This plot shows the accuracy per epoch, it increments as epoch do, this is fine and has the same meaning of the previous oue, out NN is learning.

### The Confusion Matrix

![alt text](https://github.com/Tvallejos/CC5114-NeuralNetworks/blob/master/Excercises/matplotlib-table.png)

Finally here is the confusion matrix for the last training, as you can see it just has numbers diferent than 0 on the diagonal,
happily for us it shows our NN made no miss-prediction.
