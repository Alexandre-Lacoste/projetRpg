package spring.boot.tptRpg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.boot.tptRpg.model.Compte;

public interface ICompteRepository extends JpaRepository<Compte, Long> {
	
//	@Query("select a from Admin s")
//	List<Admin> findAllAdmin(); // @Query
//	
//	@Query("select a from Admin a where a.id = :id")
//	Optional<Admin> findAdminById(@Param("id") Long id);
	
	@Query("select distinct c from Compte c where c.pseudo = :pseudo")
	Optional<Compte> findBypseudoWithRoles(@Param("pseudo") String pseudo);
//	c left join fetch

}
