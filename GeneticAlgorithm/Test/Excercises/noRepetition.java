package Excercises;

import GA.Functions.TreeGenerator;
import GA.Functions.numberFindingNoRep;
import GA.GeneticAlgorithm;
import GP.Tree.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class noRepetition {
    public static void main(String[] args) {

        GeneticAlgorithm numFindGA = new GeneticAlgorithm(300,
                new numberFindingNoRep(65348, new HashMap<>()),
                new TreeGenerator(
                        //allowed func
                        new ArrayList<IBinaryNode>(
                                List.of(
                                        new AddNode(null, null),
                                        new SubNode(null, null),
                                        new MaxNode(null, null),
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
                1000, 0);

        numFindGA.run();

    }
}
