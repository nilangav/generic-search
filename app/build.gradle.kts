plugins {
    id("buildlogic.kotlin-application-conventions")
}

dependencies {
    implementation(project(":infra"))
    implementation(project(":search"))
}

application {
    // Define the main class for the application.
    mainClass = "org.example.app.AppKt"
}
