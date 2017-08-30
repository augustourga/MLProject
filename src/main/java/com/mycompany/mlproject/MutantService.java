/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mlproject;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;


/**
 *
 * @author augus
 */
public class MutantService {
    //MongoClient client = new MongoClient("localhost", 4568);
   // Datastore datastore = new Morphia().createDatastore(client,"save");
    public int totalRecords;
    public int mutantRecords;
    
    public void MutantService(){
    totalRecords =0;
    mutantRecords =0;
    
    }
    
    public void addpost(Save save){
    //datastore.save(save);
    totalRecords++;
    if( save.isMutant ){
        mutantRecords++;
    }
    }
    
    public void setStats(Stats stats){
    
            //query (total records, mutant records)
           stats.count_human_dna= totalRecords;
           stats.count_mutant_dna= mutantRecords;
           stats.ratio(mutantRecords, totalRecords);
            
    }
    

  

    
}