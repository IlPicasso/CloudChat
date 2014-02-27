package net.cubespace.CloudChat.Module.PlayerManager.Database;

import net.cubespace.CloudChat.Config.Main;
import net.cubespace.CloudChat.Module.Mail.Database.Mail;
import net.cubespace.Yamler.Config.Config;
import net.cubespace.lib.CubespacePlugin;

import java.io.File;
import java.util.ArrayList;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 */
public class PlayerDatabase extends Config {
    public PlayerDatabase(CubespacePlugin plugin, String userName) {
        CONFIG_FILE = new File(plugin.getDataFolder(), "database" + File.separator + "users" + File.separator + userName + ".yml");
        CONFIG_HEADER = new String[]{"User Database for " + userName};

        Nick = userName;
        Focus = ((Main) plugin.getConfigManager().getConfig("main")).Global;
    }

    public ArrayList<String> JoinedChannels = new ArrayList<>();
    public String Focus;
    public String Nick = "";
    public String Prefix = "";
    public String Suffix = "";
    public String Town = "";
    public String Nation = "";
    public String Faction = "";
    public String Reply = "";
    public String World = "";
    public String WorldAlias = "";
    public String Realname = "";
    public Boolean AFK = false;
    public String Server = "";
    public Boolean Ignore = false;
    public Boolean Output = true;
    public Boolean Muted = false;
    public Boolean Spy = false;
    public ArrayList<Mail> Mails = new ArrayList<>();
}
