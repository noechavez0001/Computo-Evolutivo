import gaframework.*;
import org.moeaframework.problem.tsplib.*;

public class Fitness implements FitnessFunction<Integer>{
	TSPInstance problem;

	public Fitness(TSPInstance problem) {
		this.problem = problem;
	}

    public double evaluate(Phenotype<Integer> p){
    	DistanceTable distanceTable = problem.getDistanceTable();
		double result = 0.0;
		
		for (int i = 0; i < p.size(); i++) {
			result += distanceTable.getDistanceBetween(p.getAllele(i), p.getAllele((i+1)%p.size()));
		}
		
		return result;
    }

    public static int[] phenotypeToArray(Phenotype<Integer> p) {
    	int[] tmp =  new int[p.size()];
    	for (int i = 0; i < tmp.length; i++)
    		tmp[i] =  p.getAllele(i);
    	return tmp;
    }
}
