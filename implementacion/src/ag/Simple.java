
import gaframework.*;
import java.util.*;

public class Simple<G,P> implements GeneticAlgorithm<G,P> {

    private Breeder<G,P> breeder;
    private CrossoverOp<G> crossoverOp;
    private MutationOp<G> mutationOp;
    private SelectionOp<G,P> selectionOp;
    private TerminationCondition<G,P> termination;
    private final int popSize;

    public Simple(Codification<G,P> cod,
		  Corrector<G> cor,
		  CrossoverOp<G> cro,
		  MutationOp<G> muo,
		  SelectionOp<G,P> seo,
		  FitnessFunction<P> fun,
		  TerminationCondition<G,P> ter,
		  int popSize){
	breeder = new Breeder<>(cod, cor, fun);
	crossoverOp = cro;
	mutationOp = muo;
	selectionOp = seo;
	termination = ter;
	this.popSize = popSize;
    }

    public Population<G,P> iteration(Population<G,P> current) {
	Population<G,P> out = new Population<>(current.getGeneration() + 1);
	Individual<G,P> mejor = current.getBestIndividual();
	out.addIndividual(mejor);
	while (out.size() < current.size()) {
	    //// Seleccion
	    List<Individual<G,P>> selectionList = selectionOp.select(current);
	    // Cruza
	    List<Genotype<G>> genotypeList = new LinkedList<>();
	    
	    for (Individual<G,P> s:selectionList)
			genotypeList.add(s.getGenotype());

	    List<Genotype<G>> crossedList = crossoverOp.crossover(genotypeList);
	    // Mutacion
	    List<Genotype<G>> mutatedList = new LinkedList<>();
	    for (Genotype<G> c:crossedList)	
			mutatedList.add(mutationOp.mutate(c));
	    // Nuevos individuos
	    for (Genotype<G> c:crossedList) {
			out.addIndividual(breeder.newIndividual(c));
		}
	}

	return out;   
    }
    
    public void run(){
	Population<G,P> p = breeder.newRandomPopulation(popSize);
	while(!termination.conditionReached(p)){
	    p = iteration(p);
	    Individual<G,P> m = p.getBestIndividual();
	    System.out.println(m);
	}
    }

}
