package hoods.com.jetpetrescue.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hoods.com.jetpetrescue.R

@Composable
fun PetInfoComponent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row {
            Card(elevation = 3.dp, shape = RoundedCornerShape(8.dp)) {
                Image(
                    modifier = Modifier
                        .size(80.dp, 80.dp),


                    painter = painterResource(id = R.drawable.pet_eight),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,

                    )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Column {
                Text(
                    text = "Peter",
                    color = MaterialTheme.colors.onSurface,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Text(
                        text = buildString {
                            append("Adult")
                            append(" | ")
                            append("Persia")
                        },
                        color = MaterialTheme.colors.onSurface,
                        style = MaterialTheme.typography.caption,
                    )
                }
                Spacer(modifier = Modifier.height(13.dp))
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_location),
                        contentDescription = null,
                        tint = Color.Red
                    )
                    Text(
                        text = "Toronto CA",
                        color = MaterialTheme.colors.onSurface,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
            }

            Column (modifier = Modifier.fillMaxWidth()) {
                Button(onClick = {}, modifier = Modifier.align(alignment = Alignment.End), colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray, contentColor = MaterialTheme.colors.onSurface) ) {
                    Text(text = "Male")


                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Adoptable", modifier = Modifier.align(alignment = Alignment.End), style = MaterialTheme.typography.caption, color = MaterialTheme.colors.onSurface)

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PetPreview() {
    PetInfoComponent()
}