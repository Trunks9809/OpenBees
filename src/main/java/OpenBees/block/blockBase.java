package OpenBees.block;

import OpenBees.handler.creativeTabHandler;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public abstract class blockBase extends BlockContainer {

    private boolean hasGUI;
    private int idShift = 0;
    private Object modInstance;

    public blockBase(String unloc) {
        super(Material.clay);
        this.setHardness(1.0f);
        this.setBlockName(unloc);
        this.setup();
        this.setCreativeTab(creativeTabHandler.creativeTabBlocks);
    }

    public void setModInstance(Object modInstance) {
        this.modInstance = modInstance;
    }

    public abstract void setup();

    public void setHasGUI(boolean hasGUI) {
        this.hasGUI = hasGUI;
    }

    public void setIdShift(int idShift) {
        this.idShift = idShift;
    }

    @Override
    public abstract IIcon getIcon(int side, int meta);

    @Override
    public abstract TileEntity createNewTileEntity(World world, int meta);

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (this.hasGUI) {
            player.openGui(modInstance, (this.idShift + world.getBlockMetadata(x, y, z)), world, x, y, z);
        }
        return true;
    }

    @Override
    public abstract void getSubBlocks(Item item, CreativeTabs tabs, List list);

    @Override
    public int damageDropped(int meta) {
        return meta;
    }
}
