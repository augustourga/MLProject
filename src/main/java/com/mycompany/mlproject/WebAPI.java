/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mlproject;

import static spark.Spark.post;
import com.google.gson.Gson;

/**
 *
 * @author augus
 */
public class WebAPI {
   public static MutantService mutantService = new MutantService();
    
    public static void main(String[] args) { 
        
       post("/mutant/", (request, response) -> {
          final  Gson gson = new Gson();
           MutantCheck mutantCheck = new MutantCheck();
          //ConsoleLog.consoleLog(log, request);
            
            response.type("application/json");

            Query query = gson.fromJson(request.body(), Query.class);
            query.isMutant = mutantCheck.isMutant(query.dna); 
            mutantService.addpost(query);
            if(query.isMutant){
                return response.status(200);
                
            } else 
            {  return response.status(403);
            }
            
            
        }, gson::toJson);
} 
    
}
