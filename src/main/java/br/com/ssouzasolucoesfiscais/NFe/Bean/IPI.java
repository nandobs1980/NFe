package br.com.ssouzasolucoesfiscais.NFe.Bean;

public class IPI {

	
    private int nItem; 
    private String clEnq; 
    private int CNPJProd; 
    private String cSelo; 
    private  int qSelo; 
    private String cEnq; 
    private String CST; 
    private float vBC; 
    private float pIPI; 
    private float qUnid; 
    private float vUnid; 
    public int getnItem() {
		return nItem;
	}
	public void setnItem(int nItem) {
		this.nItem = nItem;
	}
	public String getClEnq() {
		return clEnq;
	}
	public void setClEnq(String clEnq) {
		this.clEnq = clEnq;
	}
	public int getCNPJProd() {
		return CNPJProd;
	}
	public void setCNPJProd(int cNPJProd) {
		CNPJProd = cNPJProd;
	}
	public String getcSelo() {
		return cSelo;
	}
	public void setcSelo(String cSelo) {
		this.cSelo = cSelo;
	}
	public int getqSelo() {
		return qSelo;
	}
	public void setqSelo(int qSelo) {
		this.qSelo = qSelo;
	}
	public String getcEnq() {
		return cEnq;
	}
	public void setcEnq(String cEnq) {
		this.cEnq = cEnq;
	}
	public String getCST() {
		return CST;
	}
	public void setCST(String cST) {
		CST = cST;
	}
	public float getvBC() {
		return vBC;
	}
	public void setvBC(float vBC) {
		this.vBC = vBC;
	}
	public float getpIPI() {
		return pIPI;
	}
	public void setpIPI(float pIPI) {
		this.pIPI = pIPI;
	}
	public float getqUnid() {
		return qUnid;
	}
	public void setqUnid(float qUnid) {
		this.qUnid = qUnid;
	}
	public float getvUnid() {
		return vUnid;
	}
	public void setvUnid(float vUnid) {
		this.vUnid = vUnid;
	}
	public float getvIPI() {
		return vIPI;
	}
	public void setvIPI(float vIPI) {
		this.vIPI = vIPI;
	}
	private float vIPI; 
}
