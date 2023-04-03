package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceroller.ui.theme.DiceRollerTheme
import androidx.compose.material.Text
import androidx.compose.ui.res.stringResource
import android.widget.Button
import androidx.compose.material.Button
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
//이 앱은 버튼과 이미지로만 구성되므로 이 구성 가능한 함수를 앱 자체로 생각하면 됨.
fun DiceRollerApp(){
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize() //Modifier 객체에 chaining해서 레이아웃이 전체 화면을 채우도록 한다.
        .wrapContentSize(Alignment.Center) //사용 가능한 공간이 최소한 내부에 있는 구성요소만큼 커야한다고 지정
        //여기서 Alignment는 객체를 사용 가능한 공간 내에서 구성요소를 Center로 정렬해야 하는 방식을 지정함.
    )
}
@Composable
//레이아웃의 UI 구성요소를 나타내며 버튼 클릭 및 이미지 표시 로직도 표시한다.
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) { //기본값(Modifier) 할당
    var result by remember { mutableStateOf(1) }
    //result 변수의 값은 roll버튼을 누르면 재설정되므로 표시되는 이미지를 결정해야 한다.
    val imageResource = when(result) {
        1 -> R.drawable.guni
        2 -> R.drawable.ju
        3 -> R.drawable.juyeon
        4 -> R.drawable.q
        5 -> R.drawable.q__2_
        6 -> R.drawable.q
        7 -> R.drawable.sanghun
        8 -> R.drawable.son
        9 -> R.drawable.son2
        10 -> R.drawable.sonny
        11 -> R.drawable.sun
        else -> R.drawable.sunwoo

    }
    Column(
        modifier = modifier, //modifier인수는 Column함수의 컴포저블이 modifier 인스턴스에서 호출된 제약 조건을 준수하도록 함.
        horizontalAlignment = Alignment.CenterHorizontally //열이 너비를 기준으로 기기 화면의 중앙에 배치된다.
    ) {
        androidx.compose.foundation.Image(painter = painterResource(id = imageResource),
            contentDescription = result.toString() ) //주사위 그림이 위에 먼저 위치해야 함.
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {result = (1..12).random()}) {//중괄호는 onClick 매개변수에 전달된다.
            Text(stringResource(R.string.random)) //버튼에 쓰여질 text
        }

    }
}