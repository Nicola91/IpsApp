//java
// -*- coding: utf-8 -*-

// File:Get_zone.java
// Author: Nicola Faccin
// Email: n.faccin@miriade.it
// Date: 2015-10-26
// Modify:
// ==================================================================
// Version   Date        Author                  Description
// ==================================================================
// 0.0.1     2015-10-26  Nicola Faccin        Iniziata stesura
// ------------------------------------------------------------------
// 0.0.2     2015-10-27  Nicola Faccin        Completata stesura
// ------------------------------------------------------------------
// 0.0.3     2015-10-28  Nicola Faccin        Aggiunti commenti
// ------------------------------------------------------------------
// 0.1.0     2015-10-28  Nicola Faccin        Verificato
// ------------------------------------------------------------------
// 0.1.1     2015-10-29  Nicola Faccin        Correzione errore 6-1 prima di 6-3
// ------------------------------------------------------------------
// 0.1.2     2015-11-02  Nicola Faccin        Implementazione inserimento varie configurazioni zone in base al verso dell'utente.
// ------------------------------------------------------------------
// 0.2.0     2015-11-05  Nicola Faccin        Verificato
// ------------------------------------------------------------------


import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;



import Zones.*;
import Alg.*;


//classe che contiene il main che andrà pre prima cosa a creare la stanza testata, poi ci chiederà di inserire il punto test e infine ci stampa la zona in cui potrebbe essere questo punto.
public abstract class Get_zone {

  public static void main( String[] args ){
       //prendiamo il file dove è descritta l'intera stanza già con le varie distanze e i valori di RSSI
    ArrayList<String> content = new ArrayList<>(0);

    try{
      //in base al verso dell'utente che dovrà essere passato grazie agli strumenti presenti nel telefono si decide che configurazione della stanza analizzata utilizzare, questo per ridurre il
    	//più possibile l'errore.
      BufferedReader reader=null;
      System.out.println("Inserire da che parte l'utente è girato (Nord(N), sud(S), ovest(O), est(E)");
      System.out.println();
      Scanner sideS = new Scanner(System.in);
      String side = sideS.nextLine();
      if(side.equals("N"))
        reader=new BufferedReader(new FileReader("./Configuration/zone_idN1.1.txt"));
      if(side.equals("S"))
        reader=new BufferedReader(new FileReader("./Configuration/zone_idS1.1.txt"));
      if(side.equals("E"))
        reader=new BufferedReader(new FileReader("./Configuration/zone_idE1.1.txt"));
      if(side.equals("O"))
        reader=new BufferedReader(new FileReader("./Configuration/zone_idO.txt"));

      String s=null;

      while((s=reader.readLine())!= null ){
        content.add(s);
      }

      reader.close();
     
      //costruiamo la stanza
      Room first=new Room(content);

      //si richiede il valore del punto che andremo a testare.
      System.out.print("Inserisci il nuovo punto testato, devi inserire le potenze prese in ordine dal beacon più in basso a destra e proseguendo in ordine antiorario. Attenzione che i valori possono essere da 0 a 4 non superiori");
      System.out.println();
      
      Scanner input = new Scanner(System.in);
      String tested=input.nextLine()+"\t";
      int i = 0;
      while(i<3){
        tested=tested+input.nextLine()+"\t";
        i++;
      }
      
      Id point=new Id (tested);
      //in base a questo punto si invoca il metodo risolutivo che restituisce la zona in cui si pensa che il punto sia
     
      String zona=Resoluction.solution(first,point,16);
     
      System.out.println("Questa è la zona trovata  "+zona);

      }catch (FileNotFoundException e) {System.out.println("File selezionato non trovato");}
      catch (IOException e) {}
      catch (NullPointerException e) {System.out.println("Inserimento dati non corretto, riprova");}

  }

}