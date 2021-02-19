# gabriella.moe Plugin Architecture
My shoddy plugin architecture (im still deciding if architecture is the right word for this).

## What??
I originally had this in-mind to be a utilities maven dependency, which I'm doing just I added a custom JavaPlugin like class (i guess, but not really lol).

## Cool, but what features does it have?
These epic features are included with GBMPA (with much more planned):

### Custom Plugin class
A plugin class that should be used as a replacement for the main class extending `JavaPlugin`. It is essentially the same but sets up other stuff with GBMPA.

The main plugin class should extend `PAPlugin`. Do ***NOT*** override the methods `JavaPlugin#onEnable` and `JavaPlugin#onDisable`. You should use `PAPlugin#onPluginEnable` and `PAPlugin#onPluginDisable`.

### Logger
A basic logger that allows you to log things like error, warn, debug with colours! Done through class `PALogger` using methods such as `PALogger#info`, `PALogger#debug`, etc.

### Plugin Constants
A casual constants class that holds info such as plugin name, version and instance of the plugin class.

### Fixed Updater
Fixed Updater creates a runnable that runs every x amount of ticks, calling an event every time.

You can detect when an updater fires by listening for the event `PAFixedUpdate`. You can then identify which fixed updater is calling the event through `PAFixedUpdate#getUpdateType`.

## Installation
This is pretty simple, just follow the steps below!
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
5. Enjoy!
