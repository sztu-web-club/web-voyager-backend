plugins {
    java
    `java-library`
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
}

extra["projectVersion"] = "0.0.1-SNAPSHOT"
extra["spring.boot"] = "3.2.0"
extra["lombok"] = "1.18.28"

group = "io.github.sztuwebclub.webvoyager"
version = extra["projectVersion"]!!

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
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
    }
}

subprojects {
    apply(plugin = "java")

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.BIN
    distributionUrl = "https://mirrors.cloud.tencent.com/gradle/gradle-8.4-bin.zip"
}