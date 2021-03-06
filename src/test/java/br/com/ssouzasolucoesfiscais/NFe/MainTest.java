package br.com.ssouzasolucoesfiscais.NFe;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.com.ssouzasolucoesfiscais.util.AwsUtil;
import br.inf.portalfiscal.nfe.TNfeProc;

public class MainTest {

	public static void main(String[] args) throws JAXBException {
		
		String arqXML = "33160713594751000559550050000102481002799197-nfe.xml";
		String path = "/Users/fernandosouza/Documents/workspace/NFe/src/test/samples/";
		//int id_Empresa = 1;
		AwsUtil s3 = new AwsUtil();
		JAXBContext context = JAXBContext.newInstance("br.inf.portalfiscal.nfe");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		File arq = new File(path + arqXML);
		@SuppressWarnings("unchecked")
		JAXBElement<TNfeProc> element = (JAXBElement<TNfeProc>) unmarshaller.unmarshal(new File(path + arqXML));  
		TNfeProc nfe = element.getValue();
		
		System.out.println(nfe);
		
		s3.S3Upload(arq, "ssouza-dev", "nandobs");
		System.out.println("Fim");
	}
}