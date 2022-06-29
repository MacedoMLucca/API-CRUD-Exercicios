package com.versionone.resolute.service;

import com.versionone.resolute.entities.Projeto;

import java.util.List;

public interface ProjetoService {
	List<Projeto> getAllProjeto();
	void saveProjeto(Projeto projeto);
	
	
}
