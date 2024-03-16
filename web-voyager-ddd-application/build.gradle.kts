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
    testImplementation(libs.log4j.slf4j2)

    implementation(libs.springboot.web)
    implementation(libs.lombok)
    annotationProcessor(libs.lombok)

    implementation(libs.jjwt)
    annotationProcessor(libs.jjwt)
}
