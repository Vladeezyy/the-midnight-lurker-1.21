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

## NeoForge + Fabric (2026-10-24)

One code base for both loaders: `common` (the MCreator code, compiled on vanilla 1.21.1 / NeoForm), `neoforge`, `fabric`.
- **Events**: the MCreator code keeps NeoForge's event names and methods, now loader-neutral classes in `port/bus`
  (`LivingIncomingDamageEvent`, `PlayerTickEvent.Post`, `RenderGuiEvent.Pre`, ...). `tools/port_multiloader.py`
  rewrites the imports and generates `EventIndex` / `ClientEventIndex` from the `@SubscribeEvent` methods (122);
  each loader posts its events on `LurkerBus`. NeoForge: from NeoForge's events. Fabric: Fabric API (damage, death,
  login, respawn, clone, dimension change, sleep, block use, commands, entity load/unload, client tick, screens) and
  mixins where it has none (player tick, crafting / smelting result, fishing catch, item pickup, item toss, item use
  finish, entity tick, HUD `Pre`, fog distance and colour, hidden effects in the HUD and inventory).
- **Data**: `getData(PLAYER_VARIABLES)` → `MidnightlurkerModVariables.of(entity)` and `getPersistentData()` →
  `PortUtil.data(entity)` (1100 calls, rewritten by the script); NeoForge keeps its attachment and persistent data,
  Fabric uses data attachments (`midnightlurker:player_variables`, `midnightlurker:persistent_data`).
- **Registration**: `Registrar` / `RegistryEntry` (from the Rats port) instead of `DeferredRegister`; on Fabric the
  entries are registered in NeoForge's registry order. Mob effects are passed as the registry's own holder
  (`.holder()`, 75 places). Spawn eggs are vanilla ones; natural spawns: Fabric reads the same NeoForge biome
  modifiers from the jar.
- **NeoForge-only methods** turned vanilla: `BlockTags.create` → `TagKey.create`, `getCloneItemStack` (vanilla
  signature), `onDestroyedByPlayer` → `destroy` (after a player removed the block, both loaders),
  `IClientMobEffectExtensions` → `port.EffectVisibility`, the shattered glass item handler is registered by the
  NeoForge module only (Fabric's transfer API sees the vanilla `Container`).
- **Performance**: the entity tick event reaches the bus only for this mod's entities (its only listener checked
  about 30 entity classes with `instanceof` for every entity of the world, every tick).
- Tests (`LOADER=neoforge|fabric`): `tools/servertest.sh` starts the dev server; `tools/scenetest.sh` 5/5 on both
  (all 37 entities, no missing textures, the book, translations); the Fabric release jar starts on a production
  server (`:fabric:prodServer`).
