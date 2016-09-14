import gaframework.*;
public class MaxFun implements FitnesFunction<Integer>{
	public double evaluate(Phenotype<Integer> p){
		int x = p.getAllele(0).intValue();
		return x*(1024-x);
	}
}