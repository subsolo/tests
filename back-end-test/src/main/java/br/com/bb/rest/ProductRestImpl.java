package br.com.bb.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import br.com.bb.entidades.dao.ProductDao;
public class ProductRestImpl implements ProductRest {

	@Inject 
	ProductDao productDao;
	
	@Override
	public Response listByCategory(Integer idCategory) {
		if (idCategory == null)
			throw new Error("Campo idCategory não foi informado.");
		List<ProductApi> products = new ArrayList<ProductApi>(0);
		
		try {
			products = productDao.listByCategory(idCategory);
		} catch (Exception e) {
			throw new Error("Erro ao consultar produtos por categoria. Erro:" + e.getMessage());
		}
		return Response.ok().entity(products).build(); 	
	}

}
