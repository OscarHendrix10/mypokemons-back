package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.PokemonModel;
import com.example.demo.repositories.PokemonRepositorie;


@Service
public class PokemonService {
    @Autowired
    PokemonRepositorie pokemonRepositorie;

    public ArrayList<PokemonModel> getMyPokemons(){
       return (ArrayList<PokemonModel>) pokemonRepositorie.findAll();
    }

    public PokemonModel savePokemon(PokemonModel pokemon){
        return pokemonRepositorie.save(pokemon);
    }

    public Optional<PokemonModel> getPokemonById(Long id){
        return pokemonRepositorie.findById(id);
    }

    public ArrayList<PokemonModel> getPokemonByName(String name){
        return pokemonRepositorie.findByName(name);
    }

    public boolean deletePokemon(Long id){
        try{
            pokemonRepositorie.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
