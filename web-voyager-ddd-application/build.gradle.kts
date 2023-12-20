plugins {
    `java-library`
}

group = "io.github.sztuwebclub.webvoyager"
version = rootProject.extra["projectVersion"]!!

dependencies {
    implementation(project(":web-voyager-ddd-api"))
    implementation(project(":web-voyager-ddd-const"))
    implementation(project(":web-voyager-ddd-domain"))

    implementation("org.apache.logging.log4j:log4j-core:2.22.0")
    testImplementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.22.0")

    implementation("org.springframework.boot:spring-boot-starter-web:${rootProject.extra["spring.boot"]}")
    implementation("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")
}
