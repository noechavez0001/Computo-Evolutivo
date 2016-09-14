package gaframework;

/**
 * <p>Esta interfaz define los servicios que debe proveer un algoritmo genético. </p>
 * <p>La implementación debe proveer de un constructor adecuado para solicitar 
 * parámetros adicionales. </p>
 */
public interface GeneticAlgorithm<G,P>{

    /**
     * Retorna una nueva población resultante de aplicar una iteración del algoritmo 
     * genético.
     * @param current La población actual.
     * @return La nueva población.
     */
    public Population<G,P> iteration(Population<G,P> current);
    
    /**
     * Ejecución del algoritmo genético.
     */
    public void run();
    
}
