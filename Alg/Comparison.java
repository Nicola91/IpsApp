//java
// -*- coding: utf-8 -*-

// File:Comparison.java
// Author: Nicola Faccin
// Email: n.faccin@miriade.it
// Date: 2015-10-26
// Modify:
// ==================================================================
// Version   Date        Author                  Description
// ==================================================================
// 0.0.1     2015-10-26  Nicola Faccin        Iniziata stesura
// ------------------------------------------------------------------
// 0.0.2     2015-10-27  Nicola Faccin        Completata implementazione metodo index
// ------------------------------------------------------------------
// 0.0.3     2015-10-27  Nicola Faccin        Iniziata stesura metodo choose
// ------------------------------------------------------------------
// 0.0.4     2015-10-27  Nicola Faccin        Completata stesura e aggiunti commenti
// ------------------------------------------------------------------
// 0.1.0     2015-10-28  Nicola Faccin        Verificato
// ------------------------------------------------------------------
// 0.1.1     2015-10-29  Nicola Faccin        Correzione errore 6-1 prima di 6-3
// ------------------------------------------------------------------
// 0.1.2     2015-10-30  Nicola Faccin        Cambiato metodo per calcolare la distanza dai muri, nello specifico choose.
// ------------------------------------------------------------------
// 0.2.0     2015-11-05  Nicola Faccin        Verificato
// ------------------------------------------------------------------




package Alg;

import Zones.*;


//classe astratta che ha due metodi uno che crea un array contenente gli indici degli errori delle varie zone e l'altro che restituisce la distanza calcolata dai muri considerando y zone con y>5

public abstract class Comparison{

//metodo che crea un array di inici che sono il numero degli errori rispetto il punto test e le varie zone
	protected static Double [] index(Room area, Id test, int dimension){
		Double arrayIndex []=new Double [dimension];

		for (int i=0; i<dimension; i++){

			Double ausiliar [] = area.get_room()[i].get_identify().get_Id();
			Double first=test.get_six_five();
	
			if(first<=ausiliar[0])
				arrayIndex[i]=ausiliar[0]-first;
			else 
				arrayIndex[i]=first-ausiliar[0];
			
			Double second=test.get_six_three();

			if(second<=ausiliar[1])
				arrayIndex[i]=arrayIndex[i]+ausiliar[1]-second;
			else
				arrayIndex[i]=arrayIndex[i]+second-ausiliar[1];
			
			Double third=test.get_six_one();

			if(third<=ausiliar[2])
				arrayIndex[i]=arrayIndex[i]+ausiliar[2]-third;
			else
				arrayIndex[i]=arrayIndex[i]+third-ausiliar[2];

			Double fouth=test.get_five_two();
				
			if(fouth<=ausiliar[3])
				arrayIndex[i]=arrayIndex[i]+ausiliar[3]-fouth;
			else
				arrayIndex[i]=arrayIndex[i]+fouth-ausiliar[3];

		}


		return arrayIndex;

	}

	//metodo ricorsivo che calcola la distanza della misurazione dal muro sud e dal muro est, ritorna un array di 2 elementi appunto le distanze in metri dai muri. Questa nuova versione permette di
	//dare molta più importanza alle zone che hanno meno errori rispetto a quello precedente.
	protected static Double[] choose(Double doubleArray[], Room area, int dimension, int found){
		Double [] distance= new Double[2];
		distance[0]=0.0;
		distance[1]=0.0;
		int items=0;
		Double min =12.0;
		Double [] distanceC=new Double[2];

		if(found<5){
			for (int i=0; i<dimension; i++){

				if(min>doubleArray[i])
					min=doubleArray[i];
			}
			
			for(int i=0; i<dimension; i++){
			
				if(doubleArray[i].equals(min)){
					distance[0]=distance[0]+area.get_room()[i].get_distance_hight();
					distance[1]=distance[1]+area.get_room()[i].get_distance_side();
					doubleArray[i]=12.0;
					found++;
					items++;
				}
			}
			distanceC= choose(doubleArray, area, dimension, found);//ricorsione a cui passo l'array con gli indici degli errori modificato in modo che il mimimo valore trovato la volta precedente 
			//sia stato "cancellato", gli passo tutta l'area, la dimensione dell'array e il numero di zone ottime trovate fin'ora. 
			//in questa variabile viengono salvati i valori parziali calcolati per ogni indice.

		}
		if (items!=0){//divido per il numero di item trovati fin'ora, se ho anche la variabile distanceC allora devo aggingere un item.
			if(distanceC[0]!=0.0){
				distance[0]=(distance[0]+distanceC[0])/(items+1);
				distance[1]=(distance[1]+distanceC[0])/(items+1);
			}
			else{
			distance[0]=(distance[0]+distanceC[0])/(items);
			distance[1]=(distance[1]+distanceC[0])/(items);
			}
		}

		return distance;	
	}

}
