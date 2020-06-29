plugins {
    java
}

group = "de.joemat.learning.polyglot"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}