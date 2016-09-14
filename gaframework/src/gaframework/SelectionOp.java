package gaframework;

import java.util.List;

/**
 * <p>Definición de un operador de selección. </p>
 * <p>La implementación debe proveer de un constructor adecuado para solicitar 
 * parámetros adicionales. </p>
 */
public interface SelectionOp<G,P>{

    /**
     * Retorna una lista de individuos seleccionados de la población especificada.
     * @param p La población de la cual se seleccionarán los individuos.
     * @return Una lista de los individuos seleccionados de la población.
     */
    public List<Individual<G,P>> select(Population<G,P> p);

}
