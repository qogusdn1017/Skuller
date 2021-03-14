package com.baehyeonwoo.skuller.plugin

import com.baehyeonwoo.skuller.commands.SkullCommand
import org.bukkit.plugin.java.JavaPlugin

class SkullerPlugin : JavaPlugin() {
    override fun onEnable() {
        getCommand("skull")?.setExecutor(SkullCommand())
        getCommand("skull")?.tabCompleter = SkullCommand()
    }
}