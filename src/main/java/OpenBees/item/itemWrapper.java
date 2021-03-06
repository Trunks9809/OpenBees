package OpenBees.item;

import OpenBees.info.modInfo;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class itemWrapper {

    private ItemStack stack;

    public itemWrapper(Item item, int meta) {
        this.stack = new ItemStack(item, 1, meta);
        GameRegistry.registerItem(item, item.getUnlocalizedName(), modInfo.modid);
    }

    public ItemStack getStack(int quantity, int meta) {
        ItemStack copy = this.stack.copy();
        copy.stackSize = quantity;
        copy.setItemDamage(meta);
        return copy;
    }

    public ItemStack getStack(int quantity) {
        ItemStack copy = this.stack.copy();
        copy.stackSize = quantity;
        return copy;
    }

    public ItemStack getStackOnlyMeta(int meta) {
        ItemStack copy = this.stack.copy();
        copy.stackSize = 1;
        copy.setItemDamage(meta);
        return copy;
    }

    public Item getItem() {
        return stack.getItem();
    }
}
