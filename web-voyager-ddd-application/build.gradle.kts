plugins {
    `java-library`
}

group = "io.github.sztuwebclub.webvoyager"
version = rootProject.extra["projectVersion"]!!

dependencies {
    implementation(project(":web-voyager-ddd-api"))
    implementation(project(":web-voyager-ddd-domain"))
}
