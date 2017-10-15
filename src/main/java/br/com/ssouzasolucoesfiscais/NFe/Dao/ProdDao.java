package br.com.ssouzasolucoesfiscais.NFe.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import br.com.ssouzasolucoesfiscais.NFe.Bean.Prod;
import br.com.ssouzasolucoesfiscais.NFe.Jdbc.ConnectionFactory;

public class ProdDao {

	private Connection conexao;
	
	public ProdDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Prod prod, long id_Arquivo) {
		String storedProcedure = "SPnfe_IN_TNFe_infNFe_det_prod";
		
		CallableStatement cstmt = null;
		try {
			
	        cstmt = conexao.prepareCall("{call " + storedProcedure + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");	
	        
	        cstmt.setLong("Id_Arquivo", id_Arquivo);
	        cstmt.setInt("nItem", prod.getnItem());
	        cstmt.setString("cProd", prod.getcProd());
	        cstmt.setInt("cEAN", prod.getcEAN());
	        cstmt.setString("xProd", prod.getxProd());
	        cstmt.setInt("NCM", prod.getNCM());
	        cstmt.setString("NVE", prod.getNVE());
	        cstmt.setInt("CEST", prod.getCEST());
	        cstmt.setString("indEscala", String.valueOf(prod.getIndEscala()));
	        cstmt.setInt("CNPJFab", prod.getCNPJFab());
	        cstmt.setString("cBenef", prod.getcBenef());
	        cstmt.setInt("EXTIPI", prod.getEXTIPI());
	        cstmt.setInt("CFOP", prod.getCFOP());
	        cstmt.setString("uCom", prod.getuCom());
	        cstmt.setFloat("qCom", prod.getqCom());
	        cstmt.setFloat("vUnCom", prod.getvUnCom());
	        cstmt.setFloat("vProd", prod.getvProd());
	        cstmt.setFloat("cEANTrib", prod.getcEANTrib());
	        cstmt.setString("uTrib", prod.getuTrib());
	        cstmt.setFloat("qTrib", prod.getqTrib());
	        cstmt.setFloat("vUnTrib", prod.getvUnTrib());
	        cstmt.setFloat("vFrete", prod.getvFrete());
	        cstmt.setFloat("vSeg", prod.getvSeg());
	        cstmt.setFloat("vDesc", prod.getvDesc());
	        cstmt.setFloat("vOutro", prod.getvOutro());
	        cstmt.setFloat("indTot", prod.getIndTot());
	        cstmt.setString("xPed", prod.getxPed());
	        cstmt.setFloat("nItemPed", prod.getnItemPed());
	        cstmt.setString("nFCI", prod.getnFCI());
	        
	        cstmt.execute();
	        
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
