plugins {
    java
    id("java-library")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_5
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
