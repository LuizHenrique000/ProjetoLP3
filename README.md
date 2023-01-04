## Configurações Iniciais

Antes de tudo, crie uma imagem do Postgres

`docker pull postgres`

Depois rode o container

`docker run --name moviebook-database -e POSTGRES_PASSWORD=123456 -d -p 5432:5432 postgres`

Liste todos os containers e copie o id do moviebook-database

`docker ps -a`

Entre no terminal do container substituindo o id

`docker exec -it 'id do container' bash`

Entre no Postgres

`psql -U postgres`

Crie o seguinte database

`CREATE DATABASE moviebook_db;`

Agora o banco de dados já está preparado!
