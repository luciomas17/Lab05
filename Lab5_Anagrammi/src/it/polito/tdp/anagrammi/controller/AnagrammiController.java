package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import it.polito.tdp.anagrammi.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	Model model = new Model();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private TextArea txtResultCorrect;

    @FXML
    private TextArea txtResultWrong;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	this.txtResultCorrect.clear();
    	this.txtResultWrong.clear();
    	
    	Parola daAnagrammare = new Parola(this.txtInput.getText());
    	
    	Set<Parola> anagrammi = model.trovaAnagrammi(daAnagrammare);

    	for(Parola p : anagrammi) {
    		if(p.isCorrect())
    			this.txtResultCorrect.appendText(p.toString() + "\n");
    		else
    			this.txtResultWrong.appendText(p.toString() + "\n");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtInput.clear();
    	this.txtResultCorrect.clear();
    	this.txtResultWrong.clear();
    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResultCorrect != null : "fx:id=\"txtResultCorrect\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResultWrong != null : "fx:id=\"txtResultWrong\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
	}
}