<div align="center" style="display: flex; flex-direction: row; align-items: center; justify-content: center; gap: 10px;">
  <div>
    <h1 style="margin: 0;"> Challenge: Conversor de Moedas</h1>
    <h2 align="center" style="margin-top: 10px;">Programa ONE - Projeto TECH FOUNDATION Back-End</h2>
  </div>
  <div style="display: flex; align-items: center; justify-content: center; height: 200px;">
    <img src="./assets/badge black-conversor.png" alt="Badge ONE" width="150">
  </div>
</div>

___

### Objetivo do Projeto

O objetivo deste projeto é desenvolver um Conversor de Moedas em Java, que ofereça interação textual via console com o usuário. O conversor deve disponibilizar no mínimo seis opções diferentes de conversão de moedas, utilizando taxas de câmbio obtidas dinamicamente de uma API, garantindo que os valores estejam sempre atualizados em tempo real.

Além disso, o projeto permite ao desenvolvedor praticar habilidades importantes de Java, como:
- Configuração do ambiente Java;
- Criação e estruturação do projeto;
- Consumo de APIs externas;
- Manipulação e análise de dados JSON;
- Filtragem de informações específicas;
- Exibição organizada dos resultados no console.

O desafio proporciona uma experiência prática e completa, simulando um cenário real de desenvolvimento back-end, focado em lógica, integração com APIs e boas práticas de programação orientada a objetos.

--- 
### Tecnologias Utilizadas

<p>
  <img src="https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=java&logoColor=white" alt="Java 17+">
  <img src="https://img.shields.io/badge/Gson-2.10.1-blue?style=for-the-badge" alt="Gson 2.10.1">
  <img src="https://img.shields.io/badge/ExchangeRate--API-lightgrey?style=for-the-badge" alt="ExchangeRate-API">
  <img src="https://img.shields.io/badge/IntelliJ%20IDEA-2023.2-purple?style=for-the-badge&logo=intellij-idea&logoColor=white" alt="IntelliJ IDEA">
  <img src="https://img.shields.io/badge/Maven-3.9.0-red?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven">
</p>

---
### Funcionalidades 

- Consulta de taxas de câmbio em tempo real
- Conversão entre múltiplas moedas
- Menu interativo no console

1. Histórico de Conversões

- Cada conversão realizada é registrada em memória durante a execução do programa.
- Permite que o usuário visualize todas as conversões feitas antes de encerrar o programa.
- Benefício: facilita a revisão rápida das conversões realizadas sem consultar a API novamente.

2. Registro de Logs em Arquivo

- Toda conversão é automaticamente registrada em um arquivo .txt (logs_conversoes.txt).
- Cada entrada contém:
  - Data e hora da conversão
  - Moeda de origem e destino
  - Valor original e valor convertido

- Benefício: mantém um histórico persistente, mesmo após o encerramento do programa, útil para auditoria ou análise posterior.

---
### Configuração da Chave da API

Este projeto utiliza a **ExchangeRate-API** para realizar as conversões de moedas.
Para funcionar corretamente, é necessário configurar uma **variável de ambiente** contendo sua chave de acesso.

1. Obtenha uma chave de API
- Acesse o site **https://www.exchangerate-api.com/** e crie uma conta gratuita para gerar sua API Key.

2. Configurar variável de ambiente no IntelliJ IDEA
- Passo a passo:
  - Abra o IntelliJ IDEA.
  - Vá até o menu superior e clique em:
    ````bach
    Run → Edit Configurations...
    ````
  - Selecione sua configuração de execução (por exemplo, Main).
  - Na seção Environment variables, clique no ícone de +.
  - Adicione a variável:
    ````bach
    API_KEY=sua_chave_aqui
    ````
  - Clique em OK para salvar.
  - Execute novamente o projeto.