package br.com.ssouzasolucoesfiscais.NFe.Bean;

public class Prod {

	private int nItem; 
	private String cProd; 
	private int cEAN; 
	private String xProd; 
	private int NCM; 
	private String NVE; 
	private int CEST; 
	private char indEscala; 
	private int CNPJFab; 
	private String cBenef; 
	private int EXTIPI; 
	private int CFOP; 
	private String uCom; 
	private float qCom; 
	private float vUnCom; 
	private float vProd; 
	private int cEANTrib; 
	private String uTrib; 
	private float qTrib; 
	private float vUnTrib; 
	private float vFrete; 
	private float vSeg; 
	private float vDesc; 
	private float vOutro; 
	private byte indTot; 
	private String xPed; 
	private int nItemPed; 
	private String nFCI;
	private ICMS icms = new ICMS(); 
	private PIS pis = new PIS(); 
	private COFINS cofins = new COFINS(); 
	private ISSQN issqn = new ISSQN(); 

	 
	public ICMS getIcms() {
		return icms;
	}
	public void setIcms(ICMS icms) {
		this.icms = icms;
	}
	public PIS getPis() {
		return pis;
	}
	public void setPis(PIS pis) {
		this.pis = pis;
	}
	public COFINS getCofins() {
		return cofins;
	}
	public void setCofins(COFINS cofins) {
		this.cofins = cofins;
	}
	public ISSQN getIssqn() {
		return issqn;
	}
	public void setIssqn(ISSQN issqn) {
		this.issqn = issqn;
	}
	public int getnItem() {
		return nItem;
	}
	public void setnItem(int nItem) {
		this.nItem = nItem;
	}
	public String getcProd() {
		return cProd;
	}
	public void setcProd(String cProd) {
		this.cProd = cProd;
	}
	public int getcEAN() {
		return cEAN;
	}
	public void setcEAN(int cEAN) {
		this.cEAN = cEAN;
	}
	public String getxProd() {
		return xProd;
	}
	public void setxProd(String xProd) {
		this.xProd = xProd;
	}
	public int getNCM() {
		return NCM;
	}
	public void setNCM(int nCM) {
		NCM = nCM;
	}
	public String getNVE() {
		return NVE;
	}
	public void setNVE(String nVE) {
		NVE = nVE;
	}
	public int getCEST() {
		return CEST;
	}
	public void setCEST(int cEST) {
		CEST = cEST;
	}
	public char getIndEscala() {
		return indEscala;
	}
	public void setIndEscala(char indEscala) {
		this.indEscala = indEscala;
	}
	public int getCNPJFab() {
		return CNPJFab;
	}
	public void setCNPJFab(int cNPJFab) {
		CNPJFab = cNPJFab;
	}
	public String getcBenef() {
		return cBenef;
	}
	public void setcBenef(String cBenef) {
		this.cBenef = cBenef;
	}
	public int getEXTIPI() {
		return EXTIPI;
	}
	public void setEXTIPI(int eXTIPI) {
		EXTIPI = eXTIPI;
	}
	public int getCFOP() {
		return CFOP;
	}
	public void setCFOP(int cFOP) {
		CFOP = cFOP;
	}
	public String getuCom() {
		return uCom;
	}
	public void setuCom(String uCom) {
		this.uCom = uCom;
	}
	public float getqCom() {
		return qCom;
	}
	public void setqCom(float qCom) {
		this.qCom = qCom;
	}
	public float getvUnCom() {
		return vUnCom;
	}
	public void setvUnCom(float vUnCom) {
		this.vUnCom = vUnCom;
	}
	public float getvProd() {
		return vProd;
	}
	public void setvProd(float vProd) {
		this.vProd = vProd;
	}
	public int getcEANTrib() {
		return cEANTrib;
	}
	public void setcEANTrib(int cEANTrib) {
		this.cEANTrib = cEANTrib;
	}
	public String getuTrib() {
		return uTrib;
	}
	public void setuTrib(String uTrib) {
		this.uTrib = uTrib;
	}
	public float getqTrib() {
		return qTrib;
	}
	public void setqTrib(float qTrib) {
		this.qTrib = qTrib;
	}
	public float getvUnTrib() {
		return vUnTrib;
	}
	public void setvUnTrib(float vUnTrib) {
		this.vUnTrib = vUnTrib;
	}
	public float getvFrete() {
		return vFrete;
	}
	public void setvFrete(float vFrete) {
		this.vFrete = vFrete;
	}
	public float getvSeg() {
		return vSeg;
	}
	public void setvSeg(float vSeg) {
		this.vSeg = vSeg;
	}
	public float getvDesc() {
		return vDesc;
	}
	public void setvDesc(float vDesc) {
		this.vDesc = vDesc;
	}
	public float getvOutro() {
		return vOutro;
	}
	public void setvOutro(float vOutro) {
		this.vOutro = vOutro;
	}
	public byte getIndTot() {
		return indTot;
	}
	public void setIndTot(byte indTot) {
		this.indTot = indTot;
	}
	public String getxPed() {
		return xPed;
	}
	public void setxPed(String xPed) {
		this.xPed = xPed;
	}
	public int getnItemPed() {
		return nItemPed;
	}
	public void setnItemPed(int nItemPed) {
		this.nItemPed = nItemPed;
	}
	public String getnFCI() {
		return nFCI;
	}
	public void setnFCI(String nFCI) {
		this.nFCI = nFCI;
	} 
     
}
