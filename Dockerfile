FROM gradle:7.5.1-jdk17
WORKDIR /opt/app
COPY ./ ./
# Grant executable permissions to the Gradle Wrapper
RUN chmod +x ./gradlew
RUN ./gradlew assemble

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar build/libs/heardit-0.0.1-SNAPSHOT.jar"]