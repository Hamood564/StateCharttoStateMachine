package Statemachine;

//import stateMachine.ExampleActionInStarting;
//import stateMachine.ExampleObserver;
import statemachine.StateMachine;
import statemachine.StateMachineBuilder;
import states.IStateAction;
import states.State;
import states.TransitionName;
import states.impl.*;





public class behaviour_idle {
	
	public static void statecall() {
		StateMachine sm = new StateMachineBuilder().withActionInStarting(new ExampleActionInStarting()).build();
		sm.addStateChangeObserver(new ExampleObserver());
		sm.start();
		sm.suspend();
		sm.stop();
		System.out.println("The process completed");
		
		
		StateMachine sm2 = new StateMachineBuilder().withInitialState(new StoppedState()).build();
		sm2.start();
		System.out.println("The second state");
		sm2.invokeTransition(TransitionName.abort);
	}
//	
//	public static void main(String[] args) {
//		StateMachine sm = new StateMachineBuilder().withActionInStarting(new ExampleActionInStarting()).build();
//		sm.addStateChangeObserver(new ExampleObserver());
//		sm.start();
//		sm.suspend();
//		sm.stop();
//		System.out.println("The process completed");
//		
//		
//		StateMachine sm2 = new StateMachineBuilder().withInitialState(new StoppedState()).build();
//		sm2.start();
//		System.out.println("The second state");
//		sm2.invokeTransition(TransitionName.abort);
//	}
	
	public static void main(String[] args) {
		statecall();
	}
	
	

}

