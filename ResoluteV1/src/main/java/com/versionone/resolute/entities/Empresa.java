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
@Table(name="Empresa")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdEmpresa;
	private String nomeEmpresa;
	private String cnpj;
	private String emailEmpresa;
	private String categoriaEmpresa;
	private String telEmpresa;
	private String senhaEmpresa;
	
	
}
