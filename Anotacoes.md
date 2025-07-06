1. Configuração do Ambiente

2. Inicialização do Projeto com Spring Initializr:
---
Project: Maven
Language: Java
Spring Boot: 3.x (versão mais recente)
Group: com.livraria
Artifact: livraria-api
Dependencies:
Spring Web: Para criar APIs REST.
Spring Data JPA: Para interagir com o banco via Hibernate.
Spring Security: Para autenticação e autorização.
PostgreSQL Driver: Para conectar ao banco.
Springdoc OpenAPI: Para gerar documentação Swagger.
Spring Boot Starter Test: Para testes com JUnit.

3. Configuração do Banco de Dados
**src/main/resources/application.properties** -> configure a conexão com o PostgreSQL:

spring.datasource.url: Define a URL de conexão ao banco PostgreSQL.
spring.datasource.username e password: Credenciais do banco.
spring.jpa.hibernate.ddl-auto=update: Cria/atualiza tabelas automaticamente com base nas entidades JPA.
spring.jpa.show-sql=true: Mostra os comandos SQL no console para depuração.
spring.jpa.properties.hibernate.dialect: Especifica o dialeto do PostgreSQL para o Hibernate.

4. Estrutura do Projeto
Organizaremos o projeto em pacotes para manter o código modular:

com.livraria.livraria-api: Pacote raiz.
config: Configurações (ex.: Spring Security, Swagger).
controller: Endpoints REST.
entity: Modelos JPA (entidades).
repository: Interfaces JPA para acesso ao banco.
service: Lógica de negócio.
dto: Objetos de transferência de dados.
security: Configurações de autenticação JWT.

5. Modelos (Entidades JPA)
Criaremos as entidades para Usuario, Livro e Venda.

Entidade Usuario:
@Entity e @Table: Marca a classe como uma entidade JPA mapeada para a tabela usuarios.
@Id e @GeneratedValue: Define a chave primária com auto-incremento.
@Column(nullable = false, unique = true): Garante que username seja único e não nulo.
UserDetails: Implementa a interface do Spring Security para autenticação.
@Data (Lombok): Gera getters, setters, toString, etc., automaticamente.

Entidade Livro:
Campos como titulo, autor, localEstoque, quantidadeEstoque e dataEntradaEstoque atendem aos requisitos do CRUD de livros.
LocalDate é usado para armazenar a data de entrada no estoque.

Entidade Venda:
@ManyToOne: Relaciona a venda a um livro específico.
quantidadeVendida e dataVenda: Armazenam informações para o endpoint /progresso.

6. Configuração de Segurança com JWT
Configurar o Spring Security com JWT para proteger os endpoints e gerenciar autenticação.
Dependência adicional no pom.xml.

Configuração de Segurança:
@EnableWebSecurity: Ativa a configuração de segurança.
csrf.disable(): Desativa CSRF, já que usamos JWT.
requestMatchers: Libera endpoints de cadastro, login e Swagger sem autenticação.
addFilterBefore: Adiciona um filtro JWT antes do filtro padrão de autenticação.

Filtro JWT:
OncePerRequestFilter: Garante que o filtro seja executado uma vez por requisição.
Extrai o token JWT do cabeçalho Authorization e valida com a chave secreta.
Se válido, autentica o usuário no contexto de segurança.

7. Endpoints da API: Criaremos os controllers para os endpoints solicitados.

Controller de Usuários:
/cadastro: Cria um novo usuário com senha criptografada (BCrypt).
/login: Verifica as credenciais e retorna um token JWT se válidas.
UsuarioDTO: Um objeto para transferir dados de entrada (username, password, email).

Controller de Livros:
Implementa o CRUD completo para livros.
@PostMapping, @GetMapping, etc.: Mapeiam os métodos HTTP para cada operação.
LivroService: Contém a lógica de negócio (não mostrado aqui por brevidade, mas inclui chamadas ao repositório JPA).

Controller de Progresso:
/vendas: Lista o histórico de vendas.
/quantidade-vendida: Retorna a soma total de livros vendidos.
VendaService: Contém a lógica para consultas ao banco.

8. Documentação com Swagger
O Springdoc OpenAPI já está incluído. Para acessar a documentação:

Execute o projeto (mvn spring-boot:run).
Acesse http://localhost:8080/swagger-ui.html.

9. Testes com JUnit
@SpringBootTest: Carrega o contexto do Spring para testes.
@MockBean: Simula o repositório para evitar chamadas reais ao banco.
assertNotNull: Verifica se o usuário foi cadastrado com sucesso.

10. Testes com Postman
Crie uma coleção no Postman:

POST /usuarios/cadastro:
Body: { "username": "teste", "password": "senha123", "email": "teste@email.com" }
POST /usuarios/login:
Body: { "username": "teste", "password": "senha123" }
Copie o token JWT retornado.
GET /livros:
Headers: Authorization: Bearer <token>
POST /livros:
Headers: Authorization: Bearer <token>
Body: { "titulo": "Livro Teste", "autor": "Autor Teste", "localEstoque": "Prateleira A", "quantidadeEstoque": 10, "dataEntradaEstoque": "2025-06-29" }


Como Executar o Projeto
Certifique-se de que o PostgreSQL está rodando e o banco livraria foi criado.
Execute mvn spring-boot:run na raiz do projeto.
Acesse http://localhost:8080/swagger-ui.html para ver a documentação.
Use o Postman para testar os endpoints.
Execute os testes JUnit na IDE ou com mvn test.




Iniciar o projeto.....

./mvnw spring-boot:run