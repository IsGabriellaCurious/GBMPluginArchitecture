package moe.gabriella.gbmpa.fixedupdater;

import moe.gabriella.gbmpa.PAPlugin;
import moe.gabriella.gbmpa.utils.PAConsts;
import moe.gabriella.gbmpa.utils.PALogger;

import java.util.ArrayList;

public class FixedUpdater {

    private static ArrayList<String> activeUpdaters = new ArrayList<>();

    public static boolean fixedUpdaterActive(String updater) {
        return activeUpdaters.contains(updater);
    }

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

    public static void cancelFixedUpdate(String updateType) {
        if (!fixedUpdaterActive(updateType)) {
            PALogger.error("Fixed Updater does not exist : " + updateType);
            return;
        }

        activeUpdaters.remove(updateType);
    }

    public static void cancelAllFixedUpdates() {
        PALogger.warn("All fixed updates are shutting down. If you see this whilst the server is running, something is wrong!");
        activeUpdaters.clear();
    }

}
