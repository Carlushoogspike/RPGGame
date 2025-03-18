plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.4.4"
    id("io.micronaut.aot") version "4.4.4"
    kotlin("jvm")
}


version = "0.1"
group = "net.bytes.projects.rpgmicro"

repositories {
    mavenCentral()
}

dependencies {
    /*
       Project
     */
    implementation(project(":rpg-core"))

    /*
        Micro Service
     */
    annotationProcessor("io.micronaut.data:micronaut-data-document-processor")
    annotationProcessor("io.micronaut:micronaut-http-validation")
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    implementation("com.fasterxml.jackson.core:jackson-core:2.12.3")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.3")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.12.3")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.4.0")
    implementation("com.github.ben-manes.caffeine:caffeine:3.1.3")
    implementation("io.micronaut.serde:micronaut-serde-jackson")

    implementation("io.micronaut.data:micronaut-data-mongodb")
    implementation("io.micronaut.data:micronaut-data-runtime")
    implementation("org.mongodb:mongodb-driver-sync")

    implementation("io.lettuce:lettuce-core:6.4.0.RELEASE")
    implementation("io.micronaut.nats:micronaut-nats")

    compileOnly("io.micronaut:micronaut-http-client")
    compileOnly("org.projectlombok:lombok:1.18.30")
    runtimeOnly("org.mongodb:mongodb-driver-sync")

    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("org.yaml:snakeyaml")

    testCompileOnly("org.projectlombok:lombok:1.18.30")
    testImplementation("io.micronaut:micronaut-http-client")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
    implementation(kotlin("stdlib-jdk8"))
}


application {
    mainClass = "net.bytes.projects.rpgmicro.Application"
}
java {
}


graalvmNative.toolchainDetection = false

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("net.bytes.projects.rpgmicro.*")
    }
    aot {
        // Please review carefully the optimizations enabled below
        // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
        optimizeServiceLoading = false
        convertYamlToJava = false
        precomputeOperations = true
        cacheEnvironment = true
        optimizeClassLoading = true
        deduceEnvironment = true
        optimizeNetty = true
        replaceLogbackXml = true
    }
}


tasks.named<io.micronaut.gradle.docker.NativeImageDockerfile>("dockerfileNative") {
    jdkVersion = "21"
}

tasks {
    shadowJar {
        mergeServiceFiles()

        archiveFileName.set("rpg-executor.jar")
    }
}
kotlin {
    jvmToolchain(21)
}