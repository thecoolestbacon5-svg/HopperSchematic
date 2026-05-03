plugins {
	id 'fabric-loom' version '1.6.+'
	id 'maven-publish'
}

sourceCompatibility = JavaVersion.VERSION_21
targetCompatibility = JavaVersion.VERSION_21

archivesBaseName = project.archives_base_name
version = project.mod_version
group = project.maven_group

repositories {
	mavenCentral()
	maven { url "https://maven.terraformersmc.com/releases" }
	maven { url "https://masa.dy.fi/maven" }
}

dependencies {
	minecraft "com.mojang:minecraft:${project.minecraft_version}"
	mappings loom.officialMojangMappings()
	modImplementation "net.fabricmc:fabric-loader:${project.loader_version}"
	modImplementation "net.fabricmc.fabric-api:fabric-api:${project.fabric_version}"
}

tasks.withType(JavaCompile).configureEach {
	it.options.release = 21
}

jar {
	from "LICENSE" 
	manifest {
		attributes(
			"Specification-Title": "Hopper Schematic",
			"Specification-Version": "1",
			"Implementation-Title": project.name,
			"Implementation-Version": project.version,
			"Implementation-Vendor": project.maven_group,
			"Timestamp": System.currentTimeMillis()
		)
	}
}

publishing {
	publications {
		mavenJava(MavenPublication) {
			from components.java
		}
	}
	repositories {
		local {
			url = uri('file://' + file("$projectDir/../maven").absolutePath)
		}
	}
}
