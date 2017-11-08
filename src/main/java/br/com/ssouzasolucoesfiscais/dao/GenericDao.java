package br.com.ssouzasolucoesfiscais.dao;


import java.util.List;

public interface GenericDao<T,Type> {
	void adicionar(T entity);
	void apagar (T entity);
	void atualizar (T entity);
	List<T> listarTodos();
}
