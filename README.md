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
- JUnit & Mockito
- Docker

## Funcionalidades

- Cadastro, consulta e gerenciamento de livros
- Cadastro e consulta de autores
- Controle de usuários
- Registro de vendas
- Validação de dados via Bean Validation

## Estrutura do Projeto

``` Py
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
docker-compose.yml       # Arquivo de configuração do Docker Compose
Dockerfile               # Arquivo de configuração do Docker
mvnw                     # Script para execução do Maven Wrapper
mvnw.cmd                 # Script para execução do Maven Wrapper no Windows
pom.xml                  # Arquivo de configuração do Maven
README.md                # Documentação do projeto
system.properties        # Arquivo de configuração do sistema
```

## Como executar

1. Configure o banco de dados PostgreSQL conforme o arquivo: `src/main/resources/application.properties`.

#### Duas opções de execução do DB no arquivo `application.properties`:
- Configuração manual do banco de dados
  - Altere as propriedades de conexão do PostgreSQL conforme necessário.
- Utilização do Docker Compose
  - Execute `docker-compose up` para iniciar o banco de dados em um contêiner.

<br>

2. Execute o comando:

```sh
mvn spring-boot:run
```

3. Acesse a API em: [http://localhost:8080/api/v1/livro](http://localhost:8080/api/v1/livro)

<br>

## Exemplos de uso
Para os testes via Postman ou outra ferramenta de API, utilize os seguintes exemplos:

### Cadastro de Livro:
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

### Buscar Livro:
- Utilizar o endpoint `GET /api/v1/livro/{id}`;

``` URL
http://localhost:8081/api/v1/livro/2
```

### Testes:

Os testes estão localizados em: `src/test/java/com/livraria/livraria_api/`.`
