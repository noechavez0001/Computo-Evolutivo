public class NumGeneraciones implements TerminationCondition<Boolean, Integer>{
	private int numGen;
	public NumGeneraciones(int numGen){
		this.numGen=numGen
	}

	public boolean conditionReached(Population<Boolean, Integer> p){
		return p.getGeneration()>= numGen;
	}
}