//java
// -*- coding: utf-8 -*-

// File:Id.java
// Author: Nicola Faccin
// Email: n.faccin@miriade.it
// Date: 2015-10-26
// Modify:
// ==================================================================
// Version   Date        Author                  Description
// ==================================================================
// 0.0.1     2015-10-26  Nicola Faccin        Iniziata stesura
// ------------------------------------------------------------------
// 0.0.2     2015-10-27  Nicola Faccin        Completata stesura e inseriti commenti
// ------------------------------------------------------------------
// 0.1.0     2015-10-28  Nicola Faccin        Verificato
// ------------------------------------------------------------------
// 0.1.1     2015-10-29  Nicola Faccin        Correzione errore 6-1 prima di 6-3
// ------------------------------------------------------------------
// 0.2.0     2015-11-05  Nicola Faccin        Verificato
// ------------------------------------------------------------------


package Zones;
 
public class Id {
	// classe che definisce i valori di RSSI, questi valori vanno da 0 a 3 in base a che potenza è stata registrata in quel luogo.

	private Double six_five;
	private Double six_one;
	private Double six_three;
	private Double five_two;
	// cotruttore che verrà usato per costruire la stanza testata divisa in zone. Ogni zona sarà definita in modo univoco da questi 4 valori
	public Id(Double sf,Double so, Double st, Double ft) {six_five=sf; six_three=st; six_one=so;five_two=ft;}
	// costruttore che verrà usato per costruire il punto casuale che è stato testato
	public Id(String toPath){
			   	String[] splitInputContent = toPath.split("\t");
			   	six_five=Double.parseDouble(splitInputContent[0]);
			   	six_three=Double.parseDouble(splitInputContent[1]);
			   	six_one=Double.parseDouble(splitInputContent[2]);
			   	five_two=Double.parseDouble(splitInputContent[3]);
	}
	// metodo che restituisce un array contenente tutti i valori per i vari RSSI
	public Double [] get_Id() {
		Double idArray []= {six_five, six_three, six_one, five_two};
		return idArray;
	}

	// metodi pubblici che restituiscono uno ad uno i valori del punto richiesto
	public Double get_six_five() {return six_five;}
	
	public Double get_six_three() {return six_three;}

	public Double get_six_one() {return six_one;}

	public Double get_five_two() {return five_two;}
}