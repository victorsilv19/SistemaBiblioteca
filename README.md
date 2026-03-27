# Sistema de Biblioteca 📚

Um sistema back-end completo desenvolvido em **Java** com o framework **Spring Boot** para o gerenciamento eficiente de uma biblioteca. A aplicação fornece uma API REST que permite realizar operações de CRUD (Create, Read, Update, Delete) em entidades fundamentais do domínio de bibliotecas.

## 🚀 Tecnologias Utilizadas

- **Java** (17+)
- **Spring Boot** (Web, Data JPA)
- **Banco de Dados Relacional** (PostgreSQL / H2)
- **Maven** (Gerenciamento de dependências e build)
- **Hibernate / JPA** (Mapeamento Objeto-Relacional)
- **Postman / Insomnia** (Para testes da API)

## ⚙️ Funcionalidades

O sistema expõe endpoints RESTful para o gerenciamento completo de:
- **Livros**: Cadastro, atualização de estoque, listagem por título, etc.
- **Autores**: Inclusão de novos autores e associação a livros.
- **Editoras**: Registro de editoras parceiras.
- **Bibliotecas**: Controle e organização física do acervo.

## 🛠️ Como Executar o Projeto

Pré-requisitos: Ter o [Java JDK](https://www.oracle.com/java/technologies/downloads/) e o [Maven](https://maven.apache.org/) instalados na sua máquina.

1. Clone o repositório:
   ```bash
   git clone https://github.com/victorsilv19/SistemaBiblioteca.git
   ```
2. Acesse a pasta do projeto:
   ```bash
   cd SistemaBiblioteca
   ```
3. Execute o projeto usando o Maven:
   ```bash
   mvn spring-boot:run
   ```
4. A API estará rodando por padrão em `http://localhost:8080`.

## 📌 Escopo / Endpoints Principais (Exemplo)

- `GET /livros` - Retorna a lista de livros disponíveis.
- `POST /livros` - Adiciona um novo livro.
- `GET /autores` - Lista todos os autores cadastrados.
- `POST /editoras` - Adiciona uma nova editora.

## 💡 Sobre o Projeto
Este projeto foi desenvolvido com foco no aprendizado de arquitetura limpa, padrão MVC (Model-View-Controller) aplicado à construção de APIs e injeção de dependências no ecossistema Spring Boot.

---
Desenvolvido com ☕ e 💻 por [Victor Nascimento Silva](https://github.com/victorsilv19)
