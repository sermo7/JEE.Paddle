package data.daos;

import data.entities.Token;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TokenDaoImpl implements TokenDaoExtended {

    @Autowired
    private TokenDao tokenDao;

	@Override
	public void removeTokensExpired() {
		// TODO Auto-generated method stub
		
		List <Token> tokens = tokenDao.findAll();
		for (Token token : tokens){
			if (token.hasExpired()){
				tokenDao.delete(token);
			}
		}
	}
    
    
}
