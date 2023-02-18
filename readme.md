# RS2-225

## What is this branch?

This is my latest client refactor, naming based off Dane's 317/186, official terminologies, and my own work.  
It's configured to connect to Lost City's World 2 out of the box, and has a functional webclient.  

It exists because my last code needed some serious overhauls, this time I touched as little as possible before starting any changes. I kept noticing small regressions that I would have to fix.

## How do I build it?

Run `./mvnw package` to build.  
To run the Java client, run `java -jar client/target/client-1.0.jar 10 0 highmem members`.  
To run the webclient, start a web server in the webclient folder (e.g. `npx http-server` or `python3 -m http.server`)

The main class name is `rs2.Game` if you use an IDE.

## What about the other branches?

- offline: The publicly downloadable connect-and-run-around version people seemed to like. No server scripts, this is just enough to log in, play music, and download maps.
- 2022-main: The original client code I worked on. Output is based off MoparV11's deobfuscator.
- 2022-deob: My first attempt at deobfuscating using OpenRS2.
- 2023-main: My second attempt at deobfuscating using OpenRS2, and with a functional webclient. I did a few tricks to get things working that I didn't actually need to do in this branch.
