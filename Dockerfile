FROM openjdk:16
COPY . /usr/src/techs
WORKDIR /usr/src/techs
CMD ./gradlew --no-daemon run