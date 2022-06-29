package com.versionone.resolute.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.versionone.resolute.entities.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

}
