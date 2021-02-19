package moe.gabriella.gbmpa.fixedupdater;

import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Event class that fires for the fixed updates. Listen for this class when you want to know when a fixed updater fires.
 */
public class PAFixedUpdate extends Event {

    private static final HandlerList handlers = new HandlerList();

    private String updateType;

    public PAFixedUpdate(String updateType) {
        this.updateType = updateType;
    }

    @Override public HandlerList getHandlers() { return handlers; }
    public static HandlerList getHandlerList() { return handlers; }

    /**
     * Get the update type that called the event.
     *
     * @return The name of the fixed updater.
     */
    public String getUpdateType() { return updateType; }

}
