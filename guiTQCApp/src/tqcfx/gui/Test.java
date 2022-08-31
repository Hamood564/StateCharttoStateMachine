package tqcfx.gui;

import MaltState.maltStateMain;
import Statemachine.behaviour_idle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Test extends Application{


	@Override
	public void start(Stage primaryStage) throws Exception {
		Button btn = new Button("Test ");
//		btn.setOnAction((e) -> System.out.println("Testyy"));
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				behaviour_idle bh1 = new behaviour_idle();
				bh1.statecall();
				
				
			}
		});
		
		Button btn2 = new Button("Test 2");
//		btn.setOnAction((e) -> System.out.println("Testyy"));
		
		
		StackPane root = new StackPane();
		root.getChildren().add(btn);

		
		Scene scene = new Scene(root, 1000, 300);
		primaryStage.setTitle("TEst TQC FX");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	 
	 

}
