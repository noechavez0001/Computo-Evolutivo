import gaframework.*;
import java.util.Random;
public class UniformMutation implements MutationOp<Boolean>{
	private double prob;
	private Random r;

	public UniformMutation(double prob, int seed){
		this.prob=prob;
		this.r = new Random(seed);
	}
	public Genotype<Boolean> mutate(Genotype<Boolean> g){
		Genotype<Boolean> out = new Genotype<>(g.size());
		for (int i=0; i<g.size(); i++) {
			if (r.nextDouble()<prob) {
						out.setGene(i, ! g.getGene(i).booleanValue());	
			}
			else {
			out.setGene(i, g.getGene(i));
			}
		}
		return out;
	}
}