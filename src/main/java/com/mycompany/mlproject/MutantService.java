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
    MongoClient client = new MongoClient("localhost", 27017);
    Datastore datastore = new Morphia().createDatastore(client,"save");
    
    public void addpost(Save save){
    datastore.save(save);
    }
    
    public String getStats(){
    
            //query (total records, mutant records)
            return "stats";
            
    }
    

  

    
}