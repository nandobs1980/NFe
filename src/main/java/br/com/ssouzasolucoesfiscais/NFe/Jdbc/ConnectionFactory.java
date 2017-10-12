package br.com.ssouzasolucoesfiscais.NFe.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
	         String userName = "nandobs";
	         String password = "B3ll3p0qu3#1";
	         String url = "jdbc:sqlserver://ssouza.cnghcmxcq3nb.sa-east-1.rds.amazonaws.com:1433;databaseName=nfe";
	         //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         System.out.println("Abrindo conexão com DB Amazon..." + url);
	         return DriverManager.getConnection(url, userName, password);
	         
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
}
