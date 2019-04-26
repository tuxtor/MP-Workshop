#!/bin/sh
mvn clean package && docker build -t com.nabenik/hello-ee .
docker rm -f hello-ee || true && docker run -d -p 8080:8080 -p 4848:4848 --name hello-ee com.nabenik/hello-ee 
