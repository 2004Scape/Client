plugins {
    java
    application
}

dependencies {
    compileOnly(project(":deob-annotations"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_5
}

application {
    mainClass = "client"
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Jar> {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
