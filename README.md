# Realm of Eldoria 🏰

## Descrição 📜

**Realm of Eldoria** é um jogo de RPG baseado em texto onde os jogadores podem escolher um personagem, equipar armas, lutar contra inimigos, e usar itens para sobreviver e progredir na aventura. O jogo oferece uma variedade de inimigos, itens, e armas, criando uma experiência dinâmica e envolvente para os jogadores.

## Funcionalidades 🌟

- 🗡️ Escolha de personagem
- 🛡️ Equipamento de armas
- ⚔️ Sistema de batalha contra inimigos
- 🧪 Uso de itens para curar, melhorar habilidades ou causar dano
- 📜 Menu principal para navegar entre as opções do jogo

## Estrutura do Projeto 📁

O projeto está organizado da seguinte forma:
```plaintext
src
├── entities
│   ├── BattleEntity.java
│   ├── Enemy.java
│   ├── Player.java
│   ├── Skeleton.java
│   ├── Slime.java
│   └── Zombie.java
├── game
│   ├── Limited_Objs.java
│   └── Play.java
├── items
│   ├── DamagingI.java
│   ├── HealingI.java
│   ├── Item.java
│   └── StatusI.java
├── moves
│   ├── DamagingM.java
│   ├── HealingM.java
│   ├── Move.java
│   └── StatusM.java
├── statuses
│   ├── Buff.java
│   ├── Debuff.java
│   ├── DoT.java
│   ├── Status.java
│   └── StatusType.java
└── weapons
    ├── Claymore.java
    ├── Spear.java
    ├── Sword.java
    └── Weapon.java
```
## Como Jogar 🎮
1. Clone este repositório para a sua máquina local;
2. Navegue até o diretório do projeto;
3. Compile os arquivos Java;
4. Execute o jogo.

Ao iniciar o jogo, você será solicitado a inserir seu nome. Escolha uma arma para começar sua aventura. Use o menu principal para entrar em batalhas, verificar suas estatísticas, ou sair do jogo. Durante a batalha, você pode atacar, verificar suas estatísticas, verificar as estatísticas do inimigo, usar itens do seu inventário ou tentar fugir.

## Requisitos 💻
- Java 8 ou superior
- Um terminal ou prompt de comando

## Contribuição 🤝
Se você quiser contribuir para o desenvolvimento deste jogo, por favor, siga os passos abaixo:
- Faça um fork deste repositório;
- Crie uma nova branch;
- Faça suas modificações e commit;
- Envie para o repositório remoto;
- Abra um Pull Request.
