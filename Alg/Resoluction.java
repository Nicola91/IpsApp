//java
// -*- coding: utf-8 -*-

// File:Resoluction.java
// Author: Nicola Faccin
// Email: n.faccin@miriade.it
// Date: 2015-10-26
// Modify:
// ==================================================================
// Version   Date        Author                  Description
// ==================================================================
// 0.0.1     2015-10-27  Nicola Faccin        Iniziata stesura
// ------------------------------------------------------------------
// 0.0.2     2015-10-27  Nicola Faccin        Completata stesura e aggiunti commenti
// ------------------------------------------------------------------
// 0.1.0     2015-10-28  Nicola Faccin        Verificato
// ------------------------------------------------------------------
// 0.1.2     2015-10-30  Nicola Faccin        Cambiato metodo per calcolare la distanza dai muri, nello specifico choose.
// ------------------------------------------------------------------
// 0.2.0     2015-11-05  Nicola Faccin        Verificato
// ------------------------------------------------------------------

package Alg;


import Zones.*;


//classe astratta che contiene il metodo necessario per trovare la zona corrispondente con il punto inserito

public abstract class Resoluction{

	public static String solution(Room area, Id test, int dimension){
			// nel metodo seguente contenuto nella classe Comparison confronto i valori del punto con quelli di tutte le zone e da qui ricavo un array contenente la somma degli errori dei 4 campi
			Double [] arrayIndex= Comparison.index(area, test, dimension);
			//nel metodo seguente, contenuto nella classe Comparison, confronto i valori contenuti in arrayIndex, solamente quelli più precisi(con meno errori). Quanto ne ho trovati y(y>5) sommo
			//sommo le distanze di tutte le zone e le restituisce
			Double [] distance=Comparison.choose(arrayIndex, area, dimension, 0);
			//distance contiene due elementi, rispettivamente la distanza dal muro sud e la distanza dal muro est.
			Double minErrorHight=Double.MAX_VALUE;
			Double minErrorSide=Double.MAX_VALUE;
			//i due campi min sono le discrepanze dalla zona più probabile al valore realmente trovato
			int zoneFound=0;
			Double [] auxiliar=new Double[dimension];// conterrà le differenze tra la distanza calcolata e quella propria delle zone

			for (int i=0; i<dimension; i++){

				if((area.get_room()[i].get_distance_hight())<distance[0]){

					auxiliar[i]=distance[0]-area.get_room()[i].get_distance_hight();

					if(auxiliar[i]<=minErrorHight)
						minErrorHight=auxiliar[i];
				}
				else{

					auxiliar[i] = area.get_room()[i].get_distance_hight()-distance[0];

					if(minErrorHight>auxiliar[i])
						minErrorHight=auxiliar[i];
				}
			} //qui ho l'auxiliar, un array pieno delle differenze delle distanze tra distance[0], la distanza del punto dal muro sud, e le varie zone. Inoltre abbiamo anche il valore minimo
			//sempre in questo campo. Procediamo quindi a calcolare la minima distanza dal punto rispetto al muro est.
			for(int i=0; i<dimension; i++){

				if((auxiliar[i]).equals(minErrorHight)){

					if(distance[1]>area.get_room()[i].get_distance_side()){

						if((distance[1]-area.get_room()[i].get_distance_side())<minErrorSide){

							minErrorSide=(distance[1]-area.get_room()[i].get_distance_side());
							zoneFound=i;
						}
					}


					else{
						if(minErrorSide>(area.get_room()[i].get_distance_side())-distance[1]){

							minErrorSide=(area.get_room()[i].get_distance_side())-distance[1];
							zoneFound=i;
						}
					}
				}
			}

			System.out.println("La distanza dal muro sud è "+distance[0]);
			
			System.out.println("La distanza dal muro est è "+distance[1]);
			
			return area.get_room()[zoneFound].get_name();
	}
}