import gaframework.*;
//import gaframeworkgui.*;
import gaframework.*;

public class Main{
    public static void main(String[] argumenta){
	BinInteger cod = new BinInteger(10,1);
	OnePointCrossover<Boolean> opcruza = new OnePointCrossover<>(5, 0.25);
	UniformMutation opmutacion = new UniformMutation(0.25, 5);
	Ruleta<Boolean,Integer> ruleta = new Ruleta<>(5, 10);
	MaxFun ff = new MaxFun();
	NumGeneraciones ng = new NumGeneraciones(1000);
	
	Simple<Boolean, Integer> algoSimple = new Simple<>(cod,null,opcruza,opmutacion,ruleta,ff,ng,20);
	// Simple<Boolean, Integer> algoSimple = new Simple<>(cod,null,opcruza,opmutacion,ruleta,ff,null,ng,20);
	// gaframeworkgui.GAGUI.setGA(algoSimple);
	// gaframeworkgui.GAGUI.launch(gaframeworkgui.GAGUI.class);
	algoSimple.run();
	
    }
}
