package GA;

import GA.Functions.IFitnessFunction;
import GA.Functions.IGeneGenerationFunction;
import GA.GeneticOperators.GeneticOperator;
import GA.GeneticOperators.IGeneticOperator;
import GA.Selection.ISelection;
import GA.Selection.Roulette;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GeneticAlgorithm implements IGeneticAlgorithm {

    private int populationSize, maxIter;
    private IFitnessFunction fitnessFunction;
    private IGeneGenerationFunction geneGenerator;
    private Population population;
    private ArrayList<Integer> fits;
    private ISelection selector;
    private IGeneticOperator reproductor;
    private int fittest;
    public int iterSol;

    public GeneticAlgorithm(int populationSize, IFitnessFunction fitnessFunction, IGeneGenerationFunction geneGenerator, Double mutationRate, IGeneticOperator reproductor, int maxIter, int seed) {
        this.populationSize = populationSize;
        this.fitnessFunction = fitnessFunction;
        this.geneGenerator = geneGenerator;
        this.maxIter = maxIter;
        selector = new Roulette(this.fitnessFunction);
        initializePopulation(seed);
        this.reproductor = reproductor;
        iterSol = -1;
    }


    public GeneticAlgorithm(int populationSize, IFitnessFunction fitnessFunction, IGeneGenerationFunction geneGenerator, Double mutationRate, int maxIter, int seed) {
        this(populationSize, fitnessFunction, geneGenerator, mutationRate, new GeneticOperator(mutationRate), maxIter, seed);
    }

    public GeneticAlgorithm(int populationSize, IFitnessFunction fitnessFunction, IGeneGenerationFunction geneGenerationFunction, Double mutationRate, int maxIter) {
        this(populationSize, fitnessFunction, geneGenerationFunction, mutationRate, maxIter, new Random().nextInt());
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public int getMaxIter() {
        return maxIter;
    }

    public ArrayList<Integer> getFits() {
        return fits;
    }

    public ArrayList<IIndividual> getIndividuals() {
        return population.getIndividuals();
    }

    @Override
    public void initializePopulation(int seed) {
        population = new Population(geneGenerator, populationSize, seed);
    }

    @Override
    public void evaluateFitness() {
        fits = new ArrayList<>();
        int actualFitness = 0;
        for (IIndividual ind : population.getIndividuals()) {
            actualFitness = fitnessFunction.run(ind);
            fits.add(actualFitness);
        }
    }

    @Override
    public boolean isSolutionFound() {
        for (Integer fitScore : fits) {
            if (fitnessFunction.solutionFound(fitScore)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void selection() {
        ArrayList<IIndividual> selectedIndividuals = selector.process(population.getIndividuals(), populationSize / 2);
        population.setIndividuals(selectedIndividuals);
    }

    @Override
    public void reproduction() {
        ArrayList<IIndividual> reproducedIndividuals = reproductor.reproduce(population.getIndividuals(), populationSize - population.getPopulationSize(), geneGenerator);
        population.setIndividuals(reproducedIndividuals);
    }

    @Override
    public void run() {
        for (int i = 0; i < maxIter; i++) {
            if (GAiteration()) {
                System.out.println("Solution found at " + Integer.toString(i) + " iteration");
                System.out.println("Solution is ...");
                printFittest();
                iterSol = i;
                return;
            }
        }
        System.out.println("max iter reached: " + maxIter);
        System.out.println("best fit performance is now " + fittest + " with this individual");
        evaluateFitness();
        updateFittest();
        printFittest();
        iterSol = maxIter;
    }

    public int getFittest() {
        return fittest;
    }

    private boolean GAiteration() {
        evaluateFitness();
        updateFittest();
        if (isSolutionFound()) {
            return true;
        }
        selection();
        reproduction();
        return false;
    }

    private void updateFittest() {
        fittest = Collections.max(fits);
    }

    private void printFittest() {
        int indexOf = fits.indexOf(fittest);
        System.out.println(printIndividual(population.getIndividuals().get(indexOf)));
    }

    private String printIndividual(IIndividual iIndividual) {
        return geneGenerator.individualToString(iIndividual);
    }

    //used to get iter vs max mean min Data
    public void runSavingFitness() {
        ArrayList<String> iter = new ArrayList<>();
        ArrayList<String> Max = new ArrayList<>();
        ArrayList<String> Mean = new ArrayList<>();
        ArrayList<String> Min = new ArrayList<>();
        for (int i = 0; i < maxIter; i++) {
            if (GAiteration()) {
                iter.add(Integer.toString(i));
                Max.add(getMax());
                Mean.add(getMean());
                Min.add(getMin());
                break;
            }
            iter.add(Integer.toString(i));
            Max.add(getMax());
            Mean.add(getMean());
            Min.add(getMin());
        }
        try {
            //results will be saved on a file in this format
            //iter
            //fitnessMaximum
            //fitnessMean
            //fitnessMinimum

            File logFile = new File("fitnessdata" + ".txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile));

            String iterationLine = getAsString(iter);
            String maxLine = getAsString(Max);
            String meanLine = getAsString(Mean);
            String minLine = getAsString(Min);

            writer.write(iterationLine + "\n");
            writer.write(maxLine + "\n");
            writer.write(meanLine + "\n");
            writer.write(minLine + "\n");
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getAsString(ArrayList<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
            sb.append(" ");
        }
        return sb.toString();
    }


    private String getMax() {
        return Integer.toString(fittest);
    }

    private String getMean() {
        Double acc = 0.0;
        for (int i = 0; i < populationSize; i++) {
            acc += fits.get(i);
        }
        return Double.toString(acc / populationSize);
    }

    private String getMin() {
        return Integer.toString(Collections.min(fits));
    }


}
