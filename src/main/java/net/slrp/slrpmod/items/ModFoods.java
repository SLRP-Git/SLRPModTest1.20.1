package net.slrp.slrpmod.items;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

//classic food class
public class ModFoods {
    //Custom Food Ryže s Hovězím se strenčkou a vysokou saturaci
    public static final FoodProperties RYZE_S_HOVEZIM = new FoodProperties.Builder().nutrition(8).fast()
            .saturationMod(0.8f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200), 1f).build();
}
