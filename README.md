# CRUD‑MongoDB

Um projeto Java simples para demonstrar operações de **CRUD** (Criar, Ler, Atualizar e Deletar) usando **MongoDB** como banco de dados. Ideal para aprendizado de integração Java + MongoDB.

---

## 🚀 Tecnologias

- Java 19  
- Maven  
- MongoDB (driver `org.mongodb:mongodb‑driver‑sync` 4.x)

---

## Funcionalidades

- Inserção de documentos em uma coleção  
- Consulta de documentos (todos ou filtrados)  
- Atualização de documentos existentes  
- Remoção de documentos da coleção  

---

## 🧠 Motivação

Este projeto surgiu como exemplo didático para ilustrar como aplicações Java podem interagir com MongoDB de forma simples e direta. Serve como base para aprender os principais comandos CRUD e iniciar projetos mais robustos.

---

## 🎯 Pré‑requisitos

- Java JDK 19 instalado  
- MongoDB em execução local (porta padrão 27017) ou acesso remoto  
- Maven (versão 3.x)

---

## 🛠️ Como rodar o projeto

```bash
git clone https://github.com/Viniciustertuliano/CRUD-MongoDB.git
cd CRUD-MongoDB
mvn compile exec:java -Dexec.mainClass=br.com.crud.Main
```

Por padrão, o projeto conecta-se ao MongoDB em `mongodb://localhost:27017`, usando o banco `test` e coleção `items`. Você pode alterar essas configurações no código.

---

## 🧪 Exemplos de uso

### Criar um documento

```java
Document doc = new Document("nome", "Exemplo")
    .append("idade", 25)
    .append("profissao", "Desenvolvedor");
collection.insertOne(doc);
```

### Ler documentos

```java
collection.find().forEach(doc -> System.out.println(doc.toJson()));
```

### Atualizar documento

```java
collection.updateOne(eq("nome", "Exemplo"),
    new Document("$set", new Document("idade", 26)));
```

### Deletar documento

```java
collection.deleteOne(eq("nome", "Exemplo"));
```

---

## 📁 Estrutura do projeto

```text
src/
 └─ main/
     ├─ java/
     │   └─ br/com/crud/
     │       ├── Main.java
     │       └── repository
     │           └── AlunoRepository.java
     └─ resources/
pom.xml
README.md
```

---

## ✅ Pontos fortes

- Implementação leve e didática  
- Uso do driver oficial `mongodb‑driver‑sync`  
- Simples de compilar e executar via Maven

---

## ⚠️ Oportunidades de melhoria

- Incluir tratamento de erros (exceções, falhas de conexão etc.)  
- Aplicar padrão DAO ou separação de lógica de negócios  
- Adicionar testes automatizados com JUnit ou Mockito  
- Externalizar configurações (host, porta, coleções) via `application.properties` ou variáveis de ambiente   

---

## 🤝 Contribuição

Contribuições são bem-vindas! Abra issues ou envie pull requests com sugestões ou correções.  
Por favor, siga boas práticas de commit e inclua testes quando adicionar funcionalidades.

---

## 🏷️ Licença

Este projeto está licenciado sob a **MIT License**. Consulte o arquivo [LICENSE](LICENSE) para mais detalhes.