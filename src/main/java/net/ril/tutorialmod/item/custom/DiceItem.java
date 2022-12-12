package net.ril.tutorialmod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import java.util.Random;


public class DiceItem extends Item {
    public DiceItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            // Output Random Number
            outputRandomNumber(user);
            // Add a cooldown
            user.getItemCooldownManager().set(this, 20);
        }

        return super.use(world, user, hand);
    }
    private void outputRandomNumber(PlayerEntity player){
        player.sendMessage(Text.literal("The Dice Rolled " + getRandomNumber()));
    }

    private int getRandomNumber() {
        return new Random().nextInt(6 - 1 + 1) + 1;
    }
}
