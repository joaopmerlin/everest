# Everest

Aplicação para gerenciamento de tarefas, utilizando microserviços.

<h4>Pre requisitos</h4>
<ul>
<li>Git</li>
<li>Java 8</li>
<li>Maven</li>
</ul>

<h4>Estrutura</h4>
<p>Microserviços utilizando Spring Cloud e NetflixOSS.</p>
<ul>
<li>Config server</li>
<li>Discovery service Eureka</li>
<li>Oauth2 service</li>
<li>Tarefa service</li>
<li>Client Web</li>
</ul>

<h4>Run and Deploy</h4>
``https://github.com/joaopmerlin/everest.git``
<ul>
<li>Importar o projeto principal com todos os modulos</li>
<li>Executar primeiramente o microservice de configuracao (Config server), as configuracoes sao obtidas do repositorio git</li>
<li>Executar todos os microservices</li>
</ul>

``/config-server mvn spring-boot:run``<br>
``/discovery-service mvn spring-boot:run``<br>
``/auth-service mvn spring-boot:run``<br>
``/tarefa-service mvn spring-boot:run``<br>
``/client mvn spring-boot:run``<br>

<h4>Rodando</h4>
Os servicos serao iniciados nas seguintes portas
<ul>
<li>Config server 8888</li>
<li>Discovery service Eureka 8761</li>
<li>Oauth2 service 9999</li>
<li>Tarefa service 8181</li>
<li>Client Web 8080</li>
</ul>
