# e-commerce store :convenience_store:

Sistema de processamento de pedidos para uma loja de e-commerce com foco em concorrência e controle de acesso seguro a dados compartilhados. O sistema simula múltiplos clientes, que fazem pedidos simultâneos, e workers (threads), que processam esses pedidos. O desafio foi garantir que os pedidos sejam processados de forma eficiente e correta, evitando problemas de concorrência, como condições de corrida e inconsistência de dados.

## Grupo

- Samuel Cabral de Luna - 121210376
- Victor Vinicius Freire de Araújo - 1211110361
- Paola Kathrein Moura Marques - 121111034
- Marcos Antônio Cardoso Pereira - 121210927

## Objetivo

- [x] Gerenciar múltiplos pedidos simultâneos feitos por diferentes clientes.
- [x] Controlar o acesso ao estoque compartilhado de produtos, permitindo que múltiplos trabalhadores processem pedidos simultaneamente sem causar inconsistência nos dados.
- [x] Simular cenários de concorrência real, onde pedidos são feitos e processados de forma paralela e assíncrona.
- [x] Gerar relatórios periódicos sobre o estado do sistema, como o número de pedidos processados e o valor total das vendas.

## Como executar

```
./e_commerce_livre
```
