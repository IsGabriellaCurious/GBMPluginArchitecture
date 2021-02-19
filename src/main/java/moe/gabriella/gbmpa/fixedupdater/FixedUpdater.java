package moe.gabriella.gbmpa.fixedupdater;

import moe.gabriella.gbmpa.utils.PAConsts;
import moe.gabriella.gbmpa.utils.PALogger;

import java.util.ArrayList;

public class FixedUpdater {

    private static ArrayList<String> activeUpdaters = new ArrayList<>();

    /**
     * Check if a certain updater name is in use (or if you know it is, check if it's active)
     *
     * @param updater Name of the updater
     * @return If the updater exists
     */
    public static boolean fixedUpdaterActive(String updater) {
        return activeUpdaters.contains(updater);
    }

    /**
     * Create a fixed updater
     *
     * @param updateType Name of the updater
     * @param tick How often the updater will fire (in ticks)
     */
    public static void createFixedUpdate(String updateType, int tick) {
        if (fixedUpdaterActive(updateType)) {
            PALogger.error("Fixed Updater already exists : " + updateType);
            return;
        }

        if (tick < 1) {
            PALogger.error("Requested fixed updater ('" + updateType + "') passed an invalid tick : " + tick);
            return;
        }

        activeUpdaters.add(updateType);
        new PAFURunnable(updateType).runTaskTimerAsynchronously(PAConsts.plugin, 0, tick);
    }

    /**
     * Cancel a fixed updater
     *
     * @param updateType Name of the updater
     */
    public static void cancelFixedUpdate(String updateType) {
        if (!fixedUpdaterActive(updateType)) {
            PALogger.error("Fixed Updater does not exist : " + updateType);
            return;
        }

        activeUpdaters.remove(updateType);
    }

    /**
     * Cancels all updaters
     */
    public static void cancelAllFixedUpdates() {
        PALogger.warn("All fixed updaters are shutting down. If you see this whilst the server is running, something is wrong!");
        activeUpdaters.clear();
    }

}
