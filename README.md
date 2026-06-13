# RPG Game Project

Progetto per il corso di **Modellazione e Gestione della Conoscenza** (AA 2025/26) — Matricola 129853.

## Descrizione

Piccolo gioco di ruolo a turni realizzato in Java con interfaccia grafica JavaFX. Il giocatore controlla un eroe che affronta una sequenza di nemici in combattimenti a turni, guadagnando esperienza e salendo di livello fino a raggiungere la vittoria. Il progetto segue un'architettura a strati (MVC: `controller` / `service` / `domain` / `persistence`), con persistenza della partita su file JSON.

## Esecuzione

Requisiti: JDK 25 (gestito automaticamente tramite il toolchain Gradle).

```
./gradlew build
./gradlew run
```

## Documentazione

Per i dettagli su funzionalità implementate, architettura delle classi, persistenza dei dati e meccanismi di estendibilità, vedi la [Wiki del progetto](https://github.com/FlavioPiermattei/game_project/wiki).

## Uso di Strumenti AI

Durante lo sviluppo è stato utilizzato un assistente AI (Claude Code, Anthropic) come supporto in due momenti distinti: nelle fasi iniziali per l'impostazione del progetto (struttura a package, principi SOLID, configurazione Gradle/JavaFX), e nelle fasi finali, per mancanza di tempo, per la rifinitura grafica (foglio di stile CSS e relativa applicazione alle viste FXML). Per i dettagli, vedi la pagina [Uso di Strumenti AI](https://github.com/FlavioPiermattei/game_project/wiki/Uso-Strumenti-AI) nella Wiki.
