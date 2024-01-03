plugins {
    java
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.register("sig", JavaExec::class) {
    mainClass = "lostcity.tools.LoaderSig"
    classpath = sourceSets["main"].runtimeClasspath
    workingDir = rootProject.projectDir
    args = listOf("client/build/libs/client.jar")
}
