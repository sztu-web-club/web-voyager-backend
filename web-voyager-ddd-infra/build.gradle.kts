plugins {
    `java-library`
}

group = "io.github.sztuwebclub.webvoyager"
version = libs.versions.project.get()

dependencies {
    implementation(project(":web-voyager-ddd-domain"))
    implementation(project(":web-voyager-ddd-const"))
    implementation(libs.mybatis.plus)
    implementation(libs.springboot.validation)
    implementation(libs.lombok)
    annotationProcessor(libs.lombok)
}
