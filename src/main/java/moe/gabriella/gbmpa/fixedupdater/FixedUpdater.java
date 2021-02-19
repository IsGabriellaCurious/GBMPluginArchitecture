package moe.gabriella.gbmpa.fixedupdater;

import moe.gabriella.gbmpa.utils.PAConsts;
import moe.gabriella.gbmpa.utils.PALogger;

import java.util.ArrayList;

/**
 * Utility class for the Fixed Updater system.
 * <br>
 * This provides methods for the creation and deleting of fixed updaters.
 */
public class FixedUpdater {

    private static ArrayList<String> activeUpdaters = new ArrayList<>();

    /**
     * Check if a certain updater name is in use (or if you know it is, check if it's active).<br>
     * This is done by checking if the activeUpdaters array contains the updater param.
     *
     * @param updater Name of the updater.
     * @return Boolean showing if the updater exists
     */
    public static boolean fixedUpdaterActive(String updater) {
        return activeUpdaters.contains(updater);
    }

    /**
     * Create a fixed updater.<br>
     * This is done by adding the updateType param to the activeUpdaters array then starting a new {@link PAFURunnable}.
     *
     * @param updateType Name of the updater.
     * @param tick How often the updater will fire (in ticks).
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
     * Cancel a fixed updater.<br>
     * This is done by removing the updateType string from the activeUpdaters array,
     * then when the runnable checks and sees the updateType isn't in the array, it will cancel itself.
     *
     * @param updateType Name of the updater.
     */
    public static void cancelFixedUpdate(String updateType) {
        if (!fixedUpdaterActive(updateType)) {
            PALogger.error("Fixed Updater does not exist : " + updateType);
            return;
        }

        activeUpdaters.remove(updateType);
    }

    /**
     * Cancels all updaters.<br>
     * This is done by clear the activeUpdaters array. For the full details see {@link #cancelFixedUpdate(String)}.
     */
    public static void cancelAllFixedUpdates() {
        PALogger.warn("All fixed updaters are shutting down. If you see this whilst the server is running, something is wrong!");
        activeUpdaters.clear();
    }

}
