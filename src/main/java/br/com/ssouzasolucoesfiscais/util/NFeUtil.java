package br.com.ssouzasolucoesfiscais.util;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import br.inf.portalfiscal.nfe.TNfeProc;

public class NFeUtil {

	
	public TNfeProc getNFe(String xml) throws Exception{       
		XMLUtil xmlutil = new XMLUtil();
		try {        
			JAXBContext context = JAXBContext.newInstance(TNfeProc.class);        
			Unmarshaller unmarshaller = context.createUnmarshaller(); 
			System.out.println("Antes do unMarshall");
			//TNfeProc nfe = unmarshaller.unmarshal(new StreamSource(new StringReader(xml)), TNfeProc.class).getValue();
			TNfeProc nfe = unmarshaller.unmarshal(new StreamSource(new StringReader(xmlutil.lerXML(xml))), TNfeProc.class).getValue();
			System.out.println("Depois do unMarshall");
			return nfe;  
		} catch (JAXBException ex) {        
			throw new Exception(ex.toString());        
		}        
	}
}
