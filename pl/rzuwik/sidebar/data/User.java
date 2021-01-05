package pl.rzuwik.sidebar.data;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import pl.rzuwik.sidebar.SideBarPlugin;
import pl.rzuwik.sidebar.utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class User {


    public static void displaySideBar(Player p) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        ScoreboardManager sn = Bukkit.getScoreboardManager();
        Scoreboard bolo = sn.getNewScoreboard();
        Objective objective = bolo.registerNewObjective("sidebar", "sidebar");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(Utils.fixColor(SideBarPlugin.getInstance().getConfig().getString("name")));
        List<String> lines = SideBarPlugin.getInstance().getConfig().getStringList("lines");
        int size = lines.size() + 1;
        for (String st : lines) {
            size--;
            st = st.replace("{ONLINE}", String.valueOf(Bukkit.getOnlinePlayers().size()));
            st = st.replace("{NICK}", p.getName());
            st = st.replace("{TIME}", sdf.format(new Date()));
            objective.getScore(Utils.fixColor(st)).setScore(size);
        }
    }
    }
