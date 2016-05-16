package crazypants.enderzoo.potion;

import crazypants.enderzoo.EnderZoo;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionUtils;

public class BrewingUtil {

  private static final ItemStack REDSTONE = new ItemStack(Items.redstone);
  private static final ItemStack GLOWSTONE = new ItemStack(Items.glowstone_dust);
  private static final ItemStack NETHER_WART = new ItemStack(Items.nether_wart);
  private static final ItemStack GUN_POWDER = new ItemStack(Items.gunpowder);
  private static final ItemStack SPECKLED_MELLON = new ItemStack(Items.speckled_melon);
  private static final ItemStack GHAST_TEAR = new ItemStack(Items.ghast_tear);
  private static final ItemStack SPIDER_EYE = new ItemStack(Items.spider_eye);
  private static final ItemStack FERMENTED_SPIDER_EYE = new ItemStack(Items.fermented_spider_eye);

  public static ItemStack createHarmingPotion(boolean isAugmented, boolean isSplash) {
    ItemStack result = createAwkwardPotion();
    addIngredientToPotion(result, SPIDER_EYE);
    addIngredientToPotion(result, FERMENTED_SPIDER_EYE);
    if (isAugmented) {
      addIngredientToPotion(result, GLOWSTONE);
    }
    if (isSplash) {
      addIngredientToPotion(result, GUN_POWDER);
    }
    return result;    
  }

  public static ItemStack createWitherPotion(boolean isProlonged, boolean isSplash) {
    ItemStack result = createAwkwardPotion();
    addIngredientToPotion(result, new ItemStack(EnderZoo.itemWitheringDust));
    if (isProlonged) {
      addIngredientToPotion(result, REDSTONE);
    }
    if (isSplash) {
      addIngredientToPotion(result, GUN_POWDER);
    }
    return result;
  }

  public static ItemStack createHealthPotion(boolean isProlonged, boolean isAugmented, boolean isSplash) {
    ItemStack result = createAwkwardPotion();
    addIngredientToPotion(result, SPECKLED_MELLON);
    if (isProlonged) {
      addIngredientToPotion(result, REDSTONE);
    }
    if (isAugmented) {
      addIngredientToPotion(result, GLOWSTONE);
    }
    if (isSplash) {
      addIngredientToPotion(result, GUN_POWDER);
    }
    return result;
  }

  public static ItemStack createRegenerationPotion(boolean isProlonged, boolean isAugmented, boolean isSplash) {
    ItemStack result = createAwkwardPotion();
    addIngredientToPotion(result, GHAST_TEAR);
    if (isProlonged) {
      addIngredientToPotion(result, REDSTONE);
    }
    if (isAugmented) {
      addIngredientToPotion(result, GLOWSTONE);
    }
    if (isSplash) {
      addIngredientToPotion(result, GUN_POWDER);
    }
    return result;
  }

  public static ItemStack createAwkwardPotion() {
    ItemStack result = new ItemStack(Items.potionitem);
    addIngredientToPotion(result, NETHER_WART);
    return result;
  }

  public static void addIngredientToPotion(ItemStack targetPotion, ItemStack ingredient) {
    //TODO: 1.9
//    int originalMetaData = targetPotion.getItemDamage();
//    int metaWithAddedIngredient = addPotionEffect(originalMetaData, ingredient);
//    
//    List<PotionEffect> effects = PotionUtils.getEffectsFromStack(potion);
//    if (effects.isEmpty()) {
//      return;
//    }
//    
//    List<?> originalEffects = Items.potionitem.getEffects(originalMetaData);
//    List<?> withAddedEffects = Items.potionitem.getEffects(metaWithAddedIngredient);
//    if ((originalMetaData <= 0 || originalEffects != withAddedEffects)
//        && (originalEffects == null || !originalEffects.equals(withAddedEffects) && withAddedEffects != null)) {
//      if (originalMetaData != metaWithAddedIngredient) {
//        targetPotion.setItemDamage(metaWithAddedIngredient);
//      }
//    } else if (!ItemPotion.isSplash(originalMetaData) && ItemPotion.isSplash(metaWithAddedIngredient)) {
//      targetPotion.setItemDamage(metaWithAddedIngredient);
//    }
  }

  public static int addPotionEffect(int targetMetaData, ItemStack ingredient) {    
    //TODO: 1.9
    return targetMetaData;
//    return ingredient == null ? targetMetaData : (ingredient.getItem().isPotionIngredient(ingredient) ? PotionHelper.applyIngredient(targetMetaData, ingredient
//        .getItem().getPotionEffect(ingredient)) : targetMetaData);
  }
  
  public static void writeCustomEffectToNBT(PotionEffect effect, ItemStack stack) {
    NBTTagCompound nbt;
    if(stack.hasTagCompound()) {
      nbt = stack.getTagCompound();
    } else {
      nbt = new NBTTagCompound();
      stack.setTagCompound(nbt);
    }    
    writeCustomEffectToNBT(effect, nbt);    
  }

  public static void writeCustomEffectToNBT(PotionEffect effect, NBTTagCompound nbt) {
    NBTTagCompound effectNBT = new NBTTagCompound();        
    effect.writeCustomPotionEffectToNBT(effectNBT);
    
    NBTTagList effectList = new NBTTagList();
    effectList.appendTag(effectNBT);            
    
    nbt.setTag("CustomPotionEffects", effectList);
  }

}
