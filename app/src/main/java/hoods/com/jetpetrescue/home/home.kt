package hoods.com.jetpetrescue.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import hoods.com.jetpetrescue.components.PetInfoComponent
import hoods.com.jetpetrescue.data.DummyPetDataSource

@Composable
fun HomeScreens() {
    val petList = DummyPetDataSource.dogList

    LazyColumn {
        items(petList){pet ->
            PetInfoComponent(pet =pet ) {

            }
        }
    }
}