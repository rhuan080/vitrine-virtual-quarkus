package net.rhuanrocha.vitrinevirtual;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;
import java.util.stream.Collectors;

@Provider
public class ConstraintExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException constraintViolation) {

        List<String> mensagens = constraintViolation
                .getConstraintViolations()
                .stream()
                .map(constraint -> constraint.getMessage() )
                .collect(Collectors.toList());

        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(Mensagem.of(mensagens))
                .build();
    }

    public static class Mensagem{
        public List<String> mensagens;

        public static Mensagem of( List<String> mensagems){
            Mensagem mensagem = new Mensagem();
            mensagem.mensagens = mensagems;
            return mensagem;
        }
    }
}
