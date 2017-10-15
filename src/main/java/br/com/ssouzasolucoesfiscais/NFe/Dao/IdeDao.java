package br.com.ssouzasolucoesfiscais.NFe.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import br.com.ssouzasolucoesfiscais.NFe.Bean.Ide;
import br.com.ssouzasolucoesfiscais.NFe.Jdbc.ConnectionFactory;

public class IdeDao {
	
	private Connection conexao;
	
	public IdeDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Ide ideNFe, long id_Arquivo) {
		String storedProcedure = "SPnfe_IN_TNFe_infNFe_ide";
		
		CallableStatement cstmt = null;
		try {
			
	        cstmt = conexao.prepareCall("{call " + storedProcedure + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");	
	        
	        cstmt.setLong("Id_Arquivo", id_Arquivo);
	        cstmt.setInt("Id_NFe", ideNFe.getcUF());
	        cstmt.setInt("cUF", ideNFe.getcUF());
	        cstmt.setString("cNF", ideNFe.getcNF());
	        cstmt.setString("natOp", ideNFe.getNatOp());
	        cstmt.setInt("mod", ideNFe.getMod());
	        cstmt.setString("serie", ideNFe.getSerie());
	        cstmt.setInt("nNF", ideNFe.getnNF());
	        cstmt.setString("dhEmi", ideNFe.getDhEmi());
	        cstmt.setString("dhSaiEnt", ideNFe.getDhSaiEnt());
	        cstmt.setInt("tpNF", ideNFe.getTpNF());
	        cstmt.setInt("idDest", ideNFe.getIdDest());
	        cstmt.setInt("cMunFG", ideNFe.getcMunFG());
	        cstmt.setInt("tpImp", ideNFe.getTpImp());
	        cstmt.setInt("tpEmis", ideNFe.getTpEmis());
	        cstmt.setInt("cDV", ideNFe.getcDV());
	        cstmt.setInt("tpAmb", ideNFe.getTpAmb());
	        cstmt.setInt("finNFe", ideNFe.getFinNFe());
	        cstmt.setInt("indFinal", ideNFe.getIndFinal());
	        cstmt.setInt("indPres", ideNFe.getIndPres());
	        cstmt.setInt("procEmi", ideNFe.getProcEmi());
	        cstmt.setString("verProc", ideNFe.getVerProc());
	        cstmt.setString("dhCont", ideNFe.getDhCont());
	        cstmt.setString("xJust", ideNFe.getxJust());
	        
	        cstmt.execute();
	        
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
