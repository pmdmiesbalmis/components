package com.github.pmdmiesbalmis.components.validacion.validadores

import com.github.pmdmiesbalmis.components.validacion.Validacion
import com.github.pmdmiesbalmis.components.validacion.Validador

/**
 * Validador de longitud mínima de texto.
 *
 * @param tamañoMinimo Tamaño mínimo que debe tener el texto.
 * @param error Mensaje de error que se mostrará si el texto no tiene el tamaño mínimo.
 * @see Validador
 */
class ValidadorLongitudMinimaTexto(
    val tamañoMinimo: Int,
    val error: String = "El texto debe mayor o igual a ${tamañoMinimo}"
) : Validador<String> {

    /**
     * Valida que el texto tenga al menos el tamaño mínimo.
     *
     * @return Una validación con error si el texto no tiene al menos el tamaño mínimo, o una validación vacía si no hay errores.
     * @sample com.github.pmdmiesbalmis.components.validacion.validadores.ValidadorLongitudMinimaTexto.valida
     */
    override fun valida(datos: String): Validacion {
        return object : Validacion {
            override val hayError: Boolean
                get() = datos.length < tamañoMinimo
            override val mensajeError: String
                get() = error
        }
    }
}
