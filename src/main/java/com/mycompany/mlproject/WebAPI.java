/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mlproject;

import static spark.Spark.post;
import static spark.Spark.get;
import com.google.gson.Gson;

/**
 *
 * @author augus
 */
public class WebAPI {
   public static MutantService mutantService = new MutantService();
    
    public static void main(String[] args) { 
        
       post("/mutant", (request, response) -> {
           Gson gson = new Gson();
           Save save = new Save();
           MutantCheck mutantCheck = new MutantCheck();
          //ConsoleLog.consoleLog(log, request);
            
            response.type("application/json");
            /*voy a sacar el contenido del json 
            y lo tengo que guardar en query.dna, ahora no lo esta haciendo.
            */Query query = gson.fromJson(request.body(), Query.class);
            
            
            /*una vez que tengo el objeto armado, checkeo si es mutante*/
            save.isMutant = mutantCheck.isMutant(query.dna); 
            save.dna = query.dna;
            
            /* guardo la consulta tanto el string, como el ismutant*/
           // mutantService.addpost(save);
            
            /*en caso de exito devuelve el status 200 ¿esta bien esto?
            y despues devuelvo el objeto response? */
           if(save.isMutant){
                response.status(200);
                response.body("i'm a mutant");
               
                
            } else 
            {  response.status(403);
               response.body("i'm not a mutant");
            }
           String jsonOutput = gson.toJson(response.body())    ;
          return jsonOutput;
           
            
        });
       
       
        get("/stats", (request, response) -> {
            Gson gson = new Gson();
          response.type("application/json");
       // process request
       
       String jsonOutput = gson.toJson(mutantService.getStats());
            return jsonOutput;
        
        });
       }
       
 
    
}
