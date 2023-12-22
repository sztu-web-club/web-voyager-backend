plugins {
    `java-library`
}

group = "io.github.sztuwebclub.webvoyager"
version = rootProject.extra["projectVersion"]!!


dependencies {
    implementation(project(":web-voyager-ddd-domain"))
    implementation("org.projectlombok:lombok:${rootProject.extra["lombok"]}")
    annotationProcessor("org.projectlombok:lombok:${rootProject.extra["lombok"]}")
}
