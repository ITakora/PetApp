package hoods.com.jetpetrescue.home

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import hoods.com.jetpetrescue.components.PetInfoComponent
import hoods.com.jetpetrescue.components.TopBar
import hoods.com.jetpetrescue.data.DummyPetDataSource

@SuppressLint("SuspiciousIndentation")
@Composable
fun HomeScreens(
    onSwitchClick : () -> Unit,
    onPetClick: (Int) -> Unit
) {
    val petList = DummyPetDataSource.dogList

        Scaffold (topBar =  { TopBar{onSwitchClick.invoke()}} ) { paddingValues ->
            LazyColumn(contentPadding = paddingValues) {
                itemsIndexed(petList){index,pet ->
                    PetInfoComponent(pet =pet ) {
                        onPetClick(index)
                    }
                }
            }

        }
}