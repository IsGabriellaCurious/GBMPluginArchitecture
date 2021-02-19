package moe.gabriella.gbmpa.fixedupdater;

import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PAFixedUpdate extends Event {

    private static final HandlerList handlers = new HandlerList();

    @Getter private String updateType;

    public PAFixedUpdate(String updateType) {
        this.updateType = updateType;
    }

    @Override public HandlerList getHandlers() { return handlers; }
    public static HandlerList getHandlerList() { return handlers; }

}
