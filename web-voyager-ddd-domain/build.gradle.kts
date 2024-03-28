plugins {
    `java-library`
}

group = "io.github.sztuwebclub.webvoyager"
version = libs.versions.project.get()

dependencies {
    implementation(project(":web-voyager-ddd-const"))
    implementation(libs.springboot.web)
    implementation(libs.mybatis.plus)
    implementation(libs.jakarta)
    implementation(libs.lombok)
    annotationProcessor(libs.lombok)
}
