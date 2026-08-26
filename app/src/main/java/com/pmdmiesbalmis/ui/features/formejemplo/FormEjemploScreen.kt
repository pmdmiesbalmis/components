package com.pmdmiesbalmis.ui.features.formejemplo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.pmdmiesbalmis.components.manejo_errores.InformacionEstadoUiState
import com.github.pmdmiesbalmis.components.ui.composables.OutlinedTextFieldEmail
import com.github.pmdmiesbalmis.components.ui.composables.OutlinedTextFieldEntero
import com.github.pmdmiesbalmis.components.ui.composables.OutlinedTextFieldPassword
import com.github.pmdmiesbalmis.components.ui.composables.OutlinedTextFieldPhone
import com.github.pmdmiesbalmis.components.ui.composables.OutlinedTextFieldReal
import com.github.pmdmiesbalmis.components.ui.composables.OutlinedTextFieldWithErrorState
import com.github.pmdmiesbalmis.components.ui.composables.SnackbarError
import com.pmdmiesbalmis.data.DatosModelo
import com.pmdmiesbalmis.ui.theme.LibreriaUtilidadesTheme

@Composable
fun FormEjemploScreen(
    datosModeloUiState: DatosModelo,
    validacionDatosModeloUiState: ValidacionDatosModeloUiState,
    informacionEstadoState: InformacionEstadoUiState,
    onFormEjemploEvent: (FormEjemploEvent) -> Unit
) {
    Column (modifier = Modifier.padding(16.dp)) {

        OutlinedTextFieldWithErrorState(
            modifier = Modifier.fillMaxWidth(),
            label = "Nombre",
            textoState = datosModeloUiState.nombre,
            validacionState = validacionDatosModeloUiState.validacionNombre,
            onValueChange = { onFormEjemploEvent(FormEjemploEvent.OnChangeNombre(it)) }
        )

        OutlinedTextFieldEntero(
            modifier = Modifier.fillMaxWidth(),
            label = "Edad",
            valorState = datosModeloUiState.edad,
            validacionState = validacionDatosModeloUiState.validacionEdad,
            onValueChange = { onFormEjemploEvent(FormEjemploEvent.OnChangeEdad(it)) }
        )

        OutlinedTextFieldReal(
            modifier = Modifier.fillMaxWidth(),
            label = "Altura",
            valorState = datosModeloUiState.altura,
            numeroDecimales = 2,
            unidades = "m",
            validacionState = validacionDatosModeloUiState.validacionAltura,
            onValueChange = { onFormEjemploEvent(FormEjemploEvent.OnChangeAltura(it)) }
        )

        OutlinedTextFieldEmail(
            modifier = Modifier.fillMaxWidth(),
            emailState = datosModeloUiState.correo,
            validacionState = validacionDatosModeloUiState.validacionCorreo,
            onValueChange = { onFormEjemploEvent(FormEjemploEvent.OnChangeCorreo(it)) }
        )

        OutlinedTextFieldPhone(
            modifier = Modifier.fillMaxWidth(),
            telefonoState = datosModeloUiState.telefono,
            validacionState = validacionDatosModeloUiState.validacionTelefono,
            onValueChange = { onFormEjemploEvent(FormEjemploEvent.OnChangeTelefono(it)) }
        )

        OutlinedTextFieldPassword(
            modifier = Modifier.fillMaxWidth(),
            passwordState = datosModeloUiState.clave,
            validacionState = validacionDatosModeloUiState.validacionClave,
            onValueChange = { onFormEjemploEvent(FormEjemploEvent.OnChangeClave(it)) }
        )

        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

        Button(
            onClick = { onFormEjemploEvent(FormEjemploEvent.OnAceptar) }
        ) {
            Text(text = "Aceptar")
        }

        if (informacionEstadoState is InformacionEstadoUiState.Error) {
            Spacer(modifier = Modifier.padding(8.dp))
            SnackbarError(
                mensajeError = informacionEstadoState.mensaje,
                onDismissError =  {
                    (informacionEstadoState as InformacionEstadoUiState.Error).onDismiss()
                    onFormEjemploEvent(FormEjemploEvent.OnDismissError)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormEjemploScreenPreview() {
    LibreriaUtilidadesTheme {
        Surface {
            val vm = FormEjemploViewModel()

            FormEjemploScreen(
                datosModeloUiState = vm.datosModeloUiState,
                validacionDatosModeloUiState = vm.validacionDatosModeloUiState,
                informacionEstadoState = vm.informacionEstadoState,
                onFormEjemploEvent = vm.onFormEjemploEvent
            )
        }
    }
}
