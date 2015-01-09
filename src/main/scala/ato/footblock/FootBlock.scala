package ato.footblock

import ato.footblock.proxy.ProxyCommon
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.{Mod, SidedProxy}

@Mod(modid = "FootBlock", modLanguage = "scala")
object FootBlock {

  @SidedProxy(
    clientSide = "ato.footblock.proxy.ProxyClient",
    serverSide = "ato.footblock.proxy.ProxyCommon"
  )
  var proxy: ProxyCommon = _

  @EventHandler
  def preInit(event: FMLPreInitializationEvent) {
  }
}
