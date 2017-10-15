package br.com.ssouzasolucoesfiscais.NFe.Bean;

public class PIS {

	private int nItem;

	private String Tp_PIS; 
	private String CST; 
	private float vBC; 
	private float pPIS; 
	private float vPIS; 
	private float qBCProd; 
	private float vAliqProd;
	public int getnItem() {
		return nItem;
	}
	public void setnItem(int nItem) {
		this.nItem = nItem;
	}
	public String getTp_PIS() {
		return Tp_PIS;
	}
	public void setTp_PIS(String tp_PIS) {
		Tp_PIS = tp_PIS;
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
	public float getpPIS() {
		return pPIS;
	}
	public void setpPIS(float pPIS) {
		this.pPIS = pPIS;
	}
	public float getvPIS() {
		return vPIS;
	}
	public void setvPIS(float vPIS) {
		this.vPIS = vPIS;
	}
	public float getqBCProd() {
		return qBCProd;
	}
	public void setqBCProd(float qBCProd) {
		this.qBCProd = qBCProd;
	}
	public float getvAliqProd() {
		return vAliqProd;
	}
	public void setvAliqProd(float vAliqProd) {
		this.vAliqProd = vAliqProd;
	} 
}
