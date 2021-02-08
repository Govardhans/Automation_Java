FROM govardhansanap/java-maven

WORKDIR '/app'
COPY config config
COPY src src
COPY pom.xml pom.xml