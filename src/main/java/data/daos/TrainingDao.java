package data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import data.entities.Token;
import data.entities.User;
import data.entities.Training;

public interface TrainingDao extends JpaRepository<Token, Integer>, TrainingDaoExtended {

    Token findByUser(User user);
}
