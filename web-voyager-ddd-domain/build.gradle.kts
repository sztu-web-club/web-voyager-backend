plugins {
    `java-library`
}

group = "io.github.sztuwebclub.webvoyager"
version = rootProject.extra["projectVersion"]!!


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:${rootProject.extra["spring.boot"]}")
    implementation("jakarta.annotation:jakarta.annotation-api:2.1.1")
    implementation("org.projectlombok:lombok:${rootProject.extra["lombok"]}")
    annotationProcessor("org.projectlombok:lombok:${rootProject.extra["lombok"]}")
}
