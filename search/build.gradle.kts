plugins {
    id("buildlogic.kotlin-library-conventions")
}

dependencies {
    implementation("org.jooq:jooq:3.18.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")
    implementation("org.reactivestreams:reactive-streams:1.0.4")

    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.9.1")
}
