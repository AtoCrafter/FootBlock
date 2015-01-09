package ato.footblock.tileentity

import net.minecraft.tileentity.TileEntity

class TileEntityFoot extends TileEntity {

  var life = 0

  repair

  override def updateEntity() {
    life -= 1
    if (life <= 0) {
      getWorldObj.setBlockToAir(xCoord, yCoord, zCoord)
    }
  }

  def repair = life = 2
}
