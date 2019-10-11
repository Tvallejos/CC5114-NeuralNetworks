package GA;
//TODO documentation
public interface IGeneticAlgorithm {
    void initializePopulation();
    void evaluateFitness();
    void selection();
    void reproduction();
    void run();
}
