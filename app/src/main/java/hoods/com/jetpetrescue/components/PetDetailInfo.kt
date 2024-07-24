package hoods.com.jetpetrescue.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hoods.com.jetpetrescue.R
import hoods.com.jetpetrescue.data.DummyPetDataSource
import hoods.com.jetpetrescue.data.model.Pet

@Composable
fun DetailPetInfo(pet: Pet) {
    Row(modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Column(modifier = Modifier.align(alignment = Alignment.CenterVertically)) {
            Text(
                text = pet.name,
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.onSurface,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.Bottom) {
                Icon(painter = painterResource(id = R.drawable.ic_location), contentDescription = null, tint = Color.Red, modifier = Modifier.size(20.dp) )
                Text(text = pet.location, style = MaterialTheme.typography.subtitle1, color = MaterialTheme.colors.onSurface, modifier = Modifier.padding(start = 8.dp, top = 0.dp,  end = 12.dp, bottom = .0.dp))
            }
        }



    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PrevDetailPetInfo() {
    val pet = DummyPetDataSource.dogList[0]
    DetailPetInfo(pet = pet)
}