package pl.rzuwik.sidebar;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import pl.rzuwik.sidebar.data.User;
import pl.rzuwik.sidebar.utils.Utils;

public class SideBarPlugin extends JavaPlugin {

    public static SideBarPlugin INSTANCE;

    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents((Listener) this, this);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            for (Player online : Bukkit.getOnlinePlayers())
                User.displaySideBar(online);
        }, 0L, 50L);
        saveDefaultConfig();
        INSTANCE = this;
        Utils.sendMessageToConsole("SideBar loaded :D");
    }


        public static SideBarPlugin getInstance() {
        return INSTANCE;

        }
}
