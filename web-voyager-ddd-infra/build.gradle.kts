plugins {
    `java-library`
}

group = "io.github.sztuwebclub.webvoyager"
version = libs.versions.project.get()

dependencies {
    implementation(project(":web-voyager-ddd-domain"))
    implementation(libs.mybatis.plus)
    implementation(libs.springboot.validation)
    implementation(libs.lombok)
    annotationProcessor(libs.lombok)

    dependencies {
        implementation("org.mybatis:mybatis-spring:3.0.3")
    }
}
