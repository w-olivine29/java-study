plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("org.assertj:assertj-core:3.26.3") // 테스트 코드를 위한 의존성 추가
    testImplementation("net.datafaker:datafaker:2.4.2") // 테스트 위한 픽스쳐 세팅 위함
}

tasks.test {
    useJUnitPlatform()
}