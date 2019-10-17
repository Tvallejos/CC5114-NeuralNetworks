package GA;

//TODO documentation
public interface IGeneticAlgorithm {
    void initializePopulation();

    void evaluateFitness();

    boolean isSolutionFound();

    void selection();

    void reproduction();

    void run();
}
