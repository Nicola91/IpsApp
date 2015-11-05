//java
// -*- coding: utf-8 -*-

// File:Room.java
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
 
public class Room{
	//classe che definisce l'intera stanza, giustamente è composta da più zone che vengono definite nella classe apposita

	private Zone [] room;


	public Room (ArrayList<String> another){
		// costruttore che permette di costruire zona per zona a partire da un arraylist creato da un file.txt
		room=new Zone[another.size()];
		for (int index=0; index<another.size();index++){
			room[index]= new Zone(another.get(index));
		}
	}


	//metodo che restituisce tutto l'array delle zone
	public Zone [] get_room() {return room;}
	

}