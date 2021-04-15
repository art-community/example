plugins {
    id("java-generator")
}

val lombokVersion: String by project

dependencies {
    implementation("io.art.java:core:main")
    implementation("io.art.java:scheduler:main")
    implementation("io.art.java:configurator:main")
    implementation("io.art.java:server:main")
    implementation("io.art.java:communicator:main")
    implementation("io.art.java:value:main")
    implementation("io.art.java:logging:main")
    implementation("io.art.java:launcher:main")
    implementation("io.art.java:model:main")
    implementation("io.art.java:xml:main")
    implementation("io.art.java:rsocket:main")
    implementation("io.art.java:json:main")
    implementation("io.art.java:protobuf:main")
    implementation("io.art.java:message-pack:main")
    implementation("io.art.java:yaml:main")
    implementation("io.art.java:graal:main")
    implementation("io.art.java:http:main")
    implementation("io.art.java:tarantool:main")
    implementation("io.art.java:storage:main")

    compileOnly("org.projectlombok", "lombok", lombokVersion)
    annotationProcessor("io.art.generator:language-java:main")
    annotationProcessor("org.projectlombok", "lombok", lombokVersion)
}
