package br.com.bb.entidades.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.bb.entidades.dao.ProductDao;
import br.com.bb.rest.ProductApi;

public class ProductJpaDao implements ProductDao {

	@PersistenceContext(unitName = "persistence")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductApi> listByCategory(Integer idCategory) {
		String sql = "select product " + "from Product product " + "inner join product.category "
				+ "where category.id :idCategory ";

		Query query = getEntityManager().createQuery(sql);
		if (idCategory != null)
			query.setParameter("idCategory", idCategory);
		try {
			List<Object[]> resultList = query.getResultList();
			List<ProductApi> products = new ArrayList<ProductApi>(0);
			for (Object[] o : resultList) {
				ProductApi productApi = new ProductApi();
				productApi.setId((Integer) o[0]);
				productApi.setName((String) o[1]);
				
				products.add(productApi);
			}
			return products;
		} catch (NoResultException nda) {
            return new ArrayList<ProductApi>(0);
        }
	}

}
