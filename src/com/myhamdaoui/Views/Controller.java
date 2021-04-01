package com.myhamdaoui.Views;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.myhamdaoui.Algorithms.Algorithms;
import com.myhamdaoui.Algorithms.Names;
import com.myhamdaoui.Algorithms.Output;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import com.myhamdaoui.CustomAlert.CustomerAlert;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable, EventHandler<ActionEvent> {
    private int chosedAlgorithm;
    private double[] input;
    private String from, temp, to;
    
    @FXML
    private JFXTextField inputField;
    
    @FXML
    private JFXTextField inputFieldTemp;
    
    @FXML
    private JFXTextField inputFieldFrom;
    
    @FXML
    private JFXTextField inputFieldTo;
    
    @FXML
    private TextArea inputMatrice1;
    
    @FXML
    private TextArea inputMatrice2;

    @FXML
    private Label errorMessage;

    @FXML
    private JFXTextArea outputTextArea;

    @FXML
    private JFXButton btn1;

    @FXML
    private JFXButton btn2;

    @FXML
    private JFXButton btn3;
    
    @FXML
    private JFXButton btn4;

    @FXML
    private JFXButton btn5;

    @FXML
    private JFXButton btn6;
    
    @FXML
    private JFXButton btn7;

    @FXML
    private JFXButton btn8;

    @FXML
    private JFXButton btn9;
    
    @FXML
    private JFXButton btn10;
    
    @FXML
    private JFXButton btn11;
    
    @FXML
    private JFXButton btn12;
    
    @FXML
    private JFXButton btn13;

    @FXML
    private RadioButton radio1;

    @FXML
    private RadioButton radio2;
    
    private JFXButton[] btns;
    
    @FXML
    private HBox matriceContainer;
    
    @FXML
    private HBox inputContainer;
    
    @FXML
    private VBox typeAlgoContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	initButtonsTable();
    	initParameters();        
    	
    }
    
    private void hideTypeAlgo(boolean hide) {
    	typeAlgoContainer.setVisible(!hide);
    	typeAlgoContainer.managedProperty().bind(typeAlgoContainer.visibleProperty());
    }
    
    private void hideMatriceInput(boolean hide) {
    	matriceContainer.setVisible(!hide);
    	matriceContainer.managedProperty().bind(matriceContainer.visibleProperty());
    }
    
    private void hideInput(boolean hide) {
    	inputContainer.setVisible(!hide);
    	inputContainer.managedProperty().bind(inputContainer.visibleProperty());
    }
    
    private void hideHanoiInput(boolean hide) {
    	inputFieldFrom.setVisible(!hide);
    	inputFieldTo.setVisible(!hide);
    	inputFieldTemp.setVisible(!hide);
    	
    	inputFieldFrom.managedProperty().bind(inputFieldFrom.visibleProperty());
    	inputFieldTo.managedProperty().bind(inputFieldTo.visibleProperty());
    	inputFieldTemp.managedProperty().bind(inputFieldTemp.visibleProperty());
    }
    
    private void initParameters() {
    	// Hide hanoi inputs
    	hideHanoiInput(true);
    	
    	// Hide matrices inputs
    	hideMatriceInput(true);

    	
    	chosedAlgorithm = 1;
        ToggleGroup grp = new ToggleGroup();
        radio1.setToggleGroup(grp);
        radio2.setToggleGroup(grp);
        radio1.setSelected(true);
        inputField.requestFocus();
    }
    
    private void initButtonsTable() {
    	btns = new JFXButton[13];
    	btns[0] = btn1;
    	btns[1] = btn2;
    	btns[2] = btn3;
    	btns[3] = btn4;
    	btns[4] = btn5;
    	btns[5] = btn6;
    	btns[6] = btn7;
    	btns[7] = btn8;
    	btns[8] = btn9;
    	btns[9] = btn10;
    	btns[10] = btn11;
    	btns[11] = btn12;
    	btns[12] = btn13;
    	
    	for(int i = 0; i < btns.length; i++) {
    		btns[i].setOnAction(this);
    		btns[i].setText(Names.BTN_NAMES[i]);
    	}
    }

    private boolean validateInputs() {
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Ce champ est obligatoire");

        inputField.getValidators().add(validator);

        if(inputField.getText().equals("")) {
            inputField.validate();
        } else if(!inputField.getText().matches("([-+]?[0-9](.[0-9]+)?( )?)+")) {
            errorMessage.setText("Please remove unused spaces !");
            inputField.requestFocus();
            inputField.requestFocus();
            inputField.setFocusColor(Paint.valueOf("red"));
            inputField.validate();
            return false;
        } else {
            inputField.validate();
            errorMessage.setText("");
            inputField.setFocusColor(Paint.valueOf("#4059a9"));
            inputField.setUnFocusColor(Paint.valueOf("#4d4d4d"));
            return true;
        }

        return false;
    }

    @FXML
    private void onStartClicked(ActionEvent event) {
        // init output
        Output.str = "";

        // Read input
        String inputStr = inputField.getText();

        // Validate input
        if(chosedAlgorithm <= 10 && validateInputs()) {
            String[] numbers = inputStr.split(" ");
            input = new double[numbers.length];

            for(int i = 0; i < numbers.length; i++) {
                input[i] = Double.parseDouble(numbers[i]);
            }

            // Call the right algorithm
            
            if(radio1.isSelected()) {
            	switch(chosedAlgorithm) {
            	case 1:
            		Algorithms.tri1Iteratif(input);
            		break;
            		
            	case 2:
            		Algorithms.tri2Iteratif(input);
            		break;
            		
            	case 3:
            		Algorithms.tri3Iteratif(input);
            		break;
            		
            	case 4:
            		Algorithms.tri4Iteratif(input);
            		break;
            		
            	case 5:
            		Algorithms.tri5Iteratif(input);
            		break;
            		
            	case 6:
            		Algorithms.tri6Iteratif(input);
            		break;
            		
            	case 7:
            		Algorithms.tri7Iteratif(input);
            		break;
            		
            	case 8:
            		Algorithms.tri8Iteratif(input);
            		break;
            		
            	case 9:
            		Algorithms.tri9Iteratif(input);
            		break;
            		
            	case 10:
            		Algorithms.tri10Iteratif(input);
            		break;
            	default:
            		//
            		break;
            	}
            } else {
            	switch(chosedAlgorithm) {
            	case 1:
            		Algorithms.tri1Recursive(input);
            		break;
            		
            	case 2:
            		Algorithms.tri2Recursive(input);
            		break;
            		
            	case 3:
            		Algorithms.tri3Recursive(input);
            		break;
            		
            	case 4:
            		Algorithms.tri4Recursive(input);
            		break;
            		
            	case 5:
            		Algorithms.tri5Recursive(input);
            		break;
            		
            	case 6:
            		Algorithms.tri6Recursive(input);
            		break;
            		
            	case 7:
            		Algorithms.tri7Recursive(input);
            		break;
            		
            	case 8:
            		Algorithms.tri8Recursive(input);
            		break;
            		
            	case 9:
            		Algorithms.tri9Recursive(input);
            		break;
            		
            	case 10:
            		Algorithms.tri10Recursive(input);
            		break;
            	default:
            		//
            		break;
            	}
            }
           
        } else if(chosedAlgorithm == 11) {
            String[] numbers = inputStr.split(" ");
            input = new double[numbers.length];
            int count = Integer.parseInt(inputStr.split(" ")[0]);
        	from = inputFieldFrom.getText();
        	to = inputFieldTo.getText();
        	temp = inputFieldTemp.getText();
        	Algorithms.tourHanoi(count, from, temp, to);
        } else {
        	
        	String[] matrice1Str = inputMatrice1.getText().split("\\n");
        	String[] matrice2Str = inputMatrice2.getText().split("\\n");
        	
        	int lineCount = matrice1Str.length;
        	int colCount = matrice1Str[0].split(" ").length;
        	
        	double[][] mat1Input = new double[lineCount][colCount];
        	
        	for(int i = 0; i < lineCount; i++) {
        		String[] line = matrice1Str[i].split(" ");
        		for(int j = 0; j < colCount; j++) {
        			mat1Input[i][j] = Double.parseDouble(line[j]);
        		}
        	}
        	
        	int lineCount2 = matrice2Str.length;
        	int colCount2 = matrice2Str[0].split(" ").length;
        	
        	double[][] mat2Input = new double[lineCount2][colCount2];
        	
        	for(int i = 0; i < lineCount2; i++) {
        		String[] line = matrice2Str[i].split(" ");
        		for(int j = 0; j < colCount2; j++) {
        			mat2Input[i][j] = Double.parseDouble(line[j]);
        		}
        	}
        	
        	if(chosedAlgorithm == 12) {
        		Algorithms.mat1(mat1Input, mat2Input);
        	} else if(chosedAlgorithm == 13) {
        		Algorithms.mat2(mat1Input, mat2Input);
        	}
        }
        
        // Show the output
        outputTextArea.setText(Output.str);
    }

    @FXML
    private void onClickAbout(ActionEvent event) {
        try {
            CustomerAlert.display("message", "Made with <3 BY HAMDAOUI Mohammed-Yassin & BENKADDOUR Mehdi (ENSA Oujda)");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Clicked");
    }

	@Override
	public void handle(ActionEvent event) {
		JFXButton btn = (JFXButton) event.getSource();
		int algorithmNumber = Integer.parseInt(btn.getId().substring(3));
		
		
		for(int i = 0; i < btns.length; i++) {
	        btns[i].setStyle("-fx-background-color: #636e72");
	        if(i == algorithmNumber - 1) {
	        	btns[i].setStyle("-fx-background-color: #ff7675");
	        }
		}
				
		// NEW - TOUR HANOI
		if(btn.getId().toString().equals("btn11")) {
			hideTypeAlgo(true);
			hideMatriceInput(true);
			hideInput(false);
	    	inputFieldFrom.setVisible(true);
	    	inputFieldTo.setVisible(true);
	    	inputFieldTemp.setVisible(true);
		} 
		// NEW - MATICES
		else if(btn.getId().toString().equals("btn12") || btn.getId().toString().equals("btn13")) {
			hideTypeAlgo(true);
			// Show matrices inputs
			hideMatriceInput(false);
			hideInput(true);
			hideHanoiInput(true);
			
		} else {
			hideTypeAlgo(false);
			hideInput(false);
			hideHanoiInput(true);
			hideMatriceInput(true);
		}
		
		chosedAlgorithm = algorithmNumber;
		outputTextArea.setText("");
	}
}
