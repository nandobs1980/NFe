package br.com.ssouzasolucoesfiscais.NFe.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import br.com.ssouzasolucoesfiscais.NFe.Bean.COFINS;
import br.com.ssouzasolucoesfiscais.NFe.Jdbc.ConnectionFactory;

public class COFINSDao {
	
	private Connection conexao;
	
	public COFINSDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(COFINS cofins, long id_Arquivo) {
		String storedProcedure = "SPnfe_IN_TNFe_infNFe_det_imposto_COFINS";
		
		CallableStatement cstmt = null;
		try {
			
	        cstmt = conexao.prepareCall("{call " + storedProcedure + "(?,?,?,?,?,?,?,?) }");	
	        
	        cstmt.setLong("Id_Arquivo", id_Arquivo);
	        cstmt.setString("Tp_CONFINS", cofins.getTp_COFINS());
	        cstmt.setString("CST", cofins.getCST());
	        cstmt.setFloat("vBC", cofins.getvBC());
	        cstmt.setFloat("pCOFINS", cofins.getpCOFINS());
	        cstmt.setFloat("vCOFINS", cofins.getvCOFINS());
	        cstmt.setFloat("qBCProd", cofins.getqBCProd());
	        cstmt.setFloat("vAliqProd", cofins.getvAliqProd());
	        
	        cstmt.execute();
	        
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
