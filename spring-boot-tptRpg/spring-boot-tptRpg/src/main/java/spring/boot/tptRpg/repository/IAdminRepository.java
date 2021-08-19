package spring.boot.tptRpg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.boot.tptRpg.model.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Long>{

	@Query("select a from Admin a where a.id = :id")
	Optional<Admin> findAdminById(@Param("id") Long id);

}
