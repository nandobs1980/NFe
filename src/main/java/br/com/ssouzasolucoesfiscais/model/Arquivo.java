package br.com.ssouzasolucoesfiscais.model;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Tnfe_Arquivo")
public class Arquivo implements ModeloBase, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name="id_Arquivo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column (nullable=false)
	private byte id_Empresa;
	@Column
	private String pathXML;
	@Column
	private String fileNameXML;
	@Column
	private String creationTime;
	@Column
	private String lastAccessTime;
	@Column
	private String lastModifiedTime;
	@Column
	private long size;
	@Column //(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date Data_Inclusao;

	public Arquivo() {
		
	}

	public Arquivo(byte id_Empresa, String pathXML, String fileNameXML) throws IOException {
		
		Path pFile = Paths.get(pathXML + fileNameXML);
		BasicFileAttributes attr = Files.readAttributes(pFile, BasicFileAttributes.class);
		Date now = new Date();
		
		this.pathXML = pathXML;
		this.fileNameXML = fileNameXML;
		this.setId_Empresa(id_Empresa);
		
		this.creationTime = attr.creationTime().toString();
        this.lastAccessTime = attr.lastAccessTime().toString();
        this.lastModifiedTime = attr.lastModifiedTime().toString();
        this.size = attr.size();
        this.Data_Inclusao = now;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public byte getId_Empresa() {
		return id_Empresa;
	}

	public void setId_Empresa(byte id_Empresa) {
		this.id_Empresa = id_Empresa;
	}

	public String getPathXML() {
		return pathXML;
	}

	public void setPathXML(String pathXML) {
		this.pathXML = pathXML;
	}

	
	public String getFileNameXML() {
		return fileNameXML;
	}

	public void setFileNameXML(String fileNameXML) {
		this.fileNameXML = fileNameXML;
	}

	
	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	
	public String getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(String lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}
	
	
	public String getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(String lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	
	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
	public Date getData_Inclusao() {
		return Data_Inclusao;
	}


	public void setData_Inclusao(Date data_Inclusao) {
		this.Data_Inclusao = data_Inclusao;
	}
}
