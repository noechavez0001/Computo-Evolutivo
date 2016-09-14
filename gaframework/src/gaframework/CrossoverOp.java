package gaframework;

import java.util.List;

/**
 * <p>Definición de un operador de cruza. </p>
 * <p>La implementación debe proveer de un constructor adecuado para solicitar 
 * parámetros adicionales. </p>
 */
public interface CrossoverOp<G> {

    /**
     * Retorna nuevos genotipos resultantes de la cruza los genotipos de tipo 
     * <code>G</code> especificados.
     * @param parents Los padres con los que se realizará la cruza.
     * @return Una lista de nuevos genotipos resultantes de la cruza.
     */
    public List<Genotype<G>> crossover(List<Genotype<G>> parents);

}
