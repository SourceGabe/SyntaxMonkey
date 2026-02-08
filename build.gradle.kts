plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.hexworks.zircon:zircon.core-jvm:2020.2.0-RELEASE")
    implementation("org.hexworks.zircon:zircon.jvm.swing:2020.2.0-RELEASE")
}

tasks.test {
    useJUnitPlatform()
}