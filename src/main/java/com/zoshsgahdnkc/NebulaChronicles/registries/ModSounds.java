package com.zoshsgahdnkc.NebulaChronicles.registries;


import com.zoshsgahdnkc.NebulaChronicles.NebulaChronicles;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, com.zoshsgahdnkc.NebulaChronicles.NebulaChronicles.MODID);

    public static RegistryObject<SoundEvent> TECH_BLOCK_HIT = register("tech_block_hit");
    public static RegistryObject<SoundEvent> TECH_BLOCK_BREAK = register("tech_block_break");
    public static RegistryObject<SoundEvent> TECH_BLOCK_PLACE = register("tech_block_place");
    public static RegistryObject<SoundEvent> TECH_BLOCK_STEP = register("tech_block_step");
    public static RegistryObject<SoundEvent> TECH_BLOCK_FALL = register("tech_block_fall");

    public static RegistryObject<SoundEvent> MUSIC_DISC_HALFWAY = register("music_disc_halfway");

    public static final ForgeSoundType TECH_BLOCK = new ForgeSoundType(0.6f,1f,
            TECH_BLOCK_BREAK,TECH_BLOCK_STEP,TECH_BLOCK_PLACE,TECH_BLOCK_HIT,TECH_BLOCK_FALL);

    private static RegistryObject<SoundEvent> register(String name){
        return SOUND_EVENT.register(name, ()->SoundEvent.createFixedRangeEvent(
                new ResourceLocation(NebulaChronicles.MODID,name),3f));
    }
}
