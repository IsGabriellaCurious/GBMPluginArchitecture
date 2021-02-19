package moe.gabriella.gbmpa.fixedupdater;

import moe.gabriella.gbmpa.utils.PAConsts;
import moe.gabriella.gbmpa.utils.PALogger;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class PAFURunnable extends BukkitRunnable {

    String updateType;

    public PAFURunnable(String updateType) {
        this.updateType = updateType;
        PALogger.debug("Fixed Updater '" + updateType + "' is starting.");
    }

    @Override
    public void run() {
        if (!FixedUpdater.fixedUpdaterActive(updateType)) {
            PALogger.debug("Fixed Updater '" + updateType + "' is stopping.");
            cancel();
            return;
        }

        Bukkit.getServer().getScheduler().runTask(PAConsts.plugin, () -> Bukkit.getServer().getPluginManager().callEvent(new PAFixedUpdate(updateType)));
    }
}
