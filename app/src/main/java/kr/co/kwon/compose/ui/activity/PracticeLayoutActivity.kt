package kr.co.kwon.compose.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.atLeast
import androidx.constraintlayout.compose.atMost
import kr.co.kwon.compose.R

/**
 * Create by kwonhyeok on 2022/06/30
 * **/
class PracticeLayoutActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            deepLayout()
//            basicLayout()
        }
    }
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

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
//                .padding(start = 18.dp, end = 18.dp)
                .background(color = colorResource(id = R.color.color_ff0000))
        ) {

            val (
                firstTxt, secondTxt
            ) = createRefs()


            Text(
                modifier = Modifier.constrainAs(firstTxt) {
                    top.linkTo(parent.top, margin = 18.dp)
                    start.linkTo(parent.start, margin = 18.dp)
                },
                text = "ConstraintLayout is Best", fontSize = 20.sp)


            //width -> Dimension.preferredWrapContent 으로 값을 줄경우 이전 0dp를 주는것과 같음
            //Dimension.preferredWrapContent  .atMost()  or  .atLeast() 해보지는 않았지만 최대값 또는 최소값일듯?
            Text(
                modifier = Modifier.constrainAs(secondTxt) {
                    top.linkTo(firstTxt.top)
                    bottom.linkTo(firstTxt.bottom)
                    start.linkTo(firstTxt.end, margin = 10.dp)
                    end.linkTo(parent.end, margin = 18.dp)
                    width = Dimension.preferredWrapContent
                },
                text = "ConstraintLayout is Worst", maxLines = 1,
                fontSize = 20.sp, overflow = TextOverflow.Ellipsis)
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
//                .background(
//                    color = colorResource(
//                        id = R.color.color_ff0000
//                    )
//                )
        ) {
            //상단 5번과 프레쉬 영역
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

            //2번째 광화문 부분
            Box(
                modifier = Modifier
                    .padding(top = 14.dp, start = 18.dp, end = 18.dp)
                    .fillMaxWidth()
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .background(
                            color = colorResource(id = R.color.color_7f3bd8),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .align(alignment = Alignment.Center)
                )

                /**
                 * TextView 백그라운드 처리로 하나의 위젯으로
                 * UI 형태를 만들고 싶었지만 현재 버그인지 지원이 안되는건지 텍스트가 높이가 있을경우
                 * 
                 * **/
                Text(
                    text = "광화문", color = colorResource(id = R.color.color_1e1d24),
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
                            color = colorResource(id = R.color.color_7f3bd8),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .align(alignment = Alignment.Center)
                )

                /**
                 * 이전 Button 개발시 사이즈가 적어서 강제로 키워주는 부분이 있었는데
                 * 컴포즈에서는 자동으로 넓게 영역을 잡아주는듯하다
                 * **/
                TextButton(
                    onClick = {

                    }) {
                        Text(
                            text = "교대",
                            color = colorResource(id = R.color.color_ffffff),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W500
                        )
                    }

                TextButton(
                    modifier = Modifier.align(alignment = Alignment.CenterEnd),
                    onClick = {

                    }) {
                    Text(
                        text = "역삼",
                        color = colorResource(id = R.color.color_ffffff),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W500
                    )
                }
            }

            //3번째 출도착 영역
            //예전같으면 ConstraintLayout을 사용하겠지만, compose에서는 트리 구조가 아니라서 복잡하더라도 쓰지 않도록한다.
            //안쓰면 너무 힘듬,,,
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 18.dp, top = 20.dp, end = 18.dp)
            ) {

                val (
                    departTxt1, departTxt2, departTime1, departTime2,
                    divider,
                    arriveTxt1, arriveTxt2, arriveTime1, arriveTime2
                ) = createRefs()
                Text(
                    modifier = Modifier.constrainAs(departTxt1){
                        start.linkTo(parent.start)
                        end.linkTo(departTime1.start, margin = 6.dp)
                        width = Dimension.fillToConstraints
                    },
                    text = "인천공항1터미널행", maxLines = 1, overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.W500, fontSize = 12.sp, color = colorResource(
                    id = R.color.color_606060
                ))

                Text(
                    modifier = Modifier.constrainAs(departTxt2){
                        top.linkTo(departTxt1.bottom, margin = 6.dp)
                        start.linkTo(parent.start)
                        end.linkTo(departTime2.start, margin = 6.dp)
                        width = Dimension.fillToConstraints
                    },
                    text = "인천공항2터미널행", maxLines = 1, overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.W500, fontSize = 12.sp, color = colorResource(
                    id = R.color.color_606060
                ))

                Text(
                    modifier = Modifier.constrainAs(departTime1){
                        top.linkTo(departTxt1.top)
                        bottom.linkTo(departTxt1.bottom)
                        end.linkTo(divider.start, margin = 8.dp)
                    },
                    text = "1분1초", textAlign = TextAlign.Right,
                    fontWeight = FontWeight.W400, fontSize = 12.sp, color = colorResource(
                        id = R.color.color_eb5757
                    ))

                Text(
                    modifier = Modifier.constrainAs(departTime2){
                        top.linkTo(departTxt2.top)
                        bottom.linkTo(departTxt2.bottom)
                        end.linkTo(divider.start, margin = 8.dp)
                    },
                    text = "2분2초", textAlign = TextAlign.Right,
                    fontWeight = FontWeight.W400, fontSize = 12.sp, color = colorResource(
                        id = R.color.color_eb5757
                    ))

                Divider(
                    modifier = Modifier
                        .constrainAs(divider) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .width(1.dp)
                        .height(38.dp),
                    color = colorResource(id = R.color.color_eeeeee),
                )

                Text(
                    modifier = Modifier.constrainAs(arriveTxt1){
                        start.linkTo(divider.start, margin = 8.dp)
                        end.linkTo(arriveTime1.start, margin = 6.dp)
                        width = Dimension.fillToConstraints
                    },
                    text = "강남대로변 저 한복판", maxLines = 1, overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.W500, fontSize = 12.sp, color = colorResource(
                        id = R.color.color_606060
                    ))

                Text(
                    modifier = Modifier.constrainAs(arriveTxt2){
                        top.linkTo(arriveTxt1.bottom, margin = 6.dp)
                        start.linkTo(divider.start, margin = 8.dp)
                        end.linkTo(arriveTime1.start, margin = 6.dp)
                        width = Dimension.fillToConstraints
                    },
                    text = "강남대로변 저 한복판 꽉막힌 차안", maxLines = 1, overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.W500, fontSize = 12.sp, color = colorResource(
                        id = R.color.color_606060
                    ))

                Text(
                    modifier = Modifier
                        .constrainAs(arriveTime1) {
                            top.linkTo(arriveTxt1.top)
                            bottom.linkTo(arriveTxt1.bottom)
                            end.linkTo(parent.end)
                        }
                        .width(58.dp),
                    text = "44분55초", textAlign = TextAlign.Right,
                    fontWeight = FontWeight.W400, fontSize = 12.sp, color = colorResource(
                        id = R.color.color_eb5757
                    ))

                Text(
                    modifier = Modifier.constrainAs(arriveTime2){
                        top.linkTo(arriveTxt2.top)
                        bottom.linkTo(arriveTxt2.bottom)
                        end.linkTo(parent.end)
                    },
                    text = "60분50초", textAlign = TextAlign.Right,
                    fontWeight = FontWeight.W400, fontSize = 12.sp, color = colorResource(
                        id = R.color.color_eb5757
                    ))
            }

            Row(
                modifier = Modifier
                    .padding(top = 24.dp, start = 18.dp, end = 18.dp)
                    .fillMaxWidth()
                    .height(28.dp)
                    .border(1.dp, colorResource(id = R.color.color_e3e3e3), RectangleShape),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    modifier = Modifier.fillMaxWidth(0.5f),
                    text = "시간표", fontWeight = FontWeight.W400, fontSize = 12.sp,
                    color = colorResource(id = R.color.color_818181), textAlign = TextAlign.Center
                )

                Divider(
                    modifier = Modifier
                        .width(1.dp)
                        .height(14.dp), color = colorResource(id = R.color.color_dadee3)
                )
                
                Text(
                    modifier = Modifier.fillMaxWidth(1f),
                    text = "출구/시설", fontWeight = FontWeight.W400, fontSize = 12.sp,
                    color = colorResource(id = R.color.color_818181), textAlign = TextAlign.Center
                )


            }

        }
    }
}