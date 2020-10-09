#!/bin/sh
mvn clean package && docker build -t com.mycompany/BookStoreProject .
docker rm -f BookStoreProject || true && docker run -d -p 9080:9080 -p 9443:9443 --name BookStoreProject com.mycompany/BookStoreProject