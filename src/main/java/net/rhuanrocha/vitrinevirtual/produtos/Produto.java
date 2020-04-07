package net.rhuanrocha.vitrinevirtual.produtos;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Parameters;
import net.rhuanrocha.vitrinevirtual.departamentos.Departamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Produto extends PanacheEntity {

    @NotEmpty(message = "Títuto é obrigatório")
    public String titulo;

    @NotEmpty(message = "Detalhe é obrigatório")
    public String detalhe;

    @NotNull(message = "Preco é obrigatório")
    @Column( scale = 2)
    public BigDecimal preco;

    public String foto1;

    public String foto2;

    @ManyToOne
    @NotNull(message = "Departamento é obrigatório")
    public Departamento departamento;

    public static List<Produto> listarPorDepartamento(Long idDepartamento){

        return Produto.list("departamento.id=:id", Parameters.with("id", idDepartamento));
    }


}
