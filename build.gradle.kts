import org.apache.tools.ant.taskdefs.condition.Os

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

val installGitHook = tasks.register("installGitHooks", Copy::class) {
    group = "Git Hook"
    description = "copy git hook to .git"
    from(project.rootDir.resolve("scripts/pre-commit"))
    into(project.rootDir.resolve(".git/hooks"))
    fileMode = 775
}

tasks.getByName("prepareKotlinBuildScriptModel").dependsOn(installGitHook)

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}
