package Excercises;

import GA.Allele;
import GA.Functions.wordFitnessFunction;
import GA.Functions.stdGeneGenerationFunction;
import GA.GeneticAlgorithm;
import GA.IGeneticAlgorithm;
import java.util.ArrayList;
import java.util.List;

public class bitSecuenceExcercise {
    public static void main(String[] args) {
        IGeneticAlgorithm bitGA = new GeneticAlgorithm(300,
                new wordFitnessFunction("00101010110101"),
                new stdGeneGenerationFunction(
                        new Allele(
                                new ArrayList<>(List.of("0","1"))),
                        14),
                0.2,
                100,0);

        bitGA.run();

    }
}
