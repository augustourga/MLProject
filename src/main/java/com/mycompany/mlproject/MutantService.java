/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mlproject;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
//import com.mongodb.MongoClientURI;
import org.mongodb.morphia.Morphia;

import java.util.List;


/**
 *
 * @author augus
 */
public class MutantService {
   
  
   MongoClient client = new MongoClient("127.0.0.1", 27017); //connect to mongodb
   Datastore datastore = new Morphia().createDatastore(client, "records"); //select shop collection
    
    
    public void addpost(Save save){
   
       //just save the record
       datastore.save(save);    
     

    
    }
    
    public Stats getStats(){
    
    Stats stats = new Stats();
    int totalRecords;
    int mutantRecords;
    //find all <save> records from save's datastorage
    List<Save> query = datastore.find(Save.class).asList();
    totalRecords = query.size();
    //calculate total of mutants
    mutantRecords = (int) query.stream().filter(Save::isMutant).count();
    stats.count_human_dna= totalRecords;
    stats.count_mutant_dna= mutantRecords;
    //calculate ratio
    stats.ratio =  (double) stats.calculateRatio(mutantRecords, totalRecords);
    
         
      return stats;  
    }
    

  

    
}