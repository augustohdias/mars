# Mars

[![Build Status](https://travis-ci.com/augustohdias/mars.svg?branch=master)](https://travis-ci.com/augustohdias/mars)

Este projeto simula a navegação de uma sonda em Marte. A sonda é controlada via uma API REST que permite:

- Criar uma nova sonda
- Ver informações sobre a sonda
- Mover a sonda
- Listar todas as sondas criadas

## Descrição da API

### Recupera informações de todas as sondas

`GET /mars/v1/probes`

Informações:

- Posição no eixo x
- Posição no eixo y
- Direção atual
- Número identificador

### Recupera informações de uma sonda

`GET /mars/v1/probes/{:id}`

Informações:

- Posição no eixo x
- Posição no eixo y
- Direção atual
- Número identificador

Caso a sonda não seja encontrada, retorna 404:

`404 Not Found`
```json
{
    "timestamp": "2020-10-18T05:01:57.765+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Probe not found.",
    "path": "/mars/v1/probes/1"
}
```
### Cria uma nova sonda
`POST /mars/v1/probes`
```json
{
  "probeX": 3,
  "probeY": 3,
  "limitX": 5,
  "limitY": 5,
  "facingDirection": "E"
}
```

Cria uma sonda e retorna as informações da sonda criada. 

|Parâmetro | Descrição     |
|----------|---------------|
|`probeX`|Posição inicial da sonda no eixo X.|
|`probeY`|Posição inicial da sonda no eixo Y.|
|`limitX`|Limite máximo do eixo X.|
|`limitY`|Limite máximo do eixo Y.|
|`facingDirection`|Direção inicial da sonda.|

Em caso de sucesso:

`200 OK`
```json
{
    "id": 0,
    "position": {
        "coordinate": {
            "x": 3,
            "y": 3
        },
        "facingDirection": "East"
    },
    "boundaries": {
        "x": 5,
        "y": 5
    }    
}
```

### Move uma sonda
`PATCH /mars/v1/probes/{:id}`
```json
{
    "commands": "MMRMMRMRRM"
}
```
|Parâmetro | Descrição     |
|----------|---------------|
|`commands`|Comandos a serem executados pela sonda.|

|Comando | Descrição     |
|----------|---------------|
|`L`| Gira 90 graus para a esquerda. |
|`R`| Gira 90 graus para a direita. |
|`M`| Move para a frente uma unidade. |

Caso a sonda desejada não seja encontrada, retorna 404:

`404 Not Found`
```json
{
    "timestamp": "2020-10-18T05:01:57.765+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Probe not found.",
    "path": "/mars/v1/probes/1"
}
```

Em caso de sucesso, retorna as informações do novo estado da sonda:

`200 OK`
```json
{
    "id": 0,
    "position": {
        "coordinate": {
            "x": 5,
            "y": 1
        },
        "facingDirection": "East"
    },
    "boundaries": {
        "x": 5,
        "y": 5
    }   
}
```