FROM --platform=linux/arm64 openjdk:11 AS build


COPY pom.xml mvnw ./
COPY . .

RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package


FROM --platform=linux/arm64 openjdk:11
WORKDIR account
COPY --from=build target/*.jar account.jar
ENTRYPOINT ["java", "-jar", "account.jar"]