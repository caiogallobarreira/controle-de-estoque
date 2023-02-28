# :package: Controle de Produto
### Objetivo do Projeto
Este projeto consiste em auxiliar E-commerces a controlarem seus produtos de maneira eficiente

## Endpoints
- Produto `/api/produto`
    - [Cadastrar produto](#cadastrar-produto)
    - [Listar todas](#listar-todas)
    - [Detalhar produto](#detalhar-produto)
    - [Estoque mínimo](#estoque-mínimo)
    - [Apagar produto](#apagar-produto)
    - [Atualizar produto](#atualizar-produto)
- Usuário `/api/usuario`

### Listar todas

`GET` /api/produto

**Exemplo de corpo da resposta**

```js
[
    {
        id: 1,
        informacoes: {
            nome: "Faca de Cozinha",
            descricao: "Facas de cozinha com Lâminas em Aço Inox e Cabos de Polipropileno Preto",
            imagem_url: "https://controledeproduto.com.br/img/produtos/facadecozinha.png"
        },
        quantidade: 100,
        quantidade_minima: 10,
    },
    {
        id: 2,
        informacoes: {
            nome: "Televisão",
            descricao: "Televisão 4K de 55 polegadas",
            imagem_url: "https://controledeproduto.com.br/img/produtos/televisao.png"
        },
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
    informacoes: {
        nome: "Faca de Cozinha",
        descricao: "Facas de cozinha com Lâminas em Aço Inox e Cabos de Polipropileno Preto",
        imagem_url: "https://controledeproduto.com.br/img/produtos/facadecozinha.png"
    },
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
        informacoes: {
            nome: "Faca de Cozinha",
            descricao: "Facas de cozinha com Lâminas em Aço Inox e Cabos de Polipropileno Preto",
            imagem_url: "https://controledeproduto.com.br/img/produtos/facadecozinha.png"
        },
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
|nome              |String  |sim          |Texto com o nome do produto com no máximo 255 caracteres.
|descricao         |String  |sim          |Texto com a descrição do produto com no máximo 255 caracteres.
|quantidade        |int     |sim          |O valor da quantidade existente no produto.
|quantidade_minima |int     |não          |O valor mínimo para alertar quantidade baixa no produto.
|imagem_url        |String  |não          |Texto com a URL da imagem do produto.

**Exemplo de corpo de requisição**

```js
{
    informacoes: {
        nome: "Faca de Cozinha",
        descricao: "Facas de cozinha com Lâminas em Aço Inox e Cabos de Polipropileno Preto",
        imagem_url: "https://controledeproduto.com.br/img/produtos/facadecozinha.png"
    },
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
|nome              |String  |não          |Texto com o nome do produto com no máximo 255 caracteres.
|descricao         |String  |não          |Texto com a descrição do produto com no máximo 255 caracteres.
|quantidade        |int     |não          |O valor da quantidade existente no produto.
|quantidade_minima |int     |não          |O valor mínimo para alertar quantidade baixa no produto.
|imagem_url        |String  |não          |Texto com a URL da imagem do produto.

**Exemplo de corpo de requisição**

```js
{
    informacoes: {
        nome: "Faca de Cozinha",
        descricao: "Facas de cozinha com Lâminas em Aço Inox e Cabos de Polipropileno Preto",
        imagem_url: "https://controledeproduto.com.br/img/produtos/facadecozinha.png"
    },
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