package ato.footblock.item

import ato.footblock.FootBlock
import ato.footblock.tileentity.TileEntityFoot
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.item.{EnumRarity, Item, ItemStack}
import net.minecraft.world.World

class ItemFootBlockSupplier extends Item {

  setHasSubtypes(true)
  setUnlocalizedName("FootBlockSupplier")
  setCreativeTab(CreativeTabs.tabTools)
  setTextureName("footblock:supplier")

  override def getRarity(p_77613_1_ : ItemStack): EnumRarity = EnumRarity.rare

  override def hasEffect(itemstack: ItemStack, pass: Int): Boolean = isActive(itemstack)

  override def onUpdate(itemstack: ItemStack, world: World, entity: Entity, p_77663_4_ : Int, p_77663_5_ : Boolean): Unit =
    if (isActive(itemstack) && !entity.isSneaking) entity match {
      case player: EntityPlayer => {
        val px = math.floor(player.posX).toInt
        val y = (player.posY - (if (world.isRemote) 1.62 else 0)).toInt - 1
        val pz = math.floor(player.posZ).toInt
        for (x <- px - 1 to px + 1; z <- pz - 1 to pz + 1) {
          world.getBlock(x, y, z) match {
            case Blocks.air => world.setBlock(x, y, z, FootBlock.blockFoot)
            case FootBlock.blockFoot => world.getTileEntity(x, y, z) match {
              case tile: TileEntityFoot => tile.repair
              case _ =>
            }
            case _ =>
          }
        }
      }
      case _ =>
    }

  override def onItemRightClick(itemstack: ItemStack, world: World, player: EntityPlayer): ItemStack = {
    if (!world.isRemote) itemstack.setItemDamage(1 - itemstack.getItemDamage)
    itemstack
  }

  def isActive(itemstack: ItemStack): Boolean = itemstack.getItemDamage == 1
}
