package Excercises;

import GA.Allele;
import GA.Functions.stdGeneGenerationFunction;
import GA.Functions.wordFitnessFunction;
import GA.Functions.zeroOneKnapsackFitnessFunction;
import GA.Functions.zeroOneKnapsackGeneGenerationFunction;
import GA.GeneticAlgorithm;
import GA.IGeneticAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class zeroOneKnapsackExcercise {


    public static void main(String[] args) {
        IGeneticAlgorithm knapsack;
        String s = "12,4 2,2 1,2 1,1 4,10";
        ArrayList<String> boxes = new ArrayList<String>(Arrays.asList(s.split(" ")));

        knapsack = new GeneticAlgorithm(500,
                new zeroOneKnapsackFitnessFunction(new Allele(boxes), 15),
                new zeroOneKnapsackGeneGenerationFunction(new Allele(new ArrayList<>(List.of("1", "0"))), 5),
                0.5,
                1000, 0);

        knapsack.run();
    }
}
