package Excercises;

import GA.Allele;
import GA.Functions.IFitnessFunction;
import GA.Functions.IGeneGenerationFunction;
import GA.Functions.wordFitnessFunction;
import GA.Functions.wordGeneGenerationFunction;
import GA.GeneticAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
        //uncomment line 99 at GeneticAlgorithm class to see the fitest individual at each iteration
    }

    /*
    // i used this chunk of code to get the data for the heatmap
    @Test
    void heatMapData() {
        String s = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        ArrayList<String> abc = new ArrayList<String>(Arrays.asList(s.split(" ")));
        IFitnessFunction fitnessFunction = new wordFitnessFunction("helloworld");
        IGeneGenerationFunction geneGenerationFunction = new wordGeneGenerationFunction(
                new Allele(abc), 10);
        int maxIter = 1000;
        ArrayList<Integer> iterSol = new ArrayList<>();

        for (Double mutationRate = 1.0; mutationRate > 0; mutationRate -= 0.1) {
            for (int population = 50; population <= 1000; population += 50) {
                wordGA = new GeneticAlgorithm(population,fitnessFunction,geneGenerationFunction,mutationRate,maxIter);
                wordGA.run();
                iterSol.add(wordGA.iterSol);
            }
            iterSol.add(-1);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer num : iterSol) {
            if (num == -1){
                sb.append("\n");
            }else {
                sb.append(Integer.toString(num));
                sb.append(" ");
            }
        }
        String line = sb.toString();
        try {
            //results will be saved on a file in this format
            //iter
            //fitnessMaximum
            //fitnessMean
            //fitnessMinimum

            File logFile = new File("heatMapData.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile));

            writer.write(line + "\n");
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     */
}
