plugins {
    `java-library`
}

group = "io.github.sztuwebclub.webvoyager"
version = libs.versions.project.get()

dependencies {
    implementation(libs.lombok)
    implementation(libs.jjwt)

    annotationProcessor(libs.lombok)
    annotationProcessor(libs.jjwt)
}
