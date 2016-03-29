package data.daos;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import data.entities.User;
import data.entities.Training;
import data.entities.Court;

public interface TrainingDao extends JpaRepository<Training, Integer>, TrainingDaoExtended {

    List <Training> findByCourt (Court court);
    List <Training> findByTrainer (User trainer);
    List <Training> findByStartDate (Calendar startDate);
    
}
