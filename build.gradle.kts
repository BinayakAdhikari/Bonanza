plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("junit:junit:4.13.1")
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("io.bibucket.plt:bohnanza-gui:0.0.1-SNAPSHOT")
    implementation("org.eclipse.platform:org.eclipse.swt.win32.win32.x86_64:3.105.3")
}

configurations.all {
    resolutionStrategy {
        eachDependency {
            if (requested.name.contains("\${osgi.platform}")) {
                useTarget(requested.toString().replace("\${osgi.platform}", "cocoa.macosx.x86_64"))
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}