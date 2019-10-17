package Excercises;

import GA.Allele;
import GA.Functions.wordFitnessFunction;
import GA.Functions.wordGeneGenerationFunction;
import GA.GeneticAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wordFindExcercise {
    private GeneticAlgorithm wordGA;

    @BeforeEach
    void wordExcercise() {
        String s = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        ArrayList<String> abc = new ArrayList<String>(Arrays.asList(s.split(" ")));

        wordGA = new GeneticAlgorithm(100,
                new wordFitnessFunction("helloworld"),
                new wordGeneGenerationFunction(
                        new Allele(abc), 10),
                0.2,
                1000, 0);

        wordGA.run();
    }

    @Test
    void run() {
        //uncomment line 99 at GeneticAlgorithm class to see the fitest gene at each iteration
    }
}
