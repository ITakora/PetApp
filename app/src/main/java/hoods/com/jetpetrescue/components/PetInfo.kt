package hoods.com.jetpetrescue.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hoods.com.jetpetrescue.R
import hoods.com.jetpetrescue.data.DummyPetDataSource
import hoods.com.jetpetrescue.data.model.Pet

@Composable
fun PetInfoComponent(pet: Pet, onPetItemClick:(Pet) -> Unit) {
    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 9.dp)
            .clickable {onPetItemClick(pet) }
            .fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.surface,

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Row {
                Card(elevation = 3.dp, shape = RoundedCornerShape(8.dp)) {
                    Image(
                        modifier = Modifier
                            .size(80.dp, 80.dp),
                        painter = painterResource(id =pet.image),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.CenterStart
                    )
                }
                Spacer(modifier = Modifier.size(18.dp))
                Column(modifier = Modifier.align(alignment = Alignment.CenterVertically)) {
                    Text(
                        text = pet.name,
                        color = MaterialTheme.colors.onSurface,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.subtitle1
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Text(
                            text = buildString {
                                append(pet.age)
                                append(" | ")
                                append(pet.breed)
                            },
                            color = MaterialTheme.colors.onSurface,
                            style = MaterialTheme.typography.caption,
                        )
                    }
                    Spacer(modifier = Modifier.height(13.dp))
                    Row(verticalAlignment = Alignment.Bottom) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_location),
                            contentDescription = null,
                            tint = Color.Red
                        )
                        Text(
                            text = pet.location,
                            color = MaterialTheme.colors.onSurface,
                            style = MaterialTheme.typography.caption,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .height(77.5.dp)
                    .padding(end = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                GenderTag(gender = pet.gender, modifier = Modifier,)
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Adoptable",
                    modifier = Modifier.align(alignment = Alignment.End),
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSurface
                )
            }

        }
    }
}


@Composable
fun GenderTag(gender: String, modifier: Modifier, style: TextStyle = MaterialTheme.typography.caption,) {
    val color = if (gender == "Male") {
        Color.Blue
    } else {
        Color.Red
    }

    Box(
        modifier = modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(12.dp))
            .background(color.copy(alpha = .2f))

    ) {
        Text(
            text = gender,
            modifier = Modifier.padding(12.dp, 4.dp, 12.dp, 6.dp),
            style = style,
            color = color
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PetPreview() {
    val petItem = DummyPetDataSource.dogList.random()
    PetInfoComponent(petItem){

    }
}