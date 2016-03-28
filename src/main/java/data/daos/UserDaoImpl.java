package data.daos;

import data.entities.Token;
import data.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDaoExtended {

    @Autowired
    private TokenDao tokenDao;

	@Override
	public User findByValidNotExpiredToken(String value) {
		// TODO Auto-generated method stub
		
		Token token = tokenDao.findByValue(value);
		if ((token == null) || (token.hasExpired())){
			return null;
		} 
		else {
			return token.getUser();
		}	
	}
    
    
}
