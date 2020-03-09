package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.ParoleList;
import it.polito.tdp.parole.model.ParoleArray;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ParoleController {
	
	ParoleList elencoList;
	ParoleArray elencoArray;
	String selezionato;
	Long tempoList;
	Long tempoArray;

	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextField txtParola;

	    @FXML
	    private Button btnInserisci;

	    @FXML
	    private TextArea txtResultList;

	    @FXML
	    private TextArea txtTempiList;

	    @FXML
	    private TextArea txtResultArray;

	    @FXML
	    private TextArea txtTempiArray;

	    @FXML
	    private TextField txtConfronto;

	    @FXML
	    private Button btnCancella;

	    @FXML
	    private Button btnReset;


    @FXML
    void doInsert(ActionEvent event) {
    	// TODO
    	tempoList=System.nanoTime();
    	if(txtParola.getText().isEmpty()) {
    		return;
    	}
    		
    	elencoList.addParola(txtParola.getText());
    	
    	txtResultList.clear();
    	String parole=new String();
    	for(String s: elencoList.getElenco())
    		parole+=s+"\n";
    	txtResultList.appendText(parole);
    	tempoList=System.nanoTime()-tempoList;
    	txtTempiList.appendText("Inserimento: "+tempoList+"\n");
    	
    	
    	tempoArray=System.nanoTime();
    	if(txtParola.getText().isEmpty()) {
    		return;
    	}
    		
    	elencoArray.addParola(txtParola.getText());
    	
    	txtResultArray.clear();
    	parole=new String();
    	for(String s: elencoArray.getElenco())
    		parole+=s+"\n";
    	txtResultArray.appendText(parole);
    	tempoArray=System.nanoTime()-tempoArray;
    	txtTempiArray.appendText("Inserimento: "+tempoArray+"\n");
    	
    	this.confronto(tempoList,tempoArray);
    	
    	txtParola.clear();
    }
    
    private void confronto(Long tempoList, Long tempoArray) {
		// TODO Auto-generated method stub
    	txtConfronto.clear();
    	if(tempoList<tempoArray)
    		txtConfronto.appendText("List più veloce");
    	else if(tempoArray<tempoList)
    		txtConfronto.appendText("Array più veloce");
    	else
    		txtConfronto.appendText("Stessa velocità");
	}

	@FXML
    void doReset(ActionEvent event) {
    	// TODO
		txtParola.clear();
    	tempoList=System.nanoTime();
    	elencoList.reset();
    	txtResultList.clear();
    	tempoList=System.nanoTime()-tempoList;
    	txtTempiList.appendText("Reset: "+tempoList+"\n");
    	
    	
    	tempoArray=System.nanoTime();
    	elencoArray.reset();
    	txtResultArray.clear();
    	tempoArray=System.nanoTime()-tempoArray;
    	txtTempiArray.appendText("Reset: "+tempoArray+"\n");
    	
    	this.confronto(tempoList, tempoArray);
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	txtParola.clear();
    	tempoList=System.nanoTime();
    	if(selezionato.isEmpty()) {
    		return;
    	}
    		
    	elencoList.delParola(selezionato);
    	txtResultList.clear();
    	String parole=new String();
    	for(String s: elencoList.getElenco())
    		parole+=s+"\n";
    	txtResultList.appendText(parole);
    	tempoList=System.nanoTime()-tempoList;
    	txtTempiList.appendText("Cancella: "+tempoList+"\n");
    	
    	
    	tempoArray=System.nanoTime();
    	if(selezionato.isEmpty()) {
    		return;
    	}
    		
    	elencoArray.delParola(selezionato);
    	txtResultArray.clear();
    	parole=new String();
    	for(String s: elencoArray.getElenco())
    		parole+=s+"\n";
    	txtResultArray.appendText(parole);
    	tempoArray=System.nanoTime()-tempoArray;
    	txtTempiArray.appendText("Cancella: "+tempoArray+"\n");
    	
    	this.confronto(tempoList, tempoArray);
    	
    }
    
    @FXML
    void doSelezione(MouseEvent event) {
    	
    	if(txtResultList.isFocused())
    		selezionato=txtResultList.getSelectedText();
    	else
    		selezionato=txtResultArray.getSelectedText();
    }

    @FXML
    void initialize() {
    	assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResultList != null : "fx:id=\"txtResultList\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtTempiList != null : "fx:id=\"txtTempiList\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResultArray != null : "fx:id=\"txtResultArray\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtTempiArray != null : "fx:id=\"txtTempiArray\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtConfronto != null : "fx:id=\"txtConfronto\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Parole.fxml'.";

        
        elencoList = new ParoleList() ;
        elencoArray=new ParoleArray();
        selezionato=new String();
        
        
    }
}
