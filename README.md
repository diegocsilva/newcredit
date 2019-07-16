# Newcredit !

O sistema **Newcredit** foi criado com intuito de facilitar a análise de crédito e que isso seja de forma instantânea no mesmo momento em que o cliente efetua o cadastro.

# Tecnologias

Para criar o sistema Newcredit foram utilizados as seguintes ferramentas/frameworks:

- Backend com Spring-boot
- Frontend com Angular
- Banco de dados utilizando o PostgreSQL

# Composição da Stack

A Stack do Newcredit é composta por 4 aplicações, são elas:

- PostgreSQL    : banco de dados
- NewCreditAPI : serviço com conexão ao banco de dados e gerenciamento da comunicação com a tela
- NewCreditEngineAPI: serviço responsável por fazer as analises de crédito
- NewCreditUI: frontend 

## O que preciso para subir a aplicação

- Sistema Operacional Linux
- Docker e docker-compose instalados

## Rodando a aplicação

Para rodar a aplicação você precisa abrir um terminal e ir até a pasta raiz do projeto e executar o arquivo start.sh, com o comando :

    sudo ./start.sh

Após rodar o comando e subir todos os serviços é só acessar o endereço :
http://localhost:4200