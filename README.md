# :package: Controle de Produto
### Objetivo do Projeto
Este projeto consiste em auxiliar E-commerces a controlarem seus produtos de maneira eficiente

## Endpoints
- Estoque `/api/estoque`
    - [Cadastrar estoque](#cadastrar-estoque)
    - [Listar todos](#listar-todos)
    - [Detalhar estoque](#detalhar-estoque)
    - [Apagar estoque](#apagar-estoque)
    - [Atualizar estoque](#atualizar-estoque)
- Produto `/api/produto`
    - [Cadastrar produto](#cadastrar-produto)
    - [Listar todas](#listar-todas)
    - [Detalhar produto](#detalhar-produto)
    - [Estoque mínimo](#estoque-mínimo)
    - [Apagar produto](#apagar-produto)
    - [Atualizar produto](#atualizar-produto)
- Usuário `/api/usuario`

## :package: Estoque

### Listar todos

`GET` /api/estoque

**Exemplo de corpo da resposta**

```js
[
    {
        id: 1,
        nome: "Estoque Principal",
        descricao: "Estoque principal da empresa",
    },
    {
        id: 2,
        nome: "Estoque de Retirada",
        descricao: "Estoque de retirada de produtos para entrega",
    },
]
```

**Códigos de Resposta**

| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso

---

### Detalhar estoque

`GET` /api/estoque/{id}

**Exemplo de corpo da resposta**

```js
{
    nome: "Estoque Principal",
    descricao: "Estoque principal da empresa",
}
```

**Códigos de Resposta**

| Código | Descrição
|-|-|
| 200 | Dados retornados com sucesso
| 404 | Não existe estoque com o id informado

---

### Cadastrar Estoque

`POST` /api/estoque

**Campos da requisição**

| Campo     | Tipo   | Obrigatório?| Descrição
|-----------|--------|:-----------:|-|
|nome       |String  |sim          |Texto com o nome do estoque com no máximo 255 caracteres.
|descricao  |String  |não          |Texto com a descrição do estoque com no máximo 255 caracteres.

**Exemplo de corpo da requisição**

```js
{
    nome: "Estoque Principal",
    descricao: "Estoque principal da empresa",
}
```

**Códigos de Resposta**

| Código | Descrição
|-|-|
| 201 | Dados cadastrados com sucesso
| 400 | Erro de validação dos dados

---

### Apagar estoque

`DELETE` /api/estoque/{id}

**Códigos de Resposta**

| Código | Descrição
|-|-|
| 204 | Dados apagados com sucesso
| 404 | Não existe estoque com o id informado

---

### Atualizar estoque

`PUT` /api/estoque/{id}

**Campos da requisição**

| Campo     | Tipo   | Obrigatório?| Descrição
|-----------|--------|:-----------:|-|
|nome       |String  |sim          |Texto com o nome do estoque com no máximo 255 caracteres.
|descricao  |String  |não          |Texto com a descrição do estoque com no máximo 255 caracteres.

**Exemplo de corpo da requisição**

```js
{
    nome: "Estoque Principal",
    descricao: "Estoque principal da empresa",
}
```

**Códigos de Resposta**

| Código | Descrição
|-|-|
| 200 | Dados atualizados com sucesso
| 400 | Erro de validação dos dados
| 404 | Não existe estoque com o id informado

---

## :package: Produto
### Listar todas

`GET` /api/produto

**Exemplo de corpo da resposta**

```js
[
    {
        id: 1,
        estoque_id: 1,
        nome: "Faca de Cozinha",
        descricao: "Facas de cozinha com Lâminas em Aço Inox e Cabos de Polipropileno Preto",
        imagem_url: "https://controledeproduto.com.br/img/produtos/facadecozinha.png",
        quantidade: 100,
        quantidade_minima: 10,
    },
    {
        id: 2,
        estoque_id: 1,
        nome: "Televisão",
        descricao: "Televisão 4K de 55 polegadas",
        imagem_url: "https://controledeproduto.com.br/img/produtos/televisao.png",
        quantidade: 50,
        quantidade_minima: 5,
    },
]
```

**Códigos de Resposta**

| Código | Descrição
|-|-
| 200 | Dados retornados com sucesso

---

### Detalhar produto

`GET` /api/produto/{id}

**Exemplo de corpo da resposta**

```js
{
    estoque_id: 1,
    nome: "Faca de Cozinha",
    descricao: "Facas de cozinha com Lâminas em Aço Inox e Cabos de Polipropileno Preto",
    imagem_url: "https://controledeproduto.com.br/img/produtos/facadecozinha.png",
    quantidade: 100,
    quantidade_minima: 10,
}
```

**Códigos de Resposta**

| Código | Descrição
|-|-
| 200 | Dados retornados com sucesso
| 404 | Não existe produto com o id informado

---

### Estoque mínimo

`GET` /api/produto/estoque-minimo

Essa endpoint vai servir como maneira facilitada de retornar uma lista dos produtos que possuem o parâmetro ``quantidade`` igual ao parâmetro ``quantidade_minima``

**Exemplo de corpo da resposta**

```js
[
    {
        id: 1,
        estoque_id: 1,
        nome: "Faca de Cozinha",
        descricao: "Facas de cozinha com Lâminas em Aço Inox e Cabos de Polipropileno Preto",
        imagem_url: "https://controledeproduto.com.br/img/produtos/facadecozinha.png",
        quantidade: 10,
        quantidade_minima: 10,
    }
]
```

**Códigos de Resposta**

| Código | Descrição
|-|-
| 200 | Dados retornados com sucesso

---

### Cadastrar Produto

`POST` /api/produto

**Campos da requisição**

| Campo            | Tipo   | Obrigatório?| Descrição
|------------------|--------|:-----------:|-
|estoque_id        |int     |sim          |O id do estoque que o produto pertence.
|nome              |String  |sim          |Texto com o nome do produto com no máximo 255 caracteres.
|descricao         |String  |sim          |Texto com a descrição do produto com no máximo 255 caracteres.
|quantidade        |int     |sim          |O valor da quantidade existente no produto.
|quantidade_minima |int     |não          |O valor mínimo para alertar quantidade baixa no produto.
|imagem_url        |String  |não          |Texto com a URL da imagem do produto.

**Exemplo de corpo de requisição**

```js
{
    estoque_id: 1,
    nome: "Faca de Cozinha",
    descricao: "Facas de cozinha com Lâminas em Aço Inox e Cabos de Polipropileno Preto",
    imagem_url: "https://controledeproduto.com.br/img/produtos/facadecozinha.png".
    quantidade: 100,
    quantidade_minima: 10,
}
```

**Códigos de Resposta**

| Código | Descrição
|-|-
| 201 | Produto cadastrado com sucesso
| 400 | Os campos enviados são inválidos

---

### Atualizar Produto

`PUT` /api/produto/{id}

**Campos da requisição**

| Campo            | Tipo   | Obrigatório?| Descrição
|------------------|--------|:-----------:|-
|estoque_id        |int     |não          |O id do estoque que o produto pertence.
|nome              |String  |não          |Texto com o nome do produto com no máximo 255 caracteres.
|descricao         |String  |não          |Texto com a descrição do produto com no máximo 255 caracteres.
|quantidade        |int     |não          |O valor da quantidade existente no produto.
|quantidade_minima |int     |não          |O valor mínimo para alertar quantidade baixa no produto.
|imagem_url        |String  |não          |Texto com a URL da imagem do produto.

**Exemplo de corpo de requisição**

```js
{
    estoque_id: 1,
    nome: "Faca de Cozinha",
    descricao: "Facas de cozinha com Lâminas em Aço Inox e Cabos de Polipropileno Preto",
    imagem_url: "https://controledeproduto.com.br/img/produtos/facadecozinha.png",
    quantidade: 100,
    quantidade_minima: 10,
}
```

**Códigos de Resposta**

| Código | Descrição
|-|-
| 200 | Produto atualizado com sucesso
| 400 | Os campos enviados são inválidos
| 404 | Não existe produto com o id informado

---

### Apagar produto

`DELETE` /api/produto/{id}

**Códigos de Resposta**

| Código | Descrição
|-|-
| 204 | Produto removido com sucesso
| 404 | Não existe produto com o id informado

---
