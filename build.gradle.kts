plugins {
    kotlin("jvm") version "1.4.0"
    application

    // Shadow Plugin (to generate a Fat JAR)
    id("com.github.johnrengelman.shadow") version "6.1.0"

    // ktlint Plugin
    id("org.jlleitschuh.gradle.ktlint") version "9.4.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"
repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

application {
    mainClassName = "org.example.demo.MainKt"
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    test {
        useJUnitPlatform() // Enable JUnit 5 support of Gradle
    }
}
