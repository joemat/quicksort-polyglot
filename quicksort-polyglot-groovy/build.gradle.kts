plugins {
    java
    groovy
}

group = "de.joemat.learning.polyglot"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation("org.codehaus.groovy:groovy-all:3.0.3")
    implementation(project(":quicksort-polyglot-api"))
}