package br.com.ssouzasolucoesfiscais.NFe.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import br.com.ssouzasolucoesfiscais.NFe.Bean.Emit;
import br.com.ssouzasolucoesfiscais.NFe.Jdbc.ConnectionFactory;

public class EmitDao {

	private Connection conexao;
	
	public EmitDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Emit emit, long id_Arquivo) {
		String storedProcedure = "SPnfe_IN_TNFe_infNFe_emit";
		
		CallableStatement cstmt = null;
		try {
			
	        cstmt = conexao.prepareCall("{call " + storedProcedure + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");	
	        
	        cstmt.setLong("Id_Arquivo", id_Arquivo);
	        cstmt.setString("Id_Doc", emit.getId_Doc());
	        cstmt.setString("xNome", emit.getxNome());
	        cstmt.setString("xFant", emit.getxNome());
	        cstmt.setString("xLgr", emit.getxLgr());
	        cstmt.setString("nro", emit.getNro());
	        cstmt.setString("xCpl", emit.getxCpl());
	        cstmt.setString("xBairro", emit.getxBairro());
	        cstmt.setInt("cMun", emit.getcMun());
	        cstmt.setString("xMun", emit.getxMun());
	        cstmt.setString("UF", emit.getUF());
	        cstmt.setInt("CEP", emit.getCEP());
	        cstmt.setInt("cPais", emit.getcPais());
	        cstmt.setString("xPais", emit.getxPais());
	        cstmt.setString("fone", emit.getFone());
	        cstmt.setInt("IE", emit.getIe());
	        cstmt.setInt("IEST", emit.getIest());
	        cstmt.setInt("IM", emit.getIm());
	        cstmt.setInt("CNAE", emit.getCnae());
	        cstmt.setInt("CRT", emit.getCrt());
	        
	        cstmt.execute();
	        
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
