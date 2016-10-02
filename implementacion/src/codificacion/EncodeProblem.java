import gaframework.*;
import java.util.BitSet;
import java.util.Random;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import org.moeaframework.problem.tsplib.*;


public class EncodeProblem implements Codification<Integer, Integer>{
    private int dimension; //el número de ints que componen un fenotipo
    private int [] nodes;
    private Stack<Integer> nodesToCode;
    private List<Integer> toCode;

    public EncodeProblem(TSPInstance problem){
    	this.dimension =  problem.getDimension();
    	this.nodes =  problem.getDistanceTable().listNodes();
    	this.toCode = new ArrayList<Integer>();

    	for (int i = 0; i < nodes.length; i++) {
    		toCode.add(i, node[i]);
    	}
    }

    /* 
    	el fenotipo es una lista de las ciudades indexadas
    	por nodo
    */
    public Genotype<Integer> encode (Phenotype<Integer> p) {
		ArrayList<Integer> toCodeClone =  this.toCode.clone();
		/*  quitamos el primer elemento para evitar errores en la mutacion */
		Genotype<Integer> coded = new Genotype<>(p.size());
		for (int i = 0; i < p.size() ; i++ ) {
			int index = toCodeClone.contains(p.getAllele(i));
			toCodeClone.remove(index);
			coded.setGene(i, index);
		}
		return coded;
    }

    
    public Phenotype<Integer> decode(Genotype<Integer> g) {
    	ArrayList<Integer> toCodeClone =  this.toCode.clone();
    	/*  quitamos el primer elemento para evitar errores en la mutacion */
    	Genotype<Integer> coded = new Genotype<>(p.size());
    	for (int i = 0; i < p.size() ; i++ ) {
    		int index = toCodeClone.contains(p.getAllele(i));
    		toCodeClone.remove(index);
    		coded.setGene(i, index);
    	}
    	return coded;
    }

    public Genotype<Integer> newRandomGenotype(){
		Random r = new Random();
		/* shuffle the cities */
		ArrayList<Integer> toCodeClone =  Collections.shuffle(this.toCode.clone(), new Random(r.nextInt()));
		Phenotype<Integer> newPhenotype =  new Phenotype<Integer>(toCodeClone.size());

		for(int i = 0; i < toCodeClone.size(); i++)
		    nuevo.setGene(i,toCodeClone.get(i));
		
		return this.encode(newPhenotype);
    }
    

    

}
