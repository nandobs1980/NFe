package br.com.ssouzasolucoesfiscais.NFe;

import java.io.IOException;
import java.util.List;

import br.com.ssouzasolucoesfiscais.dao.Dao;
import br.com.ssouzasolucoesfiscais.model.Arquivo;


public class HibernateTestArquivo {

	public static void main(String[] args) throws IOException {
		
		String arqXML = "NFe_Exemplo1.xml";
		String path = "/Users/fernandosouza/eclipse-workspace/SSouza/src/br/com/ssouzasolucoesfiscais/Samples/";
		byte id_Empresa = 1;
		Dao<Arquivo> arquivoDao = new Dao<Arquivo>();
				
		System.out.println("Ïnicio...");
		
		Arquivo testeArq = new Arquivo(id_Empresa, path, arqXML);
		Class<Arquivo> arquivo = Arquivo.class;
    		//testeArq.setId(3L);
        	
    		
    		arquivoDao.adicionarOuAtualizar(testeArq); 
        	
    		List<Arquivo> arquivos = arquivoDao.listarTodos(arquivo);
    		
    		System.out.println("Registros: " + arquivos.size());
    		System.out.println("Fim..");
        	
	}

}
