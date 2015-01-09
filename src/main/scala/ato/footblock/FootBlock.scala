package ato.footblock

import ato.footblock.block.BlockFoot
import ato.footblock.item.ItemFootBlockSupplier
import ato.footblock.proxy.ProxyCommon
import ato.footblock.tileentity.TileEntityFoot
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.registry.GameRegistry
import cpw.mods.fml.common.{Mod, SidedProxy}
import net.minecraft.init.Items
import net.minecraft.item.ItemStack

@Mod(modid = "FootBlock", modLanguage = "scala")
object FootBlock {

  @SidedProxy(
    clientSide = "ato.footblock.proxy.ProxyClient",
    serverSide = "ato.footblock.proxy.ProxyCommon"
  )
  var proxy: ProxyCommon = _

  val blockFoot = new BlockFoot()
  val itemSupplier = new ItemFootBlockSupplier()

  @EventHandler
  def preInit(event: FMLPreInitializationEvent) {
    GameRegistry.registerItem(itemSupplier, "FootBlockSupplier")
    GameRegistry.registerBlock(blockFoot, "FootBlock")
    GameRegistry.registerTileEntity(classOf[TileEntityFoot], "CollapseBlock")
    GameRegistry.addRecipe(new ItemStack(itemSupplier),
      "FSF",
      Character.valueOf('F'), Items.feather,
      Character.valueOf('S'), Items.nether_star)
  }
}
