#!/bin/sh
mvn clean package && docker build -t com.nabenik/home-ee .
docker rm -f home-ee || true && docker run -d -p 8080:8080 -p 4848:4848 --name home-ee com.nabenik/home-ee 
