plugins {
    id("java")
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "it.unicam"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

javafx {
    version = "25"
    modules("javafx.controls", "javafx.fxml")
}

application {
    mainClass.set("it.unicam.gioco.MainApplication")
}