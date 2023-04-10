package com.fuwafuwa.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fuwafuwa.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier:Modifier = Modifier) {
    Column(modifier= modifier
        .fillMaxSize()
        .background(Color(26, 26, 58)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Column(modifier= modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            val image = painterResource(id = R.drawable.android_logo)
            Image(painter=image, contentDescription = null, modifier=Modifier.size(100.dp))
            Text(text = stringResource(id = R.string.name),fontSize=36.sp, color = Color.White, fontWeight = FontWeight.Bold)
            Text(text = stringResource(id = R.string.Android),color = Color.White,fontWeight = FontWeight.Bold)
        }
        Column(modifier=modifier.padding(top=80.dp)){
            subContents(address = stringResource(id = R.string.github), icon = painterResource(id = R.drawable.baseline_done_all_black_24dp))
            subContents(address = stringResource(id = R.string.Tstory), icon = painterResource(id = R.drawable.baseline_done_all_black_24dp))
        }
    }

}

@Composable
fun subContents(address:String, icon: Painter, modifier: Modifier = Modifier){
    Row(modifier=modifier){
        Icon(painter=icon, contentDescription = null,modifier=Modifier.padding(top=10.dp,end=5.dp).size(20.dp).background(Color.White))
        Text(text = address, color = Color.White, modifier=Modifier.padding(top=10.dp))
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        Greeting()
    }
}