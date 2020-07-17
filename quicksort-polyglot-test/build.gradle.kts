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
    implementation(project(":quicksort-polyglot-kotlin"))
    implementation(project(":quicksort-polyglot-scala"))
    implementation(project(":quicksort-polyglot-groovy"))
    implementation(project(":quicksort-polyglot-js"))
    implementation(project(":quicksort-polyglot-clojure"))
    implementation(project(":quicksort-polyglot-jruby"))

    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        showExceptions = true
        showStandardStreams = true
        events(org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED, org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED, org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED)
    }
}
