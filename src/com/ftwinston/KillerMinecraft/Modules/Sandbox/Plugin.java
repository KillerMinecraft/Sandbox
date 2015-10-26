package com.ftwinston.KillerMinecraft.Modules.Sandbox;

import org.bukkit.Material;

import com.ftwinston.KillerMinecraft.GameMode;
import com.ftwinston.KillerMinecraft.GameModePlugin;

public class Plugin extends GameModePlugin
{
	@Override
	public Material getMenuIcon() { return Material.SAND; }
	
	@Override
	public String[] getDescriptionText() { return new String[] {"No rules, just unconstrained minecrafting.", "This game will remain active even when empty."}; }
	
	@Override
	public GameMode createInstance()
	{
		return new Sandbox();
	}
}