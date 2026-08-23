package uk.co.extraspecialstudio.dead_air_after_hours_fm;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import org.slf4j.Logger;

import java.util.List;

@Mod(Dead_air_after_hours_fm.MODID)
public class Dead_air_after_hours_fm {
    public static final String MODID = "dead_air_after_hours_fm";
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final List<String> TRACK_SLUGS = List.of(
        "after_hours",
        "another_year",
        "baritone_bedtime",
        "chasing_clouds",
        "corner_cafe_rain",
        "drift_between_days",
        "drift",
        "groove",
        "hmmhmm",
        "hot_chocolate_pillow_fight",
        "little_blossom",
        "lo_soul",
        "midnight_haze",
        "my_ideal",
        "next_to_nothing",
        "phantom",
        "pillow",
        "pixel_dust_dream",
        "press_start",
        "save_file_dreams",
        "save_point",
        "snack_break_boss_fight",
        "soft_corners",
        "soft_static_sundays",
        "velvet_hours"
    );

    public Dead_air_after_hours_fm() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::onRegister);
    }

    private void onRegister(RegisterEvent event) {
        if (!event.getRegistryKey().equals(ForgeRegistries.Keys.SOUND_EVENTS)) {
            return;
        }
        for (String slug : TRACK_SLUGS) {
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MODID, "music." + slug);
            event.register(ForgeRegistries.Keys.SOUND_EVENTS, id, () -> SoundEvent.createVariableRangeEvent(id));
        }
        LOGGER.info("[After Hours FM] Registered {} Lo-Fi / chillout tracks.", TRACK_SLUGS.size());
    }
}
