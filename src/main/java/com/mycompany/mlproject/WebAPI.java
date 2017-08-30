/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mlproject;

import spark.*;
import static spark.Spark.*;
import com.google.gson.Gson;

/**
 *
 * @author augus
 */
public class WebAPI {
   public static MutantService mutantService = new MutantService();
    
    public static void main(String[] args) { 
       
        port(getHerokuAssignedPort());
       get("/", (request, response) ->{ 
                         response.type("text/html");
                         response.body("<!DOCTYPE html><html lang=\"en\"><head><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"><script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js\"></script><script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\"><title>Mutant Service</title></head><body><div class=\"jumbotron text-center\"><h1>Welcome to mutant service</h1><p>We offer you the following services:</p> </div><div class=\"container\"><div class=\"row\"><div class=\"col-sm-6\"><h3>/mutant</h3><p>Check if a dna sequence belongs to a mutant on (POST) sending a String[]</p><a href=\"https://augustourga-mutant-service.herokuapp.com/mutant\"><p>https://augustourga-mutant-service.herokuapp.com/mutant</p></a><button type=\"button\" id=\"button-see\" class=\"btn btn-primary\">See Json example</button><div class=\"row\" style=\"margin-top: 5%;\"><div class=\"alert alert-info\" id=\"example\"><p>{ \"dna\" :  [ \"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"] } </p><p> <strong>Return:</strong> </br> Success: The sequence belongs to a mutant HTTP-200-OK </br>Unsuccess: The sequence belongs to a human  HTTP-403-Forbidden </p><strong>* The sequence must be nxn</strong> (words x lenght) </br><strong>* Only accept characters (A,T,C,G) </strong></div></div></div><div class=\"col-sm-6\"><h3>/stats</h3><p>Get some stats about checks (GET)</p><a href=\"https://augustourga-mutant-service.herokuapp.com/stats\"><p>https://augustourga-mutant-service.herokuapp.com/stats</p></a></div></div></div><script>$(\"#example\").hide();$(document).ready(function(){$(\"#button-see\").click(function(){if($(\"#example\").is(\":visible\")){$(\"#example\").hide();}else {$(\"#example\").show();}});});</script></body></html>\n");
                         return response.body();
		
       } );
        
       post("/mutant", (request, response) -> {
           Gson gson = new Gson();
           response.type("application/json");
           MutantCheck mutantCheck = new MutantCheck();
           Query query = gson.fromJson(request.body(), Query.class);

           if(!(query.validate()))
            {
              response.status(400);
              response.body("The sequence must be nxn (words x lenght) and only accept characters (A,T,C,G) ");
            
            }else 
            {
            Save save = new Save();
            save.dna = query.dna;
            save.isMutant = mutantCheck.isMutant(save.dna); 
            if(save.isMutant)
            {
                response.status(200);
                response.body("The sequence belongs to a mutant ");
            } else 
            {
               response.status(403);
               response.body("The sequence belongs to a human");
                
            }
            //mutantService.addpost(save);
            }
            
           
           String jsonOutput = gson.toJson(response.body())    ;
          return jsonOutput;
           
            
        });
       
       
        get("/stats", (request, response) -> {
            Gson gson = new Gson();
            Stats stats = new Stats();
          response.type("application/json");
       // process request
       mutantService.setStats(stats);
       String jsonOutput = gson.toJson(stats);
            return jsonOutput;
        
        });
       
       }
   
     static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
       
 
    
}
