package com.mvvm.data.remote.model

data class PokemonResponse (
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>
)

data class PokemonResult (
    val name: String,
    val url: String
)

data class Pokemon(
    val id: Int,
    val name: String,
    val types: List<PokemonType>,
    val stats: List<PokemonStat>,
    val abilities: List<PokemonAbility>,
    val species: NamedApiResource,
    val sprites: PokemonSprites
)

data class PokemonType(
    val slot: Int,
    val type: NamedApiResource
)

data class PokemonStat(
    val stat: NamedApiResource,
    val effort: Int,
    val base_stat: Int
)

data class PokemonAbility(
    val is_hidden: Boolean,
    val slot: Int,
    val ability: NamedApiResource
)

data class NamedApiResource (
    val name: String,
    val url: String
)

data class PokemonSprites(
    val back_default: String?,
    val back_shiny: String?,
    val front_default: String?,
    val front_shiny: String?,
    val back_female: String?,
    val back_shiny_female: String?,
    val front_female: String?,
    val front_shiny_female: String?
)

data class Ability(
    val id: Int,
    val name: String,
    val isMainSeries: Boolean,
    val generation: NamedApiResource,
    val names: List<Name>,
    val effect_entries: List<VerboseEffect>,
    val effect_changes: List<AbilityEffectChange>,
    val flavor_text_entries: List<AbilityFlavorText>,
    val pokemon: List<AbilityPokemon>
)

data class Name(
    val name: String,
    val language: NamedApiResource
)

data class VerboseEffect(
    val effect: String,
    val short_effect: String,
    val language: NamedApiResource
)

data class AbilityEffectChange(
    val effectEntries: List<Effect>,
    val versionGroup: NamedApiResource
)

data class Effect(
    val effect: String,
    val language: NamedApiResource
)

data class AbilityFlavorText(
    val flavor_text: String,
    val language: NamedApiResource,
    val versionGroup: NamedApiResource
)

data class AbilityPokemon(
    val isHidden: Boolean,
    val slot: Int,
    val pokemon: NamedApiResource
)

data class PokemonSpecies(
    val id: Int,
    val name: String,
    val order: Int,
    val gender_rate: Int,
    val capture_rate: Int,
    val base_happiness: Int,
    val isBaby: Boolean,
    val isLegendary: Boolean,
    val isMythical: Boolean,
    val hatch_counter: Int,
    val hasGenderDifferences: Boolean,
    val formsSwitchable: Boolean,
    val growth_rate: NamedApiResource,
    val pokedexNumbers: List<PokemonSpeciesDexEntry>,
    val egg_groups: List<NamedApiResource>,
    val color: NamedApiResource,
    val shape: NamedApiResource,
    val evolvesFromSpecies: NamedApiResource?,
    val evolution_chain: ApiResource,
    val habitat: NamedApiResource?,
    val generation: NamedApiResource,
    val names: List<Name>,
    val palParkEncounters: List<PalParkEncounterArea>,
    val formDescriptions: List<Description>,
    val genera: List<Genus>,
    val varieties: List<PokemonSpeciesVariety>,
    val flavor_text_entries: List<PokemonSpeciesFlavorText>
)

data class PokemonSpeciesDexEntry(
    val entryNumber: Int,
    val pokedex: NamedApiResource
)

data class ApiResource(
    val url: String
)

data class PalParkEncounterArea(
    val baseScore: Int,
    val rate: Int,
    val area: NamedApiResource
)

data class Description(
    val description: String,
    val language: NamedApiResource
)

data class Genus(
    val genus: String,
    val language: NamedApiResource
)

data class PokemonSpeciesVariety(
    val isDefault: Boolean,
    val pokemon: NamedApiResource
)

data class PokemonSpeciesFlavorText(
    val flavor_text: String,
    val language: NamedApiResource,
    val version: NamedApiResource
)

data class Type(
    val id: Int,
    val name: String,
    val damage_relations: TypeRelations,
    val gameIndices: List<GenerationGameIndex>,
    val generation: NamedApiResource,
    val moveDamageClass: NamedApiResource?,
    val names: List<Name>,
    val pokemon: List<TypePokemon>,
    val moves: List<NamedApiResource>
)

data class TypeRelations(
    val no_damage_to: List<NamedApiResource>,
    val half_damage_to: List<NamedApiResource>,
    val double_damage_to: List<NamedApiResource>,
    val no_damage_from: List<NamedApiResource>,
    val half_damage_from: List<NamedApiResource>,
    val double_damage_from: List<NamedApiResource>
)

data class GenerationGameIndex(
    val gameIndex: Int,
    val generation: NamedApiResource
)

data class TypePokemon(
    val slot: Int,
    val pokemon: NamedApiResource
)