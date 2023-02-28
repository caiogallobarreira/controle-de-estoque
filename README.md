# :package: Controle de Estoque
### Objetivo do Projeto
Este projeto consiste em auxiliar E-commerces a controlarem seus estoques de maneira eficiente

## Endpoints
- Estoque `/api/estoque`
    - [Cadastrar estoque](#cadastrar-estoque)
    - [Listar todas](#listar-todas)
    - [Detalhar estoque](#detalhar-estoque)
    - [Estoque mínimo](#estoque-mínimo)
    - [Apagar estoque](#apagar-estoque)
    - [Atualizar estoque](#atualizar-estoque)
- Usuário `/api/usuario`

---

### Cadastrar Estoque

`POST` /api/estoque

**Campos da requisição**

| Campo            | Tipo   | Obrigatório?| Descrição
|------------------|--------|:-----------:|-
|nome              |String  |sim          |Texto com o nome do produto com no máximo 255 caracteres.
|descricao         |String  |sim          |Texto com a descrição do produto com no máximo 255 caracteres.
|quantidade        |int     |sim          |O valor da quantidade existente no estoque.
|quantidade_minima |int     |não          |O valor mínimo para alertar quantidade baixa no estoque.
|imagem_url        |String  |não          |Texto com a URL da imagem do produto.

**Exemplo de corpo de requisição**

```js
{
    informacoes: {
        nome: "Faca de Cozinha",
        descricao: "Facas de cozinha com Lâminas em Aço Inox e Cabos de Polipropileno Preto",
        imagem_url: "https://controledeestoque.com.br/img/produtos/facadecozinha.png"
    }
    quantidade: 100,
    quantidade_minima: 10,
}
```

**Códigos de Resposta**

| Código | Descrição
|-|-
| 201 | Estoque cadastrado com sucesso
| 400 | Os campos enviados são inválidos

---

### Listar todas

`GET` /api/estoque

**Exemplo de corpo da resposta**

```js
{
    {
        id: 1,
        informacoes: {
            nome: "Faca de Cozinha",
            descricao: "Facas de cozinha com Lâminas em Aço Inox e Cabos de Polipropileno Preto",
            imagem_url: "https://controledeestoque.com.br/img/produtos/facadecozinha.png"
        }
        quantidade: 100,
        quantidade_minima: 10,
    },
    {
        id: 2,
        informacoes: {
            nome: "Televisão",
            descricao: "Televisão 4K de 55 polegadas",
            imagem_url: "https://controledeestoque.com.br/img/produtos/televisao.png"
        }
        quantidade: 50,
        quantidade_minima: 5,
    },
}
```

**Códigos de Resposta**

| Código | Descrição
|-|-
| 200 | Dados retornados com sucesso

---

### Detalhar estoque

`GET` /api/estoque/{id}

**Exemplo de corpo da resposta**

```js
{
    informacoes: {
        nome: "Faca de Cozinha",
        descricao: "Facas de cozinha com Lâminas em Aço Inox e Cabos de Polipropileno Preto",
        imagem_url: "https://controledeestoque.com.br/img/produtos/facadecozinha.png"
    }
    quantidade: 100,
    quantidade_minima: 10,
}
```

**Códigos de Resposta**

| Código | Descrição
|-|-
| 200 | Dados retornados com sucesso
| 404 | Não existe estoque com o id informado

---

### Estoque mínimo

`GET` /api/estoque/minimo

**Exemplo de corpo da resposta**

```js
{
    {
        id: 1,
        informacoes: {
            nome: "Faca de Cozinha",
            descricao: "Facas de cozinha com Lâminas em Aço Inox e Cabos de Polipropileno Preto",
            imagem_url: "https://controledeestoque.com.br/img/produtos/facadecozinha.png"
        }
        quantidade: 10,
        quantidade_minima: 10,
    }
}
```

**Códigos de Resposta**

| Código | Descrição
|-|-
| 200 | Dados retornados com sucesso

---

### Apagar estoque

`DELETE` /api/estoque/{id}

**Códigos de Resposta**

| Código | Descrição
|-|-
| 204 | Estoque removido com sucesso
| 404 | Não existe estoque com o id informado

---

### Atualizar Estoque

`PUT` /api/estoque/{id}

**Campos da requisição**

| Campo            | Tipo   | Obrigatório?| Descrição
|------------------|--------|:-----------:|-
|nome              |String  |não          |Texto com o nome do produto com no máximo 255 caracteres.
|descricao         |String  |não          |Texto com a descrição do produto com no máximo 255 caracteres.
|quantidade        |int     |não          |O valor da quantidade existente no estoque.
|quantidade_minima |int     |não          |O valor mínimo para alertar quantidade baixa no estoque.
|imagem_url        |String  |não          |Texto com a URL da imagem do produto.

**Exemplo de corpo de requisição**

```js
{
    informacoes: {
        nome: "Faca de Cozinha",
        descricao: "Facas de cozinha com Lâminas em Aço Inox e Cabos de Polipropileno Preto",
        imagem_url: "https://controledeestoque.com.br/img/produtos/facadecozinha.png"
    }
    quantidade: 100,
    quantidade_minima: 10,
}
```

**Códigos de Resposta**

| Código | Descrição
|-|-
| 200 | Estoque atualizado com sucesso
| 400 | Os campos enviados são inválidos
| 404 | Não existe estoque com o id informado

---