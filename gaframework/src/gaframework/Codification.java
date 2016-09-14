package gaframework;

/**
 * <p>Esta interfaz define los servicios que debe proveer un codificador. </p>
 * <p>La implementación debe proveer de un constructor adecuado para solicitar 
 * parámetros adicionales. </p>
 */
public interface Codification<G,P> {
    
    /**
     * Codifica el fenotipo de tipo P especifiado en un genotipo de tipo G.
     * @param phenotype El fenotipo a codificiar.
     * @return El genotipo correspondiente al fenotipo.
     */
    public Genotype<G> encode(Phenotype<P> phenotype);

    /**
     * Deocdifica el genotipo de tipo G especificado en un fenotipo de tipo P.
     * @param genotype El genotipo a decodificar.
     * @return El fenotipo correspondiente al genotipo.
     */
    public Phenotype<P> decode(Genotype<G> genotype);

    /**
     * Crea y retorna un nuevo genotipo de tipo G con valores aleatorios.
     * @return Un genotipo aleatorio.
     */
    public Genotype<G> newRandomGenotype();

}
