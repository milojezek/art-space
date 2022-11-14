package eu.milo4apps.artspacecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.milo4apps.artspacecompose.ui.theme.ArtSpaceComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen() {
    var currentArtworkNumber by remember { mutableStateOf(1) }

    val imageResource = when(currentArtworkNumber) {
        1 -> R.drawable.artwork1
        2 -> R.drawable.artwork2
        3 -> R.drawable.artwork3
        4 -> R.drawable.artwork4
        else -> R.drawable.artwork5
    }

    val authorTextResource = when(currentArtworkNumber) {
        1 -> R.string.author1
        2 -> R.string.author2
        3 -> R.string.author3
        4 -> R.string.author4
        else -> R.string.author5
    }

    val artworkTextResource = when(currentArtworkNumber) {
        1 -> R.string.artwork1
        2 -> R.string.artwork2
        3 -> R.string.artwork3
        4 -> R.string.artwork4
        else -> R.string.artwork5
    }

    val artworkYearResource = when(currentArtworkNumber) {
        1 -> R.string.art_1_year
        2 -> R.string.art_2_year
        3 -> R.string.art_3_year
        4 -> R.string.art_4_year
        else -> R.string.art_5_year
    }

    Column(
        Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .weight(2f)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = stringResource(artworkTextResource),
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
            )
        }


        Column(
            Modifier.weight(1f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .padding(8.dp),
                elevation = 3.dp,
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = stringResource(artworkTextResource),
                        fontSize = 20.sp
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Text(
                            text = stringResource(authorTextResource),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = stringResource(artworkYearResource),
                            color = Color.Gray
                        )
                    }
                }
            }


            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    Modifier.weight(1f)
                ) {
                    Button(
                        onClick = {
                            if (currentArtworkNumber == 1) {
                                currentArtworkNumber = 5
                            } else {
                                currentArtworkNumber--
                            }
                                  },
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                    ) {
                        Text(stringResource(R.string.button_previous))
                    }
                }
                Column(Modifier.weight(1f)) {
                    Button(
                        onClick = {
                            if (currentArtworkNumber == 5) {
                                currentArtworkNumber = 1
                            } else {
                                currentArtworkNumber++
                            }
                        },
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                    ) {
                        Text(stringResource(R.string.button_next))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceComposeTheme {
        ArtSpaceScreen()
    }
}