 
##########################################################################################
# Swagger
##########################################################################################
 Estou usando o Swagger 2, cuja versão é a 2.9.2, cuja notação encontra-se no POM do projeto. Para fazer um teste pelo swagger é
  só digitar o endereço localhost:8080/swagger-ui.html para testar os métodos da aplicação;



##########################################################################################
# Banco de Dados
##########################################################################################
O banco de dados usado é o embedded padrão h2 que vem junto com o spring-boot. A configuração está toda
no arquivo application.properties, podendo alterar o banco dependendo da necessidade. O arquivo data.sql na pasta resources, contém 
um carregamento inicial do usuário que irá efetuar as compras dos produtos, e também o cadastro inicial de alguns produtos.

Estou usando para parte de persistência a o Spring Data conforme encontra-se como dependência no POM do projeto.


