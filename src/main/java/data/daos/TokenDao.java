package data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import business.entities.Token;

public interface TokenDao extends JpaRepository<Token, Integer>{

}
