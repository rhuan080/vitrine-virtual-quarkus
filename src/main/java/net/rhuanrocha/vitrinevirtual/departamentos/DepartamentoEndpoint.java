package net.rhuanrocha.vitrinevirtual.departamentos;

import net.rhuanrocha.vitrinevirtual.produtos.Produto;

import javax.print.attribute.standard.Media;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("departamentos")
@Transactional
public class DepartamentoEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodos(){

        return Response.ok(Departamento.listAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(Departamento departamento){
        departamento.id = null;
        departamento.persist();

        return Response
                .created(URI.create(String.format("/departamentos/%d", departamento.id)))
                .build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id){

        return Response.ok(Departamento.findById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/produtos")
    public Response listarProdutos(@PathParam("id") Long id){

        return Response.ok(Produto.listarPorDepartamento(id)).build();
    }


}
