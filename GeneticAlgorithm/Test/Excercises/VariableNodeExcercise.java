package Excercises;

import GA.Functions.TreeGenerator;
import GA.Functions.numberFindingFitnessFunction;
import GA.Functions.numberFindingPlusPunishFitnessFunction;
import GA.GeneticAlgorithm;
import GP.Tree.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VariableNodeExcercise {

    public static void main(String[] args) {

        HashMap<String, Double> env1 = new HashMap<>();
        HashMap<String, Double> env2 = new HashMap<>();

        env1.put("x",1.0);
        env1.put("y",2.0);
        env1.put("z",3.0);
        env1.put("a",4.0);
        env1.put("b",5.0);
        env1.put("c",6.0);


        env2.put("x",5.0);
        env2.put("y",100.0);
        env2.put("z",47.0);
        env2.put("a",83.0);
        env2.put("b",45.0);
        env2.put("c",9.0);

        ArrayList<INode> terminals = new ArrayList<>(
                List.of(
                        new VariableNode("x"),
                        new VariableNode("y"),
                        new VariableNode("z"),
                        new VariableNode("a"),
                        new VariableNode("b"),
                        new VariableNode("c"),
                        new TerminalNode(7.0),
                        new TerminalNode(8.0),
                        new TerminalNode(100.0),
                        new TerminalNode(4.0),
                        new TerminalNode(2.0)
                ));

        GeneticAlgorithm numFindGAenv1 = new GeneticAlgorithm(300,
                new numberFindingFitnessFunction(65348, env1),
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
                        terminals,
                        10,
                        0.2),
                0.2,
                1000, 0);

        GeneticAlgorithm numFindGAenv2 = new GeneticAlgorithm(300,
                new numberFindingFitnessFunction(65348, env2),
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
                        terminals,
                        10,
                        0.2),
                0.2,
                1000, 0);

        numFindGAenv1.run();
        numFindGAenv2.run();

    }

}
