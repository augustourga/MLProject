/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mlproject;

import static spark.Spark.*;

/**
 *
 * @author augus
 */
public class WebAPI {
    
    public static void main(String[] args) { 
      post("/mutant", (request, response) -> {
        
       response.type("application/json");
    DNA dna = new Gson().fromJson(request.body(), DNA.class);
    if(InterfaceService.isMutant(dna)){
        return new Gson()
      .toJson(new StandardResponse(StatusResponse.SUCCESS));
    } else { return new Gson()
      .toJson(new StandardResponse(StatusResponse.ERROR));
      }
 
    
    });} 
    
}
