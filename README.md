# 💱 Conversor de Moedas (Java + ExchangeRate API)

Este é um projeto simples em Java que realiza a conversão de moedas utilizando a [ExchangeRate API](https://www.exchangerate-api.com/). O sistema carrega todas as taxas de câmbio com uma única requisição e permite conversões entre mais de 160 moedas de forma eficiente.

---

## 🚀 Tecnologias Utilizadas

- ✅ Java 17+
- ✅ HTTP Client (`java.net.http`)
- ✅ [Gson](https://github.com/google/gson) – biblioteca para parsing de JSON

---

## ✨ Funcionalidades

- 📥 Consulta de taxas de câmbio atualizadas em tempo real  
- 🔁 Conversão entre qualquer par de moedas disponíveis  
- 🔎 Validação de entrada com mensagens claras ao usuário  
- 📋 Listagem dinâmica de todas as moedas suportadas pela API  
- 🧠 Otimização com apenas **uma chamada à API**

---

## 📦 Como Executar o Projeto

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/seu-usuario/nome-do-repo.git
   cd nome-do-repo
   ```

2. **Compile o código:**

   ```bash
   javac Main.java
   ```

3. **Execute o programa:**

   ```bash
   java Main
   ```

> 💡 Você também pode abrir o projeto em IDEs como IntelliJ IDEA ou Eclipse.

---

## 🔐 Observações

- Este projeto usa uma **chave gratuita** da ExchangeRate API.
- Para uso pessoal ou em produção, crie sua própria conta e substitua a chave pela sua no código:

   ```java
   String apiKey = "sua-chave-aqui";
   ```

- Obtenha sua chave aqui: [https://www.exchangerate-api.com](https://www.exchangerate-api.com)

---

## 📄 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

## 👨‍💻 Autor

Desenvolvido por [Carlos Eduardo](https://github.com/kadu111)
