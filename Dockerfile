FROM eclipse-temurin:20.0.1_9-jre as builder
WORKDIR extracted
ADD target/*.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM eclipse-temurin:20.0.1_9-jre
WORKDIR application
COPY --from=builder extracted/dependencies/ ./
COPY --from=builder extracted/spring-boot-loader/ ./
COPY --from=builder extracted/snapshot-dependencies/ ./
COPY --from=builder extracted/application/ ./
EXPOSE 8085
ENTRYPOINT ["java", "-Dspring.config.location=./BOOT-INF/classes/application-docker.properties", "org.springframework.boot.loader.JarLauncher"]