package data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import business.entities.Reserve;

public interface ReserveDao extends JpaRepository<Reserve, Integer> {
    //TODO
    //List<Reserve> findByStartDateBetween(Calendar date1, Calendar date2);
}
