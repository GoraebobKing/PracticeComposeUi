package kr.co.kwon.compose.ui.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.RoundedCorner
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import kr.co.kwon.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            LazyColumn {
                items(listInItem()) {
                    mainRecyclerViewHolder(str = it)
                }
            }
        }
    }

    private fun listInItem() = mutableListOf<String>().apply {
        add("기본 TEXT")
        add("기본 BUTTON")
        add("기본 IMAGEVIEW")
        add("기본 View 사이즈 및 ConstraintLayout처럼 되는지 체크")
        add("기본 RecyclerView")
    }
}


@Preview
@Composable
fun DefaultPreview() {
    mainRecyclerViewHolder(str = "기본 TEXT, IMAGEVIEW, BUTTON 체크해보기")
}

@Composable
fun mainRecyclerViewHolder(str : String) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(18.dp)
            .border(1.dp, Color.Red, RoundedCornerShape(8.dp))
            .height(50.dp)
            .clickable {

            }
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = str, color = Color.Red)
        }
    }
}


/**
 * Modifier : 컴포저블의 크기, 레이아웃, 동작 및 모양 변경 , 접근성 라벨과 같은 정보 추가, 사용자 입력 처리
 * **/

/**
 * Column : 수직으로 먼가를 나열하는 메소드
 * **/
@Composable
fun ColumnTest() {
    Column {
        Text(text = "내가만든 컵케익")
        Text(text = "니가만든 제빵소")
    }
}

/**
 * Row : 수평으로 먼가를 나열하는 메소드
 * LocalContext.current : context
 * **/
@Composable
fun RowTest(ctx : Context) {
    Row(modifier =
    Modifier
        .fillMaxWidth()
        .background(Color.Red)
        .clickable {
            Toast
                .makeText(ctx, "바디바디 핫바디", Toast.LENGTH_LONG)
                .show()
        }
    ) {
        Text(text = "내가만든 컵케익")
        Text(text = "니가만든 제빵소")
    }
}

@Composable
fun ImageViewTest() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "ImageTest",
            modifier = Modifier
                .size(50.dp)
                .offset(x = 10.dp)
        )

        Column(verticalArrangement = Arrangement.Center) {
            Text(text = "어렵네 컴포즈", modifier = Modifier.offset())
            Text(text = "콘스트레인트 없나?", modifier = Modifier.offset())
        }


    }
}



