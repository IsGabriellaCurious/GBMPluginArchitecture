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

### Fixed Updater
Fixed Updater creates a runnable that runs every x amount of ticks, calling an event every time.

By listening for the event `PAFixedUpdate`. You can then identify which fixed updater is calling the event through `PAFixedUpdate#getUpdateType`.
