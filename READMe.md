# Partido Consumer API


API para consumo de [PartidoPolitico API](https://github.com/lop19029/PartidoPolitico-API)

### Funcionalidades

- [x] Validação do usuario
- [x] Display das informações dos politicos e partidos.
- [x] Sort das listas de politicos por nome (asc,desc) e por numero de projetos em que trabalharam.

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

* Você instalou `Java 11`
* [PartidoPolitico API](https://git.gft.com/aolj/partidospoliticosapi) esta rodando na porta 8081


## ☕ Usando PartidoConsumer API

Na pasta principal rodar o seguinte comando

```
./mvnw spring-boot:run
```

Entre no seu navegador e acesse este URL para ler a documentação e testar o API:
```
http://localhost:8080/swagger-ui.html
```

Para fins de teste, você pode acessar com um dos usuarios padrão:

**ADMIN**:
* Username: Admin
* Senha: Gft2021

**USER**:
* Username: User
* Senha: Gft2021

Quando tiver o seu Token de usuario, clique no botão `Autenticar` e no campo `api_key()` ingresse o seu token
da seguinte maneira:
```
"Bearer" + " " + token
```  

Testar a API usando Postman (Postman JSON Link)

```
https://www.getpostman.com/collections/f59be59c3062cf669030
```

## 📝 Créditos

Esse projeto foi desenvolvido por [Alex López](https://github.com/lop19029) como parte do programa Starter da  [GFT](https://www.gft.com/br/pt).
