package com.versionone.resolute.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.versionone.resolute.entities.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
