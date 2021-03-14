plugins {
    kotlin("jvm") version "1.4.31"
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "com.baehyeonwoo.skuller"
version = "0.0.1"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/") // PaperMC
}

dependencies {
    implementation(kotlin("stdlib")) // Kotlin
    implementation("com.destroystokyo.paper:paper-api:1.13.2-R0.1-SNAPSHOT") // Paper
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    processResources {
        filesMatching("**/*.yml") {
            expand(project.properties)

        }
    }
    shadowJar {
        archiveClassifier.set("dist")
    }
    create<Copy>("dist") {
        from (shadowJar)
        into(".\\")
    }
}