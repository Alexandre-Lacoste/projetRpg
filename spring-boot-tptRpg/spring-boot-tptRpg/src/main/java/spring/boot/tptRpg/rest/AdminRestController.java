package spring.boot.tptRpg.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import spring.boot.tptRpg.model.Admin;
import spring.boot.tptRpg.model.Compte;
import spring.boot.tptRpg.model.Views;
import spring.boot.tptRpg.repository.IAdminRepository;
import spring.boot.tptRpg.repository.ICompteRepository;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminRestController {

	@Autowired
	private IAdminRepository adminRepo;
	
	@Autowired
	private ICompteRepository compteRepo;


	@GetMapping("/admin")
	@JsonView(Views.ViewAdmin.class)
//	@PreAuthorize("hasAnyRole('ADMIN')")
	public List<Admin> findAllAdmin() {
		return adminRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewAdmin.class)
	public Compte find(@PathVariable Long id) {

		Optional<Admin> optAdmin = adminRepo.findById(id);

		if (optAdmin.isPresent()) {
			return optAdmin.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/compte")
	@JsonView(Views.ViewAdmin.class)
	public List<Compte> findAllCompte() {
		return compteRepo.findAll();
	}
	
	
	

	@PostMapping("")
	@JsonView(Views.ViewAdmin.class)
	public Admin create(@RequestBody Admin admin) {
		admin = adminRepo.save(admin);

		return admin;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewAdmin.class)
	public Admin update(@RequestBody Admin admin, @PathVariable Long id) {
		if (!adminRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		admin = adminRepo.save(admin);

		return admin;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!adminRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		adminRepo.deleteById(id);
	}
	
}
