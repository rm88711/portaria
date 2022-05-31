package br.com.portaria.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Visitante {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_visitante;
	private String nm_visitante;
	private LocalDate dt_nasc;
	private String nr_cpf;
	private String nr_rg;
	private String nm_digito_rg;
	private String imagePath;
	private LocalDateTime dt_cadastro = LocalDateTime.now();
	
	public Long getId_visitante() {
		return id_visitante;
	}
	
	public String getNm_visitante() {
		return nm_visitante;
	}
	
	public void setNm_visitante(String nm_visitante) {
		this.nm_visitante = nm_visitante;
	}
	
	public LocalDate getDt_nasc() {
		return dt_nasc;
	}
	
	public void setDt_nasc(LocalDate dt_nasc) {
		this.dt_nasc = dt_nasc;
	}
	
	public String getNr_cpf() {
		return nr_cpf;
	}
	
	public void setNr_cpf(String nr_cpf) {
		this.nr_cpf = nr_cpf;
	}
	
	public String getNr_rg() {
		return nr_rg;
	}
	
	public void setNr_rg(String nr_rg) {
		this.nr_rg = nr_rg;
	}
	
	public String getNm_digito_rg() {
		return nm_digito_rg;
	}
	
	public void setNm_digito_rg(String nm_digito_rg) {
		this.nm_digito_rg = nm_digito_rg;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public LocalDateTime getDt_cadastro() {
		return dt_cadastro;
	}
	
	public void setDt_cadastro(LocalDateTime dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}
	
	@Override
	public String toString() {
		return "Visitante [nome=" + nm_visitante + ", data de nascimento =" + dt_nasc + ", cpf=" + nr_cpf + ", rg=" + nr_rg +
				", digito do rg=" + nm_digito_rg + ", data de cadastro=" + dt_cadastro + "]";
	}

}
