package Statemachine;
import MaltState.maltStateMain;
import states.IStateAction;

public class ExampleActionInStarting implements IStateAction{
	
	 
	public void execute() { 
		System.out.println("Starting up whatever you are working with");
		// You can do what you want in here...
		
		maltStateMain malt1 = new maltStateMain();
		malt1.stmalt();

		
	}

}
