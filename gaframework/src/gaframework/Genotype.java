package gaframework;

/**
 * <p>La clase <code>Genotype&lt;G&gt;</code> define la representación de un genotipo 
 * o cormosoma y proveé los métodos necesarios para su manipulación.</p>
 * <p>Un genotipo es un conjunto ordenado de genes que representan la información 
 * genética de un individuo, los genes se definen como un objeto de tipo 
 * <code>G</code>.</p>
 */
public class Genotype<G> implements Cloneable{

    private static final String ERRMSG_NEGSIZE = "El tamaño del genotipo " +
	"debe ser un entero positivo.";
    private static final String ERRMSG_INDXOB = "Índice fuera de rango: ";

    /**
     * Representación de un genotipo como arreglo.
     */
    private final G[] genotype;

    /**
     * Construye un genotipo vacío del tamaño especificado.
     * @param size El tamaño del genotipo.
     * @throws IllegalArgumentException Si el tamaño especificado no es 
     * positivo.
     */
    @SuppressWarnings("unchecked")
    public Genotype(int size) {
	if (size < 0)
	    throw new IllegalArgumentException(ERRMSG_NEGSIZE);
	genotype = (G[]) new Object[size];
    }

    /**
     * Retorna el gen en la posición especificada en este genotipo.
     * @param index Índice del gen a retornar.
     * @return El gen en la posición especificada de este genotipo.
     * @throws IndexOutOfBoundsException Si el índice especificado es menor a cero
     * o es mayor o igual al tamaño de este genotipo.
     */
    public G getGene(int index) {
	if (index >= this.size() || index < 0)
	    throw new IndexOutOfBoundsException(ERRMSG_INDXOB + index);
	return genotype[index];
    }

    /**
     * Reemplaza el gen en la posición especificada con el gen especificado.
     * @param index  Índice del elemento a reemplazar.
     * @param gene  Gen a guardar en la posición especificada.
     * @throws IndexOutOfBoundsException Si el índice especificado es menor a cero
     * o es mayor o igual al tamaño de este genotipo.
     */
    public void setGene(int index, G gene) {
	if (index >= this.size() || index < 0)
	    throw new IndexOutOfBoundsException(ERRMSG_INDXOB + index);
	genotype[index] = gene;
    }

    /**
     * Retorna el tamaño de este genotipo.
     * @return Tamaño del genotipo.
     */
    public int size() {
	return genotype.length;
    }

    /**
     * Indica si otro objeto es igual a este genotipo.
     * @param obj Objeto con el que comparará este genotipo.
     * @return <code>true</code> si el objeto especificado es igual a 
     * este genotipo, <code>false</code> en otro caso.
     */
    @Override
    public boolean equals(Object obj) {
	if (obj == this)
	    return true;
	if (obj instanceof Genotype<?>) {
	    Genotype<?> another = (Genotype<?>) obj;
	    int i = 0;
	    if (this.size() == another.size()) {
		while (i < this.size()
		       && this.getGene(i).equals(another.getGene(i)))
		    i++;
		if (i == this.size())
		    return true;	
	    }
	}
	return false;
    }
    
    /**
     * Regresa el valor del código hash para esste genotipo.
     * @return Valor código hash para este genotipo.
     */
    @Override
    public int hashCode(){
	int out = 0;
	for (G g:genotype)
	    out = 2 * out + g.hashCode();
	return out;
    }

    /**
     * Retorna una cadena que representa a este genotipo.
     * @return Una cadena que representa a este genotipo.
     */
    @Override
    public String toString() {
	String out = "<";
	for (int i = 0; i < size() - 1; i++) {
	    out += genotype[i].toString() + ", ";
	}
	return out + genotype[size()-1] + ">";
    }

    /**
     * Crea y regresa un nuevo genotipo copia de este genotipo. 
     * La copia es superfical.
     * @return Un clon de este genotipo.
     */	
    @Override
    public Genotype<G> clone(){
	Genotype<G> out = new Genotype<>(this.size());
	for (int i = 0; i < this.size(); i++) {
	    out.setGene(i, this.getGene(i));
	}
	return out;
    }    
}
