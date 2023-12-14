package pl.vatiaz.core;

import org.bukkit.plugin.java.JavaPlugin;
import pl.vatiaz.core.command.VanishCommand;

public class CorePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin został wlaczony!");
        this.getCommand("vanish").setExecutor(new VanishCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin został wyłączony!");
    }
}
