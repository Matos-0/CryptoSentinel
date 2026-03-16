# Reactive Stock / Crypto Sentinel

Reactive Stock/Crypto Sentinel é um **microserviço reativo** que monitora **preços de ações ou criptomoedas em tempo real**, armazena o histórico para análise e expõe um **fluxo contínuo de dados** para o front-end.

O serviço é construído com uma **arquitetura reativa não-bloqueante** usando Spring WebFlux e transmite dados de mercado para clientes utilizando **Server-Sent Events (SSE)**.

---

# Funcionalidades

* Monitoramento em tempo real de **ações ou criptomoedas**
* **Ingestão reativa de dados** usando WebClient
* **Processamento não-bloqueante** com Flux e Mono
* **Armazenamento histórico de preços** com Elasticsearch
* **Endpoint de streaming ao vivo** usando Server-Sent Events (SSE)
* **Tratamento de backpressure** para proteger o sistema contra sobrecarga
* **Testes reativos** utilizando StepVerifier
* **Ambiente com Docker Compose** para Elasticsearch e Kibana

---

# Visão Geral da Arquitetura

O sistema segue um **pipeline reativo de streaming de dados**:

API de Mercado → Ingestão Reativa → Processamento → Armazenamento → Stream para Clientes

### 1. Ingestão Reativa

Um **WebClient do Spring WebFlux** consome dados de mercado de APIs públicas como:

* Binance API
* Alpha Vantage API

O serviço consulta atualizações de preços em intervalos curtos.

---

### 2. Processamento Não-Bloqueante

Os dados recebidos são processados utilizando:

* `Flux`
* `Mono`

Isso garante **IO não bloqueante**, permitindo que o serviço lide com alta concorrência sem bloquear threads.

---

### 3. Armazenamento de Dados (Elasticsearch)

Os dados de preço são armazenados no **Elasticsearch**, que é ideal para:

* alta taxa de escrita
* consultas de séries temporais
* análise de dados
* agregações rápidas

---

### 4. Endpoint de Streaming (SSE)

Em vez de retornar um JSON estático, o serviço expõe um **endpoint de Server-Sent Events**:

```
GET /stream/prices
```

Esse endpoint mantém a conexão aberta e envia atualizações de preço continuamente:

```
Content-Type: text/event-stream
```

Isso permite que o front-end receba atualizações **em tempo real**.

---

# Executando a Infraestrutura

O projeto inclui um **Docker Compose** para subir o Elasticsearch e o Kibana.

Inicie os serviços com:

```
docker-compose up -d
```

Serviços iniciados:

* Elasticsearch
* Kibana

O Kibana permite **visualizar e explorar os dados armazenados**.

---

# Tecnologias Utilizadas

* Java
* Spring Boot
* Spring WebFlux
* Project Reactor
* Spring Data Elasticsearch (Reactive)
* Docker
* Elasticsearch
* Kibana

---

# Exemplo de Fluxo de Dados

1. WebClient requisita dados de preço de uma API externa
2. Os dados são processados utilizando Flux
3. Os dados são persistidos no Elasticsearch
4. O endpoint SSE transmite os preços atualizados para os clientes

---

# Testes

Fluxos reativos são testados utilizando **StepVerifier**, que faz parte do Project Reactor.

Exemplo:

```java
StepVerifier.create(priceStream)
    .expectNextMatches(price -> price.getValue() > 0)
    .verifyComplete();
```

Isso valida o comportamento dos **Flux e Mono** de forma determinística.

---

# Tratamento de Backpressure

O sistema implementa **estratégias de backpressure** para evitar sobrecarga quando a produção de dados é maior que a capacidade de consumo.

Exemplos incluem:

* buffering
* descarte de eventos
* controle de taxa

Esse é um conceito central em **Sistemas Reativos** e garante estabilidade.

---

# Observabilidade com Kibana

Os dados armazenados podem ser explorados através de dashboards no Kibana.

Exemplos de análise:

* evolução do preço ao longo do tempo
* análise de volatilidade
* comparação entre ativos

---

# Estrutura do Projeto

```
src
 ├── ingestion
 │   └── MarketDataClient
 ├── service
 │   └── PriceStreamService
 ├── controller
 │   └── PriceStreamController
 ├── repository
 │   └── PriceRepository
 └── model
     └── PriceDocument
```

---

# Objetivos do Projeto

Este projeto demonstra experiência prática com:

* programação reativa
* streaming de eventos
* microserviços não bloqueantes
* pipelines de dados em tempo real
* persistência reativa
* gerenciamento de backpressure

---

# Melhorias Futuras

* suporte a streaming com WebSocket
* múltiplos provedores de dados de mercado
* sistema de alertas para variação de preços
* dashboards com Grafana
* integração com Kafka para streaming distribuído

---

# Licença

MIT License
