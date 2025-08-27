# Livraria API

API REST para gerenciamento de livros, autores, usuários e vendas em uma livraria.

## Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL
- MapStruct
- Lombok
- Maven

## Funcionalidades

- Cadastro, consulta e gerenciamento de livros
- Cadastro e consulta de autores
- Controle de usuários
- Registro de vendas
- Validação de dados via Bean Validation

## Estrutura do Projeto

```
src/
  main/
    java/com/livraria/livraria_api/
      controller/        # Controllers REST
      dto/               # Data Transfer Objects
      entity/            # Entidades JPA
      exception/         # Exceções customizadas
      mapper/            # MapStruct mappers
      repository/        # Repositórios JPA
      service/           # Regras de negócio
      config/            # Configurações de segurança
    resources/
      application.properties
      static/            # Arquivos estáticos (index.html, CSS)
  test/
    java/com/livraria/livraria_api/
      controllertest/    # Testes dos controllers
      service/           # Testes dos serviços
      utills/            # Utilitários para testes
```

## Como executar

1. Configure o banco de dados PostgreSQL conforme o arquivo: `src/main/resources/application.properties`.


2. Execute o comando:

```sh
mvn spring-boot:run
```

3. Acesse a API em: [http://localhost:8081/api/v1/livro](http://localhost:8081/api/v1/livro)

## Exemplos de uso
Para os testes via Postman ou outra ferramenta de API, utilize os seguintes exemplos:

### Cadastro de Livro
- Utilizar o endpoint `POST /api/v1/livro/cadastrar`;

```json
{
  "titulo": "Livro Exemplo",
  "local_estoque": "prateleira",
  "quantidade_estoque": 10,
  "autor": {
    "nome_autor": "Autor Exemplo",
    "idade_autor": 30
  }
}
```

### Buscar Livro
- Utilizar o endpoint `GET /api/v1/livro/{id}`;

``` PowerShell
http://localhost:8081/api/v1/livro/2
```

## Testes

Os testes estão localizados em: `src/test/java/com/livraria/livraria_api/`.`