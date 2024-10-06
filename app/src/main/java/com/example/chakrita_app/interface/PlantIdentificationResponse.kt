package com.example.chakrita_app.`interface`

data class PlantIdentificationResponse(
    val results: List<Result>
)

data class Result(
    val species: Species,
    val images: List<Image>,
    val score: Double
)

data class Species(
    val scientificNameWithoutAuthor: String,
    val scientificNameAuthorship: String,
    val genus: Genus,
    val family: Family
)

data class Genus(
    val scientificNameWithoutAuthor: String
)

data class Family(
    val scientificNameWithoutAuthor: String
)

data class Image(
    val url: String
)
