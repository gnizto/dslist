package com.gabrieldm.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrieldm.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
