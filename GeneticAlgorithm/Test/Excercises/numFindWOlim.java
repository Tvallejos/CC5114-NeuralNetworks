package Excercises;

import GA.Functions.TreeGenerator;
import GA.Functions.numberFindingFitnessFunction;
import GA.Functions.wordFitnessFunction;
import GA.GeneticAlgorithm;
import GA.IGeneticAlgorithm;
import GP.Tree.*;

import java.util.ArrayList;
import java.util.List;

public class numFindWOlim {
    public static void main(String[] args) {

        IGeneticAlgorithm bitGA = new GeneticAlgorithm(300,
                new numberFindingFitnessFunction(65346),
                new TreeGenerator(
                        //allowed func
                        new ArrayList<IBinaryNode>(
                                List.of(
                                        new AddNode(null, null),
                                        new SubNode(null, null),
                                        //new MaxNode(null, null),
                                        new MultNode(null, null)
                                )),
                        //terminal nodes
                        new ArrayList<>(
                                List.of(
                                        new TerminalNode(25.0),
                                        new TerminalNode(7.0),
                                        new TerminalNode(8.0),
                                        new TerminalNode(100.0),
                                        new TerminalNode(4.0),
                                        new TerminalNode(2.0)

                                )),
                        10,
                        0.2),
                0.2,
                2000, 0);

        bitGA.run();

    }
}
