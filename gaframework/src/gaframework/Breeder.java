package gaframework;

import java.util.LinkedList;

/**
 * Una instancia de Breeder permite crear nuevas instancias de individuos
 * válidos a partir de su fenotipo o genotipo, también permite crear
 * individuos y poblaciones aleatorias. 
 * @see Individual
 * @see Population
 * @see Genotype
 * @see Phenotype
 */
public class Breeder<G,P> {

    private final Codification<G,P> codification;
    private final Corrector<G> corrector;
    private final FitnessFunction<P> function;

    /**
     * Crea unan nuevo Breeder con las co
     * @param codification Codificación de los individuos.
     * @param corrector Corrector de genotipos, puede ser null.
     * @param function Función de grado de adaptación.
     */
    public Breeder(Codification<G,P> codification,
		   Corrector<G> corrector,
		   FitnessFunction<P> function){
	this.codification = codification;
	this.corrector = corrector;
	this.function = function;
    }

    /**
     * Crea un nuevo individuo a partir de su genotipo.
     * @param genotype Genotipo con el que se creara el nuevo individuo.
     * @return Un nuevo individuo.
     */
    public Individual<G,P> newIndividual(Genotype<G> genotype){
	Genotype<G> correctedGenotype = (corrector != null) ? corrector.repairGenotype(genotype) : genotype;
	Phenotype<P> phenotype = codification.decode(correctedGenotype);
	return new Individual<>(correctedGenotype, phenotype, function.evaluate(phenotype));
    }
    
    /**
     * Crea un nuevo indidividuo a partir del fenotipo.
     * @param phenotype Del nuevo individuo.
     * @return Un nuevo individuo.
     */
    public Individual<G,P> newIndividual(Phenotype<P> phenotype){
	return new Individual<>(codification.encode(phenotype), phenotype, function.evaluate(phenotype));
    }
    
    /**
     * Crea un nuevo individuo aleatorio.
     * @return Un nuevo individuo aleatorio.
     */
    public Individual<G,P> newRandomIndividual(){
	   return newIndividual(codification.newRandomGenotype());
    }
      
    /**
     * Crea una nueva población aleatoria.
     * @param size Tamaño de la población.
     * @return Una nueva población aleatoria.
     */
    public Population<G,P> newRandomPopulation(int size){
	Population<G,P> p = new Population<>();
	for (int i = 0; i < size; i++) {
	    p.addIndividual(newRandomIndividual());
	}
	return p;
    } 
}
