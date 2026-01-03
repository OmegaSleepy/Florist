package omegasleepy.contentmod.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import omegasleepy.contentmod.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ATMBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(8, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT_1 = 1;
    private static final int OUTPUT_SLOT_2 = 2;
    private static final int OUTPUT_SLOT_3 = 3;
    private static final int OUTPUT_SLOT_4 = 4;
    private static final int OUTPUT_SLOT_5 = 5;
    private static final int OUTPUT_SLOT_6 = 6;
    private static final int OUTPUT_SLOT_7 = 7;


    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public ATMBlockEntity (BlockPos pos, BlockState state) {
        super(ModBlockEntities.ATM_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get (int index) {
                return switch (index){
                    case 0 -> ATMBlockEntity.this.progress;
                    case 1 -> ATMBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set (int index, int value) {
                switch (index){
                    case 0 -> ATMBlockEntity.this.progress = value;
                    case 1 -> ATMBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size () {
                return 2;
            }
        };
    }

    @Override
    public void writeScreenOpeningData (ServerPlayerEntity serverPlayerEntity, PacketByteBuf packetByteBuf) {
        packetByteBuf.writeBlockPos(pos);
    }

    @Override
    public Text getDisplayName () {
        return Text.literal("ATM");
    }

    @Override
    protected void writeNbt (NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("atm_progress", progress);
    }

    @Override
    public void readNbt (NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("atm_progress");
    }

    @Override
    public @Nullable ScreenHandler createMenu (int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return;
    }

    @Override
    public DefaultedList<ItemStack> getInventory () {
        return inventory;
    }

    public void tick (World world, BlockPos pos, BlockState state) {
        if(world.isClient()){
            return;
        }

        if(isOutputSlotEmptyOrReceivable()){
            if(this.hasRecipe()){
                this.increaseCraftProgress();
                markDirty(world,pos,state);

                if(hasCraftingFinished()){
                    this.craftItem();
                    this.resetProgress();
                }
            } else {
                this.resetProgress();
            }
        } else {
            this.resetProgress();
            markDirty(world,pos,state);
        }

    }

    private boolean hasCraftingFinished () {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress () {
        progress += 1;
    }

    private boolean hasRecipe () {
        ItemStack result = new ItemStack(ModItems.ONE_KARAT);
        boolean hasInput = getStack(INPUT_SLOT).getItem() == Items.DIAMOND;

        return hasInput && canInsertAmountIntoOutputSlot(result) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private boolean canInsertItemIntoOutputSlot (Item item) {
        return this.getStack(OUTPUT_SLOT_1).getItem() == item || this.getStack(OUTPUT_SLOT_1).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot (ItemStack result) {
        return this.getStack(OUTPUT_SLOT_1).getCount() + result.getCount() <= getStack(OUTPUT_SLOT_1).getMaxCount();
    }

    private void craftItem () {
        int diamonds = getStack(INPUT_SLOT).getCount();
        int karats = diamonds * 10;

        int karatsLeft = karats;
        List<Integer> demoninations = List.of(1,2,5,10,20,50,100);
        List<Integer> outputs = List.of(OUTPUT_SLOT_1,OUTPUT_SLOT_2,OUTPUT_SLOT_3,OUTPUT_SLOT_4, OUTPUT_SLOT_5, OUTPUT_SLOT_6, OUTPUT_SLOT_7);

        for(int i = demoninations.size(); i >= outputs.get(1); i--) {
            this.setStack(outputs.get(i), new ItemStack(ModItems.ONE_HUNDRED_KARAT, karatsLeft%demoninations.get(i)));
            karatsLeft -= karatsLeft%demoninations.get(i);
        }
    }

    private void resetProgress () {
        this.progress = 0;
    }

    private boolean isOutputSlotEmptyOrReceivable () {
        boolean result = true;
        for(int i = 1; i < inventory.size(); i++){
            result = result && inventory.get(i).isEmpty();
        }

        return result;
    }


}
