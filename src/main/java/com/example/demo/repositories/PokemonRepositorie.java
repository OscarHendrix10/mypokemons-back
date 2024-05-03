package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.PokemonModel;



@Repository
public interface PokemonRepositorie extends CrudRepository<PokemonModel, Long>{

    public abstract ArrayList<PokemonModel> findByName(String name);
    
}
