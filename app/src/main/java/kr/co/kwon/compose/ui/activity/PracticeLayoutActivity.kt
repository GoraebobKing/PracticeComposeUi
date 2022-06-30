package kr.co.kwon.compose.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.kwon.compose.R

/**
 * Create by kwonhyeok on 2022/06/30
 * **/
class PracticeLayoutActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            deepLayout()
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    deepLayout()
}

/**
 * Column : LinearLayout Vertical
 * Row : LinearLayout Horizontal
 * Box : FrameLayout
 * Box 에서는 컴포터들을 contentAlignment 을 이용하여 위치를 정의해준다.
 * **/
@Composable
fun basicLayout(){

    Column {
        Column() {
            Text(text = "Column is Best", fontSize = 20.sp)
            Text(text = "Column is Worst", fontSize = 20.sp)
        }

        Row() {
            Text(text = "Row is Best", fontSize = 20.sp)
            Text(text = "Row is Worst", fontSize = 20.sp)
        }

        Box() {
            Text(text = "Box is Best", fontSize = 20.sp)
            Text(text = "Box is Worst", fontSize = 20.sp)
        }

//        BoxWithConstraints(contentAlignment = ) {
//
//        }
    }
}

@Composable
fun deepLayout(){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(238.dp)
                .align(alignment = Alignment.BottomCenter)
                .background(
                    color = colorResource(
                        id = R.color.color_ff0000
                    )
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(36.dp)
                    .padding(top = 6.dp)
//                    .background(colorResource(id = R.color.color_ffffff))
            ) {
                Text(
                   modifier = Modifier
                       .padding(start = 18.dp)
                       .size(20.dp)
                       .background(
                           color = colorResource(id = R.color.color_7f3bd8),
                           shape = RoundedCornerShape(25.dp)
                       )
                       .align(alignment = Alignment.CenterStart),
                   text = "5", fontSize = 13.sp, color = colorResource(id = R.color.color_ffffff),
                    textAlign = TextAlign.Center
                )

                Text(
                    modifier = Modifier
                        .padding(end = 18.dp)
                        .background(colorResource(id = R.color.color_ff0000))
                        .align(alignment = Alignment.CenterEnd),
                    text = "리프레쉬", fontSize = 13.sp, color = colorResource(id = R.color.color_1e1d24)
                )
            }

            Box(
                modifier = Modifier.padding(top = 14.dp, start = 18.dp, end = 18.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "광화문연가", color = colorResource(id = R.color.color_1e1d24),
                    fontSize = 16.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(124.dp)
                        .height(40.dp)
                        .background(
                            color = colorResource(id = R.color.color_ffffff),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .border(
                            width = 3.dp,
                            color = colorResource(id = R.color.color_1e1d24),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .align(alignment = Alignment.Center)
                )

//                .fillMaxWidth()
//                .background(
//                    colorResource(id = R.color.color_7f3bd8),
//                    shape = RoundedCornerShape(12.dp)
//                )
            }

        }
    }
}