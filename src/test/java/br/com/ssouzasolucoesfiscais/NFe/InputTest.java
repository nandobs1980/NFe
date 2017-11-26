package br.com.ssouzasolucoesfiscais.NFe;

import java.io.File;
import java.util.Scanner;

import br.com.ssouzasolucoesfiscais.dao.Dao;
import br.com.ssouzasolucoesfiscais.model.Arquivo;
import br.com.ssouzasolucoesfiscais.util.AwsUtil;
import br.com.ssouzasolucoesfiscais.util.NFeUtil;
import br.com.ssouzasolucoesfiscais.util.XMLUtil;
import br.inf.portalfiscal.nfe.TNfeProc;


public class InputTest {
	
	private static String arqXML;
	private static Byte id_Empresa;
	
	public static void main(String[] args) throws Exception {
		
		String returnId;
		String arqXSD;
        arqXSD = "/Users/fernandosouza/Documents/workspace/NFe/src/main/xml/procNFe_v3.10.xsd";
        
		Scanner scanner = new Scanner( System.in );  
		
		System.out.println("Informe o código da empresa:");
		if ( scanner.hasNextLine() ) {  
			returnId = scanner.nextLine();
			if (returnId.isEmpty()) {
				id_Empresa = 0;
			} else {
				id_Empresa = Byte.valueOf(scanner.nextLine());
			}
		}
			
		System.out.println("Informe o arquivo e caminho completo:");
		if ( scanner.hasNextLine() ) {  
			arqXML = scanner.nextLine();
			if (arqXML.isEmpty()) {
				arqXML = "/Users/fernandosouza/Documents/workspace/NFe/src/test/samples/33160713594751000559550050000102481002799197-nfe.xml";
			}
		}
		scanner.close();
		
		XMLUtil xmlValidador = new XMLUtil();
		if (xmlValidador.Validar(arqXML, arqXSD)){
			System.out.println("Validações concluidas.");
		}
		
		System.out.println("Iniciando gravação da NFe...");
		NFeUtil nfe = new NFeUtil();
		Dao<TNfeProc> nfeDao = new Dao<TNfeProc>();
		
		System.out.println("Persistindo os dados em Objeto...");
		TNfeProc tNfe = nfe.getNFe(arqXML);
		
		System.out.println("Iniciando a gravação do arquivo...");
		Dao<Arquivo> arquivoDao = new Dao<Arquivo>();
		Arquivo Arq = new Arquivo(id_Empresa, arqXML, tNfe.getNFe().getInfNFe().getId());
		arquivoDao.adicionar(Arq); 
		System.out.println("Arquivo Gravado.");
		
		System.out.println("Persistindo em Banco de dados...");
		nfeDao.adicionar(tNfe);
		System.out.println("NFe gravado com sucesso.");
		
		System.out.println("Uploading file...");
		AwsUtil s3 = new AwsUtil();
		File arq = new File(arqXML);
		s3.S3Upload(arq, "ssouza-dev", "nandobs");
		System.out.println("Fim");
	}
	
}

