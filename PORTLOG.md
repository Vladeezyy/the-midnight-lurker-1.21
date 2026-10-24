# Port log — The Midnight Lurker 3.3.7 (Forge 1.20.1) → NeoForge 1.21.1

Original: [The Midnight Lurker](https://www.curseforge.com/minecraft/mc-mods/the-midnight-lurker) by Voxla (contributors
Whirlygig, Z3R0TW0), MIT, source [Voxla/midnightlurker](https://github.com/Voxla/midnightlurker) (master = 3.3.7, made
with MCreator). The 4.0.0 beta exists only as a jar, so the port starts from the 3.3.7 source.

## Method (2026-10-17)
- Commit 1 holds the original Java sources unchanged, so every port change shows in the history.
- Resources: `tools/convert_resources.py` (from the Deep Void port) converts the 1.20.1 data / resource packs to 1.21.1.
- Java: `tools/port_java.py` (shared MCreator Forge 1.20.1 → NeoForge 1.21.1 rules from the Deep Void port), then
  `tools/port_fixups.py` (this mod), `tools/port_variables.py` (player / world variables). 1750 compile errors → 0.
- Checks: `tools/servertest.sh` (dedicated server starts), `tools/scenetest.sh` (port/DevScene: all 37 entity types
  spawn and render, no missing textures, the Lurker book opens, every item and entity name translated),
  `tools/perf.sh` (port/PerfScene: server tick and the natural spawn checks).

## API changes and how they are handled
- Networking: Forge SimpleChannel → NeoForge payloads (`MidnightlurkerMod.addNetworkMessage`, MCreator NeoForge style).
- Player variables (insanity, jumpscare and encounter state): Forge capability → NeoForge data attachment, synced with
  a payload; world variables are SavedData with the 1.21 factory. Same fields, same copy-on-death rules.
- Entities: the spawn packet constructors are gone, spawn placements come from `RegisterSpawnPlacementsEvent`,
  `getDimensions` → `getDefaultDimensions` (LivingEntity.getDimensions is final), the eye height of the invisible
  helper entities is part of the entity type (`EntityType.Builder.eyeHeight`), `MobType` (removed in 1.20.5) was
  UNDEFINED everywhere, so no tags are needed.
- Shattered glass block entities: 1.21 load / save with registries, the item handler is a registered capability.
  Procedures that copy block entity data across `setBlock` use `saveWithFullMetadata` / `loadWithComponents` with the
  registries.
- The Lurker removes Depth Strider from iron boots (as in 3.3.7): written with 1.21's `EnchantmentHelper.updateEnchantments`.
- `EntityItemPickupEvent` → `ItemEntityPickupEvent.Pre`; `LivingTickEvent` → `EntityTickEvent.Pre`; menu screens via
  `RegisterMenuScreensEvent`; `IForgeMenuType` → `IMenuTypeExtension`; recipes are awarded from a list.
- Four classes whose file names differed in case only (`MidnightLurkerNE*.java` holding `MidnightlurkerNE*`; built on
  Windows) are renamed so they compile everywhere.

## Differences from 3.3.7
- The Lurker book had an item inventory capability with 0 slots (it held nothing); 1.21 registers item capabilities
  differently, so it is dropped. Opening the book and closing its screen when the book is dropped work as before.
- The Tough Door is harvestable with any pickaxe (3.3.7: tier level ≥ 0, i.e. any pickaxe; 1.21 tiers have no level).
- The step height set when an aggressive Lurker spawns is the 1.21 `step_height` attribute.

## Performance (players reported server lag, issues #23 and #25 of the original)
Found in the 3.3.7 code:
1. **Natural spawn checks** of the Lurker, the Faker watcher, the Shadow and the void gateway ran when the game tried to
   spawn one of them — up to a few hundred times per check they searched for entities in boxes 700 or 1000 blocks wide
   ("is any Lurker of this kind within 350 blocks?"). A vanilla `getEntitiesOfClass` walks every entity section in the box.
2. **The config file** `config/midnightlurkerconfig.json` was opened and parsed from disk in 49 procedures every time
   they looked at a setting: spawn checks, entity and player ticks, and the insanity HUD (every frame).

Fixed:
1. `port/LurkerEntities`: searches for players use the level's player list, searches for this mod's entities use a
   per-level set kept by join / leave events (usually 0–3 entities); the same test as vanilla (bounding box intersects
   the box, then the predicate) picks the result, so the procedures behave the same. 1488 searches in 82 files.
2. `port/LurkerConfig`: the config is parsed once and re-read when the file changes (checked at most once per second),
   so editing it while the game runs still works.

Measured (`tools/perf.sh`, the same scene on the port before and after; MacBook Air, so ±15 % between runs):

| | Before | After |
|---|---|---|
| Lurker natural spawn check | 45.9 µs | 3.4 µs |
| Faker watcher spawn check | 48.3 µs | 2.9 µs |
| Shadow spawn check | 48.4 µs | 2.7 µs |
| Void gateway spawn check | 1.0 µs | 0.9 µs (it returns early) |
| Server tick, 20 Lurkers around the player | 3.46 ms | 2.53 ms |
| Server tick, nether with natural spawning | 4.24 ms | 3.95 ms |
| Mod code share of the client's frame (flight recording) | 14.6 % | 9.5 % |

The spawn checks cost grows with the entities and loaded chunks around (the scene world had ~200 entities), so on busy
servers the old checks were far slower than here. In single player the mod's own share of the server tick is small
(~3 %); the rest of the tick is vanilla.

