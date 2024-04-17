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
    implementation(libs.mybatis.spring)
    implementation(libs.springboot.web)
    implementation(libs.springboot.data.redis)
    implementation(libs.springboot.data.jdbc)
    implementation(libs.springboot.security)
    implementation(libs.springboot.actuator)
    implementation(libs.curator)
    implementation(libs.log4j.core)

    runtimeOnly(libs.mysql)
    testImplementation(libs.log4j.slf4j2)
}

tasks.bootJar {
    enabled = true
}