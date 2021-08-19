package spring.boot.tptRpg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.boot.tptRpg.model.Arme;

public interface IArmeRepository extends JpaRepository<Arme, Long> {
	@Query("select a from Arme a where a.id = :id")
	Optional <Arme> findByArmeId(@Param("id") Long id);

	@Query("select a from Arme a where a.nom = :nom")
	Arme findByName(@Param("nom") String nom);

}
