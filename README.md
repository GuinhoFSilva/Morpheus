# Morpheus - Olympus Simulation Engine (V1)

![Java](https://img.shields.io/badge/java-000000.svg?style=for-the-badge&logo=openjdk&logoColor=orange)
![SpringBoot](https://img.shields.io/badge/springboot-000000?style=for-the-badge&logo=springboot&logoColor=green)
![Picocli](https://img.shields.io/badge/picocli-000000.svg?style=for-the-badge)
![repo size](https://img.shields.io/github/repo-size/GuinhoFSilva/hermes?style=for-the-badge&color=000000&labelColor=000000) 


                 ███▄ ▄███▓ ▒█████   ██▀███   ██▓███   ██░ ██ ▓█████  █    ██   ██████
                ▓██▒▀█▀ ██▒▒██▒  ██▒▓██ ▒ ██▒▓██░  ██▒▓██░ ██▒▓█   ▀  ██  ▓██▒▒██    ▒
                ▓██    ▓██░▒██░  ██▒▓██ ░▄█ ▒▓██░ ██▓▒▒██▀▀██░▒███   ▓██  ▒██░░ ▓██▄  
                ▒██    ▒██ ▒██   ██░▒██▀▀█▄  ▒██▄█▓▒ ▒░▓█ ░██ ▒▓█  ▄ ▓▓█  ░██░  ▒   ██▒
                ▒██▒   ░██▒░ ████▓▒░░██▓ ▒██▒▒██▒ ░  ░░▓█▒░██▓░▒████▒▒▒█████▓ ▒██████▒▒
                ░ ▒░   ░  ░░ ▒░▒░▒░ ░ ▒▓ ░▒▓░▒▓▒░ ░  ░ ▒ ░░▒░▒░░ ▒░ ░░▒▓▒ ▒ ▒ ▒ ▒▓▒ ▒ ░
                ░  ░      ░  ░ ▒ ▒░   ░▒ ░ ▒░░▒ ░      ▒ ░▒░ ░ ░ ░  ░░░▒░ ░ ░ ░ ░▒  ░ ░
                ░      ░   ░ ░ ░ ▒    ░░   ░ ░░        ░  ░░ ░   ░    ░░░ ░ ░ ░  ░  ░ 
                       ░       ░ ░     ░               ░  ░  ░   ░  ░   ░           ░ 
                                                                                      


> O **Morpheus (V1)** é um orquestrador de cenários responsável por executar fluxos completos dentro do ecossistema Olympus.
> Nessa primeira versão, permite validar integrações entre os microserviços, medir desempenho e automatizar cenários de uso.

## Features

- Interface de linha de comando construída com Picocli.
- Simulação automática do fluxo completo do jogador.
- Coleta automática de métricas de desempenho.
- Geração automática de usuários para testes.


## Tecnologias

- Java 21
- Spring Boot
- Picocli

### Comandos
|Comando |Flag |Descrição
|--------|----------|-----------|
| simulate    | --players valor |  executa uma simulação completa do fluxo integrado entre os microsserviços do ecossistema Olympus | 

---

# Casos de Uso
> Nota: Esses são os casos de uso referentes à versão 1 do projeto.

###### **Simulate**
Objetivo: Executa automaticamente um fluxo completo utilizando as funcionalidades disponíveis do Morpheus.

*Entrada:*
- Quantidade de players para a simulação (opcional);

*Processamento:*
- O sistema registra no Argos a quantidade de jogadores informadas;
- O sistema loga os jogadores registrados e salva seus tokens;
- O sistema utiliza os tokens para colocar os jogadores nas filas do Hermes;
- O sistema coleta métricas de desempenho;

*Saída:*
- Métricas de desempenho coletadas, sendo elas:
	- Total de requisições realizadas;
	- Quantidade de requisições bem-sucedidas;
	- Quantidade de requisições com falha;
	- Total de tentativas de cadastro;
	- Cadastros realizados com sucesso;
	- Cadastros com falha;
	- Total de tentativas de login;
	- Logins realizados com sucesso;
	- Logins com falha;
  - Tempo total de execução da simulação;

*Regras de Negócio:*
- Caso o número de jogadores não seja informado. utiliza-se 50;
- O máximo de jogadores para teste do fluxo são 1000;
- Os jogadores utilizados durante a simulação são gerados automaticamente;
- O mínimo de jogadores para teste do fluxo são 2;
---

# Roadmap V2
- Refatorar sistema de métricas;
- Melhorar arquitetura de CLI;
- Melhorar UX do cli;
- Animações durante a execução de comandos longos;
