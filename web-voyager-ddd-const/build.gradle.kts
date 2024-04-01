plugins {
    `java-library`
}

group = "io.github.sztuwebclub.webvoyager"
version = libs.versions.project.get()

dependencies {
    implementation(libs.lombok)
    implementation(libs.jjwt)
    implementation(libs.springboot.security)

    annotationProcessor(libs.lombok)
    annotationProcessor(libs.jjwt)
}
