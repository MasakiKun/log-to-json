plugins {
	id("java")
}

group = "kr.ayukawa"

configure<JavaPluginConvention> {
	sourceCompatibility = JavaVersion.VERSION_11
	targetCompatibility = JavaVersion.VERSION_11
}

repositories {
	mavenCentral()
}

dependencies {
	compile("org.slf4j:slf4j-api:1.7.26")
	compile("ch.qos.logback:logback-classic:1.2.3")
	compile("ch.qos.logback.contrib:logback-json-classic:0.1.5")
	compile("ch.qos.logback.contrib:logback-jackson:0.1.5")
	compile("com.fasterxml.jackson.core:jackson-core:2.9.8")
	compile("com.fasterxml.jackson.core:jackson-databind:2.9.8")
	compileOnly("org.projectlombok:lombok:1.18.6")
}
