# 2004Scape Client

Status: **Completely renamed!** There's no obfuscation or unnamed classes/methods/fields/variables left.

The TeaVM webclient is in the `webclient` branch until it can be made compatible with this new branch: see https://github.com/2004scape/Client/tree/webclient

## Project Structure

`client` - Decompiled client source code. Some class names are original.

`deob-annotations` - OpenRS2 dedobfuscator annotations library. Useful for making the namings of everything reusable if starting again from scratch or comparing to the original bytecode.

`loader` - Decompiled loader source code. Class names are all original.

`tools` - Tooling specific to the client or loader.

## Sources

Thanks to these individuals' projects for shedding light on some things - this would've taken a lot longer to complete without their efforts.

* [Dane's 317 refactor](https://github.com/thedaneeffect/RuneScape-317)
* [Dane's 186 refactor](https://github.com/thedaneeffect/RuneScape-Beta-Public)
* [James Monger's 317 refactor](https://github.com/Jameskmonger/317refactor)
