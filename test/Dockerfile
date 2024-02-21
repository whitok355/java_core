FROM openjdk:latest
WORKDIR /usr/src/app
COPY ./src .
RUN javac -sourcepath . -d out ./ja/Main.java
WORKDIR /usr/src/app/out
ENTRYPOINT ["java", "ja.Main"]