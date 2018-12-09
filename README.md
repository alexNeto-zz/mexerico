# mexerico
Aplicativo de conversação via sockets, usando java

# Instalação
Baixe o codigo fonte com `$ git clone https://github.com/alexNeto/mexerico`

Faça a build do projeto com `$ mvn package`

# Uso
Testar localmente requere 3 terminais, uma para o servidor e outros 2 para testar os clientes

Suba o servidor com o comando `$ java -jar target/mexerico.jar -s`

Suba clientes com o comando `$ java -jar target/mexerico -c <ip> [-n <nome>]`

# Em funcionamento
Servidor:<br>
<img src="funcionamento/server.png" width="400">
<br>
Cliente 1:<br>
<img src="funcionamento/cliente1.png" width="400">
<br>
Cliente 2:<br>
<img src="funcionamento/cliente2.png" width="400">
<br>
Cliente anonimo:<br>
<img src="funcionamento/anon.png" width="400">