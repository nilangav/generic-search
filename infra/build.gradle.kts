import org.jooq.codegen.GenerationTool
import org.jooq.meta.jaxb.*
import org.jooq.meta.jaxb.Configuration
import org.jooq.meta.jaxb.Target

plugins {
    id("buildlogic.kotlin-library-conventions")

    id("org.springframework.boot") version "3.0.7"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
}

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jooq:jooq-codegen:3.18.0")
        classpath("org.postgresql:postgresql:42.5.1")
    }
}

dependencies {
    repositories {
        mavenCentral()
    }

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    compileOnly("org.jooq:jooq")
    compileOnly("org.jooq:jooq-codegen:3.18.0")
}

tasks.register("generate") {
    doLast {
        GenerationTool.generate(
            Configuration()
                .withJdbc(
                    Jdbc()
                        .withDriver("org.postgresql.Driver")
                        .withUrl("jdbc:postgresql://localhost:1234/postgres")
                        .withUser("postgres")
                        .withPassword("password"),
                ).withGenerator(
                    Generator()
                        .withName("org.jooq.codegen.KotlinGenerator")
                        .withDatabase(
                            Database()
                                .withSchemata(
                                    SchemaMappingType().withInputSchema("pharmacy"),
                                ).withIncludes("medication"),
                        ).withGenerate(
                            Generate()
                                .withPojos(true)
                                .withPojosAsKotlinDataClasses(true)
                                .withFluentSetters(true)
                                .withJooqVersionReference(false),
                        ).withTarget(
                            Target()
                                .withPackageName("org.example.infra.jooq")
                                .withDirectory("$projectDir/src/main/kotlin"),
                        ),
                ),
        )
    }
}

tasks.named("build") {
    dependsOn("generate")
}