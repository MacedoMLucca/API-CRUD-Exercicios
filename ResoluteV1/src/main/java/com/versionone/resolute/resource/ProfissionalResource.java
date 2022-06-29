package com.versionone.resolute.resource;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.versionone.resolute.entities.Profissional;
import com.versionone.resolute.repositories.ProfissionalRepository;

@RestController
@CrossOrigin
@RequestMapping({"/cadastroProfissional"})
public class ProfissionalResource {
	
	private ProfissionalRepository repository;
	
	ProfissionalResource(ProfissionalRepository cadastrorepository){
		this.repository = cadastrorepository;
	}
	
	@GetMapping
	public List findAll(){
		return repository.findAll();		
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById(@PathVariable long IdProfissional) {
		return repository.findById(IdProfissional)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public Profissional create(@RequestBody Profissional cadastro) {
		return repository.save(cadastro);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity update(@PathVariable("id") long IdProfissional,
													@RequestBody Profissional cadastro) {
		return repository.findById(IdProfissional)
					.map(record -> {
					record.setNomeProf(cadastro.getNomeProf());
					record.setNomeSocial(cadastro.getNomeSocial());
					record.setEmailProf(cadastro.getEmailProf());
					record.setCpf(cadastro.getCpf());
					record.setTelefoneProf(cadastro.getTelefoneProf());
					record.setGenero(cadastro.getGenero());
					record.setCategoria(cadastro.getCategoria());
					record.setHardskill(cadastro.getHardskill());
					record.setProfissaPCD(cadastro.getProfissaPCD());
					record.setFreelancer(cadastro.getFreelancer());
					record.setTempoExperiencia(cadastro.getTempoExperiencia());
					record.setFormaPagamento(cadastro.getFormaPagamento());
					record.setPresencial(cadastro.getPresencial());
 					record.setHomeOffice(cadastro.getHomeOffice());
					record.setHibrido(cadastro.getHibrido());
					record.setFlexivel(cadastro.getHibrido());
					record.setFisica(cadastro.getFisica());
					record.setMental(cadastro.getMental());
					record.setAuditiva(cadastro.getAuditiva());
					record.setVisual(cadastro.getVisual());
					record.setSenhaProf(cadastro.getSenhaProf());
					Profissional updated = repository.save(record);
					return ResponseEntity.ok().body(updated);
					}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path= {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable long IdProfissional){
		return repository.findById(IdProfissional)
				.map(record -> {
					repository.deleteById(IdProfissional);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
	
}
