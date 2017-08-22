package com.atsistemas.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.atsistemas.beans.Book;
import com.atsistemas.dao.BookDAO;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Path("/book")
@Produces("application/json;charset=utf-8")
@Api(value = "book", description = "Book service")
public class BookResource {
	
	private BookDAO bookDAO;

	public BookResource() {
		super();
		this.bookDAO = new BookDAO();
	}
	
    @GET
    @ApiOperation("list book objects")
    public Response list() {
        return Response.ok(this.bookDAO.list()).build();
    }

    @GET
    @Path("/{id}")
    @ApiOperation("get book object")
    public Response get(@PathParam("id") Long id) {
        Book bean = this.bookDAO.get(id);
        if (bean == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(bean).build();
    }

    @POST
    @Consumes("application/json;charset=utf-8")
    @ApiOperation("save book object")
    public Response save(Book bean) {
        this.bookDAO.save(bean);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation("delete book object")
    public Response delete(@PathParam("id") Long id) {
    	Book bean = this.bookDAO.get(id);
        if (bean == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        this.bookDAO.delete(bean);
        return Response.ok().build();
    }

}
