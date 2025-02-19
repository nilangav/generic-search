plugins {
    id("buildlogic.kotlin-library-conventions")
}

dependencies {
    compileOnly("org.jooq:jooq")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")
}
