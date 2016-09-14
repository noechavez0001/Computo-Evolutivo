package gaframework;

/**
 * <p>La clase <code>Individual&lt;G,P&gt;</code> modela a los individuos de una
 * población con genotipo de tipo <code>G</code> y fenotipo de tipo <code>P</code> y
 * proveé los métodos necesarios para su manipulación.</p> 
 * <p> Cada instancia o individuo cuenta con un genotipo, un fenotipo,un grado de 
 *  adaptación y el valor de la evaluación de la función  objetivo. 
 * Para asegurar su validez, una instancia de Individual sólo puede 
 * ser construida por medio de una instancia de <code>Breeder</code>.</p>
 * @see Breeder
 * @see Genotype
 * @see Phenotype
 */
public final class Individual<G,P> implements Comparable<Individual<G,P>>{

    private static final String ERRMSG_NULREF = "No se puede construir un " +
	"individuo con referencia a genotipo o fenotipo nula.";
    private static final String ERRMSG_NEGFIT = "El grado de adaptación debe ser " +
	"positivo: ";
    private static final String ERRMSG_NEGOBJ = "El valor de la función objetivo "+
	"ser positivo: ";
    private static final int SRT_FIT = 0;
    private static final int SRT_OBJ = 1;
    
    /**
     * Genotipo del individuo.
     */
    private final Genotype<G> genotype;
    
    /**
     * Fenotipo del individuo.
     */
    private final Phenotype<P> phenotype;
    
    /**
     * Grado de adaptación del individuo.
     */
    private final double fitness;
    
    /**
     * Evaluación de función objetivo.
     */
    private double objectiveEval;

    /**
     * Determina cómo se deben comparar los objetos.
     * ORD_FIT para grado de adaptación (por omisión).
     * ORD_OBJ para evaluación de función objetivo
     */
    private int sortBy;

    /**
     * Construye un individuo con el genotipo, fenotipo y grado de adapación
     * especificados. El valor de la evaluación de la función objetivo es 0.
     * @param genotype Genotipo del individuo.
     * @param phenotype Fenotipo del individuo.
     * @param fitness Grado de adaptación del individuo.
     * @throws IllegalArgumentException Si los objetos especificados son nulos o
     * si el grado de adaptación es negativo.
     */
    Individual(Genotype<G> genotype, Phenotype<P> phenotype, double fitness){
	if (genotype == null || phenotype == null)
	    throw new IllegalArgumentException(ERRMSG_NULREF);
	if (fitness < 0)
	    throw new IllegalArgumentException(ERRMSG_NEGFIT + fitness);
	this.genotype = genotype;
	this.phenotype = phenotype;
	this.fitness = fitness; 
	this.objectiveEval = 0.0;
	this.sortBy = SRT_FIT;
    }

    /**
     * Construye un individuo con el genotipo, fenotipo, grado de adapación
     * y valor de la evaluación de la función objetivo especificados.
     * @param genotype Genotipo del individuo.
     * @param phenotype Fenotipo del individuo.
     * @param fitness Grado de adaptación del individuo.
     * @patam objectiveEval Valor de la evaluación de  la función objetivo.
     * @throws IllegalArgumentException Si los objetos especificados son nulos,
     * si el grado de adaptación o el valor de la evaluación de la función objetivo
     * son negativos.
     */
    private Individual(Genotype<G> genotype,
		       Phenotype<P> phenotype,
		       double fitness,
		       double objectiveEval){
	if (genotype == null || phenotype == null)
	    throw new IllegalArgumentException(ERRMSG_NULREF);
	if (fitness < 0)
	    throw new IllegalArgumentException(ERRMSG_NEGFIT + fitness);
	if (objectiveEval < 0)
	    throw new IllegalArgumentException(ERRMSG_NEGOBJ + objectiveEval);
	this.genotype = genotype;
	this.phenotype = phenotype;
	this.fitness = fitness; 
	this.objectiveEval = objectiveEval;
    }
    
    /**
     * Retorna el fenotipo de este individuo.
     * @return Fenotipo de este individuo.
     */
    public Phenotype<P> getPhenotype(){
	return phenotype;
    }

