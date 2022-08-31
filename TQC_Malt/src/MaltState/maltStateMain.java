package MaltState;

import com.yakindu.*;
import com.yakindu.core.IStatemachine;
import malt.*;
import malt.StatechartMalt.State;

public class  maltStateMain{
	
	
	public static void printstateCondition (StatechartMalt stmalt) {
		System.out.println("The active state is: "+stmalt.isActive());
	}
	
	
	public static void main(String[] args) {
		stmalt();
	}
	
	
	public static void stmalt() {
		
		//initialise statechart
		StatechartMalt stmalt1 = new StatechartMalt();
				
		//initilise variables, timers etc.
		
		
		
		//enter statemachine and activate "activate" state
		stmalt1.enter();
		printstateCondition(stmalt1);
		
		//raise introducePart event
		System.out.println("*** Initialising ***");
		stmalt1.activation().raiseIntroducePart();
		
		//go to activated composite state "part_functionality_choice"
		//by design by raising event introducePart we are in state composite state "Identifying_Part"
		//The state activated in this composite state is "FeatureIdentification"
		
		System.out.println("Composite State Part_Functionality_Choice is active:"); 		
		printstateCondition(stmalt1);
		
		//raise start event , it will raise an out event identifiedPart
		//The composite state partIdentification is activated
		//State PartRecognised is active through out event transition
		
		stmalt1.part().raiseStart();
		printstateCondition(stmalt1);
		
		//raise part_req event shifting to composite state Setting Requirement
		//Activate Cust_Req  composite state
		//activate gettingCust_Requirements
		
		stmalt1.part().raisePart_req();
		printstateCondition(stmalt1);
		
		//raise getCustomerReq event
		//activate state CustomerRequirements
		
		stmalt1.set_requirements().raiseGetCustomerReq();
		printstateCondition(stmalt1);
		
		//raise setCust_Req event
		//activate Prc_Req composite state
		// activate State gettingPrc_Requirements 
		stmalt1.set_requirements().raiseSetCust_req();
		printstateCondition(stmalt1);
		
		//raise getProcessReq event
		//activate ProcessRequirements state
		stmalt1.set_requirements().raiseGetProcessReq();
		printstateCondition(stmalt1);
		
		//raise setPrc_req event
		//activate Activate_Functionality state
		stmalt1.set_requirements().raiseSetPrc_req();
		printstateCondition(stmalt1);
		
		//raise getFunctionality event
		//activate get_functionality_choice composite state
		//activate functionality-t_variable composite state through introduce_functionality entry point
		//activate Identifying Functionality and Variables
		//activate setFunctionality state
		stmalt1.activation().raiseGetFunctionality();
		printstateCondition(stmalt1);
		
		//raise requirement_lookup event
		//activate generateFunctionalityRequirements state
		stmalt1.functionality().raiseRequirement_lookup();
		printstateCondition(stmalt1);
		
		//raise apply_functionality_req event
		//activate generateVariableList state
		stmalt1.functionality().raiseApply_functionality_req();
		printstateCondition(stmalt1);
		
		//raise match event
		//activate matchVariablewithRequirement state
		stmalt1.functionality().raiseMatch();
		printstateCondition(stmalt1);
		
		//raise getVariables event
		//activate variable determination composite state
		//activate variableValueDetermination State
		stmalt1.functionality().raiseGetVariables();
		printstateCondition(stmalt1);
		
		//raise setVariableValue event
		//activate Allocation State
		stmalt1.variable().raiseSetVariableValue();
		printstateCondition(stmalt1);
		
		//raise linking event
		//activate Deployment on System Composite State
		//activate establishingConnection State
		stmalt1.variable().raiseLinking();
		printstateCondition(stmalt1);
		
		//raise Connection event
		//activate settingRequirements state
		stmalt1.deploy().raiseConnection();
		printstateCondition(stmalt1);
		
		//raise index event
		//raise requirements event
		//activate ChangeConfiguration state
		stmalt1.deploy().raiseIndex();
		stmalt1.deploy().raiseRequirements();
		printstateCondition(stmalt1);
		
		//raise execute event
		//activate HardwareAbstraction composite state
		//activate runFunctionality state
		stmalt1.deploy().raiseExecute();
		printstateCondition(stmalt1);
		
		//raise design_exp event
		//activate Experiments state
		stmalt1.harware_abs().raiseDesign_exp();
		printstateCondition(stmalt1);
		
		//raise exiting event
		//activate exit state
		stmalt1.harware_abs().raiseExiting();
		printstateCondition(stmalt1);
		
		//activate exit
		stmalt1.exit();
		System.out.println("Test is complete!");
		
	}

}
