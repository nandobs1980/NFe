package br.com.ssouzasolucoesfiscais.NFe.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import br.com.ssouzasolucoesfiscais.NFe.Bean.Avulsa;
import br.com.ssouzasolucoesfiscais.NFe.Jdbc.ConnectionFactory;

public class AvulsaDao {
	
	private Connection conexao;
	
	public AvulsaDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Avulsa avlsa, long id_Arquivo) {
		String storedProcedure = "SPnfe_IN_TNFe_infNFe_avulsa";
		
		CallableStatement cstmt = null;
		try {
			
	        cstmt = conexao.prepareCall("{call " + storedProcedure + "(?,?,?,?,?,?,?,?,?,?,?,?) }");	
	        
	        cstmt.setLong("Id_Arquivo", id_Arquivo);
	        cstmt.setString("CNPJ", avlsa.getCNPJ());
	        cstmt.setString("xOrgao", avlsa.getxOrgao());
	        cstmt.setString("matr", avlsa.getMatr());
	        cstmt.setString("xAgente", avlsa.getxAgente());
	        cstmt.setString("fone", avlsa.getFone());
	        cstmt.setString("UF", avlsa.getUF());
	        cstmt.setString("nDAR", avlsa.getnDAR());
	        cstmt.setString("dEmi", avlsa.getdEmi());
	        cstmt.setFloat("vDAR", avlsa.getvDAR());
	        cstmt.setString("repEmi", avlsa.getRepEmi());
	        cstmt.setString("dPag", avlsa.getdPag());
	        
	        cstmt.execute();
	        
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
