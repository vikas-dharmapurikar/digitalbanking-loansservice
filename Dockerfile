
FROM maven

RUN apt-get install git

RUN git clone https://github.com/caprepo/digitalbanking-loansservice

RUN cd /digitalbanking-loansservice

RUN mvn -f /digitalbanking-loansservice/pom.xml clean install -DskipTests

EXPOSE 8110

ENTRYPOINT ["java", "-jar", "/digitalbanking-loansservice/target/loanservice-1.0.jar"]
