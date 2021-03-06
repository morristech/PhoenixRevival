package com.github.elfin8er.PhoenixRevival.Commands;

import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.args.CommandContext;
import org.spongepowered.api.util.command.spec.CommandExecutor;

import com.github.elfin8er.PhoenixRevival.Phoenix;

public class CommandGiveMoney implements CommandExecutor {

	private Phoenix plugin;
	
	public CommandGiveMoney(Phoenix plugin) {
        this.plugin = plugin;
	}

	public CommandResult execute(CommandSource sender, CommandContext arguments) throws CommandException {

		Player recipient = plugin.game.getServer().getPlayer(arguments.getOne("player").get().toString()).get();
		double amount = Double.parseDouble(arguments.getOne("amt").get().toString());
		
		//checks to make sure it's not negative
		if (amount <= 0){
			return CommandResult.empty();
		}
		
		//gives money
		this.plugin.giveMoney(recipient,(Player) sender, amount);
		

		
		return CommandResult.success();
	}

}