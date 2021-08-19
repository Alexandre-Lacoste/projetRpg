package spring.boot.tptRpg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.boot.tptRpg.model.Arme;
import spring.boot.tptRpg.model.TypeArme;

public interface IArmeRepository extends JpaRepository<Arme, Long> {
	@Query("select a from Arme a where a.id = :id")
	Optional <Arme> findByArmeId(@Param("id") Long id);

	@Query("select a from Arme a where a.nom = :nom")
	Arme findByName(@Param("nom") String nom);
	
//	@Query("select a from Arme a ORDER BY a.prixAchat ASC")
//	Arme orderByBuyingPriceAsc();
//	
//	@Query("SELECT a FROM Arme a ORDER BY a.prixAchat DESC")
//	Arme orderByBuyingPriceDesc();
//	
//	@Query("SELECT a FROM Arme a ORDER BY a.prixVente ASC")
//	Arme orderBySellingPriceAsc();
//	
//	@Query("SELECT a FROM Arme a ORDER BY a.prixVente DESC")
//	Arme orderBySellingPriceDesc();
//	
//	@Query("SELECT a FROM Arme a ORDER BY a.typeArme")
//	Arme findAllByTypeArme();
	
//	// Pour trouver les classer en fonction de leur type
//	@Query("SELECT a FROM Arme a ORDER BY a.typeArme ASC")
//	Arme findAllByTypeArmeAsc();
//	
//	@Query("SELECT a FROM Arme a ORDER BY a.typeArme DESC")
//	Arme findAllByTypeArmeDesc();
	
//	//Pour choisir un type precis à afficher
	@Query("SELECT a FROM Arme a WHERE a.typeArme = :type")
	Arme findTypeArme(@Param("type") TypeArme type);
	
	@Query("SELECT a.prixAchat FROM Arme a where a.nom = :nom")
	Arme findArmeBuyingPriceFromName(@Param("nom") Long nom);
}
