package moe.gabriella.gbmpa;

import moe.gabriella.gbmpa.fixedupdater.FixedUpdater;
import moe.gabriella.gbmpa.utils.PAConsts;
import moe.gabriella.gbmpa.utils.PALogger;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Custom Java Plugin Implementation.<br>
 * This will setup other GMBPA features such as the consts and logger.
 */
public abstract class PAPlugin extends JavaPlugin {

    /**
     * Constructor for the class. This is so the plugin's name and version can be stored,
     * along with an instance of the class for the rest of the plugin to use.
     * <br><br>This information is only used internally.
     *
     * @param pluginName Name of your plugin
     * @param pluginVersion Version of your plugin
     */
    public PAPlugin(String pluginName, String pluginVersion) {
        PAConsts.plugin = this;
        PAConsts.pluginName = pluginName;
        PAConsts.pluginVersion = pluginVersion;
    }

    /**
     * Put your onEnable code here. Runs during the JavaPlugin#onEnable method.
     */
    public void onPluginEnable() { }

    /**
     * Put your onDisable code here. Runs during the JavaPlugin#onDisable method.
     */
    public void onPluginDisable() { }

    /**
     * Handles the setting up of a GBMPA plugin. <b>DO NOT OVERRIDE THIS METHOD!</b>
     */
    @Override
    public void onEnable() {
        PALogger.info("Loading GBMPA plugin " + PAConsts.pluginName + " at version " + PAConsts.pluginVersion);
        onPluginEnable();
        PALogger.info("Loading complete!");
    }

    /**
     * Handles the shutting down up of a GBMPA plugin. <b>DO NOT OVERRIDE THIS METHOD!</b>
     */
    @Override
    public void onDisable() {
        PALogger.info("Disabling GBMPA plugin " + PAConsts.pluginName + " at version " + PAConsts.pluginVersion);
        FixedUpdater.cancelAllFixedUpdates();
        onPluginDisable();
    }
}
