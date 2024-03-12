plugins {
    `java-library`
}

group = "io.github.sztuwebclub.webvoyager"
version = libs.versions.project.get()

dependencies {
    implementation(libs.lombok)
    annotationProcessor(libs.lombok)
}
