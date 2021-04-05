 
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

##########################################################################################
# Como rodar
##########################################################################################

Vá na pasta do projeto principal onde tem um arquivo pom.xml. 
Nesta pasta basta abrir uma tela de comando e executar o seguinte: mvn spring-boot:run;

Isso vai fazer com que a aplicação suba.

Assim que ela estiver no ar, pode rodar a parte cliente, conforme readme.md do cliente, ou usar de modo simples a 
api do swagger digitando a seguinte URL no browser: localhost:8080/swagger-ui.html
