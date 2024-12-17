package com.bluecode.PhraseDaily.presentation.startScreen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun StartScren(
    modifier: Modifier = Modifier,
    onNavigate: () -> Unit = {}
    ) {

    var isLongPressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(targetValue = if (isLongPressed) 1f else 1f, label = "") // Scale effect

    // Animated size and color change on long press
    val size by animateDpAsState(targetValue = if (isLongPressed) 250.dp else 200.dp, label = "")
    val color by animateColorAsState(targetValue = if (isLongPressed) Color.Red else Color.Blue,
        label = ""
    )

    Box(modifier = Modifier.fillMaxSize()){

        Column(modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier
                    .size(size)
                    .scale(scale)
                    .clip(CircleShape)
                    .background(color)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onPress = {
                                isLongPressed = true
                                tryAwaitRelease()
                                isLongPressed = false
                                onNavigate()
                            }
                        )
                    }
                ,
                contentAlignment = Alignment.Center

            ){
                Text(text = "Start", color = Color.White)
            }

        }
    }


}

@Preview(showBackground = true)
@Composable
fun StartScrenPreview() {
    StartScren()
}
