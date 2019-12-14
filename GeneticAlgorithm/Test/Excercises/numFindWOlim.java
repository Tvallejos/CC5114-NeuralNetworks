package Excercises;

import GA.Functions.*;
import GA.GeneticAlgorithm;
import GP.Tree.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class numFindWOlim {
    public static void main(String[] args) {

        GeneticAlgorithm numFindGA = new GeneticAlgorithm(300,
                new numberFindingFitnessFunction(65348, new HashMap<>()),
                //new numberFindingNoRep(65348),
                //new numberFindingPlusPunishFitnessFunction(65348),
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

/*
    @Test
    void heatMapData() {

        IFitnessFunction fitnessFunction = new numberFindingFitnessFunction(65346);
        IGeneGenerationFunction geneGenerationFunction = new TreeGenerator(
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
                0.2);
        int maxIter = 3500;
        ArrayList<Integer> iterSol = new ArrayList<>();
        GeneticAlgorithm numFindGA;
        for (Double mutationRate = 1.0; mutationRate > 0; mutationRate -= 0.1) {
            for (int population = 50; population <= 1000; population += 50) {
                numFindGA = new GeneticAlgorithm(population, fitnessFunction, geneGenerationFunction, mutationRate, maxIter);
                numFindGA.run();
                iterSol.add(numFindGA.iterSol);
                System.out.println(population+" "+mutationRate);
            }
            iterSol.add(-1);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer num : iterSol) {
            if (num == -1) {
                sb.append("\n");
            } else {
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

            File logFile = new File("heatMapNumFindData.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile));

            writer.write(line + "\n");
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/

}
