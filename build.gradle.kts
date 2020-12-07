plugins {
    kotlin("jvm") version "1.4.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

application {
    mainClass.set("org.example.demo.MainKt")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    jar {
        // Specify the main class
        manifest {
            attributes["Main-Class"] = "org.example.demo.MainKt"
        }
    }
}