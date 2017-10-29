package br.com.ssouzasolucoesfiscais.NFe;

import org.hibernate.Session;

import br.com.ssouzasolucoesfiscais.util.HibernateUtil;

public class HibernateTestConnection {

	public static void main(String[] args) {
		Session sessao = null;
        try{
        sessao = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Conectou!");
       } finally { 
          sessao.close(); 
      }

	}

}
