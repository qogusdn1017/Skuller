package com.baehyeonwoo.skuller.commands

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta

class SkullCommand : CommandExecutor, TabCompleter {
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage(ChatColor.GREEN.toString() + "[Skuller] " + ChatColor.RED + "Please use this command in-game.")
            return true
        }
        if (args.isEmpty() || args.equals(" ")) {
            sender.sendMessage(ChatColor.GREEN.toString() + "[Skuller] " + ChatColor.RESET + ChatColor.GREEN + sender.name + "님의 머리를 얻으셨습니다!")
            sender.inventory.addItem(getPlayerHead(sender.name))
        }
        else {
            sender.sendMessage(ChatColor.GREEN.toString() + "[Skuller] " + ChatColor.RESET + ChatColor.GREEN + args[0] + "님의 머리를 얻으셨습니다!")
            sender.inventory.addItem(getPlayerHead(args[0]))
            return true
        }
        return true
    }

    private fun getPlayerHead(player: String?): ItemStack {
        val type = Material.PLAYER_HEAD
        val item = ItemStack(type, 1)
        val meta = item.itemMeta as SkullMeta
        meta.owner = player
        item.itemMeta = meta
        return item
    }

    override fun onTabComplete(sender: CommandSender, cmd: Command, alias: String, args: Array<out String>): List<String> {
        return emptyList()
    }
}