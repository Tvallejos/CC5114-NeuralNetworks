package GA;

import GA.Functions.IFitnessFunction;
import GA.Functions.IGeneGenerationFunction;
import GA.Genes.IGene;
import GA.GeneticOperators.GeneticOperator;
import GA.GeneticOperators.IGeneticOperator;
import GA.Selection.ISelection;
import GA.Selection.Roulette;

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

    public GeneticAlgorithm(int populationSize, IFitnessFunction fitnessFunction, IGeneGenerationFunction geneGenerator, Double mutationRate, int maxIter, int seed) {
        this.populationSize = populationSize;
        this.fitnessFunction = fitnessFunction;
        this.geneGenerator = geneGenerator;
        this.maxIter = maxIter;
        selector = new Roulette(this.fitnessFunction);
        initializePopulation(seed);
        reproductor = new GeneticOperator(mutationRate, population.getAlleleValues());

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
        ArrayList<IIndividual> reproducedIndividuals = reproductor.reproduce(population.getIndividuals(), populationSize - population.getPopulationSize());
        population.setIndividuals(reproducedIndividuals);
    }

    @Override
    public void run() {
        for (int i = 0; i < maxIter; i++) {
            evaluateFitness();
            updateFittest();
            //printFittest();

            if (isSolutionFound()) {
                System.out.println("Secret word is ...");
                printFittest();
                System.out.println("Found on iteration number "+(i+1));
                return;
            }

            selection();
            reproduction();
        }
        System.out.println("max iter reached");
        System.out.println("best fit performance is now "+fittest+" with this individual");
        printFittest();
    }

    private void updateFittest() {
        fittest = Collections.max(fits);
    }

    private void printFittest() {
        int indexOf = fits.indexOf(fittest);
        System.out.println(printIndividual(population.getIndividuals().get(indexOf)));
    }

    private String printIndividual(IIndividual iIndividual) {
        ArrayList<IGene> genes = iIndividual.getGenes();
        String individualAsString = "";
        for (IGene gene : genes) {
            individualAsString = individualAsString + gene.getStringValue();
        }
        return individualAsString;
    }
}
