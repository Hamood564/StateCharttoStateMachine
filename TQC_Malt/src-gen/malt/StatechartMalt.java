package malt;


import com.yakindu.core.IStatemachine;
import com.yakindu.core.rx.Observable;
import java.util.LinkedList;
import java.util.Queue;

public class StatechartMalt implements IStatemachine {
	public static class Activation {
		private StatechartMalt parent;
		
		public Activation(StatechartMalt parent) {
			this.parent = parent;
			System.out.println("The parent is" + parent);
		}
		private boolean introducePart;
		
		
		public void raiseIntroducePart() {
			parent.inEventQueue.add(() -> {
				introducePart = true;
				System.out.println("Test for part is introduced...");
			});
			parent.runCycle();
		}
		
		private boolean getFunctionality;
		
		
		public void raiseGetFunctionality() {
			parent.inEventQueue.add(() -> {
				getFunctionality = true;
			});
			parent.runCycle();
		}
		
	}
	
	public static class Part {
		private StatechartMalt parent;
		
		public Part(StatechartMalt parent) {
			this.parent = parent;
		}
		private boolean start;
		
		
		public void raiseStart() {
			parent.inEventQueue.add(() -> {
				start = true;
			});
			parent.runCycle();
		}
		
		private boolean identifiedPart;
		
		
		protected void raiseIdentifiedPart() {
			identifiedPart = true;
			identifiedPartObservable.next(null);
			parent.raiseLocal_part_identifiedPart();
		}
		
		private Observable<Void> identifiedPartObservable = new Observable<Void>();
		
		public Observable<Void> getIdentifiedPart() {
			return identifiedPartObservable;
		}
		
		private boolean part_req;
		
		
		public void raisePart_req() {
			parent.inEventQueue.add(() -> {
				part_req = true;
			});
			parent.runCycle();
		}
		
	}
	
	public static class Set_requirements {
		private StatechartMalt parent;
		
		public Set_requirements(StatechartMalt parent) {
			this.parent = parent;
		}
		private boolean getCustomerReq;
		
		
		public void raiseGetCustomerReq() {
			parent.inEventQueue.add(() -> {
				getCustomerReq = true;
			});
			parent.runCycle();
		}
		
		private boolean setCust_req;
		
		
		public void raiseSetCust_req() {
			parent.inEventQueue.add(() -> {
				setCust_req = true;
			});
			parent.runCycle();
		}
		
		private boolean getProcessReq;
		
		
		public void raiseGetProcessReq() {
			parent.inEventQueue.add(() -> {
				getProcessReq = true;
			});
			parent.runCycle();
		}
		
		private boolean setPrc_req;
		
		
		public void raiseSetPrc_req() {
			parent.inEventQueue.add(() -> {
				setPrc_req = true;
			});
			parent.runCycle();
		}
		
	}
	
	public static class Functionality {
		private StatechartMalt parent;
		
		public Functionality(StatechartMalt parent) {
			this.parent = parent;
		}
		private boolean requirement_lookup;
		
		
		public void raiseRequirement_lookup() {
			parent.inEventQueue.add(() -> {
				requirement_lookup = true;
			});
			parent.runCycle();
		}
		
		private boolean apply_functionality_req;
		
		
		public void raiseApply_functionality_req() {
			parent.inEventQueue.add(() -> {
				apply_functionality_req = true;
			});
			parent.runCycle();
		}
		
		private boolean match;
		
		
		public void raiseMatch() {
			parent.inEventQueue.add(() -> {
				match = true;
			});
			parent.runCycle();
		}
		
		private boolean getVariables;
		
		
		public void raiseGetVariables() {
			parent.inEventQueue.add(() -> {
				getVariables = true;
			});
			parent.runCycle();
		}
		
	}
	
	public static class Variable {
		private StatechartMalt parent;
		
		public Variable(StatechartMalt parent) {
			this.parent = parent;
		}
		private boolean setVariableValue;
		
		
		public void raiseSetVariableValue() {
			parent.inEventQueue.add(() -> {
				setVariableValue = true;
			});
			parent.runCycle();
		}
		
		private boolean linking;
		
		
		public void raiseLinking() {
			parent.inEventQueue.add(() -> {
				linking = true;
			});
			parent.runCycle();
		}
		
	}
	
	public static class Deploy {
		private StatechartMalt parent;
		
		public Deploy(StatechartMalt parent) {
			this.parent = parent;
		}
		private boolean connection;
		
		
		public void raiseConnection() {
			parent.inEventQueue.add(() -> {
				connection = true;
			});
			parent.runCycle();
		}
		
		private boolean index;
		
		
		public void raiseIndex() {
			parent.inEventQueue.add(() -> {
				index = true;
			});
			parent.runCycle();
		}
		
		private boolean requirements;
		
		
		public void raiseRequirements() {
			parent.inEventQueue.add(() -> {
				requirements = true;
			});
			parent.runCycle();
		}
		
		private boolean execute;
		
		
		public void raiseExecute() {
			parent.inEventQueue.add(() -> {
				execute = true;
			});
			parent.runCycle();
		}
		
	}
	
	public static class Harware_abs {
		private StatechartMalt parent;
		
		public Harware_abs(StatechartMalt parent) {
			this.parent = parent;
		}
		private boolean design_exp;
		
		
		public void raiseDesign_exp() {
			parent.inEventQueue.add(() -> {
				design_exp = true;
			});
			parent.runCycle();
		}
		
		private boolean exiting;
		
		
		public void raiseExiting() {
			parent.inEventQueue.add(() -> {
				exiting = true;
			});
			parent.runCycle();
		}
		
	}
	
	protected Activation activation;
	
	protected Part part;
	
	protected Set_requirements set_requirements;
	
	protected Functionality functionality;
	
	protected Variable variable;
	
	protected Deploy deploy;
	
	protected Harware_abs harware_abs;
	
