package hoods.com.jetpetrescue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface




import hoods.com.jetpetrescue.home.HomeScreens



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface ( color = MaterialTheme.colors.background) {
                HomeScreens(onSwitchClick ={} ){

                }
            }
        }
    }
}



