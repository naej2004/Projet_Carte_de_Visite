package com.example.cartedevisite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartedevisite.ui.theme.CarteDeVisiteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarteDeVisiteTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    Column {
                        CarteVisite(nomComplet = "KING NAEJ",
                            titre = "Naej's Party",
                            numeroTelephone = "0716841889",
                            siteWeb = "kingnaej.com",
                            mail = "kingnaej@gmail.com")
                    }
                }
            }
        }
    }
}

@Composable
fun CarteVisite(nomComplet : String, titre : String, numeroTelephone : String, siteWeb : String,
                mail : String){
    Column (modifier = Modifier
        .fillMaxSize()) {
        Column (modifier = Modifier
            .fillMaxSize()
            .weight(1.6f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            val image = R.drawable.king_removebg_preview
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
            )
            Text(
                text = nomComplet,
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(top = 10.dp)
            )
            Text(
                text = titre,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(top = 5.dp)
            )
        }
        Column (modifier = Modifier
            .fillMaxSize()
            .weight(0.4f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Row (verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start) {
                Icon(
                    imageVector = Icons.Filled.Call,
                    contentDescription = "Numero de Telephone",
                    tint = Color.Green,
                    modifier = Modifier
                        .size(20.dp)
                )
                Text(
                    text = numeroTelephone,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(top = 10.dp, start = 10.dp)
                )
            }
            Row (verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Partage",
                    tint = Color.Green,
                    modifier = Modifier
                        .size(20.dp)
                )
                Text(
                    text = siteWeb,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(top = 10.dp, start = 10.dp)
                )
            }
            Row (verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Adresse Email",
                    tint = Color.Blue,
                    modifier = Modifier
                        .size(20.dp)
                )
                Text(
                    text = mail,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(top = 10.dp, start = 10.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CarteVisitePreview() {
    CarteDeVisiteTheme {
        CarteVisite(nomComplet = "KING NAEJ",
            titre = "Naej's Party",
            numeroTelephone = "0716841889",
            siteWeb = "kingnaej.com",
            mail = "kingnaej@gmail.com")
    }
}