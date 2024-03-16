plugins {
    `java-library`
    id("org.springframework.boot")
}

group = "io.github.sztuwebclub.webvoyager"
version = libs.versions.project.get()

dependencies {
    implementation(project(":web-voyager-ddd-domain"))
    implementation(project(":web-voyager-ddd-infra"))
    implementation(project(":web-voyager-ddd-api"))
    implementation(project(":web-voyager-ddd-application"))

    implementation(libs.alibaba.druid)
    implementation(libs.mybatis.plus)
    implementation(libs.springboot.web)
    implementation(libs.springboot.data.redis)
    implementation(libs.springboot.data.jdbc)
    implementation(libs.springboot.security)
    implementation(libs.springboot.actuator)

    runtimeOnly(libs.mysql)
    developmentOnly(libs.springboot.compose)
}

tasks.bootJar {
    enabled = true
}