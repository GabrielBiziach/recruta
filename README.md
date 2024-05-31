# Recruta - Backend

Este é o repositório do backend para o projeto Recruta, desenvolvido como parte de um teste técnico para Desenvolvedor Full Stack.

## Objetivo

O objetivo deste projeto é criar uma aplicação web que facilite o processo de recrutamento interno para os colaboradores da empresa. A aplicação deve permitir aos usuários pesquisar e candidatar-se a vagas internas, passando por filtros de requisitos específicos.

## Requisitos Funcionais

- **Autenticação e Autorização:** Implementar um sistema de autenticação seguro para os usuários.
- **Cadastro de Vagas:** Permitir que os administradores cadastrem novas vagas, incluindo informações como título, descrição e requisitos. Possibilitar a atualização e exclusão de vagas.
- **Candidatura a Vagas:** Implementar um sistema de candidatura às vagas, onde os usuários podem expressar interesse em uma posição específica. Enviar notificações aos responsáveis pela vaga e ao candidato.

### Bônus

- **Painel do Candidato:** Criar um painel para os candidatos acompanharem o status de suas candidaturas e receberem feedbacks.
- **Avaliação de Candidatos:** Implementar um sistema de avaliação de candidatos pelos responsáveis pela vaga, incluindo filtros de requisitos ou tempo de empresa.

## Escopo

- Desenvolver os módulos de frontend e backend de forma separada.
- O desenvolvimento do backend deve ser feito em Java 8+.
- Preferencialmente utilizar Spring Boot 2.0+ com toda sua stack para o desenvolvimento do backend.
- Utilizar um banco de dados relacional PostgreSQL.

## Instalação e Execução

Antes de executar o projeto, certifique-se de ter instalado:

- **Java 8 ou superior**
- **Maven**
- **PostgreSQL**
- **Postman** (para testar as APIs)

### Passos para executar o projeto:

1. **Clonar o repositório:**

   ```
   git clone https://github.com/GabrielBiziach/recruta.git
   ```

2. **Backend:**

   - Acesse o diretório do backend:

     ```
     cd recruta/backend
     ```

   - Execute o comando Maven para construir o projeto:

     ```
     mvn clean install
     ```

   - Execute o comando para iniciar o servidor Spring Boot:

     ```
     java -jar target/backend-0.0.1-SNAPSHOT.jar
     ```

3. **Banco de Dados:**

   - Certifique-se de ter o PostgreSQL instalado e em execução.
   - Configure as credenciais do banco de dados no arquivo `application.properties`.

4. **Testando as APIs:**

   - Importe a coleção do Postman disponível em [[link_para_coleção_do_postman](https://api.postman.com/collections/1059682-bf22face-689d-4a75-bec8-1823c0ab0166?access_key=PMAT-01HZ88Y73XHN4634MV9D8101XJ)].
   - Altere as variáveis de ambiente do Postman conforme necessário.


## Licença

Este projeto está licenciado sob a [Licença XYZ]. Consulte o arquivo `LICENSE` para obter mais detalhes.

## Contato

Gabriel Biziach - [gabrielbiziach@gmail.com] - [https://](https://www.linkedin.com/in/gabriel-biziach-rodrigues/)

