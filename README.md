<h1 align="center">
  <img src="https://github.com/andersonleite1/AnimeApi/blob/master/src/img/API.png?raw=true" alt="AnimeLink Api" width="350px"/> 
</h1>

<h2 align="center">AnimeLink API - Em desenvolvimento 👨‍💻</h2>
<br>

Este projeto é uma API que esta sendo desenvolvida com Spring Boot para gerenciar informações sobre animes e usuários.

## Estrutura do Projeto

A estrutura do projeto segue a Arquitetura em Camadas, organizada da seguinte forma:

```
br.com.andersonleite.animelinkapi
├── config
│ └── SecurityConfig.java
├── configurer
│ └── AnimeLinkWebMvnConfigurer.java
├── controller
│ └── AnimeController.java
├── domain
│ ├── Anime.java
│ └── UserData.java
├── dto
│ ├── AnimePostRequestBody.java
│ └── AnimePutRequestBody.java
├── exception
│ ├── BadRequestException.java
│ ├── BadRequestExceptionDetails.java
│ ├── ExceptionDetails.java
│ └── ValidationExceptionDetails.java
├── handler
│ └── RestExceptionHandler.java
├── repository
│ ├── AnimeRepository.java
│ └── UserDataRepository.java
├── service
│ ├── AnimeService.java
│ └── UserDataService.java
├── wrapper
│ └── PageableResponse.java
└── AnimeLinkApiApplication.java
```


### Descrição das Camadas e Pacotes

- **config**:
  - `SecurityConfig.java`: Configurações de segurança da aplicação.

- **configurer**:
  - `AnimeLinkWebMvnConfigurer.java`: Configurações adicionais do projeto.

- **controller**:
  - `AnimeController.java`: Controlador responsável por gerenciar as requisições relacionadas aos animes.

- **domain**:
  - `Anime.java`: Entidade que representa um anime.
  - `UserData.java`: Entidade que representa os dados do usuário.

- **dto**:
  - `AnimePostRequestBody.java`: DTO para criação de novos animes.
  - `AnimePutRequestBody.java`: DTO para atualização de animes existentes.

- **exception**:
  - `BadRequestException.java`: Exceção personalizada para requisições inválidas.
  - `BadRequestExceptionDetails.java`: Detalhes da exceção de requisição inválida.
  - `ExceptionDetails.java`: Detalhes gerais de exceções.
  - `ValidationExceptionDetails.java`: Detalhes de exceções de validação.

- **handler**:
  - `RestExceptionHandler.java`: Manipulador global de exceções.

- **repository**:
  - `AnimeRepository.java`: Repositório para operações de banco de dados relacionadas a animes.
  - `UserDataRepository.java`: Repositório para operações de banco de dados relacionadas a dados de usuários.

- **service**:
  - `AnimeService.java`: Serviço contendo a lógica de negócios relacionada aos animes.
  - `UserDataService.java`: Serviço contendo a lógica de negócios relacionada aos dados dos usuários.

- **wrapper**:
  - `PageableResponse.java`: Classe utilitária para respostas paginadas.

- **AnimeLinkApiApplication.java**: Classe principal da aplicação Spring Boot.

### Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 2.5.6**
  - **spring-boot-starter-actuator**: Fornece recursos de monitoramento e métricas.
  - **spring-boot-starter-security**: Fornece segurança para a aplicação.
  - **spring-boot-starter-data-jpa**: Integração com JPA (Java Persistence API).
  - **spring-boot-starter-web**: Suporte para desenvolvimento de aplicações web, incluindo RESTful.
  - **spring-boot-devtools**: Ferramentas de desenvolvimento para acelerar o processo de desenvolvimento.
  - **spring-boot-starter-test**: Dependências para testes.
  - **spring-boot-starter-validation**: Suporte para validação de bean.
- **org.jacoco:jacoco-maven-plugin**: Plugin para geração de relatórios de cobertura de código.
- **io.micrometer:micrometer-registry-prometheus**: Integração com Prometheus para monitoramento.
- **org.springdoc**:
  - **springdoc-openapi-ui**: Integração com OpenAPI para documentação.
  - **springdoc-openapi-data-rest**: Suporte para Spring Data REST.
  - **springdoc-openapi-security**: Suporte para segurança no OpenAPI.
- **mysql:mysql-connector-java**: Driver JDBC para MySQL.
- **org.projectlombok:lombok**: Biblioteca para reduzir boilerplate de código Java.
- **com.h2database:h2**: Banco de dados em memória para testes.


### Configuração e Execução

1. Clone o repositório:
```sh
git clone https://github.com/andersonleite1/AnimeApi.git
```

2. Navegue até o diretório do projeto:
```sh
cd AnimeApi
```

3. Compile e execute a aplicação:

```sh 
mvn spring-boot:run
```

### Endpoints
A API fornece os seguintes endpoints para gerenciar animes e dados de usuários:

- GET /animes: Retorna a lista de todos os animes.
- POST /animes: Cria um novo anime.
- GET /animes/{id}: Retorna os detalhes de um anime específico.
- PUT /animes/{id}: Atualiza um anime existente.
- DELETE /animes/{id}: Deleta um anime.

### Tratamento de Exceções
A API utiliza um manipulador global de exceções (RestExceptionHandler.java) para capturar e retornar respostas apropriadas para diferentes tipos de erros, como BadRequestException, ValidationException, entre outros.

### Segurança
A segurança da API é configurada através da classe SecurityConfig.java, que define as políticas de segurança para os endpoints.


