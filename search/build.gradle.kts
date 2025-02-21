plugins {
    id("buildlogic.kotlin-library-conventions")
}

dependencies {
    implementation("org.jooq:jooq")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")
    implementation("org.reactivestreams:reactive-streams:1.0.4")
}
