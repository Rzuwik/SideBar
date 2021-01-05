package pl.rzuwik.sidebar.utils;

import org.bukkit.ChatColor;

public class Utils {
        public static String fixColor(String text) {
            return ChatColor.translateAlternateColorCodes('&', text.replace(">>", "»").replace("<<", "«"));
        }
        public static void sendMessageToConsole(String message) {
            System.out.println(message);
        }
}
