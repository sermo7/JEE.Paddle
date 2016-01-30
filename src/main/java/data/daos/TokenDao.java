package data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import business.entities.Token;
import business.entities.User;

public interface TokenDao extends JpaRepository<Token, Integer> {

    Token findByUser(User user);
}
