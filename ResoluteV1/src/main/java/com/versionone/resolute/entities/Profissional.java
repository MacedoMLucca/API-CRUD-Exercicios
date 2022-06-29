package com.versionone.resolute.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="Profissional")
public class Profissional {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdProfissional;
	private String nomeProf;
	private String nomeSocial;
	private String emailProf;
	private String cpf;
	private String telefoneProf;
	private String genero;
	private String categoria;
	private String hardskill;
	private String profissaPCD;
	private String freelancer;
	private String tempoExperiencia;
	private String formaPagamento;
	private String presencial;
	private String homeOffice;
	private String hibrido;
	private String flexivel;
	private String fisica;
	private String mental;
	private String auditiva;
	private String visual;
	private String senhaProf;
}
