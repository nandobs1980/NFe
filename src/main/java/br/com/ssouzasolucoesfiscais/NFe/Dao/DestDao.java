package br.com.ssouzasolucoesfiscais.NFe.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import br.com.ssouzasolucoesfiscais.NFe.Bean.Dest;
import br.com.ssouzasolucoesfiscais.NFe.Jdbc.ConnectionFactory;

public class DestDao {

	private Connection conexao;
	
	public DestDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Dest dest, long id_Arquivo) {
		String storedProcedure = "SPnfe_IN_TNFe_dest";
		
		CallableStatement cstmt = null;
		try {
			
	        cstmt = conexao.prepareCall("{call " + storedProcedure + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");	
	        
	        cstmt.setLong("Id_Arquivo", id_Arquivo);
	        cstmt.setString("Id_Doc", dest.getId_Doc());
	        cstmt.setString("xNome", dest.getxNome());
	        cstmt.setString("xLgr", dest.getxLgr());
	        cstmt.setString("nro", dest.getNro());
	        cstmt.setString("xCpl", dest.getxCpl());
	        cstmt.setString("xBairro", dest.getxBairro());
	        cstmt.setInt("cMun", dest.getcMun());
	        cstmt.setString("xMun", dest.getxMun());
	        cstmt.setString("UF", dest.getUF());
	        cstmt.setInt("CEP", dest.getCEP());
	        cstmt.setInt("cPais", dest.getcPais());
	        cstmt.setString("xPais", dest.getxPais());
	        cstmt.setFloat("fone", dest.getFone());
	        cstmt.setInt("indIEDest", dest.getIndIEDest());
	        cstmt.setString("IE", dest.getIE());
	        cstmt.setString("ISUF", dest.getISUF());
	        cstmt.setString("IM", dest.getIM());
	        cstmt.setString("email", dest.getEmail());
	        
	        cstmt.execute();
	        
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
