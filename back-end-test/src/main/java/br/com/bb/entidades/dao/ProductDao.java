package br.com.bb.entidades.dao;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.EntityManager;

import br.com.bb.rest.ProductApi;

@Local
public interface ProductDao {
	
	public List<ProductApi> listByCategory(Integer idCategory);

	EntityManager getEntityManager();

}
