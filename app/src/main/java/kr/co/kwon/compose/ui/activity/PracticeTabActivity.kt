package kr.co.kwon.compose.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import kr.co.kwon.compose.R

/**
 * Create by kwonhyeok on 2022/07/11
 * **/
class PracticeTabActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            tabInitView()
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    tabInitView()
}

@Composable
fun tabInitView(){

    var tabIndex = remember { mutableStateOf(0) }
    val tabTitle = listOf("좌측", "중간", "우측")
    Column() {
        TabRow(
//            indicator = { tabPositions ->
//                TabRowDefaults.Indicator(
//                    Modifier.tabIndicatorOffset(tabPositions[tabIndex.value])
//                )
//            } ,
            selectedTabIndex = tabIndex.value) {
            tabTitle.forEachIndexed { index, title ->
                Tab(selected = tabIndex.value == index,
                    onClick = { tabIndex.value = index },
                    text = { Text(text = title) })
            }
            when (tabIndex.value) {
                0 -> Text("Hello content")
                1 -> Text("There content")
                2 -> Text("World content")
            }
        }
    }
}