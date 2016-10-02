import gaframework.*;
import org.moeaframework.problem.tsplib.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;


public class Main{

    public static void main(String[] argumenta) throws IOException {

    	TSPInstance problem = new TSPInstance(new File("./data/tsp/burma14.tsp"));
    	EncodeProblem encoder =  new EncodeProblem(problem);
        Genotype<Integer> gen = encoder.newRandomGenotype();
    	
        System.out.println("Genotype: " + gen);
        System.out.println("Phenotype:" +  encoder.decode(gen));
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

		// BinInteger cod = new BinInteger(10,1);
		// OnePointCrossover<Boolean> opcruza = new OnePointCrossover<>(5, 0.25);
		// UniformMutation opmutacion = new UniformMutation(0.25, 5);
		// Ruleta<Boolean,Integer> ruleta = new Ruleta<>(5, 10);
		// MaxFun ff = new MaxFun();
		// NumGeneraciones ng = new NumGeneraciones(1000);

		// Simple<Boolean, Integer> algoSimple = new Simple<>(cod,null,opcruza,opmutacion,ruleta,ff,ng,20);
		// Simple<Boolean, Integer> algoSimple = new Simple<>(cod,null,opcruza,opmutacion,ruleta,ff,null,ng,20);
		// gaframeworkgui.GAGUI.setGA(algoSimple);
		// gaframeworkgui.GAGUI.launch(gaframeworkgui.GAGUI.class);
		//algoSimple.run();
	
    }
}
