package Excercises;

import GA.Allele;
import GA.Functions.wordFitnessFunction;
import GA.Functions.wordGeneGenerationFunction;
import GA.GeneticAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class bitSecuenceExcercise {
    private GeneticAlgorithm bitGA;

    @BeforeEach
    void bitSecuenceExcercise(){
        bitGA = new GeneticAlgorithm(100,
                new wordFitnessFunction("00101010110101"),
                new wordGeneGenerationFunction(
                        new Allele(
                                new ArrayList<>(List.of("0","1"))),
                        14),
                0.2,
                100,0);

        bitGA.run();
    }

    @Test
    void run(){
        //uncomment line 99 at GeneticAlgorithm class to see the fitest gene at each iteration
    }
}
