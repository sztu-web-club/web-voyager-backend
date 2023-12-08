plugins {
    `java-library`
}

group = "io.github.sztuwebclub.webvoyager"
version = rootProject.extra["projectVersion"]!!


dependencies {
    testImplementation(project(":web-voyager-ddd-infra"))
}
