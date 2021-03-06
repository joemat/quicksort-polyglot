plugins {
    java
}

group = "de.joemat.learning.polyglot"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.mozilla:rhino:1.7.12")
    implementation(project(":quicksort-polyglot-api"))
    implementation(project(":quicksort-polyglot-scripted-factory"))
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

