package br.com.ssouzasolucoesfiscais.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T,Type extends Serializable> {
	void adicionar(T entity);
	void apagar (T entity);
	void atualizar (T entity);
	List<T> listarTodos();
}