    /**
     * Retorna el genotipo de este individuo.
     * @return Genotipo de este individuo.
     */
    public Genotype<G> getGenotype(){
	return genotype;
    }
    
    /**
     * Retorna el grado de adaptación de este individuo.
     * @return Grado de adaptación de este individuo.
     */
    public double getFitness(){
	return fitness;
    }

    /**
     * Retorna el valor de la evaluación de la función objetivo de este individuo.
     * @return Valor de la evaluación de la función objetivo de este individuo.
     */
    public double getObjectiveEvaluation(){
	return objectiveEval;
    }

    /**
     * Reemplaza el valor de la evauación de la función objetivo de este individuo 
     * con el valor especificado.
     * @param eval Valor de la evaluación de la función objetivo de este individuo.
     * @throws IllegalArgumentException Si el valor especificado es menor que cero.
     */
    public void setObjectiveEvaluation(double eval){
	if (objectiveEval < 0)
	    throw new IllegalArgumentException(ERRMSG_NEGOBJ + objectiveEval);
	this.objectiveEval = eval;
    }

    /**
     * Cambia el modo de comparación, los individuos serán ordenados dependiendo
     * el valor de la evaluación de la función objetivo.
     */
    void sortByObjective(){
	sortBy = SRT_OBJ;
    }
    
    /**
     * Cambia el modo de comparación, los individuos serán ordenados dependiendo
     * su grado de adaptación.
     */
    void sortByFitness(){
	sortBy = SRT_FIT;
    }
    
    /**
     * Indica si otro objeto es igual a este individuo.
     * @param obj Objeto con el que se va a comparar este individuo.
     * @return <code>true</code> si <code>obj</code> es igual a este individuo,
     * <code>false</code> en otro caso.
     */
    @Override
    public boolean equals(Object obj){
	if (obj == this)
	    return true;
	if (obj instanceof Individual) {
	    Individual<?,?> another = (Individual<?,?>) obj;
	    if(genotype.size() == another.genotype.size()){
		return genotype.equals(another.genotype);
	    }
	}
	return false;
    }

    /**
     * Retorna una cadena que representa a este individuo.
     * @return Una cadena que representa a este individuo.
     */
    @Override
    public String toString(){
	return "Genotype: " + genotype.toString() + "\n"
	    + "Phenotype: " + phenotype.toString() +  "\n"
	    + "Fitness: " + fitness;	
    }

    /**
     * Retorna el código hash de este individuo.
     * @return Código hash de este individuo.
     */
    @Override
    public int hashCode(){
	return super.hashCode();
    }
    
    /**
     * Compara con el individuo especificado para determinar si es menor igual 
     * o mayor que este individuo dependiendo de su grado de adaptación o su
     * función objetivo.
     * @param individual El individuo con el que se comparará el individuo.
     * @return -1, 0 ó 1 si este individuo es menor, igual o mayor al individuo
     * especificado.
     */
    @Override
    public int compareTo(Individual<G,P> individual){
	int comparation = 0;
	if (this.sortBy == SRT_FIT) {
	    // sort by fitness
	    if(this.fitness == individual.fitness) 
		comparation = 0;
	    else 
		comparation = (this.fitness < individual.fitness) ? -1 : 1;
	} else if (this.sortBy == SRT_OBJ) {
	    // sort by objective
	    if(this.objectiveEval == individual.objectiveEval) {
		// if objective's value is the same, sort by fitness
		if(this.fitness == individual.fitness)
		    comparation = 0;
		else
		    comparation = (this.fitness < individual.fitness) ? -1 : 1;
	    } else {	
		comparation = (this.objectiveEval < individual.objectiveEval)? -1 : 1;
	    }
	}
	return comparation;
    }

    /**
     * Crea y retorna un nuevo individuo, el cual es una copia superficial de
     * esre individuo.
     * @return Un clon de este individuo.
     */
    @Override
    public Individual<G,P> clone() {
	return new Individual<G,P>(this.genotype.clone(),
				   this.phenotype.clone(),
				   this.fitness,
				   this.objectiveEval);
    }
}
