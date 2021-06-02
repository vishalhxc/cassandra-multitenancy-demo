group = "io.vishalhxc"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_16

repositories { mavenCentral() }

plugins {
	java
	id("org.springframework.boot") version "2.5.0"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

dependencies {
	fun versionOf(name: String) = properties["dependency.version.$name"].toString()
	implementation("org.springframework.boot:spring-boot-starter-data-cassandra")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.datastax.oss:java-driver-core:${versionOf("datastax-jdbc")}")
	implementation("com.datastax.oss:java-driver-mapper-runtime:${versionOf("datastax-jdbc")}")
	implementation("com.datastax.oss:java-driver-query-builder:${versionOf("datastax-jdbc")}")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> { useJUnitPlatform() }