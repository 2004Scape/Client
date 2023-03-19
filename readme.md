# RS2-225

This is my latest client refactor, naming based off Dane's 317/186, official terminologies, and my own work.  
It's configured to connect to Lost City's World 2 out of the box, and has a functional webclient.  

It exists because my last code needed some serious overhauls, this time I touched as little as possible before starting any changes. I kept noticing small regressions that I would have to fix.

## How do I build it?

Run `./mvnw package` to build.  
To run the Java client, run `java -jar client/target/client-1.0.jar 10 0 highmem members`.  
To run the webclient, start a web server in the webclient folder (e.g. `npx http-server` or `python3 -m http.server`)

The main class name is `rs2.Game` if you use an IDE.
