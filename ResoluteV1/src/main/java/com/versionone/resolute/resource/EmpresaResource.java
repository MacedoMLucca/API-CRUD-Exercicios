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

import com.versionone.resolute.entities.Empresa;
import com.versionone.resolute.repositories.EmpresaRepository;

@RestController
@CrossOrigin
@RequestMapping({"/cadastroEmpresa"})
public class EmpresaResource {
	
	private EmpresaRepository repository;
	
	public EmpresaResource(EmpresaRepository empresaorepository) {
		this.repository = empresaorepository;
	}
	
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById(@PathVariable long IdEmpresa) {
		return repository.findById(IdEmpresa)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Empresa create(@RequestBody Empresa cadastro) {
		return repository.save(cadastro);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity update(@PathVariable("id") long IdEmpresa,
											@RequestBody Empresa cadastro) {
		return repository.findById(IdEmpresa)
				.map(record -> {
					record.setIdEmpresa(cadastro.getIdEmpresa());
					record.setNomeEmpresa(cadastro.getNomeEmpresa());
					record.setCnpj(cadastro.getCnpj());
					record.setEmailEmpresa(cadastro.getEmailEmpresa());
					record.setCategoriaEmpresa(cadastro.getCategoriaEmpresa());
					record.setTelEmpresa(cadastro.getTelEmpresa());
					record.setSenhaEmpresa(cadastro.getSenhaEmpresa());
					Empresa updated = repository.save(record);
					return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build());
	}
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable long IdEmpresa){
		return repository.findById(IdEmpresa)
				.map(record ->{
					repository.deleteById(IdEmpresa);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
	
	
	
	
	
	

}