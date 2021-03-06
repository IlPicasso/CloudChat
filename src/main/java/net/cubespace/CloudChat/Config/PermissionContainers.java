package net.cubespace.CloudChat.Config;

import net.cubespace.CloudChat.Config.Sub.PermissionContainer;
import net.cubespace.Yamler.Config.Config;
import net.cubespace.lib.CubespacePlugin;

import java.io.File;
import java.util.ArrayList;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 */
public class PermissionContainers extends Config {
    public PermissionContainers(CubespacePlugin plugin) {
        CONFIG_FILE = new File(plugin.getDataFolder(), "permissionContainer.yml");
        CONFIG_HEADER = new String[] {
                "Config for Permission Containers",
                "You give a Player the Access Permission and it will get all the Sub Permissions"
        };
    }

    @SuppressWarnings("CanBeFinal")
    public ArrayList<PermissionContainer> PermissionContainers = new ArrayList<PermissionContainer>(){{
        /**
         * Access: cloudchat.rank.admin
         *
         * Sub:
         * - cloudchat.*
         */
        PermissionContainer adminContainer = new PermissionContainer();
        adminContainer.Access = "cloudchat.rank.admin";
        adminContainer.Sub.add("cloudchat.*");
        add(adminContainer);

        /**
         * Access: cloudchat.rank.moderator
         *
         * Sub:
         * - cloudchat.command.broadcast
         * - cloudchat.command.clearchat.other
         * - cloudchat.rank.user
         * - cloudchat.canleaveforced
         * - cloudchat.cannot.muted
         * - cloudchat.ignore.maxchannel
         * - cloudchat.command.nick
         * - cloudchat.command.nick.other
         * - cloudchat.command.createchannel
         * - cloudchat.command.cc.mute
         * - cloudchat.command.cc.unmute
         */
        PermissionContainer moderatorContainer = new PermissionContainer();
        moderatorContainer.Access = "cloudchat.rank.moderator";
        moderatorContainer.Sub.add("cloudchat.command.broadcast");
        moderatorContainer.Sub.add("cloudchat.command.clearchat.other");
        moderatorContainer.Sub.add("cloudchat.rank.user");
        moderatorContainer.Sub.add("cloudchat.canleaveforced");
        moderatorContainer.Sub.add("cloudchat.cannot.muted");
        moderatorContainer.Sub.add("cloudchat.ignore.maxchannel");
        moderatorContainer.Sub.add("cloudchat.command.nick");
        moderatorContainer.Sub.add("cloudchat.command.nick.other");
        moderatorContainer.Sub.add("cloudchat.command.createchannel");
        moderatorContainer.Sub.add("cloudchat.command.cc.mute");
        moderatorContainer.Sub.add("cloudchat.command.cc.unmute");
        add(moderatorContainer);

        /**
         * Access: cloudchat.rank.user
         *
         * Sub:
         * - cloudchat.command.join
         * - cloudchat.command.leave
         * - cloudchat.command.focus
         * - cloudchat.command.msg
         * - cloudchat.command.reply
         * - cloudchat.command.channels
         * - cloudchat.command.clearchat
         * - cloudchat.command.invite
         * - cloudchat.command.togglepm
         */
        PermissionContainer userContainer = new PermissionContainer();
        userContainer.Access = "cloudchat.rank.user";
        userContainer.Sub.add("cloudchat.command.join");
        userContainer.Sub.add("cloudchat.command.leave");
        userContainer.Sub.add("cloudchat.command.focus");
        userContainer.Sub.add("cloudchat.command.msg");
        userContainer.Sub.add("cloudchat.command.reply");
        userContainer.Sub.add("cloudchat.command.channels");
        userContainer.Sub.add("cloudchat.command.clearchat");
        userContainer.Sub.add("cloudchat.command.invite");
        userContainer.Sub.add("cloudchat.command.togglepm");
        add(userContainer);

        /**
         * BungeeSuiteChat Permissions (only for the usage of migration)
         */
        PermissionContainer bungeeSuiteUserContainer = new PermissionContainer();
        bungeeSuiteUserContainer.Access = "bungeesuite.chat.user";
        bungeeSuiteUserContainer.Sub.add("cloudchat.rank.user");
        bungeeSuiteUserContainer.Sub.add("cloudchat.channel.global");
        add(bungeeSuiteUserContainer);

        PermissionContainer bungeeSuiteModContainer = new PermissionContainer();
        bungeeSuiteModContainer.Access = "bungeesuite.chat.mod";
        bungeeSuiteModContainer.Sub.add("cloudchat.rank.moderator");
        bungeeSuiteModContainer.Sub.add("cloudchat.channel.global");
        bungeeSuiteModContainer.Sub.add("cloudchat.channel.staff");
        add(bungeeSuiteModContainer);

        PermissionContainer bungeeSuiteAdminContainer = new PermissionContainer();
        bungeeSuiteAdminContainer.Access = "bungeesuite.chat.admin";
        bungeeSuiteAdminContainer.Sub.add("cloudchat.rank.admin");
        add(bungeeSuiteAdminContainer);

        PermissionContainer bsUserContainer = new PermissionContainer();
        bsUserContainer.Access = "bungeesuite.user";
        bsUserContainer.Sub.add("bungeesuite.chat.user");
        add(bsUserContainer);

        PermissionContainer bsModContainer = new PermissionContainer();
        bsModContainer.Access = "bungeesuite.mod";
        bsModContainer.Sub.add("bungeesuite.chat.mod");
        add(bsModContainer);

        PermissionContainer bsAdminContainer = new PermissionContainer();
        bsAdminContainer.Access = "bungeesuite.admin";
        bsAdminContainer.Sub.add("bungeesuite.chat.admin");
        add(bsAdminContainer);
    }};
}
