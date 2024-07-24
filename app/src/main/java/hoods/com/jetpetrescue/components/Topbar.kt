package hoods.com.jetpetrescue.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hoods.com.jetpetrescue.R

@Composable
fun TopBar(onToggleSwitch: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Hello",
                textAlign = TextAlign.Start,
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Find a New Friend near you to adopt",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onSurface
            )
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, end = 36.dp)
            ) {
            SwitchIcon{onToggleSwitch.invoke()}
        }

    }
}

@Composable
fun SwitchIcon(onToggleSwitch: () -> Unit) {
    val icon = if (isSystemInDarkTheme()) {
        painterResource(id = R.drawable.ic_switch_on)
    } else {
        painterResource(id = R.drawable.ic_switch_off)
    }
    Icon(
        painter = icon, contentDescription = null,
        modifier = Modifier
            .clickable {onToggleSwitch.invoke() }
            .size(30.dp),

        )
}


@Preview(showBackground = true)
@Composable
private fun PrevTopBar() {
    TopBar(){}
}