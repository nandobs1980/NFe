package br.com.ssouzasolucoesfiscais.NFe.Bean;

public class Local {

	private char Tp_Local;    
    private int Id_Doc;  
    private String xLgr;  
    private String nro;  
    private String xCpl;  
    private String xBairro;  
    private int cMun; 
    private String xMun;  
    private String UF;
    
	public char getTp_Local() {
		return Tp_Local;
	}
	public void setTp_Local(char tp_Local) {
		Tp_Local = tp_Local;
	}
	public int getId_Doc() {
		return Id_Doc;
	}
	public void setId_Doc(int id_Doc) {
		Id_Doc = id_Doc;
	}
	public String getxLgr() {
		return xLgr;
	}
	public void setxLgr(String xLgr) {
		this.xLgr = xLgr;
	}
	public String getNro() {
		return nro;
	}
	public void setNro(String nro) {
		this.nro = nro;
	}
	public String getxCpl() {
		return xCpl;
	}
	public void setxCpl(String xCpl) {
		this.xCpl = xCpl;
	}
	public String getxBairro() {
		return xBairro;
	}
	public void setxBairro(String xBairro) {
		this.xBairro = xBairro;
	}
	public int getcMun() {
		return cMun;
	}
	public void setcMun(int cMun) {
		this.cMun = cMun;
	}
	public String getxMun() {
		return xMun;
	}
	public void setxMun(String xMun) {
		this.xMun = xMun;
	}
	public String getUF() {
		return UF;
	}
	public void setUF(String uF) {
		UF = uF;
	}
	
	
}
