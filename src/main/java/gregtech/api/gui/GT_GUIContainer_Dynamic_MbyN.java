package gregtech.api.gui;

import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import net.minecraft.entity.player.InventoryPlayer;

import static gregtech.api.enums.GT_Values.RES_PATH_GUI;

public class GT_GUIContainer_Dynamic_MbyN extends GT_GUIContainerMetaTile_Machine {

    private final String mName;

    public GT_GUIContainer_Dynamic_MbyN(InventoryPlayer aInventoryPlayer, IGregTechTileEntity aTileEntity, String aName, int size) {
        this(aInventoryPlayer, aTileEntity, aName, size, size);
    }

    public GT_GUIContainer_Dynamic_MbyN(InventoryPlayer aInventoryPlayer, IGregTechTileEntity aTileEntity, String aName, int cols, int rows) {
        this(aInventoryPlayer, aTileEntity, aName, "", cols, rows);
    }

    public GT_GUIContainer_Dynamic_MbyN(InventoryPlayer aInventoryPlayer, IGregTechTileEntity aTileEntity, String aName, String aBackground, int size) {
        this(aInventoryPlayer, aTileEntity, aName, aBackground, size, size);
    }

    public GT_GUIContainer_Dynamic_MbyN(InventoryPlayer aInventoryPlayer, IGregTechTileEntity aTileEntity, String aName, String aBackground, int cols, int rows) {
        super(new GT_Container_Dynamic_MbyN(aInventoryPlayer, aTileEntity, cols, rows), RES_PATH_GUI + aBackground + "generic.png");
        mName = aName;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        fontRendererObj.drawString(mName, 8, 4, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        super.drawGuiContainerBackgroundLayer(par1, par2, par3);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }

}
