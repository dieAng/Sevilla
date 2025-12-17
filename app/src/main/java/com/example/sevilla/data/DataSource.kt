package com.example.sevilla.data

import com.example.sevilla.R
import com.example.sevilla.model.SevillaItem.*

object DataSource {
    val categorias = listOf(
        Categoria(
            nombre = R.string.museos,
            lugares = listOf(
                Lugar(
                    nombre = R.string.museo_bellas_artes,
                    descripcion = R.string.museo_bellas_artes_descripcion,
                    imagen = R.drawable.museo_bellas_artes_img
                ),
                Lugar(
                    nombre = R.string.museo_ilusiones,
                    descripcion = R.string.museo_ilusiones_descripcion,
                    imagen = R.drawable.museo_ilusiones_img
                ),
                Lugar(
                    nombre = R.string.museo_palacio_condesa_lebrija,
                    descripcion = R.string.museo_palacio_condesa_lebrija_descripcion,
                    imagen = R.drawable.museo_palacio_condesa_lebrija_img
                ),
                Lugar(
                    nombre = R.string.casa_ciencia,
                    descripcion = R.string.casa_ciencia_descripcion,
                    imagen = R.drawable.casa_ciencia_img
                ),
                Lugar(
                    nombre = R.string.antiquarium,
                    descripcion = R.string.antiquarium_descipcion,
                    imagen = R.drawable.antiquarium_img
                )
            ),
            imagen = R.drawable.museos_img
        ),

        Categoria(
            nombre = R.string.restaurantes,
            lugares = listOf(
                Lugar(
                    nombre = R.string.terraviva,
                    descripcion = R.string.terraviva_descripcion,
                    imagen = R.drawable.terraviva_img
                ),
                Lugar(
                    nombre = R.string.abaceria_postigo,
                    descripcion = R.string.abaceria_postigo_descripcion,
                    imagen = R.drawable.abaceria_postigo_img
                ),
                Lugar(
                    nombre = R.string.restaurante_tapas_el_sella,
                    descripcion = R.string.restaurante_tapas_el_sella_descripcion,
                    imagen = R.drawable.restaurante_tapas_el_sella_img
                ),
                Lugar(
                    nombre = R.string.gascona,
                    descripcion = R.string.gascona_descripcion,
                    imagen = R.drawable.gascona_img
                ),
                Lugar(
                    nombre = R.string.tropiqual,
                    descripcion = R.string.tropiqual_descripcion,
                    imagen = R.drawable.tropiqual_img
                )
            ),
            imagen = R.drawable.restaurantes_img
        ),

        Categoria(
            nombre = R.string.hoteles,
            lugares = listOf(
                Lugar(
                    nombre = R.string.hotel_fernando_iii,
                    descripcion = R.string.hotel_fernando_iii_descripcion,
                    imagen = R.drawable.hotel_fernando_iii_img
                ),
                Lugar(
                    nombre = R.string.h10_casa_plata,
                    descripcion = R.string.h10_casa_plata_descripcion,
                    imagen = R.drawable.h10_casa_plata_img
                ),
                Lugar(
                    nombre = R.string.only_you_hotel_sevilla,
                    descripcion = R.string.only_you_hotel_sevilla_descripcion,
                    imagen = R.drawable.only_you_hotel_sevilla_img
                ),
                Lugar(
                    nombre = R.string.melia_sevilla,
                    descripcion = R.string.melia_sevilla_descripcion,
                    imagen = R.drawable.melia_sevilla_img
                ),
                Lugar(
                    nombre = R.string.hotel_rey_alfonso_x,
                    descripcion = R.string.hotel_rey_alfonso_x_descripcion,
                    imagen = R.drawable.hotel_rey_alfonso_x_img
                )
            ),
            imagen = R.drawable.hoteles_img
        ),

        Categoria(
            nombre = R.string.parques_plazas,
            lugares = listOf(
                Lugar(
                    nombre = R.string.parque_maria_luisa,
                    descripcion = null,
                    imagen = R.drawable.parque_maria_luisa_img
                ),
                Lugar(
                    nombre = R.string.jardines_murillo,
                    descripcion = null,
                    imagen = R.drawable.jardines_murillo_img
                ),
                Lugar(
                    nombre = R.string.parque_alamillo,
                    descripcion = null,
                    imagen = R.drawable.parque_alamillo_img
                ),
                Lugar(
                    nombre = R.string.plaza_espana,
                    descripcion = null,
                    imagen = R.drawable.plaza_espana_img
                ),
                Lugar(
                    nombre = R.string.plaza_america,
                    descripcion = null,
                    imagen = R.drawable.plaza_america_img
                )
            ),
            imagen = R.drawable.parques_palazs_img
        ),

        Categoria(
            nombre = R.string.iglesias,
            lugares = listOf(
                Lugar(
                    nombre = R.string.catedral_santa_maria_sede,
                    descripcion = R.string.catedral_santa_maria_sede_descripcion,
                    imagen = R.drawable.catedral_santa_maria_sede_img
                ),
                Lugar(
                    nombre = R.string.omnium_sanctorum,
                    descripcion = R.string.omnium_sanctorum_descripcion,
                    imagen = R.drawable.omnium_sanctorum_img
                ),
                Lugar(
                    nombre = R.string.santa_ana,
                    descripcion = R.string.santa_ana_descripcion,
                    imagen = R.drawable.santa_ana_img
                ),
                Lugar(
                    nombre = R.string.san_marcos,
                    descripcion = R.string.san_marcos_descripcion,
                    imagen = R.drawable.san_marcos_img
                ),
                Lugar(
                    nombre = R.string.portada_iglesia_monasterio_santa_paula,
                    descripcion = R.string.portada_iglesia_monasterio_santa_paula_descripcion,
                    imagen = R.drawable.portada_iglesia_monasterio_santa_paula_img
                )
            ),
            imagen = R.drawable.iglesias_img
        )
    )
}