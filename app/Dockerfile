FROM openjdk:17-jdk

# the fat jar you built with spring-boot-maven-plugin
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app.jar

# the OTEL agent
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar /agent.jar

# JSON array form: entire array on one line
ENTRYPOINT ["java", "-Dotel.exporter.otlp.endpoint=http://tempo:4318/v1/traces", "-javaagent:/agent.jar", "-jar", "/app.jar"]