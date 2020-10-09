@echo off
call mvn clean package
call docker build -t com.mycompany/BookStoreProject .
call docker rm -f BookStoreProject
call docker run -d -p 9080:9080 -p 9443:9443 --name BookStoreProject com.mycompany/BookStoreProject