	public enum State {
		SELF_CONFIGURATION_ACTIVATE,
		SELF_CONFIGURATION_SETTING_REQUIREMENT,
		SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ,
		SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ_CUSTOMER_GETTINGCUST_REQUIREMENTS,
		SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ_CUSTOMER_CUSTOMERREQUIREMENTS,
		SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_PRC_REQ,
		SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_PRC_REQ_PROCESS_GETTINGPRC_REQUIREMENTS,
		SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_PRC_REQ_PROCESS_PROCESSREQUIREMENT,
		SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE,
		SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART,
		SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_FEATUREIDENTIFICATION,
		SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_PARTIDENTFICATION,
		SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_PARTIDENTFICATION_FEATURE_FEATUREEXTRACT,
		SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_PARTIDENTFICATION_FEATURE_PARTRECOGNISED,
		SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE,
		SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES,
		SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_SETFUNTIONALITY,
		SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_GENERATEFUNCTIONALITYREQUIREMENTS,
		SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_GENERATEVARIABLELIST,
		SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_MATCHVARIABLEWITHREQUIREMENTS,
		SELF_CONFIGURATION_ACTIVATE_FUNCTIONALITY,
		SELF_CONFIGURATION_VARIABLE_DETERMINATION,
		SELF_CONFIGURATION_VARIABLE_DETERMINATION_VARIABLE_ALLOCATION_VARIABLEVALUEDETERMINATION,
		SELF_CONFIGURATION_VARIABLE_DETERMINATION_VARIABLE_ALLOCATION_ALLOCATION,
		SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM,
		SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_ESTABLISHINGCONNECTION,
		SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_SETTINGREQUIREMENTS,
		SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_CHANGECONFIGURATION,
		SELF_CONFIGURATION_HARDWARE_ABSTRACTION,
		SELF_CONFIGURATION_HARDWARE_ABSTRACTION_EXECUTION_RUNFUNCTIONALITY,
		SELF_CONFIGURATION_HARDWARE_ABSTRACTION_EXECUTION_EXPERIMENT,
		SELF_CONFIGURATION__FINAL_,
		$NULLSTATE$
	};
	
	private final State[] stateVector = new State[1];
	
	private Queue<Runnable> internalEventQueue = new LinkedList<Runnable>();
	private Queue<Runnable> inEventQueue = new LinkedList<Runnable>();
	private boolean local_part_identifiedPart;
	private boolean isExecuting;
	
	protected boolean getIsExecuting() {
		return isExecuting;
	}
	
	protected void setIsExecuting(boolean value) {
		this.isExecuting = value;
	}
	public StatechartMalt() {
		activation = new Activation(this);
		part = new Part(this);
		set_requirements = new Set_requirements(this);
		functionality = new Functionality(this);
		variable = new Variable(this);
		deploy = new Deploy(this);
		harware_abs = new Harware_abs(this);
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NULLSTATE$;
		}
		
