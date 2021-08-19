# Version 0.1
FROM openjdk:11
LABEL maintainer="root2z"

COPY /target/MyBlog.jar ./

EXPOSE 9090

ENTRYPOINT ["java","-jar","/MyBlog.jar"]
