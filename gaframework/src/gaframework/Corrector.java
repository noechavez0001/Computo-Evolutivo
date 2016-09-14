package gaframework;

/**
 * <p>Esta interfaz define los servicios que debe proveer un corrector de 
 * genotipos.</p>
 * <p>La implementación debe proveer de un constructor adecuado para solicitar 
 * parámetros adicionales. </p>
 */
public interface Corrector<G> {

    /**
     * Corrige el genotipo especificado a uno adecuado para el problema a resolver.
     * @param g El genotipo a reparar.
     * @return Un nuevo genotipo válido.
     */
    public Genotype<G> repairGenotype(Genotype<G> g);

}
