package eu.milo4apps.artspacecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    val imageResource = R.drawable.test_picture

    Column(
        Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .weight(2f)
                .border(0.5.dp, Color.Gray)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = "Some Description",
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp),
                alignment = Alignment.TopCenter
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
                    Text(text = "ARTWORK_NAME")
                    Text(text = "AUTHOR_NAME")
                }
            }


            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(8.dp)
                ) {
                    Text("Previous")
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(8.dp)
                ) {
                    Text("Next")
                }
            }
        }
    }

}

@Composable
fun ControlButton() {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceComposeTheme {
        ArtSpaceScreen()
    }
}