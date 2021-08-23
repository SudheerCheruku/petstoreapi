FROM maven:latest
WORKDIR /tests
COPY . .
RUN mvn dependency:resolve && \
    mvn install -DskipTests -Dcucumber.report.skip=true
