package net.rhuanrocha.vitrinevirtual.departamentos;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class Departamento extends PanacheEntity {

    @NotEmpty(message = "Nome é obrigatório")
    public String nome;

    @NotEmpty(message = "Descrição é obrigatória")
    public String descricao;

}
