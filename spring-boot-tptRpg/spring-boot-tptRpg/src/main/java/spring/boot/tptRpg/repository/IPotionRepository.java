package spring.boot.tptRpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.boot.tptRpg.model.*;

public interface IPotionRepository  extends JpaRepository<Potion, Long>{
	@Query("select p from Potion p where p.nom = :nom")
	Potion findPotionByName(@Param("nom") String nom);
	

}
