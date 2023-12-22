plugins {
    `java-library`
}

group = "io.github.sztuwebclub.webvoyager"
version = rootProject.extra["projectVersion"]!!

dependencies {
    implementation(project(":web-voyager-ddd-domain"))
    implementation("com.baomidou:mybatis-plus-boot-starter:3.5.4.1")
    implementation("org.projectlombok:lombok:${rootProject.extra["lombok"]}")
    implementation("org.springframework.boot:spring-boot-starter-validation:${rootProject.extra["spring.boot"]}")
    annotationProcessor("org.projectlombok:lombok:${rootProject.extra["lombok"]}")
}
