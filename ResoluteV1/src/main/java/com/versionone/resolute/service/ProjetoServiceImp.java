package com.versionone.resolute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versionone.resolute.entities.Projeto;
import com.versionone.resolute.repositories.ProjetoRepository;

import java.util.List;

@Service
public class ProjetoServiceImp implements ProjetoService{

	@Autowired
	private ProjetoRepository projetorepository;
	
	
	@Override
	public List<Projeto> getAllProjeto(){
		return projetorepository.findAll();
	}
	
	
	
	@Override
	public void saveProjeto(Projeto projeto) {
		this.projetorepository.save(projeto);
	}

}
