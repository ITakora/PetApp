package hoods.com.jetpetrescue.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hoods.com.jetpetrescue.components.DetailPetInfo
import hoods.com.jetpetrescue.data.DummyPetDataSource


@Composable
fun DetailScreen(petIndex: Int, onNavigation: () -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Detail") },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .size(height = 24.dp, width = 24.dp)
                        .clickable { onNavigation.invoke() },
                    tint = MaterialTheme.colors.onSurface,

                    )
            },
            backgroundColor = MaterialTheme.colors.background,
            contentColor = MaterialTheme.colors.onSurface

        )
    }
    ) { paddingValues ->
        val pet = DummyPetDataSource.dogList[petIndex]
        LazyColumn(contentPadding = paddingValues) {
            item {

                Image(
                    painter = painterResource(id = pet.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(346.dp),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop
                )
                DetailPetInfo(pet =pet )
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
private fun PrevDetailScreen() {
    DetailScreen(0) {

    }
}