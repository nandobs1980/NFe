package br.com.ssouzasolucoesfiscais.NFe.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import br.com.ssouzasolucoesfiscais.NFe.Bean.ISSQN;
import br.com.ssouzasolucoesfiscais.NFe.Jdbc.ConnectionFactory;

public class ISSQNDao {

	private Connection conexao;
	
	public ISSQNDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(ISSQN issqn, long id_Arquivo) {
		String storedProcedure = "SPnfe_IN_TNFe_infNFe_det_imposto_ISSQN";
		
		CallableStatement cstmt = null;
		try {
			
	        cstmt = conexao.prepareCall("{call " + storedProcedure + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");	
	        
	        cstmt.setLong("Id_Arquivo", id_Arquivo);
	        cstmt.setInt("nItem", issqn.getnItem());
	        cstmt.setFloat("vBC", issqn.getvBC());
	        cstmt.setFloat("vAliq", issqn.getvAliq());
	        cstmt.setFloat("vISSQN", issqn.getvISSQN());
	        cstmt.setInt("cMunFG", issqn.getcMunFG());
	        cstmt.setFloat("cListServ", issqn.getcListServ());
	        cstmt.setFloat("vDeducao", issqn.getvDeducao());
	        cstmt.setFloat("vOutro", issqn.getvOutro());
	        cstmt.setFloat("vDescIncond", issqn.getvDescIncond());
	        cstmt.setFloat("vDescCond", issqn.getvDescCond());
	        cstmt.setFloat("vISSRet", issqn.getvISSRet());
	        cstmt.setInt("indISS", issqn.getIndISS());
	        cstmt.setString("cServico", issqn.getcServico());
	        cstmt.setInt("cMun", issqn.getcMun());
	        cstmt.setInt("cPais", issqn.getcPais());
	        cstmt.setString("nProcesso", issqn.getnProcesso());
	        cstmt.setFloat("indIncentivo", issqn.getIndIncentivo());
	        
	        cstmt.execute();
	        
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
