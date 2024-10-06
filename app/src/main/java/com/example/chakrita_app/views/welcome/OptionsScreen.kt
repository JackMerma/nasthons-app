package com.example.chakrita_app.views.welcome

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import com.example.chakrita_app.R
import com.example.chakrita_app.navigation.CustomTopBar
import com.example.chakrita_app.ui.theme.type_bagel
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.result.launch

private const val title = "Look Up an Object"

@Composable
fun OptionsScreen() {
    var imageBitmap by remember { mutableStateOf<Bitmap?>(null) }
    val context = LocalContext.current

    // Lanzador para abrir la cámara
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap: Bitmap? ->
        imageBitmap = bitmap
    }

    // Lanzador para solicitar el permiso de la cámara
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            cameraLauncher.launch()  // Abrir la cámara si el permiso fue concedido
        } else {
            // Manejar el caso donde el permiso fue denegado
            // Aquí podrías mostrar un mensaje de error o advertencia
        }
    }

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {

                CustomTopBar()

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = title,
                    style = TextStyle(
                        fontFamily = type_bagel,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp) // Espacio entre las imágenes
            ) {
                // Imagen de la cámara como botón
                Image(
                    painter = painterResource(id = R.drawable.camera),
                    contentDescription = "Camera Button",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .clickable {
                            // Verifica si el permiso ya fue concedido
                            if (ContextCompat.checkSelfPermission(
                                    context,
                                    Manifest.permission.CAMERA
                                ) == PackageManager.PERMISSION_GRANTED
                            ) {
                                // Si el permiso ya está concedido, abre la cámara
                                cameraLauncher.launch()
                            } else {
                                // Si el permiso no está concedido, solicita el permiso
                                permissionLauncher.launch(Manifest.permission.CAMERA)
                            }
                        }
                )

                // Mostrar la imagen capturada (si existe)
                imageBitmap?.let {
                    Image(
                        bitmap = it.asImageBitmap(),
                        contentDescription = "Imagen Capturada",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.message),
                    contentDescription = "Message Button",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.alert),
                    contentDescription = "Search Button", // Descripción única
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )
            }
        }
    )
}

@Preview
@Composable
fun OptionsPreview() {
    OptionsScreen()
}
