package gregtech.api.gui;

import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class GT_Container_Dynamic_MbyN extends GT_ContainerMetaTile_Machine {

    protected int cols;
    protected int rows;
    //
    public static final int slotSpacingX = 5;
    public static final int slotSpacingY = 5;
    public static final int slotHeight = 10;
    public static final int slotWidth = 10;

    public GT_Container_Dynamic_MbyN(InventoryPlayer aInventoryPlayer, IGregTechTileEntity aTileEntity, int size) {
        this(aInventoryPlayer,aTileEntity,size, size);
    }

    public GT_Container_Dynamic_MbyN(InventoryPlayer aInventoryPlayer, IGregTechTileEntity aTileEntity, int cols, int rows) {
        super(aInventoryPlayer, aTileEntity);
        this.cols = cols;
        this.rows = rows;
    }

    @Override
    public void addSlots(InventoryPlayer aInventoryPlayer) {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                addSlotToContainer(new Slot(mTileEntity, i+rows*j, getX(i), getY(j)));
            }
        }
    }

    public int getX(int index) {
        return slotWidth*index  + slotSpacingX * (index - 1);
    }

    public int getY(int index) {
        return slotHeight*index + slotSpacingY * (index - 1);
    }

    @Override
    public int getSlotCount() {
        return (cols+1)*(rows+1);
    }

    @Override
    public int getShiftClickSlotCount() {
        return getSlotCount();
    }

}
