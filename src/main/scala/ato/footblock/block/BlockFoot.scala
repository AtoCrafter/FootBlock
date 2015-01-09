package ato.footblock.block

import java.util.Random

import ato.footblock.tileentity.TileEntityFoot
import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.block.material.Material
import net.minecraft.block.{Block, ITileEntityProvider}
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

class BlockFoot extends Block(Material.glass) with ITileEntityProvider {

  setHardness(10)
  setBlockTextureName("glass")

  override def quantityDropped(random: Random): Int = 0

  override def createNewTileEntity(p_149915_1_ : World, p_149915_2_ : Int): TileEntity =
    new TileEntityFoot()

  override def isOpaqueCube: Boolean = false

  @SideOnly(Side.CLIENT)
  override def getRenderBlockPass: Int = 0

  override def renderAsNormalBlock(): Boolean = false
}
