plugins {
    `java-library`
    id("org.springframework.boot")
}

group = "io.github.sztuwebclub.webvoyager"
version = rootProject.extra["projectVersion"]!!

dependencies {
    implementation(project(":web-voyager-ddd-domain"))
    implementation(project(":web-voyager-ddd-infra"))
    implementation(project(":web-voyager-ddd-api"))
    implementation(project(":web-voyager-ddd-application"))

    implementation("org.springframework.boot:spring-boot-starter-web:${rootProject.extra["spring.boot"]}")
}


tasks.bootJar {
    enabled = true
}