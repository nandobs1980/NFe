package br.com.ssouzasolucoesfiscais.NFe.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import br.com.ssouzasolucoesfiscais.NFe.Bean.IPI;
import br.com.ssouzasolucoesfiscais.NFe.Jdbc.ConnectionFactory;

public class IPIDao {

	private Connection conexao;
	
	public IPIDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(IPI ipi, long id_Arquivo) {
		String storedProcedure = "SPnfe_IN_TNFe_infNFe_det_imposto_IPI";
		
		CallableStatement cstmt = null;
		try {
			
	        cstmt = conexao.prepareCall("{call " + storedProcedure + "(?,?,?,?,?,?,?,?,?,?,?,?,?) }");	
	        
	        cstmt.setLong("Id_Arquivo", id_Arquivo);
	        cstmt.setInt("nItem", ipi.getnItem());
	        cstmt.setString("clEnq", ipi.getClEnq());
	        cstmt.setInt("CNPJProd", ipi.getCNPJProd());
	        cstmt.setString("cSelo", ipi.getcSelo());
	        cstmt.setInt("qSelo", ipi.getqSelo());
	        cstmt.setString("cEnq", ipi.getcEnq());
	        cstmt.setString("CST", ipi.getCST());
	        cstmt.setFloat("vBC", ipi.getvBC());
	        cstmt.setFloat("pIPI", ipi.getpIPI());
	        cstmt.setFloat("qUnid", ipi.getqUnid());
	        cstmt.setFloat("vUnid", ipi.getvUnid());
	        cstmt.setFloat("vIPI", ipi.getvIPI());
	        
	        cstmt.execute();
	        
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
