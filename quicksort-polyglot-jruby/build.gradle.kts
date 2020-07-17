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
    implementation("org.jruby:jruby:9.2.12.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

