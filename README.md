<div align="center">

<h1>2004Scape Client - May 18, 2004</h1>

[Website](https://2004scape.org) | [Discord](https://discord.2004scape.org) | [Rune-Server](https://www.rune-server.ee/runescape-development/rs2-server/projects/701698-lost-city-225-emulation.html)

**status: completely refactored**

**The client code was decompiled, deobfuscated, and refactored by us.**  
**Jagex has never had any source code leaks.**
</div>

## Project Structure

`client` - Decompiled client source code.

`runetek3` - Decompiled client engine source code. Some class names are original.

`deob-annotations` - OpenRS2 dedobfuscator annotations library. Useful for making the namings of everything reusable if starting again from scratch or comparing to the original bytecode.

`loader` - Decompiled loader source code. Class names are all original.

`mapview` - Decompiled mapview source code.

`tools` - Tooling specific to the client or loader.

## Sources

Thanks to these individuals' projects for shedding light on some things - this would've taken a lot longer to complete without their efforts.

* [Dane's 317 refactor](https://github.com/thedaneeffect/RuneScape-317)
* [Dane's 186 refactor](https://github.com/thedaneeffect/RuneScape-Beta-Public)
* [James Monger's 317 refactor](https://github.com/Jameskmonger/317refactor)

## Running

Because there are multiple entry points, instead of `gradle run` you have to execute `gradle client:run` or `gradle mapview:run` else it will launch both sequentially.
