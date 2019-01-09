package br.com.bb.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;

@Path(ProductRest.PATH)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/product", produces = MediaType.APPLICATION_JSON)
public interface ProductRest {

	public static final String PATH = "/product";
	
	@GET
	@Path("/listByCategory/{idCategory}")
	public Response listByCategory(@PathParam("idCategory") Integer idCategory);
}
