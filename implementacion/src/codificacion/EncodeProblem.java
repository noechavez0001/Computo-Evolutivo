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
        System.out.println("La Ciudad Origen es:");
    	System.out.println(toCode.get(0));
    }
    /* 
    	el fenotipo es una lista de las ciudades indexadas
    	por nodo
    */
    @SuppressWarnings("unchecked")
    public Genotype<Integer> encode (Phenotype<Integer> p) {
		ArrayList<Integer> toCodeClone =  (ArrayList<Integer>)this.toCode.clone();
		Genotype<Integer> coded = new Genotype<>(p.size());
		int index = 0;
		for (int i = 0; i < p.size() ; i++ ) {
			index =  toCodeClone.indexOf(p.getAllele(i));
			int node = toCodeClone.remove(index);
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
    	for (int i = 0; i < g.size() ; i++ ) {
    		int node = toCodeClone.remove((int)g.getGene(i));
    		decoded.setAllele(i, node);
    	}
    	return decoded;
    }

    @SuppressWarnings("unchecked")
    public Genotype<Integer> newRandomGenotype(){
		Random r = new Random();
		ArrayList<Integer> toCodeClone =  (ArrayList<Integer>)this.toCode.clone();
		/* shuffle the cities */
		Collections.shuffle(toCodeClone);
		Phenotype<Integer> newPhenotype =  new Phenotype<Integer>(toCodeClone.size());
		
		System.out.println(toCodeClone);


		for(int i = 0; i < toCodeClone.size(); i++)
		    newPhenotype.setAllele(i,toCodeClone.get(i));

		return this.encode(newPhenotype);
    }
    

    

}
