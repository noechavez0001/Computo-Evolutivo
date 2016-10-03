import gaframework.*;
import org.moeaframework.problem.tsplib.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;


public class Main{

    public static void main(String[] argumenta) throws IOException {

    	TSPInstance problem = new TSPInstance(new File("./data/tsp/burma14.tsp"));
    	// EncodeProblem encoder =  new EncodeProblem(problem);
     //    Genotype<Integer> gen = encoder.newRandomGenotype();
     //    Phenotype<Integer> phen = encoder.decode(gen);
     //    Fitness fitness =  new Fitness(problem);
    	
     //    System.out.println("Genotype: " + gen);
     //    System.out.println("Phenotype:" +  phen);
     //    System.out.println("Fitness: " + fitness.evaluate(phen));

    	/* Obtenemos los nodos en orden arbitrario*/ 
    	

    	// TSPPanel panel = new TSPPanel(problem);
    	// panel.displayTour(problem.getTours().get(0), Color.RED);

    	// JFrame frame = new JFrame(problem.getName());
    	// frame.getContentPane().setLayout(new BorderLayout());
    	// frame.getContentPane().add(panel, BorderLayout.CENTER);
    	// frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	// frame.setSize(500, 400);
    	// frame.setLocationRelativeTo(null);
    	// frame.setVisible(true);

		EncodeProblem cod = new EncodeProblem(problem);
		OnePointCrossover<Integer> opcruza = new OnePointCrossover<>(5, 0.25);
		UniformMutation opmutacion = new UniformMutation(0.25, 5);
		Ruleta<Integer,Integer> ruleta = new Ruleta<>(5, 10);
	    Fitness ff = new Fitness(problem);
		NumGeneraciones ng = new NumGeneraciones(10);

		Simple<Integer, Integer> algoSimple = new Simple<Integer, Integer>(cod,null,opcruza,opmutacion,ruleta,ff,ng, 200);
		// Simple<Boolean, Integer> algoSimple = new Simple<>(cod,null,opcruza,opmutacion,ruleta,ff,null,ng,20);
		// gaframeworkgui.GAGUI.setGA(algoSimple);
		// gaframeworkgui.GAGUI.launch(gaframeworkgui.GAGUI.class);
		algoSimple.run();
	
    }
}
