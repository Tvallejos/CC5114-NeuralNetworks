package Excercises;

import GA.Functions.TreeGenerator;
import GA.Functions.numberFindingFitnessFunction;
import GA.Functions.symbolicRegressionFitnessFunction;
import GA.GeneticAlgorithm;
import GP.Tree.*;
import com.sun.source.tree.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class symbolicRegression {


    public static void main(String[] args) {

        IBinaryNode X2 = new MultNode(new VariableNode("x"), new VariableNode("x"));
        IBinaryNode sum = new AddNode(X2, new VariableNode("x"));
        IBinaryNode end = new SubNode(sum, new TerminalNode(3.0));

        //function is x^2 + x - 6

        GeneticAlgorithm numFindGA = new GeneticAlgorithm(500,
                new symbolicRegressionFitnessFunction(end, -10, 10),
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
                                        new TerminalNode(10.0),
                                        new TerminalNode(9.0),
                                        new TerminalNode(8.0),
                                        new TerminalNode(7.0),
                                        new TerminalNode(6.0),
                                        new TerminalNode(5.0),
                                        new TerminalNode(4.0),
                                        new TerminalNode(3.0),
                                        new TerminalNode(2.0),
                                        new TerminalNode(1.0),
                                        new TerminalNode(0.0),
                                        new TerminalNode(-10.0),
                                        new TerminalNode(-9.0),
                                        new TerminalNode(-8.0),
                                        new TerminalNode(-7.0),
                                        new TerminalNode(-6.0),
                                        new TerminalNode(-5.0),
                                        new TerminalNode(-4.0),
                                        new TerminalNode(-3.0),
                                        new TerminalNode(-2.0),
                                        new TerminalNode(-1.0),
                                        new VariableNode("x")

                                )),
                        10,
                        0.2),
                0.2,
                10000, 0);

        numFindGA.run();
    }



}
