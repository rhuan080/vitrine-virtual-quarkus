package net.rhuanrocha.vitrinevirtual.produtos;


import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/produtos")
@Transactional
public class ProdutoEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodos() {

        return Response.ok(Produto.listAll()).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvar(@Valid Produto produto ){

        produto.id = null;
        produto.persist();
        return Response
                .created(URI.create(String.format("/produtos/%d", produto.id)))
                .build();

    }

}
