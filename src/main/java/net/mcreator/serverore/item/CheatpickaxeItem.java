
package net.mcreator.serverore.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.BlockState;

import net.mcreator.serverore.procedures.CheatpickaxeKoghdaNazhataPKMPoBlokuProcedure;
import net.mcreator.serverore.ServerOreModElements;

import java.util.Map;
import java.util.HashMap;

@ServerOreModElements.ModElement.Tag
public class CheatpickaxeItem extends ServerOreModElements.ModElement {
	@ObjectHolder("server_ore:cheatpickaxe")
	public static final Item block = null;
	public CheatpickaxeItem(ServerOreModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 50f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 50;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, 11f, new Item.Properties().group(ItemGroup.TOOLS).isImmuneToFire()) {
			@Override
			public boolean onBlockDestroyed(ItemStack itemstack, World world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
				boolean retval = super.onBlockDestroyed(itemstack, world, blockstate, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					CheatpickaxeKoghdaNazhataPKMPoBlokuProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("cheatpickaxe"));
	}
}
