package com.afrikalabs.motionjet

import TopBarWithSearchMotion
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.SearchBar
import com.afrikalabs.motionjet.ui.theme.MotionJetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MotionJetTheme {
                AutoScrollingTextScreenWithSpeed()
//                SearchBar() { }
            }
        }
    }
}
