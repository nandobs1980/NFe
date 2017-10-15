package br.com.ssouzasolucoesfiscais.NFe.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import br.com.ssouzasolucoesfiscais.NFe.Bean.Local;
import br.com.ssouzasolucoesfiscais.NFe.Jdbc.ConnectionFactory;

public class LocalDao {
	
	private Connection conexao;
	
	public LocalDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Local local, long id_Arquivo) {
		String storedProcedure = "SPnfe_IN_TNFe_infNFe_local";
		
		CallableStatement cstmt = null;
		try {
			
	        cstmt = conexao.prepareCall("{call " + storedProcedure + "(?,?,?,?,?,?,?,?,?,?) }");	
	        
	        cstmt.setLong("Id_Arquivo", id_Arquivo);
	        cstmt.setString("Tp_Local", String.valueOf(local.getTp_Local()));
	        cstmt.setInt("Id_Doc", local.getId_Doc());
	        cstmt.setString("xLgr", local.getxLgr());
	        cstmt.setString("nro", local.getNro());
	        cstmt.setString("xCpl", local.getxCpl());
	        cstmt.setString("xBairro", local.getxBairro());
	        cstmt.setInt("cMun", local.getcMun());
	        cstmt.setString("xMun", local.getxMun());
	        cstmt.setString("UF", local.getUF());
	        
	        cstmt.execute();
	        
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
