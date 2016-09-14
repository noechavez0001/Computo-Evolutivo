package gaframework;

import java.util.LinkedList;
import java.util.Collections;

/**
 * <p>Una población es un conjunto ordenado de individuos, la clase 
 * <code>Population&lt;G,P&gt;</code> modela dichas poblaciones. Los individuos
 * de la población tienen un genotipo de tipo <code>G</code> y un fenotipo de
 * tipo <code>P</code>.</p>
 * Cada población cuenta con un número que representa la generación de los individuos
 * que contiene. El orden de la población se puede realizar de dos formas: por medio
 * del grado de adaptación (por omisión) o del valor de la evaluación de
 * la función objetivo de cada individuo.
 * @see Individual
 */
public class Population<G,P> {

    private static final int SRT_FIT = 0;
    private static final int SRT_OBJ = 1;

    private static int defaultSort = SRT_FIT;
    
    private LinkedList<Individual<G,P>> population;
    private boolean sorted;
    private int generation;
    private int sortBy;
 
    
    /**
     * Construye una población vacía con generación igual a cero.
     */
    Population(){
	this.generation = 0;
    }
    
    /**
     * Construye una población vacía cuya generación se especifica.
     * @param generation La generación de esta población.
     */
    public Population(int generation){
	this.generation = generation;
    }
    
    {
	this.population = new LinkedList<>();
	this.sorted = true;
	this.sortBy = defaultSort;
    }
    
    /**
     * Agrega el individuo especificado a esta población.
     * @param individual Iindividuo que será agregado esta población.
     */
    public void addIndividual(Individual<G,P> individual){
	population.add(individual);
	sorted = false;
    }
    
    /**
     * Retorna el individuo en la posición especificada de esta población.
     * La población estará ordenada según se haya especificado.
     * @param index El índice del individuo a solicitar.
     * @return El individuo en la posición index.
     */
    public Individual<G,P> getIndividual(int index){
	if (!sorted)
	    this.sort();
	return population.get(index);
    }
    
    /**
     * Retorna el mejor individuo de esta población. 
     * @return El mejor individuo de la población.
     */
    public Individual<G,P> getBestIndividual(){
	if (!sorted)
	    this.sort();
	return population.getFirst();
    }
    
    /**
     * Retorna el peor individudo de esta población.
     * @return El peor individuo esta población.
     */
    public Individual<G,P> getWorstIndividual(){
	if (!sorted)
	   this.sort();
	return population.getLast();
    }
    
    /**
     * Retorna un arreglo con los grados de adaptación de los individuos de
     * esta población.
     * @return Arreglo con los grados de adaptación
     * de los individuos de la población.
     */
    public double[] getFitnessArray(){
	if (!sorted)
	   this.sort();
	double[] a = new double[this.size()];
	for (int i = 0; i < this.size(); i++)
	    a[i] = population.get(i).getFitness();
	return a;	    
    }
    
    /**
     * Retorna un arreglo con los el valor de la evaluación de la función objetivo
     * de cada individuo en esta población.
     * @return Arreglo con los valores de la evaluación de la función objetivo
     * de los individuos de la población.
     */
    public double[] getObjectiveEvaluationArray(){
	if (!sorted)
	   this.sort();
	double[] a = new double[this.size()];
	for (int i = 0; i < this.size(); i++)
	    a[i] = population.get(i).getObjectiveEvaluation();
	return a;	    
    }

    /**
     * Retorna el número de generación de esta población.
     * @return Número de generación de esta población.
     */
    public int getGeneration(){
	return generation;
    }
    
    /**
     * Retorna el número en individuos de esta población.
     * @return  Número de individuos en esta población.
     */
    public int size(){
	return population.size();
    }
    
    /**
     * Ordena los individuos de esta población. El orden de los individuos depende
     * de su grado de adaptación o del valor de la función objetivo, según se haya
     * especificado.
     * @see Individual#compareTo
     */
    public void sort(){
	population.sort(null);
	LinkedList<Individual<G,P>> l = new LinkedList<>();
	for (Individual<G,P> ind:population)
	    l.addFirst(ind);
	population = l;
	sorted = true;
    }

    /**
     * Cambia la forma en que esta poblacion se ordena. Las poblacion se ordenará
     * de forma decreciente con los valores de la evaluación de la función objetivo de
     * cada individuo. 
     */
    public void sortByObjective(){
	if (sortBy !=  SRT_OBJ) {
	    for(Individual<G,P> i:population) {
		i.sortByObjective();
	    }
	    this.sorted = false;
	}
    }

    /**
     * Cambia la forma en que esta poblacion se orde. La poblacion se ordenará
     * de forma decreciente con el grado de adaptación de cada individuo.
     */
    public void sortByFitness(){
	if (sortBy !=  SRT_FIT) {
	    for(Individual<G,P> i:population) {
		i.sortByFitness();
	    }
	    this.sorted = false;
	}
    }

    /**
     * Cambia la forma en que las nuevas poblaciones se ordenen. Las poblaciones 
     * se ordenará de forma decreciente con el grado de adaptación de cada individuo.
     */
    public static void setDefaultSortByFitness(){
	defaultSort = SRT_FIT;
    }
    
    /**
     * Cambia la forma en que las nuevas poblaciones se ordenen. Las poblaciones 
     * se ordenará de forma decreciente con el valor de la evaluación de la 
     * función objetivo de cada individuo.
     */    public static void setDefaultSortByObjective(){
	defaultSort = SRT_OBJ;
    }
}
