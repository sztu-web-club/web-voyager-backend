plugins {
    java
    `java-library`
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "io.github.sztuwebclub.webvoyager"
version = libs.versions.project.get()

buildscript {
    repositories {
        maven {
            setUrl("https://maven.aliyun.com/repository/gradle-plugin/")
        }
    }
}

allprojects {
    repositories {
        maven {
            setUrl("https://maven.aliyun.com/repository/public/")
        }
        maven {
            setUrl("https://maven.aliyun.com/repository/gradle-plugin/")
        }
        maven {
            setUrl("https://maven.aliyun.com/repository/central/")
        }
    }
    tasks.withType<JavaCompile> {
        options.encoding = "utf-8"
        sourceCompatibility = JavaVersion.VERSION_21.toString()
        targetCompatibility = JavaVersion.VERSION_21.toString()
    }
}

subprojects {
    apply(plugin = "java")

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }
}

tasks.jar {
    enabled = true
}