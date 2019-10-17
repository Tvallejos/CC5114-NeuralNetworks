package GA;

import GA.Functions.IFitnessFunction;
import GA.Functions.IGeneGenerationFunction;
import GA.GeneticOperators.GeneticOperator;
import GA.GeneticOperators.IGeneticOperator;
import GA.Selection.ISelection;
import GA.Selection.Roulette;

import java.util.ArrayList;
import java.util.Random;

public class GeneticAlgorithm implements IGeneticAlgorithm {

    private int populationSize, maxIter;
    private IFitnessFunction fitnessFunction;
    private IGeneGenerationFunction geneGenerator;
    private Population population;
    private ArrayList<Integer> fits;
    private ISelection selector;
    private IGeneticOperator reproductor;

    public GeneticAlgorithm(int populationSize, IFitnessFunction fitnessFunction, IGeneGenerationFunction geneGenerator, Double mutationRate, int maxIter) {
        this.populationSize = populationSize;
        this.fitnessFunction = fitnessFunction;
        this.geneGenerator = geneGenerator;
        this.maxIter = maxIter;
        selector = new Roulette(this.fitnessFunction);
        reproductor = new GeneticOperator(mutationRate,population.getAlleleValues());
        initializePopulation();
    }

    @Override
    public void initializePopulation() {
        population = new Population(geneGenerator, populationSize);
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
        ArrayList<IIndividual> selectedIndividuals = selector.process(population.getIndividuals(),populationSize/2);
        population.setIndividuals(selectedIndividuals);
    }

    @Override
    public void reproduction() {
        ArrayList<IIndividual> reproducedIndividuals = reproductor.reproduce(population.getIndividuals(),populationSize-population.getPopulationSize());
        population.setIndividuals(reproducedIndividuals);
    }

    @Override
    public void run() {
        for (int i = 0; i <maxIter ; i++) {
            evaluateFitness();
            if(isSolutionFound()){
                break;
            }
            selection();
            reproduction();
        }
        System.out.println("max iter reached");
    }
}
