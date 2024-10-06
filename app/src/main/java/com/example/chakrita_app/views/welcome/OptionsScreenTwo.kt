package com.example.chakrita_app.views.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chakrita_app.R
import com.example.chakrita_app.navigation.CustomTopBar
import com.example.chakrita_app.ui.theme.type_bagel

private const val title = "Look Up an Object"
private val description = "description\nposted near to the paint"

@Composable
fun OptionsScreenTwo(){

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
                Image(
                    painter = painterResource(id = R.drawable.camera),
                    contentDescription = "Camera Button",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.message),
                    contentDescription = "Gallery Button",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }
        }
    )
}

@Preview
@Composable
fun OptionsTwoPreview(){
    OptionsScreenTwo()
}