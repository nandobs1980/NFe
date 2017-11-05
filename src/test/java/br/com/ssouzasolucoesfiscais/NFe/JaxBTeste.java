package br.com.ssouzasolucoesfiscais.NFe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import br.inf.portalfiscal.nfe.TNfeProc;

public class JaxBTeste {

	public static void main(String[] args) {


		try {

			String arqXML = "33160713594751000559550050000102481002799197-nfe.xml";

			//String arqXML = "NFe_Exemplo1.xml";
			String path = "/Users/fernandosouza/Documents/workspace/NFe/src/test/samples/";
			//String xml = lerXML("P:/lixo/26130124073694000155550000004830991853608354-nfe.xml");  


			TNfeProc wNfe = getNFe(path + arqXML);  
			if (wNfe != null) {
				info("| Destinatario[CNPJ]........: " + wNfe.getNFe().getInfNFe().getDest().getCNPJ());    
				info("| Destinatario[Nome]........: " + wNfe.getNFe().getInfNFe().getDest().getXNome());  
				info("| Emitente[CNPJ]............: " + wNfe.getNFe().getInfNFe().getEmit().getCNPJ());    
				info("| Emitente[Nome]............: " + wNfe.getNFe().getInfNFe().getEmit().getXNome());  

				System.out.println(wNfe.getNFe().getInfNFe().getDet().size());  
				for(int i=0; i < wNfe.getNFe().getInfNFe().getDet().size(); i++){
					info("| Item[Nome]............: " + wNfe.getNFe().getInfNFe().getDet().get(i).getProd().getXProd());      
				}  

			}  

		} catch (Exception e) {
			error(e.toString());    
		}    
	}    


	public static TNfeProc getNFe(String xml) throws Exception{        
		try {        
			JAXBContext context = JAXBContext.newInstance(TNfeProc.class);        
			Unmarshaller unmarshaller = context.createUnmarshaller(); 
			System.out.println("Antes do unMarshall");
			//TNfeProc nfe = unmarshaller.unmarshal(new StreamSource(new StringReader(xml)), TNfeProc.class).getValue();
			TNfeProc nfe = unmarshaller.unmarshal(new StreamSource(new StringReader(lerXML(xml))), TNfeProc.class).getValue();
			System.out.println("Depois do unMarshall");
			return nfe;  
		} catch (JAXBException ex) {        
			throw new Exception(ex.toString());        
		}        
	}        

	private static String lerXML(String fileXML) throws IOException {    
		String linha = "";    
		StringBuilder xml = new StringBuilder();    

		BufferedReader in = new BufferedReader(new InputStreamReader(    
				new FileInputStream(fileXML)));    
		while ((linha = in.readLine()) != null) {    
			xml.append(linha);    
		}    
		in.close();    

		return xml.toString();    
	}    



	private static void info(String log) {    
		System.out.println("INFO: " + log);    
	}    

	private static void error(String log) {    
		System.out.println("ERROR: " + log);    
	}    
}
