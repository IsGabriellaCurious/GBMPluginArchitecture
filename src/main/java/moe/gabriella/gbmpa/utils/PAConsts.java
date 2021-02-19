package moe.gabriella.gbmpa.utils;

import moe.gabriella.gbmpa.PAPlugin;

/**
 * Contains different constants and instances for GBMPA plugins. For example, the main plugin instance!
 */
public class PAConsts {

    /**
     * The name of the plugin specified in {@link PAPlugin}'s constructor.
     */
    public static String pluginName;

    /**
     * The plugin's version specified in {@link PAPlugin}'s constructor.
     */
    public static String pluginVersion;

    /**
     * Get an instance of {@link PAPlugin} (which is the main plugin class).
     * <br> This is set during the initialization of {@link PAPlugin}.
     */
    public static PAPlugin plugin;

}
