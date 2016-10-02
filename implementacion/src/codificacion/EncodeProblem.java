import gaframework.*;
import java.util.BitSet;
import java.util.Random;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;
import org.moeaframework.problem.tsplib.*;


public class EncodeProblem implements Codification<Integer, Integer>{
    private int dimension; //el número de ints que componen un fenotipo
    private int [] nodes;
    private Stack<Integer> nodesToCode;
    private ArrayList<Integer> toCode;

    public EncodeProblem(TSPInstance problem){
    	this.dimension =  problem.getDimension();
    	this.nodes =  problem.getDistanceTable().listNodes();
    	this.toCode = new ArrayList<Integer>();

    	for (int i = 0; i < nodes.length; i++) {
    		toCode.add(i, nodes[i]);
    	}

    	System.out.println(toCode);
    }
    /* 
    	el fenotipo es una lista de las ciudades indexadas
    	por nodo
    */
    @SuppressWarnings("unchecked")
    public Genotype<Integer> encode (Phenotype<Integer> p) {
		ArrayList<Integer> toCodeClone =  (ArrayList<Integer>)this.toCode.clone();
		/*  quitamos el primer elemento para evitar errores en la mutacion */
		Genotype<Integer> coded = new Genotype<>(p.size());
		int index = 0;
		for (int i = 0; i < p.size() ; i++ ) {
			boolean has = toCodeClone.contains(p.getAllele(i));
			
			if (has)
				index =  toCodeClone.indexOf(p.getAllele(i));

			toCodeClone.remove(index);
			coded.setGene(i, index);
		}
		return coded;
    }

    @SuppressWarnings("unchecked")
    public Phenotype<Integer> decode(Genotype<Integer> g) {
    	ArrayList<Integer> toCodeClone =  (ArrayList<Integer>)this.toCode.clone();
    	/*  quitamos el primer elemento para evitar errores en la mutacion */
    	Phenotype<Integer> decoded = new Phenotype<>(g.size());
    	int index = 0;
    	boolean has =  false;
    	for (int i = 0; i < g.size() ; i++ ) {
    		has = toCodeClone.contains(g.getGene(i));

    		if (has)
    			index = toCodeClone.indexOf(g.getGene(i));

    		toCodeClone.remove(index);
    		decoded.setAllele(i, index);
    	}
    	return decoded;
    }

    @SuppressWarnings("unchecked")
    public Genotype<Integer> newRandomGenotype(){
		Random r = new Random();
		ArrayList<Integer> toCodeClone =  (ArrayList<Integer>)this.toCode.clone();
		/* shuffle the cities */
		Collections.shuffle((ArrayList<Integer>)toCodeClone.clone(), new Random(r.nextInt()));
		Phenotype<Integer> newPhenotype =  new Phenotype<Integer>(toCodeClone.size());

		for(int i = 0; i < toCodeClone.size(); i++)
		    newPhenotype.setAllele(i,toCodeClone.get(i));
		
		return this.encode(newPhenotype);
    }
    

    

}
