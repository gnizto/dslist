package com.gabrieldm.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrieldm.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
