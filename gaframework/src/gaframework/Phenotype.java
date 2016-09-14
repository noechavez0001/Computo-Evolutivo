package gaframework;

/**
 * <p> La clase <code>Phenotype&lt;P&gt;</code> define la representación
 * de un fenotipo y proveé los métodos necesarios para su manipulación.</p>
 * <p> El fenotipo es un conjunto ordenado de alelos, es decir los valores  
 * codificados en el genotipo de un individuo, cada alelo se define como un
 * objeto de tipo <code>P</code>.</p>
 */
public class Phenotype<P> implements Cloneable{
    
    private static final String ERRMSG_NEGSIZE = "El tamaño del fenotipo " +
	"debe ser un entero positivo.";
    private static final String ERRMSG_INDXOB = "Índice fuera de rango: ";

    /**
     * Representración de un fenotipo como arreglo.
     */
    private final P[] phenotype;

    /**
     * Construye un fenotipo vacío del tamaño especificado.
     * @param size El tamaño del fenotipo.
     * @throws IllegalArgumentException Si el tamaño especificado no es 
     * positivo.
     */
    @SuppressWarnings("unchecked")
    public Phenotype(int size){
	if (size < 0)
	    throw new IllegalArgumentException(ERRMSG_NEGSIZE);
	phenotype = (P[]) new Object[size];
    }

    /**
     * Retorna el alelo en la posición especificada en este fenotipo.
     * @param index Indice del alelo a retornar.
     * @return El alelo en la posición especificada de este fenotipo.
     * @throws IndexOutOfBoundsException Si el índice especificado es menor a cero
     * o es mayor o igual al tamaño de este fenotipo.
     */
    public P getAllele(int index) {
	if (index >= this.size() || index < 0)
	    throw new IndexOutOfBoundsException(ERRMSG_INDXOB + index);
	return phenotype[index];
    }

    /**
     * Reemplaza el alelo en la posición especificada con el alelo especificado.
     * @param index Índice del alelo a reemplazar.
     * @param allele Alelo a guardar en la posición especificada.   
     * @throws IndexOutOfBoundsException Si el índice especificado es menor a cero
     * o es mayor o igual al tamaño de este fenotipo.
     */
    public void setAllele(int index, P allele) {
	if (index >= this.size() || index < 0)
	    throw new IndexOutOfBoundsException(ERRMSG_INDXOB + index);
	phenotype[index] = allele;
    }

    /**
     * Retorna el tamaño de este fenotipo.
     * @return Tamaño del fenotipo.
     */
    public int size() {
	return phenotype.length;
    }

    /**
     * Indica si otro objero es igual a este fenotipo.
     * @param obj Objeto con el que se comparará este fenotipo.
     * @return <code>true</code> si el objeto especificado es igual a este 
     * fenotipo, <code>false</code> en otro caso.
     */
    @Override
    public boolean equals(Object obj) {
	if (obj == this)
	    return true;
	if (obj instanceof Phenotype<?>) {
	    Phenotype<?> another = (Phenotype<?>) obj;
	    int i = 0;
	    if (this.size() == another.size()) {
		while (i < this.size()
		       && this.getAllele(i).equals(another.getAllele(i)))
		    i++;
		if (i == this.size())
		    return true;	
	    }
	}
	return false;
    }

    /**
     * Regresa el valor del código hash para este fenotipo.
     * @return Valor del código hash de este fenotipo.
     */
    @Override
    public int hashCode(){
	int out = 0;
	for (P p:phenotype)
	    out = 2 * out + p.hashCode();
	return out;
    }
    
    /**
     * Retirna una cadena que representa a este fenotipo.
     * @return Una cadena que representa a este fenotipo.
     */
    @Override
    public String toString() {
	String out = "<";
	for (int i = 0; i < size() - 1; i++) {
	    out += phenotype[i].toString() + ", ";
	}
	return out + phenotype[size()-1] + ">";
    }

    /**
     * Crea y regresa un nuevo fenotipo copia de este fenotipo.
     * La copia es superficial.
     * fenotipo.
     * @return Un clon de este fenotipo.
     */	
    @Override
    public Phenotype<P> clone(){
	Phenotype<P> out = new Phenotype<>(this.size());
	for (int i = 0; i < this.size(); i++) {
	    out.setAllele(i, this.getAllele(i));
	}
	return out;
    }
}
