package Excercises;

import GA.Functions.TreeGenerator;
import GA.Functions.numberFindingFitnessFunction;
import GA.GeneticAlgorithm;
import GP.Tree.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivisionNode {
    private INode zeroDiv;


    public static void main(String[] args) {

        GeneticAlgorithm numFindGA = new GeneticAlgorithm(300,
                new numberFindingFitnessFunction(65348, new HashMap<>()),
                new TreeGenerator(
                        //allowed func
                        new ArrayList<IBinaryNode>(
                                List.of(
                                        new GP.Tree.DivisionNode(null, null))),
                        //terminal nodes
                        new ArrayList<>(
                                List.of(
                                        new TerminalNode(25.0),
                                        new TerminalNode(5.0),
                                        new TerminalNode(0.0)

                                )),
                        2,
                        0.2),
                0.2,
                10000, 0);

        numFindGA.run();

    }

    @BeforeEach
    void setup() {
        zeroDiv = new GP.Tree.DivisionNode(new TerminalNode(1.0), new TerminalNode(0.0));
    }

    @Test
    void zeroDivision() {
        assertThrows(ArithmeticException.class, () -> {
            zeroDiv.evaluate(new HashMap<>());
        });
    }
}
