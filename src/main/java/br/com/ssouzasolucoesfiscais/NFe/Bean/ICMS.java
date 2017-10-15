package br.com.ssouzasolucoesfiscais.NFe.Bean;

public class ICMS {

	
    private int nItem; 
    private String Tp_ICMS; 
    private byte orig; 
    private String CST; 
    private byte modBC; 
    private float vBC; 
    private float pICMS; 
    private float vICMS; 
    private float pFCP; 
    private float vFCP;
	public int getnItem() {
		return nItem;
	}
	public void setnItem(int nItem) {
		this.nItem = nItem;
	}
	public String getTp_ICMS() {
		return Tp_ICMS;
	}
	public void setTp_ICMS(String tp_ICMS) {
		Tp_ICMS = tp_ICMS;
	}
	public byte getOrig() {
		return orig;
	}
	public void setOrig(byte orig) {
		this.orig = orig;
	}
	public String getCST() {
		return CST;
	}
	public void setCST(String cST) {
		CST = cST;
	}
	public byte getModBC() {
		return modBC;
	}
	public void setModBC(byte modBC) {
		this.modBC = modBC;
	}
	public float getvBC() {
		return vBC;
	}
	public void setvBC(float vBC) {
		this.vBC = vBC;
	}
	public float getpICMS() {
		return pICMS;
	}
	public void setpICMS(float pICMS) {
		this.pICMS = pICMS;
	}
	public float getvICMS() {
		return vICMS;
	}
	public void setvICMS(float vICMS) {
		this.vICMS = vICMS;
	}
	public float getpFCP() {
		return pFCP;
	}
	public void setpFCP(float pFCP) {
		this.pFCP = pFCP;
	}
	public float getvFCP() {
		return vFCP;
	}
	public void setvFCP(float vFCP) {
		this.vFCP = vFCP;
	} 
    
}
