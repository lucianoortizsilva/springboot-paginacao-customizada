### Tech Stack
- Java
- Maven
- Spring Boot

### O que é ?
Uma alternativa para uma paginação customizada, ou seja, quando precisamos que a paginação não siga o padrão de informar um objeto Pageable na query do Repository.

### Problema
Imagine que você precisa realizar uma paginação para o seguinte cenário:\
1º Você deverá criar um endpoint que retorne um "Page<PessoaDTO>"\
2º Deverá buscar uma lista de objetos Pessoa, cadastradas na base de dados.\
3º Converter todas essas pessoas em PessoaDTO.\
4º Para cada PessoaDTO, é modificado sua propriedade "apelido".\
5º Por último, o endpoint recebe um parâmetro, para poder pesquisar por "apelido"\
Sendo assim, podemos afirmar que não podemos utilizar a paginação padrão, pois o atributo de "apelido" será informado somente depois da query do banco de dados já ter sido executada.  

<hr>

### Solução
Como exemplo de solução, criei esse projeto utilizando Spring Boot, Maven e banco de dados H2.\
Ao inicializar a aplicação será criada uma base de dados "Pessoa", com nomes fakes.\
Basicamente a aplicação faz:\
1º Buscar todas a pessoas cadastradas (Utilizando @Cacheable)\
2º Converter Pessoas em uma lista de PessoaDTO\
3º Informar apelidos aleatórios para cada PessoaDTO\
4º Realizar o filtro, conforme o termo de pesquisa "filtroApelido=Thanos"\
5º Por último, montar a lista de PessoaDTO a serem exibidas, conforme página e filtros solicitados.\
    
### Como rodar ?
- Execute **`mvn clean package`**
- Execute **`mvn spring-boot:run`**, e consuma o endpoint de exemplo abaixo.\
Ao rodar o projeto, irá criar automaticamente uma base de dados, em um banco H2 (via liquibase).

> **GET** http://localhost:8080/pessoas?page=0&size=5&filtroApelido=Thanos

![](https://github.com/lucianoortizsilva/springboot-paginacao-customizada/blob/master/src/main/resources/static/github/paginacao-customizada.jpg)

<hr>
