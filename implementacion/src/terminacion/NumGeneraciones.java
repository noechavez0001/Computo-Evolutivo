import gaframework.TerminationCondition;
import gaframework.Population;

/**
 * Clase para modelar la condición de terminación del Algoritmo Genetico
 * @author
 * 
 */

public class NumGeneraciones implements TerminationCondition<Boolean, Integer>{
    /** Atributos **/
    private int numGen;

    /** Constructor**/
    public NumGeneraciones(int numGen){
	this.numGen =  numGen;
    }
    /** Comportamiento**/
    public boolean conditionReached(Population<Boolean,Integer> p){
	return p.getGeneration() >= numGen;
    }
}
