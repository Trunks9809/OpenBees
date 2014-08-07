package info.inpureprojects.OpenBees.Common.Blocks;

import info.inpureprojects.OpenBees.API.OpenBeesAPI;
import info.inpureprojects.OpenBees.OpenBees;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by den on 8/7/2014.
 */
public abstract class BlockBase extends BlockContainer {

    public BlockBase(String unloc) {
        super(Material.clay);
        this.setHardness(1.0f);
        this.setBlockName(unloc);
        this.setCreativeTab(OpenBeesAPI.getAPI().getClientAPI().creativeTabBlocks);
    }

    @Override
    public abstract IIcon getIcon(int side, int meta);

    @Override
    public abstract TileEntity createNewTileEntity(World world, int meta);

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        player.openGui(OpenBees.instance, world.getBlockMetadata(x, y, z), world, x, y, z);
        return super.onBlockActivated(world, x, y, z, player, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
    }
}
