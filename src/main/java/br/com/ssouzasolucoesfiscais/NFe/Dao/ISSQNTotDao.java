package br.com.ssouzasolucoesfiscais.NFe.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import br.com.ssouzasolucoesfiscais.NFe.Bean.ISSQNTot;
import br.com.ssouzasolucoesfiscais.NFe.Jdbc.ConnectionFactory;

public class ISSQNTotDao {

	private Connection conexao;
	
	public ISSQNTotDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(ISSQNTot issqnTot, long id_Arquivo) {
		String storedProcedure = "SPnfe_IN_TNFe_total_ISSQNTot";
		
		CallableStatement cstmt = null;
		try {
			
	        cstmt = conexao.prepareCall("{call " + storedProcedure + "(?,?,?,?,?,?,?,?,?,?,?,?,?) }");	
	        
	        cstmt.setLong("Id_Arquivo", id_Arquivo);
	        cstmt.setFloat("vServ", issqnTot.getvServ());
	        cstmt.setFloat("vBC", issqnTot.getvBC());
	        cstmt.setFloat("vISS", issqnTot.getvISS());
	        cstmt.setFloat("vPIS", issqnTot.getvPIS());
	        cstmt.setFloat("vCOFINS", issqnTot.getvCOFINS());
	        cstmt.setString("dCompet", issqnTot.getdCompet());
	        cstmt.setFloat("vDeducao", issqnTot.getvDeducao());
	        cstmt.setFloat("vOutro", issqnTot.getvOutro());
	        cstmt.setFloat("vDescIncond", issqnTot.getvDescIncond());
	        cstmt.setFloat("vDescCond", issqnTot.getvDescCond());
	        cstmt.setFloat("vISSRet", issqnTot.getvISSRet());
	        cstmt.setInt("cRegTrib", issqnTot.getcRegTrib());
	        
	        cstmt.execute();
	        
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
