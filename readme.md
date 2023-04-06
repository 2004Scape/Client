# RS2-225

note: Class/package names have been seriously overhauled lately, and is still in progress. This may seem like a regression in readability and understanding. The goal is to replicate the original client as closely as possible.  

Naming tries to come from official resources that could be found publicly. Then I fall back to making up names that makes sense relative to the others.

## How do I run this?

Run `./mvnw package` to build.  
To run the Java client, run `java -jar client/target/client-1.0.jar 10 0 highmem members`.  
To run the webclient, start a web server in the webclient folder (e.g. `npx http-server` or `python3 -m http.server`)

The main class name is `jagex2.client.client` if you use an IDE.
