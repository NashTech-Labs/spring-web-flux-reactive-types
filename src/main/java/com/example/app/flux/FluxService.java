package com.example.app.flux;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class FluxService {




    public Flux<String> createFluxOfStrings(){
        return Flux.just("gaurav","akshit","sachin");
    }

    public Flux<String> createEmptyFlux(){
        return Flux.empty();
    }


    public Flux<String>  combineTwoFlux(){

       return Flux.concat(getFirstFlux()).concatWith(getSecondFlux());
    }

    public Flux<String> mergeTwoFlux(){
        return Flux.merge(getFirstFlux()).mergeWith(getSecondFlux());
    }


    public Flux<String> fluxFromIterable(){
        return Flux.fromIterable(Arrays.asList("AKSHIT","SUNNY"));
    }

    public Flux<String> fluxFromArray(){
        return Flux.fromArray( new String[]{"AKSHIT","AJAY"});
    }

    public Flux<String> handleFluxWithError(){

        return Flux.fromArray( new String[]{"AKSHIT","DHONI"}).doOnNext( name -> {

            System.out.println("name received "+name);
            if("BARATH".equals(name)){
                throw new RuntimeException("throw custom forced exception");
            }
        }).doOnError( error -> {
            System.out.println("Error occured "+error.getMessage());
        }).onErrorReturn("ERROR AKSHIT");
    }

    private Flux<String> getFirstFlux(){

        return Flux.just("AJAY","VIJAY","RAJU");
    }

    private Flux<String> getSecondFlux(){

        return Flux.just("BILL","GATES","JORDAN");
    }

    private Flux<String> getSecondFluxWithDuplicateValues(){

        return Flux.just("BILL","GATES","JORDAN");
    }
}
