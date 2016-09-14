package gaframework;

/**
 * <p>Interfaz que define la condición de terminación de un algoritmo genético. </p>
 * <p>La implementación debe proveer de un constructor adecuado para solicitar 
 * parámetros adicionales. </p>
 */
public interface TerminationCondition<G,P>{

    /**
     * Indica si se ha cumplido la condición de terminación del algoritmo genético
     * evaluando la población especificada.
     * @param p La población con la cual se determinará si
     * se ha alcanzado la condición de terminación.
     * @return true si se alcanzó la condición de terminación, 
     * false en caso contrario
     */
    public boolean conditionReached(Population<G,P> p);
    
}

