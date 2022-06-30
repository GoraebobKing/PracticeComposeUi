package kr.co.kwon.compose.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.kwon.compose.R

/**
 * Create by kwonhyeok on 2022/06/30
 * **/
class PracticeTextActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                basicTextView()
                deepTextView()
            }
        }
    }
}



/**
 * colorResource : color.xml에 있는 색상을 주입하는 방식
 * fontSize : 폰트 사이즈에 dp를 넣으면 에러가 발생
 * textAlign : Text 정렬
 * overflow : 텍스트를 보여주는 영역에 대한 처리
 * TextOverflow.Clip) 영역을 벗어나면 자른다
 * TextOverflow.Ellipsis) 영역을 벗어나면... 처리
 * TextOverflow.Visible) 영역을 벗어나도 보임
 * **/
@Composable
fun basicTextView(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 18.dp, start = 18.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = Modifier
                .width(250.dp)
                .background(color = Color.Black),
            color = colorResource(id = R.color.color_ff0000),
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Right,
            text = "컴포즈 어렵다...",
        )

        Text(
            modifier = Modifier
                .padding(top = 18.dp)
                .width(70.dp)
                .background(color = Color.Black),
            color = colorResource(id = R.color.color_ff0000),
            maxLines = 1,
            overflow = TextOverflow.Clip,
            text = "컴포즈 와이라노",
        )

        Text(
            modifier = Modifier
                .padding(top = 18.dp)
                .width(70.dp)
                .background(color = Color.Black),
            color = colorResource(id = R.color.color_ff0000),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            text = "컴포즈 와저라노",
        )

        Text(
            modifier = Modifier
                .padding(top = 18.dp)
                .width(70.dp)
                .height(30.dp)
                .background(color = Color.Black),
            color = colorResource(id = R.color.color_ff0000),
//            maxLines = 1,
            overflow = TextOverflow.Visible,
            text = "컴포즈 와그라노",
        )
    }
}

/**
 * 텍스트 1개를 이용하여 다르게 스타일링하기
 * 이전 SpannableStringBuilder 를 이용하여 커스텀 폰트를 사용하는등 하는 방법을 간단하게 이용가능
 * **/
@Composable
fun deepTextView(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 18.dp, start = 18.dp), horizontalAlignment = Alignment.Start) {
        Text(
            text = buildAnnotatedString() {
                withStyle(
                    SpanStyle(
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("와따시와 ")
                }

                withStyle(
                    SpanStyle(
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Normal
                    )
                ) {
                    append("칸코쿠 ")
                }

                withStyle(
                    SpanStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Italic
                    )
                ) {
                    append("데스")
                }
            })
    }
}