		clearInEvents();
		clearInternalEvents();
		
		
		isExecuting = false;
	}
	
	public void enter() {
		
		System.out.println("We are entering!");
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		
		enterSequence_self_Configuration_default();
		isExecuting = false;
	}
	
	public void exit() {
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		
		exitSequence_self_Configuration();
		isExecuting = false;
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public String isActive() {
		return stateVector[0].toString();
//		return stateVector[0] != State.$NULLSTATE$;
	}
	
	/** 
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return (stateVector[0] == State.SELF_CONFIGURATION__FINAL_);
	}
	private void clearInEvents() {
		myEvent = false;
		matchrequirmentswithvariables = false;
		generate_rules = false;
		setvariable = false;
		setfun_rule = false;
		apply_funrule = false;
		set_req = false;
		apply_varrule = false;
		off = false;
		req_confirm = false;
		activation.introducePart = false;
		activation.getFunctionality = false;
		part.start = false;
		part.part_req = false;
		set_requirements.getCustomerReq = false;
		set_requirements.setCust_req = false;
		set_requirements.getProcessReq = false;
		set_requirements.setPrc_req = false;
		functionality.requirement_lookup = false;
		functionality.apply_functionality_req = false;
		functionality.match = false;
		functionality.getVariables = false;
		variable.setVariableValue = false;
		variable.linking = false;
		deploy.connection = false;
		deploy.index = false;
		deploy.requirements = false;
		deploy.execute = false;
		harware_abs.design_exp = false;
		harware_abs.exiting = false;
	}
	
	private void clearInternalEvents() {
		local_part_identifiedPart = false;
	}
	
	private void microStep() {
		switch (stateVector[0]) {
		case SELF_CONFIGURATION_ACTIVATE:
			self_Configuration_Activate_react(-1l);
			break;
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ_CUSTOMER_GETTINGCUST_REQUIREMENTS:
			self_Configuration_Setting_Requirement_requirements_Cust_Req_customer_gettingCust_Requirements_react(-1l);
			break;
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ_CUSTOMER_CUSTOMERREQUIREMENTS:
			self_Configuration_Setting_Requirement_requirements_Cust_Req_customer_CustomerRequirements_react(-1l);
			break;
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_PRC_REQ_PROCESS_GETTINGPRC_REQUIREMENTS:
			self_Configuration_Setting_Requirement_requirements_Prc_Req_process_gettingPrc_Requirements_react(-1l);
			break;
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_PRC_REQ_PROCESS_PROCESSREQUIREMENT:
			self_Configuration_Setting_Requirement_requirements_Prc_Req_process_ProcessRequirement_react(-1l);
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_FEATUREIDENTIFICATION:
			self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_FeatureIdentification_react(-1l);
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_PARTIDENTFICATION_FEATURE_FEATUREEXTRACT:
			self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_feature_FeatureExtract_react(-1l);
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_PARTIDENTFICATION_FEATURE_PARTRECOGNISED:
			self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_feature_PartRecognised_react(-1l);
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_SETFUNTIONALITY:
			self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_setFuntionality_react(-1l);
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_GENERATEFUNCTIONALITYREQUIREMENTS:
			self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_generateFunctionalityRequirements_react(-1l);
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_GENERATEVARIABLELIST:
			self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_generateVariableList_react(-1l);
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_MATCHVARIABLEWITHREQUIREMENTS:
			self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_matchVariablewithRequirements_react(-1l);
			break;
		case SELF_CONFIGURATION_ACTIVATE_FUNCTIONALITY:
			self_Configuration_Activate_Functionality_react(-1l);
			break;
		case SELF_CONFIGURATION_VARIABLE_DETERMINATION_VARIABLE_ALLOCATION_VARIABLEVALUEDETERMINATION:
			self_Configuration_Variable_Determination_Variable_Allocation_variableValueDetermination_react(-1l);
			break;
		case SELF_CONFIGURATION_VARIABLE_DETERMINATION_VARIABLE_ALLOCATION_ALLOCATION:
			self_Configuration_Variable_Determination_Variable_Allocation_Allocation_react(-1l);
			break;
		case SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_ESTABLISHINGCONNECTION:
			self_Configuration_Deployment_on_System_Configuration_establishingConnection_react(-1l);
			break;
		case SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_SETTINGREQUIREMENTS:
			self_Configuration_Deployment_on_System_Configuration_settingRequirements_react(-1l);
			break;
		case SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_CHANGECONFIGURATION:
			self_Configuration_Deployment_on_System_Configuration_ChangeConfiguration_react(-1l);
			break;
		case SELF_CONFIGURATION_HARDWARE_ABSTRACTION_EXECUTION_RUNFUNCTIONALITY:
			self_Configuration_Hardware_Abstraction_Execution_runFunctionality_react(-1l);
			break;
		case SELF_CONFIGURATION_HARDWARE_ABSTRACTION_EXECUTION_EXPERIMENT:
			self_Configuration_Hardware_Abstraction_Execution_Experiment_react(-1l);
			break;
		case SELF_CONFIGURATION__FINAL_:
			self_Configuration__final__react(-1l);
			break;
		default:
			break;
		}
	}
	
	private void runCycle() {
		
		
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		
		nextEvent();
		do { 
			microStep();
			
			clearInEvents();
			
			clearInternalEvents();
			
			nextEvent();
		} while (((((((((((((((((((((((((((((((myEvent || matchrequirmentswithvariables) || generate_rules) || setvariable) || setfun_rule) || apply_funrule) || set_req) || apply_varrule) || off) || req_confirm) || activation.introducePart) || activation.getFunctionality) || part.start) || part.part_req) || set_requirements.getCustomerReq) || set_requirements.setCust_req) || set_requirements.getProcessReq) || set_requirements.setPrc_req) || functionality.requirement_lookup) || functionality.apply_functionality_req) || functionality.match) || functionality.getVariables) || variable.setVariableValue) || variable.linking) || deploy.connection) || deploy.index) || deploy.requirements) || deploy.execute) || harware_abs.design_exp) || harware_abs.exiting) || local_part_identifiedPart));
		
		isExecuting = false;
	}
	
	protected void nextEvent() {
		if(!internalEventQueue.isEmpty()) {
			internalEventQueue.poll().run();
			return;
		}
		if(!inEventQueue.isEmpty()) {
			inEventQueue.poll().run();
			return;
		}
	}
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
	
		switch (state) {
		case SELF_CONFIGURATION_ACTIVATE:
			return stateVector[0] == State.SELF_CONFIGURATION_ACTIVATE;
		case SELF_CONFIGURATION_SETTING_REQUIREMENT:
			return stateVector[0].ordinal() >= State.
					SELF_CONFIGURATION_SETTING_REQUIREMENT.ordinal()&& stateVector[0].ordinal() <= State.SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_PRC_REQ_PROCESS_PROCESSREQUIREMENT.ordinal();
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ:
			return stateVector[0].ordinal() >= State.
					SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ.ordinal()&& stateVector[0].ordinal() <= State.SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ_CUSTOMER_CUSTOMERREQUIREMENTS.ordinal();
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ_CUSTOMER_GETTINGCUST_REQUIREMENTS:
			return stateVector[0] == State.SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ_CUSTOMER_GETTINGCUST_REQUIREMENTS;
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ_CUSTOMER_CUSTOMERREQUIREMENTS:
			return stateVector[0] == State.SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ_CUSTOMER_CUSTOMERREQUIREMENTS;
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_PRC_REQ:
			return stateVector[0].ordinal() >= State.
					SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_PRC_REQ.ordinal()&& stateVector[0].ordinal() <= State.SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_PRC_REQ_PROCESS_PROCESSREQUIREMENT.ordinal();
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_PRC_REQ_PROCESS_GETTINGPRC_REQUIREMENTS:
			return stateVector[0] == State.SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_PRC_REQ_PROCESS_GETTINGPRC_REQUIREMENTS;
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_PRC_REQ_PROCESS_PROCESSREQUIREMENT:
			return stateVector[0] == State.SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_PRC_REQ_PROCESS_PROCESSREQUIREMENT;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE:
			return stateVector[0].ordinal() >= State.
					SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE.ordinal()&& stateVector[0].ordinal() <= State.SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_MATCHVARIABLEWITHREQUIREMENTS.ordinal();
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART:
			return stateVector[0].ordinal() >= State.
					SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART.ordinal()&& stateVector[0].ordinal() <= State.SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_PARTIDENTFICATION_FEATURE_PARTRECOGNISED.ordinal();
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_FEATUREIDENTIFICATION:
			return stateVector[0] == State.SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_FEATUREIDENTIFICATION;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_PARTIDENTFICATION:
			return stateVector[0].ordinal() >= State.
					SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_PARTIDENTFICATION.ordinal()&& stateVector[0].ordinal() <= State.SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_PARTIDENTFICATION_FEATURE_PARTRECOGNISED.ordinal();
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_PARTIDENTFICATION_FEATURE_FEATUREEXTRACT:
			return stateVector[0] == State.SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_PARTIDENTFICATION_FEATURE_FEATUREEXTRACT;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_PARTIDENTFICATION_FEATURE_PARTRECOGNISED:
			return stateVector[0] == State.SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_PARTIDENTFICATION_FEATURE_PARTRECOGNISED;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE:
			return stateVector[0].ordinal() >= State.
					SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE.ordinal()&& stateVector[0].ordinal() <= State.SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_MATCHVARIABLEWITHREQUIREMENTS.ordinal();
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES:
			return stateVector[0].ordinal() >= State.
					SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES.ordinal()&& stateVector[0].ordinal() <= State.SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_GENERATEVARIABLELIST.ordinal();
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_SETFUNTIONALITY:
			return stateVector[0] == State.SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_SETFUNTIONALITY;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_GENERATEFUNCTIONALITYREQUIREMENTS:
			return stateVector[0] == State.SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_GENERATEFUNCTIONALITYREQUIREMENTS;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_GENERATEVARIABLELIST:
			return stateVector[0] == State.SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_GENERATEVARIABLELIST;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_MATCHVARIABLEWITHREQUIREMENTS:
			return stateVector[0] == State.SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_MATCHVARIABLEWITHREQUIREMENTS;
		case SELF_CONFIGURATION_ACTIVATE_FUNCTIONALITY:
			return stateVector[0] == State.SELF_CONFIGURATION_ACTIVATE_FUNCTIONALITY;
		case SELF_CONFIGURATION_VARIABLE_DETERMINATION:
			return stateVector[0].ordinal() >= State.
					SELF_CONFIGURATION_VARIABLE_DETERMINATION.ordinal()&& stateVector[0].ordinal() <= State.SELF_CONFIGURATION_VARIABLE_DETERMINATION_VARIABLE_ALLOCATION_ALLOCATION.ordinal();
		case SELF_CONFIGURATION_VARIABLE_DETERMINATION_VARIABLE_ALLOCATION_VARIABLEVALUEDETERMINATION:
			return stateVector[0] == State.SELF_CONFIGURATION_VARIABLE_DETERMINATION_VARIABLE_ALLOCATION_VARIABLEVALUEDETERMINATION;
		case SELF_CONFIGURATION_VARIABLE_DETERMINATION_VARIABLE_ALLOCATION_ALLOCATION:
			return stateVector[0] == State.SELF_CONFIGURATION_VARIABLE_DETERMINATION_VARIABLE_ALLOCATION_ALLOCATION;
		case SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM:
			return stateVector[0].ordinal() >= State.
					SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM.ordinal()&& stateVector[0].ordinal() <= State.SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_CHANGECONFIGURATION.ordinal();
		case SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_ESTABLISHINGCONNECTION:
			return stateVector[0] == State.SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_ESTABLISHINGCONNECTION;
		case SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_SETTINGREQUIREMENTS:
			return stateVector[0] == State.SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_SETTINGREQUIREMENTS;
		case SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_CHANGECONFIGURATION:
			return stateVector[0] == State.SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_CHANGECONFIGURATION;
		case SELF_CONFIGURATION_HARDWARE_ABSTRACTION:
			return stateVector[0].ordinal() >= State.
					SELF_CONFIGURATION_HARDWARE_ABSTRACTION.ordinal()&& stateVector[0].ordinal() <= State.SELF_CONFIGURATION_HARDWARE_ABSTRACTION_EXECUTION_EXPERIMENT.ordinal();
		case SELF_CONFIGURATION_HARDWARE_ABSTRACTION_EXECUTION_RUNFUNCTIONALITY:
			return stateVector[0] == State.SELF_CONFIGURATION_HARDWARE_ABSTRACTION_EXECUTION_RUNFUNCTIONALITY;
		case SELF_CONFIGURATION_HARDWARE_ABSTRACTION_EXECUTION_EXPERIMENT:
			return stateVector[0] == State.SELF_CONFIGURATION_HARDWARE_ABSTRACTION_EXECUTION_EXPERIMENT;
		case SELF_CONFIGURATION__FINAL_:
			return stateVector[0] == State.SELF_CONFIGURATION__FINAL_;
		default:
			return false;
		}
	}
	
	public Activation activation() {
		return activation;
	}
	
	public Part part() {
		return part;
	}
	
	public Set_requirements set_requirements() {
		return set_requirements;
	}
	
	public Functionality functionality() {
		return functionality;
	}
	
	public Variable variable() {
		return variable;
	}
	
	public Deploy deploy() {
		return deploy;
	}
	
	public Harware_abs harware_abs() {
		return harware_abs;
	}
	
	
	protected void raiseLocal_part_identifiedPart() {
		internalEventQueue.add(() -> {
			local_part_identifiedPart = true;
		});
	}
	
	private boolean myEvent;
	
	
	public void raiseMyEvent() {
		inEventQueue.add(() -> {
			myEvent = true;
		});
		runCycle();
	}
	
	private boolean matchrequirmentswithvariables;
	
	
	public void raiseMatchrequirmentswithvariables() {
		inEventQueue.add(() -> {
			matchrequirmentswithvariables = true;
		});
		runCycle();
	}
	
	private boolean generate_rules;
	
	
	public void raiseGenerate_rules() {
		inEventQueue.add(() -> {
			generate_rules = true;
		});
		runCycle();
	}
	
	private boolean setvariable;
	
	
	public void raiseSetvariable() {
		inEventQueue.add(() -> {
			setvariable = true;
		});
		runCycle();
	}
	
	private boolean setfun_rule;
	
	
	public void raiseSetfun_rule() {
		inEventQueue.add(() -> {
			setfun_rule = true;
		});
		runCycle();
	}
	
	private boolean apply_funrule;
	
	
	public void raiseApply_funrule() {
		inEventQueue.add(() -> {
			apply_funrule = true;
		});
		runCycle();
	}
	
	private boolean set_req;
	
	
	public void raiseSet_req() {
		inEventQueue.add(() -> {
			set_req = true;
		});
		runCycle();
	}
	
	private boolean apply_varrule;
	
	
	public void raiseApply_varrule() {
		inEventQueue.add(() -> {
			apply_varrule = true;
		});
		runCycle();
	}
	
	private boolean off;
	
	
	public void raiseOff() {
		inEventQueue.add(() -> {
			off = true;
		});
		runCycle();
	}
	
	private boolean req_confirm;
	
	
	public void raiseReq_confirm() {
		inEventQueue.add(() -> {
			req_confirm = true;
		});
		runCycle();
	}
	
	/* 'default' enter sequence for state Activate */
	private void enterSequence_self_Configuration_Activate_default() {
		stateVector[0] = State.SELF_CONFIGURATION_ACTIVATE;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for state Setting Requirement */
	private void enterSequence_self_Configuration_Setting_Requirement_default() {
		enterSequence_self_Configuration_Setting_Requirement_requirements_default();
		
	}
	
	/* 'default' enter sequence for state Cust_Req */
	private void enterSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req_default() {
		enterSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req_customer_default();
	
	}
	
	/* 'default' enter sequence for state gettingCust_Requirements */
	private void enterSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req_customer_gettingCust_Requirements_default() {
		stateVector[0] = State.SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ_CUSTOMER_GETTINGCUST_REQUIREMENTS;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for state CustomerRequirements */
	private void enterSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req_customer_CustomerRequirements_default() {
		stateVector[0] = State.SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ_CUSTOMER_CUSTOMERREQUIREMENTS;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for state Prc_Req */
	private void enterSequence_self_Configuration_Setting_Requirement_requirements_Prc_Req_default() {
		enterSequence_self_Configuration_Setting_Requirement_requirements_Prc_Req_process_default();
		
	}
	
	/* 'default' enter sequence for state gettingPrc_Requirements */
	private void enterSequence_self_Configuration_Setting_Requirement_requirements_Prc_Req_process_gettingPrc_Requirements_default() {
		stateVector[0] = State.SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_PRC_REQ_PROCESS_GETTINGPRC_REQUIREMENTS;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for state ProcessRequirement */
	private void enterSequence_self_Configuration_Setting_Requirement_requirements_Prc_Req_process_ProcessRequirement_default() {
		stateVector[0] = State.SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_PRC_REQ_PROCESS_PROCESSREQUIREMENT;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for state part_functionality_choice */
	private void enterSequence_self_Configuration_part_functionality_choice_default() {
		enterSequence_self_Configuration_part_functionality_choice_choice_default();
		
	}
	
	/* 'introduce_functionality' enter sequence for state part_functionality_choice */
	private void enterSequence_self_Configuration_part_functionality_choice_introduce_functionality() {
		enterSequence_self_Configuration_part_functionality_choice_choice_introduce_functionality();
		
	}
	
	/* 'default' enter sequence for state Identifying_Part */
	private void enterSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_default() {
		enterSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_default();
		
	}
	
	/* 'default' enter sequence for state FeatureIdentification */
	private void enterSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_FeatureIdentification_default() {
		stateVector[0] = State.SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_FEATUREIDENTIFICATION;
		System.out.println("We are in State" + stateVector[0].toString() +":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for state PartIdentfication */
	private void enterSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_default() {
		enterSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_feature_default();
		
	}
	
	/* 'default' enter sequence for state FeatureExtract */
	private void enterSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_feature_FeatureExtract_default() {
		stateVector[0] = State.SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_PARTIDENTFICATION_FEATURE_FEATUREEXTRACT;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for state PartRecognised */
	private void enterSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_feature_PartRecognised_default() {
		stateVector[0] = State.SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_PARTIDENTFICATION_FEATURE_PARTRECOGNISED;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for state Funtionality_to_variable */
	private void enterSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_default() {
		enterSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_default();
		
	}
	
	/* 'default' enter sequence for state Identifying Functionality and Variables */
	private void enterSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_default() {
		enterSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_default();
		
	}
	
	/* 'default' enter sequence for state setFuntionality */
	private void enterSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_setFuntionality_default() {
		stateVector[0] = State.SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_SETFUNTIONALITY;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for state generateFunctionalityRequirements */
	private void enterSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_generateFunctionalityRequirements_default() {
		stateVector[0] = State.SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_GENERATEFUNCTIONALITYREQUIREMENTS;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for state generateVariableList */
	private void enterSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_generateVariableList_default() {
		stateVector[0] = State.SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_GENERATEVARIABLELIST;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for state matchVariablewithRequirements */
	private void enterSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_matchVariablewithRequirements_default() {
		stateVector[0] = State.SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_MATCHVARIABLEWITHREQUIREMENTS;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for state Activate_Functionality */
	private void enterSequence_self_Configuration_Activate_Functionality_default() {
		stateVector[0] = State.SELF_CONFIGURATION_ACTIVATE_FUNCTIONALITY;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for state Variable Determination */
	private void enterSequence_self_Configuration_Variable_Determination_default() {
		enterSequence_self_Configuration_Variable_Determination_Variable_Allocation_default();
		
	}
	
	/* 'default' enter sequence for state variableValueDetermination */
	private void enterSequence_self_Configuration_Variable_Determination_Variable_Allocation_variableValueDetermination_default() {
		stateVector[0] = State.SELF_CONFIGURATION_VARIABLE_DETERMINATION_VARIABLE_ALLOCATION_VARIABLEVALUEDETERMINATION;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for state Allocation */
	private void enterSequence_self_Configuration_Variable_Determination_Variable_Allocation_Allocation_default() {
		stateVector[0] = State.SELF_CONFIGURATION_VARIABLE_DETERMINATION_VARIABLE_ALLOCATION_ALLOCATION;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for state Deployment on System */
	private void enterSequence_self_Configuration_Deployment_on_System_default() {
		enterSequence_self_Configuration_Deployment_on_System_Configuration_default();
		
	}
	
	/* 'default' enter sequence for state establishingConnection */
	private void enterSequence_self_Configuration_Deployment_on_System_Configuration_establishingConnection_default() {
		stateVector[0] = State.SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_ESTABLISHINGCONNECTION;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for state settingRequirements */
	private void enterSequence_self_Configuration_Deployment_on_System_Configuration_settingRequirements_default() {
		stateVector[0] = State.SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_SETTINGREQUIREMENTS;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for state ChangeConfiguration */
	private void enterSequence_self_Configuration_Deployment_on_System_Configuration_ChangeConfiguration_default() {
		stateVector[0] = State.SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_CHANGECONFIGURATION;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for state Hardware Abstraction */
	private void enterSequence_self_Configuration_Hardware_Abstraction_default() {
		enterSequence_self_Configuration_Hardware_Abstraction_Execution_default();
	}
	
	/* 'default' enter sequence for state runFunctionality */
	private void enterSequence_self_Configuration_Hardware_Abstraction_Execution_runFunctionality_default() {
		stateVector[0] = State.SELF_CONFIGURATION_HARDWARE_ABSTRACTION_EXECUTION_RUNFUNCTIONALITY;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for state Experiment */
	private void enterSequence_self_Configuration_Hardware_Abstraction_Execution_Experiment_default() {
		stateVector[0] = State.SELF_CONFIGURATION_HARDWARE_ABSTRACTION_EXECUTION_EXPERIMENT;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* Default enter sequence for final state */
	private void enterSequence_self_Configuration__final__default() {
		stateVector[0] = State.SELF_CONFIGURATION__FINAL_;
		System.out.println("We are in State" + stateVector[0].toString() + ":entry.. we can do process here!");
	}
	
	/* 'default' enter sequence for region self-Configuration */
	private void enterSequence_self_Configuration_default() {
		react_self_Configuration__entry_Default();
	}
	
	/* 'default' enter sequence for region requirements */
	private void enterSequence_self_Configuration_Setting_Requirement_requirements_default() {
		react_self_Configuration_Setting_Requirement_requirements__entry_Default();
	}
	
	/* 'default' enter sequence for region customer */
	private void enterSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req_customer_default() {
		react_self_Configuration_Setting_Requirement_requirements_Cust_Req_customer__entry_Default();
	}
	
	/* 'default' enter sequence for region process */
	private void enterSequence_self_Configuration_Setting_Requirement_requirements_Prc_Req_process_default() {
		react_self_Configuration_Setting_Requirement_requirements_Prc_Req_process__entry_Default();
	}
	
	/* 'default' enter sequence for region choice */
	private void enterSequence_self_Configuration_part_functionality_choice_choice_default() {
		react_self_Configuration_part_functionality_choice_choice__entry_Default();
	}
	
	/* 'introduce_functionality' enter sequence for region choice */
	private void enterSequence_self_Configuration_part_functionality_choice_choice_introduce_functionality() {
		react_self_Configuration_part_functionality_choice_choice_introduce_functionality();
	}
	
	/* 'default' enter sequence for region identify */
	private void enterSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_default() {
		react_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify__entry_Default();
	}
	
	/* 'default' enter sequence for region feature */
	private void enterSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_feature_default() {
		react_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_feature__entry_Default();
	}
	
	/* 'default' enter sequence for region matching */
	private void enterSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_default() {
		react_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching__entry_Default();
	}
	
	/* 'default' enter sequence for region identification */
	private void enterSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_default() {
		react_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification__entry_Default();
	}
	
	/* 'default' enter sequence for region Variable_Allocation */
	private void enterSequence_self_Configuration_Variable_Determination_Variable_Allocation_default() {
		react_self_Configuration_Variable_Determination_Variable_Allocation__entry_Default();
	}
	
	/* 'default' enter sequence for region Configuration */
	private void enterSequence_self_Configuration_Deployment_on_System_Configuration_default() {
		react_self_Configuration_Deployment_on_System_Configuration__entry_Default();
	}
	
	/* 'default' enter sequence for region Execution */
	private void enterSequence_self_Configuration_Hardware_Abstraction_Execution_default() {
		react_self_Configuration_Hardware_Abstraction_Execution__entry_Default();
	}
	
	/* Default exit sequence for state Activate */
	private void exitSequence_self_Configuration_Activate() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state Setting Requirement */
	private void exitSequence_self_Configuration_Setting_Requirement() {
		exitSequence_self_Configuration_Setting_Requirement_requirements();
	}
	
	/* Default exit sequence for state Cust_Req */
	private void exitSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req() {
		exitSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req_customer();
	}
	
	/* Default exit sequence for state gettingCust_Requirements */
	private void exitSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req_customer_gettingCust_Requirements() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state CustomerRequirements */
	private void exitSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req_customer_CustomerRequirements() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state gettingPrc_Requirements */
	private void exitSequence_self_Configuration_Setting_Requirement_requirements_Prc_Req_process_gettingPrc_Requirements() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state ProcessRequirement */
	private void exitSequence_self_Configuration_Setting_Requirement_requirements_Prc_Req_process_ProcessRequirement() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state part_functionality_choice */
	private void exitSequence_self_Configuration_part_functionality_choice() {
		exitSequence_self_Configuration_part_functionality_choice_choice();
	}
	
	/* Default exit sequence for state FeatureIdentification */
	private void exitSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_FeatureIdentification() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state FeatureExtract */
	private void exitSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_feature_FeatureExtract() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state PartRecognised */
	private void exitSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_feature_PartRecognised() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state Identifying Functionality and Variables */
	private void exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables() {
		exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification();
	}
	
	/* Default exit sequence for state setFuntionality */
	private void exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_setFuntionality() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state generateFunctionalityRequirements */
	private void exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_generateFunctionalityRequirements() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state generateVariableList */
	private void exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_generateVariableList() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state matchVariablewithRequirements */
	private void exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_matchVariablewithRequirements() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state Activate_Functionality */
	private void exitSequence_self_Configuration_Activate_Functionality() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state Variable Determination */
	private void exitSequence_self_Configuration_Variable_Determination() {
		exitSequence_self_Configuration_Variable_Determination_Variable_Allocation();
	}
	
	/* Default exit sequence for state variableValueDetermination */
	private void exitSequence_self_Configuration_Variable_Determination_Variable_Allocation_variableValueDetermination() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state Allocation */
	private void exitSequence_self_Configuration_Variable_Determination_Variable_Allocation_Allocation() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state Deployment on System */
	private void exitSequence_self_Configuration_Deployment_on_System() {
		exitSequence_self_Configuration_Deployment_on_System_Configuration();
	}
	
	/* Default exit sequence for state establishingConnection */
	private void exitSequence_self_Configuration_Deployment_on_System_Configuration_establishingConnection() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state settingRequirements */
	private void exitSequence_self_Configuration_Deployment_on_System_Configuration_settingRequirements() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state ChangeConfiguration */
	private void exitSequence_self_Configuration_Deployment_on_System_Configuration_ChangeConfiguration() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state Hardware Abstraction */
	private void exitSequence_self_Configuration_Hardware_Abstraction() {
		exitSequence_self_Configuration_Hardware_Abstraction_Execution();
	}
	
	/* Default exit sequence for state runFunctionality */
	private void exitSequence_self_Configuration_Hardware_Abstraction_Execution_runFunctionality() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state Experiment */
	private void exitSequence_self_Configuration_Hardware_Abstraction_Execution_Experiment() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for final state. */
	private void exitSequence_self_Configuration__final_() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for region self-Configuration */
	private void exitSequence_self_Configuration() {
		switch (stateVector[0]) {
		case SELF_CONFIGURATION_ACTIVATE:
			exitSequence_self_Configuration_Activate();
			break;
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ_CUSTOMER_GETTINGCUST_REQUIREMENTS:
			exitSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req_customer_gettingCust_Requirements();
			break;
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ_CUSTOMER_CUSTOMERREQUIREMENTS:
			exitSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req_customer_CustomerRequirements();
			break;
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_PRC_REQ_PROCESS_GETTINGPRC_REQUIREMENTS:
			exitSequence_self_Configuration_Setting_Requirement_requirements_Prc_Req_process_gettingPrc_Requirements();
			break;
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_PRC_REQ_PROCESS_PROCESSREQUIREMENT:
			exitSequence_self_Configuration_Setting_Requirement_requirements_Prc_Req_process_ProcessRequirement();
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_FEATUREIDENTIFICATION:
			exitSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_FeatureIdentification();
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_PARTIDENTFICATION_FEATURE_FEATUREEXTRACT:
			exitSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_feature_FeatureExtract();
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_PARTIDENTFICATION_FEATURE_PARTRECOGNISED:
			exitSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_feature_PartRecognised();
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_SETFUNTIONALITY:
			exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_setFuntionality();
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_GENERATEFUNCTIONALITYREQUIREMENTS:
			exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_generateFunctionalityRequirements();
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_GENERATEVARIABLELIST:
			exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_generateVariableList();
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_MATCHVARIABLEWITHREQUIREMENTS:
			exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_matchVariablewithRequirements();
			break;
		case SELF_CONFIGURATION_ACTIVATE_FUNCTIONALITY:
			exitSequence_self_Configuration_Activate_Functionality();
			break;
		case SELF_CONFIGURATION_VARIABLE_DETERMINATION_VARIABLE_ALLOCATION_VARIABLEVALUEDETERMINATION:
			exitSequence_self_Configuration_Variable_Determination_Variable_Allocation_variableValueDetermination();
			break;
		case SELF_CONFIGURATION_VARIABLE_DETERMINATION_VARIABLE_ALLOCATION_ALLOCATION:
			exitSequence_self_Configuration_Variable_Determination_Variable_Allocation_Allocation();
			break;
		case SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_ESTABLISHINGCONNECTION:
			exitSequence_self_Configuration_Deployment_on_System_Configuration_establishingConnection();
			break;
		case SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_SETTINGREQUIREMENTS:
			exitSequence_self_Configuration_Deployment_on_System_Configuration_settingRequirements();
			break;
		case SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_CHANGECONFIGURATION:
			exitSequence_self_Configuration_Deployment_on_System_Configuration_ChangeConfiguration();
			break;
		case SELF_CONFIGURATION_HARDWARE_ABSTRACTION_EXECUTION_RUNFUNCTIONALITY:
			exitSequence_self_Configuration_Hardware_Abstraction_Execution_runFunctionality();
			break;
		case SELF_CONFIGURATION_HARDWARE_ABSTRACTION_EXECUTION_EXPERIMENT:
			exitSequence_self_Configuration_Hardware_Abstraction_Execution_Experiment();
			break;
		case SELF_CONFIGURATION__FINAL_:
			exitSequence_self_Configuration__final_();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region requirements */
	private void exitSequence_self_Configuration_Setting_Requirement_requirements() {
		switch (stateVector[0]) {
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ_CUSTOMER_GETTINGCUST_REQUIREMENTS:
			exitSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req_customer_gettingCust_Requirements();
			break;
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ_CUSTOMER_CUSTOMERREQUIREMENTS:
			exitSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req_customer_CustomerRequirements();
			break;
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_PRC_REQ_PROCESS_GETTINGPRC_REQUIREMENTS:
			exitSequence_self_Configuration_Setting_Requirement_requirements_Prc_Req_process_gettingPrc_Requirements();
			break;
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_PRC_REQ_PROCESS_PROCESSREQUIREMENT:
			exitSequence_self_Configuration_Setting_Requirement_requirements_Prc_Req_process_ProcessRequirement();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region customer */
	private void exitSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req_customer() {
		switch (stateVector[0]) {
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ_CUSTOMER_GETTINGCUST_REQUIREMENTS:
			exitSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req_customer_gettingCust_Requirements();
			break;
		case SELF_CONFIGURATION_SETTING_REQUIREMENT_REQUIREMENTS_CUST_REQ_CUSTOMER_CUSTOMERREQUIREMENTS:
			exitSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req_customer_CustomerRequirements();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region choice */
	private void exitSequence_self_Configuration_part_functionality_choice_choice() {
		switch (stateVector[0]) {
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_FEATUREIDENTIFICATION:
			exitSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_FeatureIdentification();
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_PARTIDENTFICATION_FEATURE_FEATUREEXTRACT:
			exitSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_feature_FeatureExtract();
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_IDENTIFYING_PART_IDENTIFY_PARTIDENTFICATION_FEATURE_PARTRECOGNISED:
			exitSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_feature_PartRecognised();
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_SETFUNTIONALITY:
			exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_setFuntionality();
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_GENERATEFUNCTIONALITYREQUIREMENTS:
			exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_generateFunctionalityRequirements();
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_GENERATEVARIABLELIST:
			exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_generateVariableList();
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_MATCHVARIABLEWITHREQUIREMENTS:
			exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_matchVariablewithRequirements();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region identification */
	private void exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification() {
		switch (stateVector[0]) {
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_SETFUNTIONALITY:
			exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_setFuntionality();
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_GENERATEFUNCTIONALITYREQUIREMENTS:
			exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_generateFunctionalityRequirements();
			break;
		case SELF_CONFIGURATION_PART_FUNCTIONALITY_CHOICE_CHOICE_FUNTIONALITY_TO_VARIABLE_MATCHING_IDENTIFYING_FUNCTIONALITY_AND_VARIABLES_IDENTIFICATION_GENERATEVARIABLELIST:
			exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_generateVariableList();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Variable_Allocation */
	private void exitSequence_self_Configuration_Variable_Determination_Variable_Allocation() {
		switch (stateVector[0]) {
		case SELF_CONFIGURATION_VARIABLE_DETERMINATION_VARIABLE_ALLOCATION_VARIABLEVALUEDETERMINATION:
			exitSequence_self_Configuration_Variable_Determination_Variable_Allocation_variableValueDetermination();
			break;
		case SELF_CONFIGURATION_VARIABLE_DETERMINATION_VARIABLE_ALLOCATION_ALLOCATION:
			exitSequence_self_Configuration_Variable_Determination_Variable_Allocation_Allocation();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Configuration */
	private void exitSequence_self_Configuration_Deployment_on_System_Configuration() {
		switch (stateVector[0]) {
		case SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_ESTABLISHINGCONNECTION:
			exitSequence_self_Configuration_Deployment_on_System_Configuration_establishingConnection();
			break;
		case SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_SETTINGREQUIREMENTS:
			exitSequence_self_Configuration_Deployment_on_System_Configuration_settingRequirements();
			break;
		case SELF_CONFIGURATION_DEPLOYMENT_ON_SYSTEM_CONFIGURATION_CHANGECONFIGURATION:
			exitSequence_self_Configuration_Deployment_on_System_Configuration_ChangeConfiguration();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region Execution */
	private void exitSequence_self_Configuration_Hardware_Abstraction_Execution() {
		switch (stateVector[0]) {
		case SELF_CONFIGURATION_HARDWARE_ABSTRACTION_EXECUTION_RUNFUNCTIONALITY:
			exitSequence_self_Configuration_Hardware_Abstraction_Execution_runFunctionality();
			break;
		case SELF_CONFIGURATION_HARDWARE_ABSTRACTION_EXECUTION_EXPERIMENT:
			exitSequence_self_Configuration_Hardware_Abstraction_Execution_Experiment();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_self_Configuration__entry_Default() {
		enterSequence_self_Configuration_Activate_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_self_Configuration_Setting_Requirement_requirements__entry_Default() {
		enterSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_self_Configuration_Setting_Requirement_requirements_Cust_Req_customer__entry_Default() {
		enterSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req_customer_gettingCust_Requirements_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_self_Configuration_Setting_Requirement_requirements_Prc_Req_process__entry_Default() {
		enterSequence_self_Configuration_Setting_Requirement_requirements_Prc_Req_process_gettingPrc_Requirements_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_feature__entry_Default() {
		enterSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_feature_FeatureExtract_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify__entry_Default() {
		enterSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_FeatureIdentification_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification__entry_Default() {
		enterSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_setFuntionality_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching__entry_Default() {
		enterSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_self_Configuration_part_functionality_choice_choice__entry_Default() {
		enterSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_default();
	}
	
	/* Default react sequence for initial entry introduce_functionality */
	private void react_self_Configuration_part_functionality_choice_choice_introduce_functionality() {
		enterSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_self_Configuration_Variable_Determination_Variable_Allocation__entry_Default() {
		enterSequence_self_Configuration_Variable_Determination_Variable_Allocation_variableValueDetermination_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_self_Configuration_Deployment_on_System_Configuration__entry_Default() {
		enterSequence_self_Configuration_Deployment_on_System_Configuration_establishingConnection_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_self_Configuration_Hardware_Abstraction_Execution__entry_Default() {
		enterSequence_self_Configuration_Hardware_Abstraction_Execution_runFunctionality_default();
	}
	
	private long react(long transitioned_before) {
		return transitioned_before;
	}
	
	private long self_Configuration_Activate_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
			if (activation.getFunctionality) {
				exitSequence_self_Configuration_Activate();
				enterSequence_self_Configuration_part_functionality_choice_introduce_functionality();
				react(0l);
				
				transitioned_after = 0l;
			} else {
				if (activation.introducePart) {
					exitSequence_self_Configuration_Activate();
					enterSequence_self_Configuration_part_functionality_choice_default();
					react(0l);
					
					transitioned_after = 0l;
				}
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_Setting_Requirement_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0l) {
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_Setting_Requirement_requirements_Cust_Req_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0l) {
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_Setting_Requirement_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_Setting_Requirement_requirements_Cust_Req_customer_gettingCust_Requirements_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
			if (set_requirements.getCustomerReq) {
				exitSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req_customer_gettingCust_Requirements();
				enterSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req_customer_CustomerRequirements_default();
				self_Configuration_Setting_Requirement_requirements_Cust_Req_react(0l);
				
				transitioned_after = 0l;
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_Setting_Requirement_requirements_Cust_Req_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_Setting_Requirement_requirements_Cust_Req_customer_CustomerRequirements_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
			if (set_requirements.setCust_req) {
				exitSequence_self_Configuration_Setting_Requirement_requirements_Cust_Req();
				enterSequence_self_Configuration_Setting_Requirement_requirements_Prc_Req_default();
				self_Configuration_Setting_Requirement_react(0l);
				
				transitioned_after = 0l;
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_Setting_Requirement_requirements_Cust_Req_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_Setting_Requirement_requirements_Prc_Req_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0l) {
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_Setting_Requirement_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_Setting_Requirement_requirements_Prc_Req_process_gettingPrc_Requirements_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
			if (set_requirements.getProcessReq) {
				exitSequence_self_Configuration_Setting_Requirement_requirements_Prc_Req_process_gettingPrc_Requirements();
				enterSequence_self_Configuration_Setting_Requirement_requirements_Prc_Req_process_ProcessRequirement_default();
				self_Configuration_Setting_Requirement_requirements_Prc_Req_react(0l);
				
				transitioned_after = 0l;
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_Setting_Requirement_requirements_Prc_Req_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_Setting_Requirement_requirements_Prc_Req_process_ProcessRequirement_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0l) {
			if (set_requirements.setPrc_req) {
				exitSequence_self_Configuration_Setting_Requirement();
				enterSequence_self_Configuration_Activate_Functionality_default();
				react(0l);
				
				transitioned_after = 0l;
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_Setting_Requirement_requirements_Prc_Req_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_part_functionality_choice_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0l) {
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_part_functionality_choice_choice_Identifying_Part_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0l) {
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_part_functionality_choice_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_FeatureIdentification_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
			if (part.start) {
				exitSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_FeatureIdentification();
				part.raiseIdentifiedPart();
				
				enterSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_default();
				self_Configuration_part_functionality_choice_choice_Identifying_Part_react(0l);
				
				transitioned_after = 0l;
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_part_functionality_choice_choice_Identifying_Part_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0l) {
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_part_functionality_choice_choice_Identifying_Part_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_feature_FeatureExtract_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
			if (local_part_identifiedPart) {
				exitSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_feature_FeatureExtract();
				enterSequence_self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_feature_PartRecognised_default();
				self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_react(0l);
				
				transitioned_after = 0l;
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_feature_PartRecognised_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
			if (part.part_req) {
				exitSequence_self_Configuration_part_functionality_choice();
				enterSequence_self_Configuration_Setting_Requirement_default();
				react(0l);
				
				transitioned_after = 0l;
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_part_functionality_choice_choice_Identifying_Part_identify_PartIdentfication_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0l) {
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_part_functionality_choice_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0l) {
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_setFuntionality_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
			if (functionality.requirement_lookup) {
				exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_setFuntionality();
				enterSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_generateFunctionalityRequirements_default();
				self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_react(0l);
				
				transitioned_after = 0l;
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_generateFunctionalityRequirements_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
			if (functionality.apply_functionality_req) {
				exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_generateFunctionalityRequirements();
				enterSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_generateVariableList_default();
				self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_react(0l);
				
				transitioned_after = 0l;
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_identification_generateVariableList_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
			if (functionality.match) {
				exitSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables();
				enterSequence_self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_matchVariablewithRequirements_default();
				self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_react(0l);
				
				transitioned_after = 0l;
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_Identifying_Functionality_and_Variables_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_matching_matchVariablewithRequirements_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
			if (functionality.getVariables) {
				exitSequence_self_Configuration_part_functionality_choice();
				enterSequence_self_Configuration_Variable_Determination_default();
				react(0l);
				
				transitioned_after = 0l;
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_part_functionality_choice_choice_Funtionality_to_variable_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_Activate_Functionality_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
			if (activation.getFunctionality) {
				exitSequence_self_Configuration_Activate_Functionality();
				enterSequence_self_Configuration_part_functionality_choice_introduce_functionality();
				react(0l);
				
				transitioned_after = 0l;
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_Variable_Determination_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0l) {
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_Variable_Determination_Variable_Allocation_variableValueDetermination_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
			if (variable.setVariableValue) {
				exitSequence_self_Configuration_Variable_Determination_Variable_Allocation_variableValueDetermination();
				enterSequence_self_Configuration_Variable_Determination_Variable_Allocation_Allocation_default();
				self_Configuration_Variable_Determination_react(0l);
				
				transitioned_after = 0l;
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_Variable_Determination_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_Variable_Determination_Variable_Allocation_Allocation_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
			if (variable.linking) {
				exitSequence_self_Configuration_Variable_Determination();
				enterSequence_self_Configuration_Deployment_on_System_default();
				react(0l);
				
				transitioned_after = 0l;
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_Variable_Determination_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_Deployment_on_System_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0l) {
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_Deployment_on_System_Configuration_establishingConnection_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
			if (deploy.connection) {
				exitSequence_self_Configuration_Deployment_on_System_Configuration_establishingConnection();
				enterSequence_self_Configuration_Deployment_on_System_Configuration_settingRequirements_default();
				self_Configuration_Deployment_on_System_react(0l);
				
				transitioned_after = 0l;
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_Deployment_on_System_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_Deployment_on_System_Configuration_settingRequirements_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
			if ((deploy.index || deploy.requirements)) {
				exitSequence_self_Configuration_Deployment_on_System_Configuration_settingRequirements();
				enterSequence_self_Configuration_Deployment_on_System_Configuration_ChangeConfiguration_default();
				self_Configuration_Deployment_on_System_react(0l);
				
				transitioned_after = 0l;
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_Deployment_on_System_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_Deployment_on_System_Configuration_ChangeConfiguration_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
			if (deploy.execute) {
				exitSequence_self_Configuration_Deployment_on_System();
				enterSequence_self_Configuration_Hardware_Abstraction_default();
				react(0l);
				
				transitioned_after = 0l;
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_Deployment_on_System_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_Hardware_Abstraction_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0l) {
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_Hardware_Abstraction_Execution_runFunctionality_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
			if (harware_abs.design_exp) {
				exitSequence_self_Configuration_Hardware_Abstraction_Execution_runFunctionality();
				enterSequence_self_Configuration_Hardware_Abstraction_Execution_Experiment_default();
				self_Configuration_Hardware_Abstraction_react(0l);
				
				transitioned_after = 0l;
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_Hardware_Abstraction_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration_Hardware_Abstraction_Execution_Experiment_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
			if (harware_abs.exiting) {
				exitSequence_self_Configuration_Hardware_Abstraction();
				enterSequence_self_Configuration__final__default();
				transitioned_after = 0l;
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = self_Configuration_Hardware_Abstraction_react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long self_Configuration__final__react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		System.out.println("We are in State" + stateVector[0].toString()+":exit.. we can do process here!");
		if (transitioned_after<0l) {
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = react(transitioned_before);
		}
		return transitioned_after;
	}
	
	/* Can be used by the client code to trigger a run to completion step without raising an event. */
	public void triggerWithoutEvent() {
		runCycle();
	}
}
