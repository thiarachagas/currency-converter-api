# Conversor de Moedas

Este projeto é um conversor de moedas interativo que permite a conversão de USD para várias outras moedas em tempo real. Ele utiliza uma API de taxas de câmbio para obter dados atualizados e exibe as taxas de câmbio no console.

## Visão Geral

O objetivo deste projeto é demonstrar a capacidade de consumir uma API externa, manipular dados JSON e interagir com o usuário por meio de uma interface de linha de comando.

## Pré-requisitos

- Java JDK 11 ou posterior
- Biblioteca Gson 2.10.1 ou posterior
- Maven (opcional, mas recomendado)
- Postman (para testes de API)

## Configuração do Ambiente

1. **Instale o Java JDK 11 ou posterior:**
    - Baixe e instale a versão mais recente do [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html).

2. **Adicione a Biblioteca Gson ao Projeto:**
    - Se estiver usando Maven, adicione a dependência ao seu `pom.xml`:
      ```xml
      <dependency>
          <groupId>com.google.code.gson</groupId>
          <artifactId>gson</artifactId>
          <version>2.10.1</version>
      </dependency>
      ```
    - Se não estiver usando Maven, baixe o JAR do Gson e adicione ao seu classpath.

3. **Instale o Postman:**
    - Baixe e instale o [Postman](https://www.postman.com/downloads/).

4. **Clone o Repositório:**
    - Clone este repositório para a sua máquina local.

## Instruções para Execução

1. **Substitua a API Key:**
    - No arquivo `CurrencyConverter.java`, substitua `API_KEY` pela sua chave de API da [ExchangeRate-API](https://www.exchangerate-api.com/).

2. **Compile e Execute o Projeto:**
    - Utilize o IntelliJ IDEA ou qualquer outra IDE de sua preferência.
    - Compile e execute a classe `Main`.

3. **Utilize a Interface do Console:**
    - Siga as instruções no console para selecionar a conversão de moeda desejada.

## Testes

### Testando a API no Postman

1. **Abra o Postman.**
2. **Crie uma nova requisição GET.**
3. **Insira a URL:** `https://v6.exchangerate-api.com/v6/API_KEY/latest/USD`.
4. **Envie a requisição.**
5. **Verifique a resposta JSON.**
    - Certifique-se de que a resposta contém o campo `conversion_rates`.

## Autor

Este projeto foi desenvolvido por Thiára Chagas. Sinta-se à vontade para entrar em contato em thiaraschagas@gmail.com para quaisquer dúvidas ou sugestões.
