package spring.boot.tptRpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.boot.tptRpg.model.*;

public interface IObjetRepository extends JpaRepository<Objet, Long>{
	@Query("select o.id from Objet o where o.nom = :nom")
	Integer findIdObjetForNom(@Param("nom") String nom);

}
