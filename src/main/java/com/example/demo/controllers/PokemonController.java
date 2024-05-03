package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.PokemonModel;
import com.example.demo.services.PokemonService;


@RestController
@RequestMapping("/mypokemons")
public class PokemonController {
    @Autowired
    PokemonService pokemonService;

    @GetMapping()
    public ArrayList<PokemonModel> getAllPokemons(){
        return pokemonService.getMyPokemons();
    }

    @PostMapping()
    public PokemonModel savePokemon(@RequestBody PokemonModel pokemon){
        return this.pokemonService.savePokemon(pokemon);
    }

    @GetMapping(path = "{id}")
    public Optional<PokemonModel> getAllPokemonsById(@PathVariable("id") Long id){
        return this.pokemonService.getPokemonById(id);
    }

    @GetMapping("/query")
    public ArrayList<PokemonModel> getPokemonName(@RequestParam("name") String name){
        return this.pokemonService.getPokemonByName(name);
    }

    @DeleteMapping(path = "{id}")
    public String deletePokemon(@PathVariable("id") Long id){
        boolean ok = this.pokemonService.deletePokemon(id);
        if(ok){
            return "delete pokemon succesful" + id;
        }else{
            return "cannot delete this pokemon" + id;
        }
    }


}
