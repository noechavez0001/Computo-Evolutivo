package gaframework;

/**
 * <p> Interfaz que define la evaluación de individuos de una población
 * con genotipo de tipo <code>G</code> y fenotipo de tipo <code>P</code> con una 
 * funcion objetivo. </p>
 * <p>La implementación debe proveer de un constructor adecuado para solicitar 
 * parámetros adicionales. </p>
 */
public interface ObjectiveFunction<G,P> {

    /**
     * <p>Evalua a cada individuo de la población especificada asignándoles 
     * un real positivo.</p>
     * <p>La implementación debe asignar a cada individuo de la población
     * el valor resultante de la evaluación de la función objectivo con el método
     * <code>setObjectiveEvaluation(double)</code> de la clase 
     * <code>Individual</code>.</p>
     * @param p Población a evaluar.
     * @see Individual#setObjectiveEvaluation
     */
    public void evaluate(Population<G,P> p);

}
