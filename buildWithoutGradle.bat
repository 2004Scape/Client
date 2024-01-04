@echo off
@rem Manual build script for really old JDKs

cd client
if exist build rmdir /s /q build
mkdir build

javac -encoding utf8 -d build -sourcepath src/main/java/ src/main/java/client.java

java -cp build client

cd ..
