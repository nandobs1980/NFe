package br.com.ssouzasolucoesfiscais.util;

import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class XMLUtil {

    protected static class Handler implements ErrorHandler {

        /**
         * Report a non-fatal error
         * @param ex the error condition
         */
        public void error(SAXParseException ex) {
            System.err.println("Error:At line " + ex.getLineNumber() + " of " + ex.getSystemId() + ':');
            System.err.println(ex.getMessage());
        }

        /**
         * Report a fatal error
         * @param ex the error condition
         */

        public void fatalError(SAXParseException ex) {
            System.err.println("fatalError:At line " + ex.getLineNumber() + " of " + ex.getSystemId() + ':');
            System.err.println(ex.getMessage());
        }

        /**
         * Report a warning
         * @param ex the warning condition
         */
        public void warning(org.xml.sax.SAXParseException ex) {
            System.err.println("warning:At line " + ex.getLineNumber() + " of " + ex.getSystemId() + ':');
            System.err.println(ex.getMessage());
        }

    }

    /**
     * Inner class to implement a resource resolver. This version always returns null, which
     * has the same effect as not supplying a resource resolver at all. The LSResourceResolver
     * is part of the DOM Level 3 load/save module.
     */
	public String lerXML(String fileXML) throws IOException {    
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
	
    protected static class Resolver implements LSResourceResolver{

        /**
         * Resolve a reference to a resource
         * @param type The type of resource, for example a schema, source XML document, or query
         * @param namespace The target namespace (in the case of a schema document)
         * @param publicId The public ID
         * @param systemId The system identifier (as written, possibly a relative URI)
         * @param baseURI The base URI against which the system identifier should be resolved
         * @return an LSInput object typically containing the character stream or byte stream identified
         * by the supplied parameters; or null if the reference cannot be resolved or if the resolver chooses
         * not to resolve it.
         */

        public LSInput resolveResource(String type, String namespace, String publicId, String systemId, String baseURI) {
            return null;
        }
    }

    /**
     * Main entry point. Expects two arguments: the schema document, and the source document.
     * @param args
     */
    public boolean Validar(String arqXML, String arqXSD) {
        try {


            Handler handler = new Handler();

            SchemaFactory schemaFactory;

            // Set a system property to force selection of the Saxon SchemaFactory implementation
            // This is commented out because it shouldn't be necessary if Saxon-SA is on the classpath;
            // but in the event of configuration problems, try reinstating it.

            System.setProperty("javax.xml.validation.SchemaFactory:http://www.w3.org/2001/XMLSchema",
                    "com.saxonica.jaxp.SchemaFactoryImpl");

            schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
//            schemaFactory = new com.saxonica.jaxp.SchemaFactoryImpl();
            System.err.println("Loaded schema validation provider " + schemaFactory.getClass().getName());

            schemaFactory.setErrorHandler(handler);

            // create a grammar object.
            Schema schemaGrammar;
            schemaGrammar = schemaFactory.newSchema(new File(arqXSD));
            System.err.println("Created Grammar object for schema : "+arqXSD);

            Resolver resolver = new Resolver();
            //create a validator to validate against grammar sch.
            Validator schemaValidator = schemaGrammar.newValidator();
            schemaValidator.setResourceResolver(resolver);
            schemaValidator.setErrorHandler(handler);

            System.err.println("Validating "+arqXML +" against grammar "+arqXSD);
            //validate xml instance against the grammar.
            schemaValidator.validate(new StreamSource(arqXML));

            System.err.println("Validado com sucesso.");
            return true;
        } catch (SAXException saxe) {
            exit(1, "Error: " + saxe.getMessage());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            exit(2, "Fatal Error: " + e);
            return false;
        }
    }

    /**
     *
     * @param errCode
     * @param msg
     */
 
    public static void exit(int errCode, String msg) {
        System.err.println(msg);
        System.exit(errCode);
    }

    public static void printUsage(){
        System.err.println("Usage : SchemaValidatorExample <schemaFile> <xmlFile>");
    }
}