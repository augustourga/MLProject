/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mlproject;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import com.mongodb.MongoClientURI;
import org.mongodb.morphia.Morphia;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
    import com.mongodb.Mongo;
  import com.mongodb.DB;
 import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
//import com.mongodb.client.MongoCollection;

/**
 *
 * @author augus
 */
public class MutantService {
   // Datastore datastore = new Morphia().createDatastore(client,"save");
    public int totalRecords;
    public int mutantRecords;
    //private Datastore datastore;
    //private MongoCollection<Document> records;
    private DBCollection records;
    private MongoClientURI uri;
    private MongoClient client;
    private DB db;
    private Mongo mongo;
    private BasicDBObject addRecord;
    
    public void MutantService(){
    totalRecords =0;
    mutantRecords =0;
    // uri  = new MongoClientURI("mongodb://augustourga:123456@ds151963.mlab.com:51963/magneto_recruting"); 
 
   // uri  = new MongoClientURI("mongodb://augustourga:123456@localhost:27017");
       //client = new MongoClient(uri);
       mongo = new Mongo("localhost",27017);
  //  boolean auth = db.authenticate("augustourga", "123456".toCharArray());
    db = client.getDB("magneto-recruiting");
   // datastore = new Morphia().createDatastore(client,"magneto_recruting");
    records = db.getCollection("records");
    
    }
    
    public void addpost(Save save){
    //datastore.save(save);
    // Create seed data
    // records.insertOne({"dna": save.dna, "isMutant": save.isMutant });
    addRecord = new BasicDBObject();
    addRecord.put("dna", save.dna);
    addRecord.put("isMutant", save.isMutant);
    records.insert(addRecord);
    
    }
    
    public void setStats(Stats stats){
    
            //query (total records, mutant records)
         //  stats.count_human_dna= records.find().count();
           //stats.count_mutant_dna=  records.find( { "isMutant": true } ).count();
           stats.ratio(mutantRecords, totalRecords);
            
    }
    

  

    
}