package br.com.ssouzasolucoesfiscais.NFe.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import br.com.ssouzasolucoesfiscais.NFe.Bean.ICMS;
import br.com.ssouzasolucoesfiscais.NFe.Jdbc.ConnectionFactory;

public class ICMSDao {

	private Connection conexao;
	
	public ICMSDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(ICMS icms, long id_Arquivo) {
		String storedProcedure = "SPnfe_IN_TNFe_infNFe_det_imposto_ICMS";
		
		CallableStatement cstmt = null;
		try {
			
	        cstmt = conexao.prepareCall("{call " + storedProcedure + "(?,?,?,?,?,?,?,?,?,?,?) }");	
	        
	        cstmt.setLong("Id_Arquivo", id_Arquivo);
	        cstmt.setInt("nItem", icms.getnItem());
	        cstmt.setString("Tp_ICMS", icms.getTp_ICMS());
	        cstmt.setInt("orig", icms.getOrig());
	        cstmt.setString("CST", icms.getCST());
	        cstmt.setInt("modBC", icms.getModBC());
	        cstmt.setFloat("vBC", icms.getvBC());
	        cstmt.setFloat("pICMS", icms.getpICMS());
	        cstmt.setFloat("vICMS", icms.getvICMS());
	        cstmt.setFloat("pFCP", icms.getpFCP());
	        cstmt.setFloat("vFCP", icms.getvFCP());
	        
	        cstmt.execute();
	        
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
