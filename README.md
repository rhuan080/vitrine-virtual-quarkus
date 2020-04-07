# vitrine-virtual project

Este é um exemplo de um simples serviço feito utilizando quarkus. Este serviço se comunica com um banco de dados postgres
e contém o seguinte modelo de dados:

    Departamento (id, nome, descricao)
    Produto(id, titulo, detalhe, preco, foto1, foto2)

Por default ele espera um postgres no `localhost:5432`, como o usuário `postgres` e senha `postgres`. O nome do banco utilizado 
é `vitrineDB`. Para levantar o banco via Docker o seguinte comando pode ser utilizado:

```
 docker run --name vitrine-virtual-db -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=vitrineDB -p 5432:5432 -d postgres
``` 

## Rodando a aplicação em modo dev

Para rodar em modo dev execute o comando abaixo dentro da parta raiz do projeto:
```
./mvnw quarkus:dev
```

## Empacotando e rodando a aplicaçãão

Execute este comando para empacotar:
 
 ```
 ./mvnw package
 ```
Então execute o .jar:

 ```
 java -jar target/vitrine-virtual-1.0.0-SNAPSHOT-runner.jar
 
 ```

## Criando um executável nativo

You can create a native executable using: 

```
 ./mvnw package -Pnative -Dquarkus.native.container-build=true
 ```
Então execute o nativo:

 ```
 ./target/vitrine-virtual-1.0.0-SNAPSHOT-runner
 
 ```

