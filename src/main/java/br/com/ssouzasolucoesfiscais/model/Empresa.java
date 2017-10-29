package br.com.ssouzasolucoesfiscais.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Empresa implements ModeloBase {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	@Column
	private String Nome;
	@Column
	private String Documento;
	@Column (nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Data_Inclusao;
	
	public Long getId() {
		return Id;
	}
	public void setId_Empresa(Long id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDocumento() {
		return Documento;
	}
	public void setDocumento(String documento) {
		Documento = documento;
	}
	public Date getData_Inclusao() {
		return Data_Inclusao;
	}
	public void setData_Inclusao(Date data_Inclusao) {
		Data_Inclusao = data_Inclusao;
	}
	
}
