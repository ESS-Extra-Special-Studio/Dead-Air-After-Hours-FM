package uk.co.extraspecialstudio.dead_air_after_hours_fm;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;
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

    public Dead_air_after_hours_fm(IEventBus modEventBus) {
        modEventBus.addListener(this::onRegister);
    }

    private void onRegister(RegisterEvent event) {
        event.register(Registries.SOUND_EVENT, registry -> {
            for (String slug : TRACK_SLUGS) {
                ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MODID, "music." + slug);
                registry.register(id, SoundEvent.createVariableRangeEvent(id));
            }
        });
        LOGGER.info("[After Hours FM] Registered {} tracks.", TRACK_SLUGS.size());
    }
}
