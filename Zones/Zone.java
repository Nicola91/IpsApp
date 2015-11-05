//java
// -*- coding: utf-8 -*-

// File:Zone.java
// Author: Nicola Faccin
// Email: n.faccin@miriade.it
// Date: 2015-10-26
// Modify:
// ==================================================================
// Version   Date        Author                  Description
// ==================================================================
// 0.0.1     2015-10-26  Nicola Faccin        Iniziata stesura
// ------------------------------------------------------------------
// 0.0.2     2015-10-27  Nicola Faccin        Completata stesura e aggiunti commenti
// ------------------------------------------------------------------
// 0.1.0     2015-10-28  Nicola Faccin        Verificato
// ------------------------------------------------------------------


package Zones;
import java.util.*;


public class Zone {
	// classe che definisce la struttura di una zona. Una zona infatti è definita dai valori RSSI, dal nome, entrambi univoci e dalle distanze dal muro sud, muro est

	private Id identify;

	private Double distance_hight;

	private Double distance_side;

	private String name;

	// costruttore che va a creare completamente una zona, grazie a questo costruttore, è possibile inserire l'intera stanza da file separato .txt 
	public Zone(String toPath){
		   	String[] splitInputContent = toPath.split("\t");
			name=splitInputContent[0];
			identify=new Id (Double.parseDouble(splitInputContent[1]), Double.parseDouble(splitInputContent[2]), Double.parseDouble(splitInputContent[3]), Double.parseDouble(splitInputContent[4]));
			distance_hight=Double.parseDouble(splitInputContent[5]);
			distance_side=Double.parseDouble(splitInputContent[6]);
		}

	// metodi che ritornano i campi dati uno ad uno
	public String get_name() {return name;}
	
	public Double get_distance_hight() {return distance_hight;}
	
	public Double get_distance_side() {return distance_side;}
	
	
	public Id get_identify() {return identify;}


}