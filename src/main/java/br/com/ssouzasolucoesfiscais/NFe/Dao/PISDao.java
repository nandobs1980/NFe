package br.com.ssouzasolucoesfiscais.NFe.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import br.com.ssouzasolucoesfiscais.NFe.Bean.PIS;
import br.com.ssouzasolucoesfiscais.NFe.Jdbc.ConnectionFactory;

public class PISDao {

	private Connection conexao;
	
	public PISDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(PIS pis, long id_Arquivo) {
		String storedProcedure = "SPnfe_IN_TNFe_infNFe_det_imposto_PIS";
		
		CallableStatement cstmt = null;
		try {
			
	        cstmt = conexao.prepareCall("{call " + storedProcedure + "(?,?,?,?,?,?,?,?) }");	
	        
	        cstmt.setLong("Id_Arquivo", id_Arquivo);
	        cstmt.setString("Tp_PIS", pis.getTp_PIS());
	        cstmt.setString("CST", pis.getCST());
	        cstmt.setFloat("vBC", pis.getvBC());
	        cstmt.setFloat("pPIS", pis.getvPIS());
	        cstmt.setFloat("vPIS", pis.getvPIS());
	        cstmt.setFloat("qBCProd", pis.getqBCProd());
	        cstmt.setFloat("vAliqProd", pis.getvAliqProd());
	        
	        cstmt.execute();
	        
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
