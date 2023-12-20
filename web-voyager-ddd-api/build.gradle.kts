plugins {
    `java-library`
}

group = "io.github.sztuwebclub.webvoyager"
version = rootProject.extra["projectVersion"]!!


dependencies {
    implementation(project(":web-voyager-ddd-domain"))
    implementation("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")
}
