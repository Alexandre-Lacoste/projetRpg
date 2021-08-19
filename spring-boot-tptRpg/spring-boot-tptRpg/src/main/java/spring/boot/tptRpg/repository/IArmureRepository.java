package spring.boot.tptRpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.boot.tptRpg.model.*;

public interface IArmureRepository extends JpaRepository<Armure, Long> {
	@Query("select a from Armure a where a.nom = :nom")
	Armure findByName(@Param("nom") String nom);
}
