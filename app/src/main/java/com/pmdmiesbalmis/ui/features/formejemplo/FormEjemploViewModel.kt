package com.pmdmiesbalmis.ui.features.formejemplo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.github.pmdmiesbalmis.components.manejo_errores.InformacionEstadoUiState
import com.pmdmiesbalmis.data.DatosModelo
import com.pmdmiesbalmis.data.ValidadorDatosModelo

class FormEjemploViewModel : ViewModel() {
    private val validadordatosModeloUiState = ValidadorDatosModelo(
        mensajeErrorGlobal = "Revisa los errores del formulario"
    )

    var validacionDatosModeloUiState by mutableStateOf(ValidacionDatosModeloUiState())
        private set
    var datosModeloUiState by mutableStateOf(DatosModelo())
        private set
    var informacionEstadoState: InformacionEstadoUiState by mutableStateOf(InformacionEstadoUiState.Oculta())
        private set

    val onFormEjemploEvent: (FormEjemploEvent) -> Unit = { e ->
        when (e) {
            is FormEjemploEvent.OnChangeNombre -> {
                validacionDatosModeloUiState = validacionDatosModeloUiState.copy(
                    validacionNombre = validadordatosModeloUiState.validadorNombre.valida(e.nombre)
                )
                datosModeloUiState = datosModeloUiState.copy(nombre = e.nombre)
            }

            is FormEjemploEvent.OnChangeEdad -> {
                validacionDatosModeloUiState = validacionDatosModeloUiState.copy(
                    validacionEdad = validadordatosModeloUiState.validadorEdad.valida(e.edad.toString())
                )
                datosModeloUiState = datosModeloUiState.copy(edad = e.edad)
            }

            is FormEjemploEvent.OnChangeAltura -> {
                validacionDatosModeloUiState = validacionDatosModeloUiState.copy(
                    validacionAltura = validadordatosModeloUiState.validadorAltura.valida(e.altura.toString())
                )
                datosModeloUiState = datosModeloUiState.copy(altura = e.altura)
            }

            is FormEjemploEvent.OnChangeCorreo -> {
                validacionDatosModeloUiState = validacionDatosModeloUiState.copy(
                    validacionCorreo = validadordatosModeloUiState.validadorCorreo.valida(e.correo)
                )
                datosModeloUiState = datosModeloUiState.copy(correo = e.correo)
            }

            is FormEjemploEvent.OnChangeTelefono -> {
                validacionDatosModeloUiState = validacionDatosModeloUiState.copy(
                    validacionTelefono = validadordatosModeloUiState.validadorTelefono.valida(e.telefono)
                )
                datosModeloUiState = datosModeloUiState.copy(telefono = e.telefono)
            }

            is FormEjemploEvent.OnChangeClave -> {
                validacionDatosModeloUiState = validacionDatosModeloUiState.copy(
                    validacionClave = validadordatosModeloUiState.validadorClave.valida(e.clave)
                )
                datosModeloUiState = datosModeloUiState.copy(clave = e.clave)
            }

            is FormEjemploEvent.OnDismissError -> {
                validacionDatosModeloUiState = ValidacionDatosModeloUiState()
            }

            is FormEjemploEvent.OnAceptar -> {
                validacionDatosModeloUiState =
                    validadordatosModeloUiState.valida(datosModeloUiState)
                if (!validacionDatosModeloUiState.hayError) {
                } else {
                    informacionEstadoState = InformacionEstadoUiState.Error(
                        mensaje = validacionDatosModeloUiState.mensajeError!!,
                        onDismiss = { informacionEstadoState = InformacionEstadoUiState.Oculta() }
                    )
                }
            }
        }
    }
}
