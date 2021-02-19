# gabriella.moe Plugin Architecture
My shoddy plugin architecture (im still deciding if architecture is the right word for this). For development, please see from the Installation & Setup header.

## What??
I originally had this in-mind to be a utilities maven dependency, which I'm doing just I added a custom JavaPlugin like class (i guess, but not really lol).

## Cool, but what features does it have?
These epic features are included with GBMPA (with much more planned):

### Custom Plugin class
A plugin class that should be used as a replacement for the main class extending `JavaPlugin`. It is essentially the same but sets up other stuff with GBMPA.

### Logger
A basic logger that allows you to log things like error, warn, debug with colours!

### Plugin Constants
A casual constants class that holds info such as plugin name, version and instance of the plugin class.

### Fixed Updater
Fixed Updater creates a runnable that runs every x amount of ticks, calling an event every time.

### Utilities
GBMPA also comes with a bunch of helpful utilities! Proper documentation for them can be found [here](https://gabriella.moe/gbmpa-javadocs/moe/gabriella/gbmpa/utils/package-summary.html).

## Installation & Setup
A guide on using GBMPA!

### Installation
1. Download and compile the source code.
2. Build the code with maven.
3. Edit the `install.bat` file with the correct location to your maven executable and the correct jar file.
4. Add the maven dependency to your class using the following:
```
<dependency>
    <groupId>moe.gabriella</groupId>
    <artifactId>GBMPluginArchitecture</artifactId>
    <version>version</version>
</dependency>
```

### Setup
1. Do your usual project setup.
2. Once created your main class, extend `PAPlugin`.
3. Create a constructor that takes two strings, this will be your plugin name and version. (Most IDEs should do this automatically)
4. You can now override the two (de)initialization methods, which are `onPluginEnable` and `onPluginDisable`. These are like the JavaPlugin methods and are self-explanitory.
  - On the note of JavaPlugin, ***DO NOT*** extend `onEnable` or `onDisable` as this will stop critical methods within GBMPA from executing.

## Further Development
For using this further I suggest you have a read of the Javadocs, which can be found at https://gabriella.moe/gbmpa-javadocs/.
