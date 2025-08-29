package com.example.cartedevisite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                Surface (
                    modifier = Modifier.fillMaxSize()
                ) {
                    CarteVisite(
                        nomComplet = stringResource(R.string.nomComplet),
                        titre = stringResource(R.string.titre),
                        numeroTelephone = stringResource(R.string.numeroTelephone),
                        siteWeb = stringResource(R.string.lien),
                        mail = stringResource(R.string.email)
                    )
                }
            }
        }
    }
}

@Composable
fun CarteVisite(nomComplet : String, titre : String, numeroTelephone : String, siteWeb : String,
                mail : String){
    val royalBackground = Brush.linearGradient(
        listOf(Color.Black, Color(0xFF1A1A1A), Color(0xFFFFD700).copy(alpha = 0.15f))
    )
    Column (modifier = Modifier
        .fillMaxSize()
        .background(royalBackground)) {
        Column (modifier = Modifier
            .fillMaxSize()
            .weight(1.5f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            val image = R.drawable.king_removebg_preview
            Image(
                painter = painterResource(image),
                contentDescription = "Couronne Royale",
                modifier = Modifier
                    .size(180.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = nomComplet,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFFD700)
            )
            Text(
                text = titre,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color.LightGray,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        Column (modifier = Modifier
            .weight(0.5f)
            .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)){
            InfoRow(Icons.Filled.Call, numeroTelephone, Color(0xFF00FF7F))
            InfoRow(Icons.Filled.Share, siteWeb, Color(0xFFFFD700))
            InfoRow(Icons.Filled.Email, mail, Color(0xFF1E90FF))
        }
    }
}

@Composable
fun InfoRow(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String, tint: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = tint,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CarteVisitePreview(){
    CarteVisite(
        nomComplet = stringResource(R.string.nomComplet),
        titre = stringResource(R.string.titre),
        numeroTelephone = stringResource(R.string.numeroTelephone),
        siteWeb = stringResource(R.string.lien),
        mail = stringResource(R.string.email)
    )
}