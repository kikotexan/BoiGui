package me.kikotexan.BoiGui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.Http2Connection.Listener;
import io.netty.handler.codec.http2.Http2Stream;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener {
	
	public Inventory inv;
	
	@Override
	public void onEnable()  {
		this.getServer().getPluginManager().registerEvents(this, this);
		createInv();
	}
	
	@Override
	public void onDisable()  {
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)  {
		
		if (label.equalsIgnoreCase("armor"))  {
			if (!(sender instanceof Player))  {
				sender.sendMessage("You cannot do this!");
				return true;
			}
			Player player = (Player) sender;
			// open the GUI
			player.openInventory(inv);
			return true;
		}
		return false;
	}
	
	@EventHandler()
	public void onClick(InventoryClickEvent event) {
		if (!event.getInventory().equals(inv))
			return;
		if (event.getCurrentItem() == null) return;  
		if (event.getCurrentItem().getItemMeta() == null) return;
		if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
		
		event.setCancelled(true);
		
		Player player = (Player) event.getWhoClicked();
		
		if (event.getSlot() == 1 && event.getCurrentItem().getType() == Material.LIME_DYE) {
			//lime
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.LIME);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e---------------------------"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l&o&nYou Changed Your Team"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e---------------------------"));
		}
		if (event.getSlot() == 2 && event.getCurrentItem().getType() == Material.PINK_DYE) {
			//cowboy
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.fromRGB(255, 192, 203));
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e---------------------------"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l&o&nYou Changed Your Team"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e---------------------------"));
		}
		if (event.getSlot() == 3 && event.getCurrentItem().getType() == Material.LIGHT_BLUE_DYE) {
			// light blue
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.AQUA);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e---------------------------"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l&o&nYou Changed Your Team"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e---------------------------"));
		}
		if (event.getSlot() == 4 && event.getCurrentItem().getType() == Material.YELLOW_DYE) {
			//yellow
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.YELLOW);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e---------------------------"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l&o&nYou Changed Your Team"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e---------------------------"));
		}
		if (event.getSlot() == 5 && event.getCurrentItem().getType() == Material.ORANGE_DYE) {
			//orange
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.ORANGE);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e---------------------------"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l&o&nYou Changed Your Team"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e---------------------------"));
		}
		if (event.getSlot() == 6 && event.getCurrentItem().getType() == Material.RED_DYE) {
			//red
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.RED);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e---------------------------"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l&o&nYou Changed Your Team"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e---------------------------"));
			if (event.getSlot() == 8 && event.getCurrentItem().getType() == Material.BARRIER) {
			player.closeInventory();
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e---------------------------"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lYou Closed The Menu"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e---------------------------"));
		}
		return;
		}
		
	}
	
	public ItemStack[] changeColor(ItemStack[] a, Color color) {
		for (ItemStack item : a) {
			try {
				if (item.getType() == Material.LEATHER_BOOTS || item.getType() == Material.LEATHER_CHESTPLATE ||
						item.getType() == Material.LEATHER_HELMET || item.getType() == Material.LEATHER_LEGGINGS) {
					LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
					meta.setColor(color);
					item.setItemMeta(meta);
				}
			} catch (Exception e) {
				// do nothing
			}
		}
		
		return a;
	}
	
	
	public void createInv() {
		
		inv = Bukkit.createInventory(null, 9,ChatColor.GOLD + "" + ChatColor.BOLD + "Give Full Armor Sets");
				
		ItemStack item = new ItemStack(Material.LIME_DYE);
		ItemMeta meta = item.getItemMeta();
		
		//Green Armor
		meta.setDisplayName(ChatColor.GREEN + "Lime Clothes");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.DARK_GRAY + "Click To Equip!");
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(1, item);
		
		// Leather Armor
		item.setType(Material.PINK_DYE);
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pink Clothes");
		item.setItemMeta(meta);
		inv.setItem(2, item);
		
		// Chain Armor
		item.setType(Material.LIGHT_BLUE_DYE);
		meta.setDisplayName(ChatColor.AQUA + "Light Blue Clothes");
		item.setItemMeta(meta);
		inv.setItem(3, item);
		
		// Iron Armor
		item.setType(Material.YELLOW_DYE);
		meta.setDisplayName(ChatColor.YELLOW + "Yellow Clothes");
		item.setItemMeta(meta);
		inv.setItem(4, item);
		
		// Gold Armor
		item.setType(Material.ORANGE_DYE);
		meta.setDisplayName(ChatColor.GOLD + "Orange Clothes");
		item.setItemMeta(meta);
		inv.setItem(5, item);
		
		// Diamond Armor
		item.setType(Material.RED_DYE);
		meta.setDisplayName(ChatColor.RED + "Red Clothes");
		item.setItemMeta(meta);
		inv.setItem(6, item);	
		
		//CLOSE BUTTON
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Close Menu");
		lore.clear();
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(8, item);
				
	}

	@Override
	public void onGoAwayReceived(int arg0, long arg1, ByteBuf arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGoAwaySent(int arg0, long arg1, ByteBuf arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStreamActive(Http2Stream arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStreamAdded(Http2Stream arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStreamClosed(Http2Stream arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStreamHalfClosed(Http2Stream arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStreamRemoved(Http2Stream arg0) {
		// TODO Auto-generated method stub
		
	}
		


}
