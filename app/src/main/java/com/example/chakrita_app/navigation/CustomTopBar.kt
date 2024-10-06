package com.example.chakrita_app.navigation
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
import com.example.chakrita_app.R
import com.example.chakrita_app.views.welcome.WelcomeScreen

@Composable
fun CustomTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = "flecha",
            modifier = Modifier
                .padding(start = 16.dp) // Añade padding al lado izquierdo
                .size(70.dp)
                .clickable {
                    //navController.popBackStack() // Regresa a la vista anterior
                }
        )

        Spacer(modifier = Modifier.weight(1f)) // Espacio flexible para empujar el logo al centro

        Image(
            painter = painterResource(id = R.drawable.logo), // Reemplaza 'logo' con el ID de tu imagen
            contentDescription = "logo",
            modifier = Modifier
                .size(50.dp)
        )

        Spacer(modifier = Modifier.weight(2f)) // Espacio flexible para empujar el ícono de configuración a la derecha

    }
}

@Composable
fun CustomTopBarHome() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun CustomTopBarPreview(){
    CustomTopBar()
}
@Preview
@Composable
fun CustomTopBarHomePreview(){
    CustomTopBarHome()
}