package data.daos;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import business.entities.Court;
import business.entities.Reserve;

public interface ReserveDao extends JpaRepository<Reserve, Integer> {
    
    List<Reserve> findByDateBetween(Calendar date1, Calendar date2);

    Reserve findByCourtAndDate(Court court, Calendar date);
}
