/*
  Copyright (c) 2022 Daniel McCoy Stephenson
  Apache License 2.0
 */
package dansapps.interakt.commands;

import dansapps.interakt.commands.abs.InteraktCommand;
import dansapps.interakt.data.PersistentData;
import dansapps.interakt.objects.Actor;
import dansapps.interakt.objects.World;
import preponderous.ponder.system.abs.CommandSender;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel McCoy Stephenson
 * @since January 7th, 2022
 */
public class ListCommand extends InteraktCommand {

    public ListCommand() {
        super(new ArrayList<>(List.of("list")), new ArrayList<>(List.of("interakt.list")));
    }

    @Override
    public boolean execute(CommandSender sender) {
        sender.sendMessage("=== Actors ===");
        for (Actor actor : PersistentData.getInstance().getActors()) {
            sender.sendMessage(actor.getName());
        }
        sender.sendMessage("");
        sender.sendMessage("=== Worlds ===");
        for (World world : PersistentData.getInstance().getWorlds()) {
            sender.sendMessage(world.getName());
        }
        return true;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        return execute(sender);
    }
}