FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim
EXPOSE 8080
COPY build/libs/*.jar beanstalk-app.jar
CMD java  -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -noverify ${JAVA_OPTS} -jar beanstalk-app.jar