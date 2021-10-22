package com.mvvm.data.dataclass

data class PokemonList(
    var status: Int = 0,
    var pokemon: List<PokemonData>? = null
)
data class PokemonData (
    var id: String = "",
    var name: String = "",
    var url: String = "",
    var types: List<PokemonType>? = null
)

data class Pokemon(
    var id: Int = 0,
    var name: String = "",
    var types: List<PokemonType>? = null,
    var stats: List<PokemonStat>? = null,
    var abilities: List<PokemonAbility>? = null,
    var species: NamedApiResource? = null,
    var sprites: PokemonSprites? = null
)

data class PokemonType(
    var slot: Int = 0,
    var type: NamedApiResource? = null
)

data class PokemonStat(
    var stat: NamedApiResource? = null,
    var effort: Int = 0,
    var base_stat: Int = 0
)

data class PokemonAbility(
    var is_hidden: Boolean = false,
    var slot: Int = 0,
    var ability: NamedApiResource? = null,
)

data class NamedApiResource (
    var name: String = "",
    var url: String = ""
)

data class PokemonSprites(
    var back_default: String?,
    var back_shiny: String?,
    var front_default: String?,
    var front_shiny: String?,
    var back_female: String?,
    var back_shiny_female: String?,
    var front_female: String?,
    var front_shiny_female: String?
)

data class Ability(
    var id: Int = 0,
    var name: String = "",
    var isMainSeries: Boolean = false,
    var generation: NamedApiResource? = null,
    var names: List<Name>? = null,
    var effect_entries: List<VerboseEffect>? = null,
    var effect_changes: List<AbilityEffectChange>? = null,
    var flavor_text_entries: List<AbilityFlavorText>? = null,
    var pokemon: List<AbilityPokemon>? = null
)

data class Name(
    var name: String = "",
    var language: NamedApiResource? = null
)

data class VerboseEffect(
    var effect: String = "",
    var short_effect: String = "",
    var language: NamedApiResource? = null
)

data class AbilityEffectChange(
    var effectEntries: List<Effect>? = null,
    var versionGroup: NamedApiResource? = null
)

data class Effect(
    var effect: String = "",
    var language: NamedApiResource? = null,
)

data class AbilityFlavorText(
    var flavor_text: String = "",
    var language: NamedApiResource? = null,
    var versionGroup: NamedApiResource? = null
)

data class AbilityPokemon(
    var isHidden: Boolean = false,
    var slot: Int = 0,
    var pokemon: NamedApiResource? = null
)

data class PokemonSpecies(
    var id: Int,
    var name: String,
    var order: Int,
    var gender_rate: Int,
    var capture_rate: Int,
    var base_happiness: Int,
    var isBaby: Boolean,
    var isLegendary: Boolean,
    var isMythical: Boolean,
    var hatch_counter: Int,
    var hasGenderDifferences: Boolean,
    var formsSwitchable: Boolean,
    var growth_rate: NamedApiResource,
    var pokedexNumbers: List<PokemonSpeciesDexEntry>,
    var egg_groups: List<NamedApiResource>,
    var color: NamedApiResource,
    var shape: NamedApiResource,
    var evolvesFromSpecies: NamedApiResource?,
    var evolution_chain: ApiResource,
    var habitat: NamedApiResource?,
    var generation: NamedApiResource,
    var names: List<Name>,
    var palParkEncounters: List<PalParkEncounterArea>,
    var formDescriptions: List<Description>,
    var genera: List<Genus>,
    var varieties: List<PokemonSpeciesVariety>,
    var flavor_text_entries: List<PokemonSpeciesFlavorText>
)

data class PokemonSpeciesDexEntry(
    var entryNumber: Int,
    var pokedex: NamedApiResource
)

data class ApiResource(
    var url: String
)

data class PalParkEncounterArea(
    var baseScore: Int,
    var rate: Int,
    var area: NamedApiResource
)

data class Description(
    var description: String,
    var language: NamedApiResource
)

data class Genus(
    var genus: String,
    var language: NamedApiResource
)

data class PokemonSpeciesVariety(
    var isDefault: Boolean,
    var pokemon: NamedApiResource
)

data class PokemonSpeciesFlavorText(
    var flavor_text: String,
    var language: NamedApiResource,
    var version: NamedApiResource
)

data class Type(
    var id: Int,
    var name: String,
    var damage_relations: TypeRelations,
    var gameIndices: List<GenerationGameIndex>,
    var generation: NamedApiResource,
    var moveDamageClass: NamedApiResource?,
    var names: List<Name>,
    var pokemon: List<TypePokemon>,
    var moves: List<NamedApiResource>
)

data class TypeRelations(
    var no_damage_to: List<NamedApiResource>,
    var half_damage_to: List<NamedApiResource>,
    var double_damage_to: List<NamedApiResource>,
    var no_damage_from: List<NamedApiResource>,
    var half_damage_from: List<NamedApiResource>,
    var double_damage_from: List<NamedApiResource>
)

data class GenerationGameIndex(
    var gameIndex: Int,
    var generation: NamedApiResource
)

data class TypePokemon(
    var slot: Int,
    var pokemon: NamedApiResource
)