# News API
Api de Atividade de DDI (Desenvolvimento Distribuido na internet)

## Fases

#### Fase01 - Uma api simples
![Frame 2](https://user-images.githubusercontent.com/13178261/161849199-b8a3a74e-29fd-46e5-b33e-3264dd35b0d1.png)

#### Como executar o projeto

Para executar o projeto você vai precisar dos seguintes pre-requisitos:
- GIT
- Java JDK 11 (De preferência a versão correto, mas pode ser outra)
- IntellijIDEA
- Postman

Após a instalação dos programas listados acima, basta clonar o projeto na máquina e abrir a pasta no **IntelijIDEA**. O projeto vai demorar um pouco pra buildar na sua maquina a primeira vez, então você pode esperar um pouquinho.
Após a aplicação terminar a build, abra o arquivo `src/main/kotlin/dev.cancio/Application.kt` e clique no botão de play mostrado abaixo:

![image](https://user-images.githubusercontent.com/13178261/161887998-fcfa53cd-129a-47c2-b4f9-c1ead8bb0645.png)
 
 Em seguida abra a aba run no canto inferior da IDE e espere aparecer a seguinte imagem:

![image](https://user-images.githubusercontent.com/13178261/161888248-cd3af868-8c39-4996-a3be-9469984258cb.png)

Agora basta abrir o postman e criar os endpoints de sua preferência. Vou sugerir aqui algums para realizar testes, são esses:

- GetCategorys: coleta todas as categorias
  - Endpoint: `http://localhost:8080/category`
- GetNews: coleta uma unica notícia mediante ao id e à categoria
  - Endpoint: `http://localhost:8080/sistemas_operacionais/1` ou `http://localhost:8080/jogatina/1`
- CreateNews: Cria uma nova notícia
  - Endpoint: `http://localhost:8080/`
  - Corpo da requisição:
  ```json
  {
    "category":"SISTEMAS_OPERACIONAIS",
    "news":{
        "id": "4",
        "date": "26/04/2019",
        "title": "Creating HTTP APIs",
        "urlName": "https://ktor.io/docs/creating-http-apis.html#register-customer-routes"
    }
  ```
- UpdateNews: Atualiza uma nova notícia
  - Endpoint: `http://localhost:8080/sistemas_operacionais/1` ou `http://localhost:8080/jogatina/1`
  - Corpo da requisição:
  ```json
  {
        "id": "4",
        "date": "26/04/2019",
        "title": "Creating HTTP APIs",
        "urlName": "https://ktor.io/docs/creating-http-apis.html#register-customer-routes"
    }
  ```
- DeleteNews: Apaga uma notícia
  - Endpoint: `http://localhost:8080/sistemas_operacionais/1` ou `http://localhost:8080/jogatina/1`
