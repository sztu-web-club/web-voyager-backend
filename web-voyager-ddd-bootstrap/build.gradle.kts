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

    implementation("mysql:mysql-connector-java:8.0.33")
    implementation("com.alibaba:druid-spring-boot-starter:1.2.20")
    implementation("com.baomidou:mybatis-plus-boot-starter:3.5.4.1")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:${rootProject.extra["spring.boot"]}")
    implementation("org.springframework.boot:spring-boot-starter-web:${rootProject.extra["spring.boot"]}")
}


tasks.bootJar {
    enabled = true
}