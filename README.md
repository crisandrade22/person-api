# API REST para gerenciamento de pessoas

## Objetivo

📚 Fiz esse projeto com o propósito de estudar Spring Boot, Spring Data JPA e Java 11.

## Como executar

1. 🚀 Inicie o Spring Boot
    ```bash
    mvn spring-boot:run
    ```
1. 🌐 O microsserviço estará disponível na URL: `http://localhost:5000`.
1. 👤 Cadastre uma pessoa com a requisição abaixo
    ```bash
    POST http://localhost:5000/people
    Content-Type: application/json
   
   {
      "firstName": "ABCDE",
      "surname": "ABCDE",
      "cpf": "000.000.000-00",
      "birthDate": "yyyy-mm-dd",
      "phones": [
         {
             "type": "Commercial|Home|Mobile",
             "phoneNumber": "(99) 9 9999-9999"
         }
       ]
   }
    ```
1. 👤 Sobrescreva os dados de uma pessoa com a requisição abaixo
    ```bash
   PUT http://localhost:5000/people/99
   Content-Type: application/json
   
   {
      "firstName": "ABCDE",
      "surname": "ABCDE",
      "cpf": "000.000.000-00",
      "birthDate": "yyyy-mm-dd",
      "phones": [
         {
             "type": "Commercial|Home|Mobile",
             "phoneNumber": "(99) 9 9999-9999"
         }
       ]
   }
    ```
1. 👤 Exclua os dados de uma pessoa com a requisição abaixo
    ```bash
   DELETE http://localhost:5000/people/99
    ```
1. 👤 Obtenha os dados de uma pessoa com a requisição abaixo
   ```bash
   GET http://localhost:5000/people/99
   ```
1. 👥 Obtenha os dados de todas as pessoas com o comando abaixo
   ```bash
   GET http://localhost:5000/people
   ```