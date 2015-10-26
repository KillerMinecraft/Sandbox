package com.ftwinston.KillerMinecraft.Modules.Sandbox;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World.Environment;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import com.ftwinston.KillerMinecraft.Option;
import com.ftwinston.KillerMinecraft.PersistentGameMode;
import com.ftwinston.KillerMinecraft.Configuration.TeamInfo;
import com.ftwinston.KillerMinecraft.Configuration.ToggleOption;

public class Sandbox extends PersistentGameMode
{
	private ToggleOption creativeMode;
	
	@Override
	public int getMinPlayers() { return 1; }
	
	@Override
	public Option[] setupOptions()
	{
		creativeMode = new ToggleOption("Use creative mode", false, "Whether or not players should be", "in creative mode in this game.");
		
		Option[] options = { creativeMode };
		
		return options;
	}
	
	@Override
	public String getHelpMessage(int num, TeamInfo team)
	{
		return null;
	}
	
	@Override
	public boolean isLocationProtected(Location l, Player player)
	{
		return false;
	}
	
	@Override
	public Environment[] getWorldsToGenerate() { return new Environment[] { Environment.NORMAL, Environment.NETHER, Environment.THE_END }; }
	
	@Override
	protected void gameStarted()
	{
		if (creativeMode.isEnabled())
			for (Player player : getOnlinePlayers())
				player.setGameMode(GameMode.CREATIVE);
	}
	
	@Override
	public void playerJoinedLate(Player player)
	{
		if (creativeMode.isEnabled())
			player.setGameMode(GameMode.CREATIVE);
	}

	@Override
	public Location getSpawnLocation(Player player)
	{
		return getWorld(0).getSpawnLocation();
	}
	
	@Override
	public void loadPersistentData(ConfigurationSection config) { }

	@Override
	public void savePersistentData(ConfigurationSection config) { }
}
