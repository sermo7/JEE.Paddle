package data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import business.entities.Court;

public interface CourtDao extends JpaRepository<Court, Integer>{

}
