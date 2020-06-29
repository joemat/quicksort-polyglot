plugins {
    java
}

group = "de.joemat.learning.polyglot"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":quicksort-polyglot-api"))
    implementation(project(":quicksort-polyglot-java"))
}
configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

