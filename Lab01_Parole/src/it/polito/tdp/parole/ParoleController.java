package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ParoleController {
	
	Parole elenco ;
	String selezionato;
	Long inizio;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    private Button btnReset;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private TextArea txtTempi;

    @FXML
    void doInsert(ActionEvent event) {
    	// TODO
    	inizio=System.nanoTime();
    	if(txtParola.getText().isEmpty()) {
    		return;
    	}
    		
    	elenco.addParola(txtParola.getText());
    	txtParola.clear();
    	txtResult.clear();
    	String parole=new String();
    	for(String s: elenco.getElenco())
    		parole+=s+"\n";
    	txtResult.appendText(parole);
    	txtTempi.appendText("Inserimento: "+(System.nanoTime()-inizio)+"\n");
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	// TODO
    	inizio=System.nanoTime();
    	elenco.reset();
    	txtResult.clear();
    	txtParola.clear();
    	txtTempi.appendText("Reset: "+(System.nanoTime()-inizio)+"\n");
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	inizio=System.nanoTime();
    	if(selezionato.isEmpty()) {
    		return;
    	}
    		
    	elenco.delParola(selezionato);
    	txtParola.clear();
    	txtResult.clear();
    	String parole=new String();
    	for(String s: elenco.getElenco())
    		parole+=s+"\n";
    	txtResult.appendText(parole);
    	txtTempi.appendText("Cancella: "+(System.nanoTime()-inizio)+"\n");
    }
    
    @FXML
    void doSelezione(MouseEvent event) {
    
    	selezionato=txtResult.getSelectedText();
    
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtTempi != null : "fx:id=\"txtTempi\" was not injected: check your FXML file 'Parole.fxml'.";
        
        elenco = new Parole() ;
        selezionato=new String();
        
        
    }
}
