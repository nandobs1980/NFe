package br.com.ssouzasolucoesfiscais.dao;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.ssouzasolucoesfiscais.model.ModeloBase;
import br.com.ssouzasolucoesfiscais.util.HibernateUtil;

public class Dao <T extends ModeloBase>{

	private Session session = HibernateUtil.getSessionFactory().openSession();
	 
	public T procurarPorId(Class<T> clazz, Long id){
		return this.session.find(clazz, id);
	}
	 
	public void adicionarOuAtualizar(T obj){
		
		this.session.beginTransaction();
		if(obj.getId() == null){
			this.session.save(obj);
		}else{
			this.session.update(obj);
		}
        this.session.getTransaction().commit();
	}
	
	public void apagar(T obj) {
		
		this.session.beginTransaction();
		this.session.remove(obj);
		this.session.getTransaction().commit();
	}
	
	
	public List<T> listarTodos(Class<T> clazz) {
		
		
		
		//Get Criteria Builder
        CriteriaBuilder builder = this.session.getCriteriaBuilder();
        
        //Create Criteria
        CriteriaQuery<T> query = builder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        query.select(root);
        Query<T> q = this.session.createQuery(query);
        List<T> list = q.getResultList();


        return list;
	}
}
