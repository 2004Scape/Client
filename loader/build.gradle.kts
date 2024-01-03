plugins {
    java
}

dependencies {
    compileOnly(project(":deob-annotations"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_5
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
