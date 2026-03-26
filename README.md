# Shift (Projeto Diamante)

- Projeto solicitado como avaliação para a matéria de JAVA, utilizando Spring e todas as tecnologias abordadas em Aula.

- Além da Possibilidade de testar o funcionamento do projeto no Insomia (ou qualquer testador de APIS) conta com uma página web para visualização.

#### Project Tree (Árvore do Projeto):

```
Shift
├─ .mvn
│  └─ wrapper
│     └─ maven-wrapper.properties
├─ mvnw
├─ mvnw.cmd
├─ pom.xml
└─ src
   ├─ main
   │  ├─ java
   │  │  └─ br
   │  │     └─ com
   │  │        └─ fiap
   │  │           └─ Shift
   │  │              ├─ ShiftApplication.java
   │  │              ├─ config
   │  │              │  └─ CorsConfig.java
   │  │              ├─ controllers
   │  │              │  ├─ CustomerController.java
   │  │              │  └─ VehicleController.java
   │  │              ├─ models
   │  │              │  ├─ Customer.java
   │  │              │  └─ Vehicle.java
   │  │              ├─ repositories
   │  │              │  ├─ CustomerRepository.java
   │  │              │  └─ VehicleRepository.java
   │  │              └─ service
   │  │                 ├─ CustomerService.java
   │  │                 └─ VehicleService.java
   │  └─ resources
   │     └─ application.properties
   └─ test
      └─ java
         └─ br
            └─ com
               └─ fiap
                  └─ Shift
                     └─ ShiftApplicationTests.java

```

## Como Testar:

- Clone o projeto e rode o arquivo **ShiftApplication** para levar a API.

- Links para o teste em **LocalHost**: http://localhost:8080/customers | http://localhost:8080/vehicles

- ( Adicionar Tutorial de como testar na web após a implementação da mesma )


**Por: orlando-IDA | ggabmartins | Asuyz | Obrigado pelo acesso:
