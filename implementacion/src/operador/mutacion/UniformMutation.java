import gaframework.*;
import java.util.Random;
public class UniformMutation implements MutationOp<Integer>{
    private double prob;
    private Random r;
    private Random p;

    public UniformMutation(double prob, int seed){
		this.prob=prob;
		this.r = new Random(seed);
		this.p = new Random(seed);
    }
    public Genotype<Integer> mutate(Genotype<Integer> g){
    	System.out.println("----------------------------\n " +  g);
		int gsize = g.size();
		Genotype<Integer> out = new Genotype<>(gsize);
		for (int i=0; i<gsize; i++) {
		    if (r.nextDouble() < prob){
				out.setGene(i, p.nextInt(gsize-i));
		    } else {
				out.setGene(i, g.getGene(i));
		    }
		}
		return out;
    }
}
