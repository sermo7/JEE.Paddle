package data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import data.entities.Token;
import data.entities.User;

public interface TokenDao extends JpaRepository<Token, Integer>, TokenDaoExtended {

    Token findByUser(User user);
    
    Token findByValue (String value);
}
