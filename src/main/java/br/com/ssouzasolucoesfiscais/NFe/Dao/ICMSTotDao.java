package br.com.ssouzasolucoesfiscais.NFe.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import br.com.ssouzasolucoesfiscais.NFe.Bean.ICMSTot;
import br.com.ssouzasolucoesfiscais.NFe.Jdbc.ConnectionFactory;

public class ICMSTotDao {

	private Connection conexao;
	
	public ICMSTotDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(ICMSTot icmsTot, long id_Arquivo) {
		String storedProcedure = "SPnfe_IN_TNFe_total_ICMSTot";
		
		CallableStatement cstmt = null;
		try {
			
	        cstmt = conexao.prepareCall("{call " + storedProcedure + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");	
	        
	        cstmt.setLong("Id_Arquivo", id_Arquivo);
	        cstmt.setFloat("vBC", icmsTot.getvBC());
	        cstmt.setFloat("vICMS", icmsTot.getvICMS());
	        cstmt.setFloat("vICMSDeson", icmsTot.getvICMSDeson());
	        cstmt.setFloat("vFCPUFDest", icmsTot.getvFCPUFDest());
	        cstmt.setFloat("vICMSUFDest", icmsTot.getvICMSUFDest());
	        cstmt.setFloat("vICMSUFRemet", icmsTot.getvICMSUFRemet());
	        cstmt.setFloat("vFCP", icmsTot.getvFCP());
	        cstmt.setFloat("vBCST", icmsTot.getvBCST());
	        cstmt.setFloat("vST", icmsTot.getvST());
	        cstmt.setFloat("vFCPST", icmsTot.getvFCPST());
	        cstmt.setFloat("vFCPSTRet", icmsTot.getvFCPSTRet());
	        cstmt.setFloat("vProd", icmsTot.getvProd());
	        cstmt.setFloat("vFrete", icmsTot.getvFrete());
	        cstmt.setFloat("vSeg", icmsTot.getvSeg());
	        cstmt.setFloat("vDesc", icmsTot.getvDesc());
	        cstmt.setFloat("vII", icmsTot.getvBC());
	        cstmt.setFloat("vIPI", icmsTot.getvII());
	        cstmt.setFloat("vIPIDevol", icmsTot.getvIPIDevol());
	        cstmt.setFloat("vPIS", icmsTot.getvPIS());
	        cstmt.setFloat("vCOFINS", icmsTot.getvCOFINS());
	        cstmt.setFloat("vOutro", icmsTot.getvOutro());
	        cstmt.setFloat("vNF", icmsTot.getvNF());
	        cstmt.setFloat("vTotTrib", icmsTot.getvTotTrib());
	        
	        cstmt.execute();
	        
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
