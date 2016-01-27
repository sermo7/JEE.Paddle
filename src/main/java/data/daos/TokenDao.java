package data.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import business.entities.Token;
import business.entities.User;

public interface TokenDao extends JpaRepository<Token, Integer> {

    @Query("select token.user from Token token where token.value = ?1")
    User findUserByValue(String value);

    Token findByUser(User user);
}