## Languages
English, Russian, Ukrainian, German, Spanish, Portuguese (Brazil) are complete (`tools/lang/` merged over the original
files by convert_resources.py). Ukrainian and Portuguese (Brazil) are new (not by native speakers); the original's
Portuguese (Portugal) file names the pig, cow and villager disguises "Midnight Lurker", so Brazilian Portuguese is
written from English. The Russian community translation calls the Lurker «Бабай»; the port keeps it and fills the
missing entries. The Lurker book's tooltip, which was English text in the code, is translatable. The original's French,
Italian, Icelandic, Japanese, Dutch and Portuguese (Portugal) files are kept as they were.

## Release 3.3.7+1.21.1 (2026-10-17)
- GitHub release v3.3.7+1.21.1 (Latest, repo private): `the-midnight-lurker-neoforge-3.3.7+1.21.1.jar`.
- Before the release the jar (with GeckoLib 4.9.3) ran on real NeoForge 21.1.197 and 21.1.259 servers
  (`prodtest/serve.sh`: start, a minute at midnight, stop): no errors on either.

## 1.21.1 → 1.21.11 (branch `mc/1.21.11`, NeoForge 21.11.48, GeckoLib 5.4.5, 2026-10-24)
One commit on top of `main`. Method: `tools/port_1_21_11.py` (mechanical rules, rerunnable), `tools/port_geckolib5.py`
(GeckoLib 4 → 5), the moved-class imports from modding-kb `scripts/fix_moved_imports.py`, the scenes with
`scripts/port_1_21_11_scenes.py`, resources with `tools/convert_resources_1_21_11.py <1.21.1 client resources jar>`.
~5400 compile errors → 0.
- **GeckoLib 5**: the 30 models, 30 renderers and 18 glow layers are regenerated from their MCreator templates. Models
  see a render state, not the entity: the texture the entity syncs is copied into the state
  (`addAdditionalStateData`, `port/GeoTextures`). The head turn is `adjustModelBonesForRender` with
  `DefaultAnimations.hardcodedHeadRotation`; the scale is `withScale`; the eye layers are `TextureLayerGeoLayer` with
  `RenderTypes::eyes`. Controllers: `AnimationTest`, no animatable argument; the "procedure" controller is shared
  (`port/GeoAnims.procedure`). Files moved to `geckolib/models` / `geckolib/animations`, ids without folder and suffix.
- **Missing animations crash GeckoLib 5**: 3.3.7 asks for animations its files lack (the Faker watcher's `idle`, the
  Hider's `swim8`, the Creep's `releport1122`). GeckoLib 4 skipped them; GeckoLib 5.4.5 throws `NoSuchElementException`
  in `AnimationTimeline.create` (no stage and transition ticks > 0) and the client crashes. `GeoAnims.Controller` skips
  them as before; the Faker watcher idles with its `idle4`.
- Overlays (61): the manual GL state is gone (1.21.6 GUI), `blit(RenderPipelines.GUI_TEXTURED, ...)`. The insanity fog
  is the atmospheric environment fog (`ViewportEvent.RenderFog`, `FogType.ATMOSPHERIC`), no fog shape any more.
- Entities: `hurtServer`, `dropExperience(ServerLevel, …)`, `awardKillScore` without score, `EntitySpawnReason`,
  `EntityType.Builder.build(ResourceKey)`. The cow, pig and villager disguises and the destroy textures use render
  states (`MobRenderer<E, S, M>`). Effects tick on the server (`applyEffectTick(ServerLevel, …)`); their visibility is
  registered in `RegisterClientExtensionsEvent` (`client/MidnightlurkerEffectsClient`).
- Items and blocks get their id in the properties at registration; spawn eggs are `SpawnEggItem(props.spawnEgg(type))`
  with one texture each, tinted from the 1.21.1 template with the old colors (`tools/spawn_egg_colors.json`); item
  definitions in `assets/midnightlurker/items`; recipe ingredients as plain ids.
- Data: player variables serialize to `ValueOutput` (same keys, so 1.21.1 saves carry over), world / map variables are
  `SavedDataType`s with a `CompoundTag` codec (same files). Block entities save to `ValueOutput`; the 0-slot item
  handler capability of the shattered glass is gone (NeoForge 21.9 transfer API). Clientbound payloads need a client
  registration (`RegisterClientPayloadHandlersEvent`, `port/ClientNetworking`), else the client does not start.
- Dropping the Lurker book closed its screen through `Minecraft` from a client-only subscriber of a server event; now
  the server closes the menu, which also works in multiplayer.
- `pack.mcmeta` (format 15) removed: NeoForge generates it (the old one showed the mod pack as incompatible).

Tests (Windows, Git Bash; the scripts now share `tools/common.sh`):
- `tools/servertest.sh`: dev server, Done, no errors.
- `tools/scenetest.sh`: 5/5 (37 entities, no missing textures, inventory, book, translations); `SCENE_LANG=ru_ru`:
  5/5; `-Pwith_compat` (Sodium 0.8.14, Iris 1.10.8, Lithium 0.21.4, FerriteCore 8.2.0, Jade 21.1.7, JEI 27.48):
  5/5. NeoForge's dev validation layer is switched off for the compat run (Sodium casts the GPU device).
- `tools/perf.sh`: overworld at night 2.73 ms per tick (206 entities), nether 3.04 ms, 20 Lurkers 2.00 ms; spawn
  checks 1.2–5.2 µs.
- Release jar on a real NeoForge 21.11.48 server (`prodtest/serve.sh`): start, a minute at midnight, stop, restart
  on the saved world: no errors.
