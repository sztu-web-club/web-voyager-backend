plugins {
    `java-library`
}

group = "io.github.sztuwebclub.webvoyager"
version = libs.versions.project.get()

dependencies {
    implementation(project(":web-voyager-ddd-api"))
    implementation(project(":web-voyager-ddd-const"))
    implementation(project(":web-voyager-ddd-domain"))

    implementation(libs.log4j.core)
    implementation(libs.springboot.web)
    implementation(libs.lombok)
    implementation(libs.jjwt)

    testImplementation(libs.log4j.slf4j2)

    annotationProcessor(libs.lombok)
    annotationProcessor(libs.jjwt)
}
