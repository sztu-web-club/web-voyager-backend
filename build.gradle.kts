plugins {
    java
    `java-library`
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
}

val projectVersion = "0.0.1-SNAPSHOT"

extra["projectVersion"] = projectVersion
extra["spring.boot"] = "3.2.0"

group = "io.github.sztuwebclub.webvoyager"
version = extra["projectVersion"]!!


allprojects {
    repositories {
        maven {
            setUrl("https://maven.aliyun.com/repository/public/")
        }
        maven {
            setUrl("https://maven.aliyun.com/repository/spring/")
        }
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }
}

allprojects {
    tasks.withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
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