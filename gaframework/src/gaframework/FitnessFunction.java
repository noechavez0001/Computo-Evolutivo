
package gaframework;

/**
 * <p> Interfaz que define la evaluación del grado de adaptación del fenotipo de tipo
 * <code>P</code>.</p>
 * <p> La implementación debe proveer de un constructor adecuado para solicitar 
 * parámetros adicionales. </p>
 */public interface FitnessFunction<P> {

    /**
     * Retorna el valor de la evaluación el grado de adaptación  el fenotipo
     * especificado.
     * @param p El fenotipo a evaluar.
     * @return El grado de adaptación del fenotipo.
     */
    public double evaluate(Phenotype<P> p);
    
}
