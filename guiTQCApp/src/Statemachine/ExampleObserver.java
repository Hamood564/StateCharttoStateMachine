package Statemachine;
import statemachine.IStateChangeObserver;
import states.IState;

public class ExampleObserver implements IStateChangeObserver {

	public void onStateChanged(IState newState) {
		System.out.println("State has changed, new State is: " + newState.getClass().getSimpleName());
		
	}

}
