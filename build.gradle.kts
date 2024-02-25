import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id 'java'
    id 'org.springframework.boot' version '3.2.3'
    id 'io.spring.dependency-management' version '1.1.4'
    id 'org.hibernate.orm' version '6.4.4.Final'
    id 'org.graalvm.buildtools.native' version '0.9.28'
    id 'org.jetbrains.kotlin.jvm' version '1.9.22'
    id 'org.jetbrains.kotlin.plugin.spring' version '1.9.22'
    id 'org.jetbrains.kotlin.plugin.jpa' version '1.9.22'
}

group = 'org.safa'
version = '0.0.1-SNAPSHOT'

java {
    sourceCompatibility = '21'
}

configurations {
    compileOnly {
        extendsFrom annotationProcessor
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'com.fasterxml.jackson.module:jackson-module-kotlin'
    implementation 'org.jetbrains.kotlin:kotlin-reflect'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    developmentOnly 'org.springframework.boot:spring-boot-docker-compose'
    annotationProcessor 'org.springframework.boot:spring-boot-configuration-processor'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'org.springframework.boot:spring-boot-testcontainers'
    testImplementation 'org.testcontainers:junit-jupiter'
}

tasks.withType(KotlinCompile) {
    kotlinOptions {
        freeCompilerArgs += '-Xjsr305=strict'
        jvmTarget = '21'
    }
}

tasks.named('test') {
    useJUnitPlatform()
}

tasks.withType(BootJar) {
    archiveFileName = "app.jar"
}

hibernate {
    enhancement {
        enableAssociationManagement = true
    }
}

