package com.example.chakrita_app.views.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.chakrita_app.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chakrita_app.navigation.CustomTopBar
import com.example.chakrita_app.navigation.CustomTopBarHome
import com.example.chakrita_app.ui.theme.type_bagel

private const val title = "We take care of your chakra"
private val description = "description of the app nad others\nposted near to the paint"

@Composable
fun WelcomeScreen(){

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {

                CustomTopBarHome()

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

                Text(
                    text = description,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),  //padding para evitar que el contenido se solape con la topBar.
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.welcome),
                    contentDescription = "Search Button",
                    modifier = Modifier

                )
            }
        }
    )
}

@Preview
@Composable
fun WelcomePreview(){
    WelcomeScreen()
}