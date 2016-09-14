package gaframework;

/**
 * <p>Definición de un operador de mutación. </p>
 * <p>La implementación debe proveer de un constructor adecuado para solicitar 
 * parámetros adicionales. </p>
 */
public interface MutationOp<G>{

    /**
     * Retorna un nuevo genotipo de tipo <code>G</code> resultante de mutar el
     * genotipo especificado.
     * @param g El genotipo a mutar.
     * @return Un nuevo genotipo resultante de mutar el genotipo g.
     */
    public Genotype<G> mutate(Genotype<G> g);

}
