plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.0.13"
}

group = "edu.bsu.cs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.slf4j:slf4j-nop:2.0.11")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.10.1")
    implementation ("net.minidev:json-smart:2.5.0")
    implementation("com.jayway.jsonpath:json-path:2.9.0")
    implementation("org.slf4j:slf4j-nop:2.0.11")

}

tasks.test {
    useJUnitPlatform()
}
javafx {
    version = "22"
    modules ("javafx.controls", "javafx.fxml")
}
application {
    mainClass.set("edu.bsu.cs.UI")
}