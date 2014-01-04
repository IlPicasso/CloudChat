package net.cubespace.CloudChat;

import net.cubespace.CloudChat.Config.Database;
import net.cubespace.CloudChat.Config.Factions;
import net.cubespace.CloudChat.Config.IRC;
import net.cubespace.CloudChat.Config.IRCPermissions;
import net.cubespace.CloudChat.Config.Main;
import net.cubespace.CloudChat.Config.Spam;
import net.cubespace.CloudChat.Config.Twitter;
import net.cubespace.CloudChat.Listener.ChatListener;
import net.cubespace.CloudChat.Listener.PlayerJoinListener;
import net.cubespace.CloudChat.Listener.PlayerQuitListener;
import net.cubespace.CloudChat.Listener.ServerConnectListener;
import net.cubespace.CloudChat.Module.Admin.AdminModule;
import net.cubespace.CloudChat.Module.ChannelManager.ChannelManagerModule;
import net.cubespace.CloudChat.Module.ChatHandler.ChatHandlerModule;
import net.cubespace.CloudChat.Module.CloudChat.CloudChatModule;
import net.cubespace.CloudChat.Module.ColorHandler.ColorHandlerModule;
import net.cubespace.CloudChat.Module.FormatHandler.FormatHandlerModule;
import net.cubespace.CloudChat.Module.IRC.IRCModule;
import net.cubespace.CloudChat.Module.Logging.LoggingModule;
import net.cubespace.CloudChat.Module.Mail.MailModule;
import net.cubespace.CloudChat.Module.Mute.MuteModule;
import net.cubespace.CloudChat.Module.PM.PMModule;
import net.cubespace.CloudChat.Module.PlayerManager.PlayerManagerModule;
import net.cubespace.CloudChat.Module.Spam.SpamModule;
import net.cubespace.CloudChat.Module.Twitter.TwitterModule;
import net.cubespace.CloudChat.Util.AutoComplete;
import net.cubespace.lib.CubespacePlugin;
import net.cubespace.lib.Logger.Level;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 * @date Last changed: 24.11.13 18:02
 */
public class CloudChatPlugin extends CubespacePlugin {
    @Override
    public void onEnable() {
        //Setup the Logging Level
        getPluginLogger().setLogLevel(Level.INFO);

        //Load the Configs
        getConfigManager().initConfig("main", new Main(this));
        getConfigManager().initConfig("irc", new IRC(this));
        getConfigManager().initConfig("database", new Database(this));
        getConfigManager().initConfig("spam", new Spam(this));
        getConfigManager().initConfig("twitter", new Twitter(this));
        getConfigManager().initConfig("factions", new Factions(this));
        getConfigManager().initConfig("ircPermissions", new IRCPermissions(this));

        //Static init
        AutoComplete.init(this);

        //Load the Modules
        new PlayerManagerModule(this);
        new ChannelManagerModule(this);
        new ChatHandlerModule(this);
        new FormatHandlerModule(this);
        new ColorHandlerModule(this);
        new PMModule(this);
        new LoggingModule(this);
        new MuteModule(this);
        new IRCModule(this);
        new CloudChatModule(this);
        new SpamModule(this);
        new TwitterModule(this);
        new AdminModule(this);
        new MailModule(this);

        getPluginMessageManager("CloudChat").finish();

        //Register the Listeners
        getProxy().getPluginManager().registerListener(this, new PlayerJoinListener(this));
        getProxy().getPluginManager().registerListener(this, new PlayerQuitListener(this));
        getProxy().getPluginManager().registerListener(this, new ChatListener(this));
        getProxy().getPluginManager().registerListener(this, new ServerConnectListener(this));
    }
}
