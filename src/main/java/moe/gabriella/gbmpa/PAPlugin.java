package moe.gabriella.gbmpa;

import moe.gabriella.gbmpa.fixedupdater.FixedUpdater;
import moe.gabriella.gbmpa.utils.PAConsts;
import moe.gabriella.gbmpa.utils.PALogger;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class PAPlugin extends JavaPlugin {

    public PAPlugin(String pluginName, String pluginVersion) {
        PAConsts.plugin = this;
        PAConsts.pluginName = pluginName;
        PAConsts.pluginVersion = pluginVersion;
    }

    public void onPluginEnable() { }
    public void onPluginDisable() { }

    @Override
    public void onEnable() {
        PALogger.info("Loading GBMPA plugin " + PAConsts.pluginName + " at version " + PAConsts.pluginVersion);
        onPluginEnable();
        PALogger.info("Loading complete!");
    }

    @Override
    public void onDisable() {
        PALogger.info("Disabling GBMPA plugin " + PAConsts.pluginName + " at version " + PAConsts.pluginVersion);
        FixedUpdater.cancelAllFixedUpdates();
        onPluginDisable();
    }
}
