package br.com.ssouzasolucoesfiscais.NFe.Bean;

public class COFINS {
	
	private int nItem;
	private String Tp_COFINS; 
    private String CST; 
    private float vBC; 
    private float pCOFINS; 
    private float vCOFINS; 
    private float qBCProd; 
    private float vAliqProd; 
    
	public int getnItem() {
		return nItem;
	}
	public void setnItem(int nItem) {
		this.nItem = nItem;
	}
    public String getTp_COFINS() {
		return Tp_COFINS;
	}
	public void setTp_COFINS(String tp_COFINS) {
		Tp_COFINS = tp_COFINS;
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
	public float getpCOFINS() {
		return pCOFINS;
	}
	public void setpCOFINS(float pCOFINS) {
		this.pCOFINS = pCOFINS;
	}
	public float getvCOFINS() {
		return vCOFINS;
	}
	public void setvCOFINS(float vCOFINS) {
		this.vCOFINS = vCOFINS;
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
