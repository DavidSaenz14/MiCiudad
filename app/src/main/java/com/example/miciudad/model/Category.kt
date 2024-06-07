package com.example.miciudad.model

data class Category(
    val name: Int,
    val image: Int,
    val sport: String? = null,
    // Cambiado a String para representar el deporte asociado a la categoría
    // Si la propiedad s representa algún otro dato asociado a la categoría, deberías proporcionar una descripción adecuada aquí
)
