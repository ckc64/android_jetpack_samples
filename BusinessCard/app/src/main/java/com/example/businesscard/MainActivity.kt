package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import org.intellij.lang.annotations.JdkConstants

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
                        CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard(){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(20.dp),
            backgroundColor = Color.White,
        elevation = 4.dp,
        shape = RoundedCornerShape(corner = CornerSize(15.dp))
        ) {
            Column(
                modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileImage()
                Divider(
                    modifier = Modifier.padding(10.dp),
                    thickness = 2.dp
                )
                ProfileInfo(
                    profileName = "Charles K.",
                    profileDescription = "Mobile App Developer",
                    profileID = "@charleskurt")
                Button(
                    modifier = Modifier.size(100.dp, 40.dp),
                    shape = RoundedCornerShape(0.dp),
                    onClick =
                    { /*TODO*/ }) {
                    Text(
                        text = "Portfolio"
                    )
                }
            }

        }
    }
}

@Composable
fun ProfileInfo(profileName: String,
                profileDescription: String,
                profileID: String){
    Surface{
       Column(
           verticalArrangement = Arrangement.Top,
           horizontalAlignment = Alignment.Start
       ) {
           Text(

               text = profileName,
               fontSize = 26.sp,
               color = Color.Blue,
               fontWeight = FontWeight.Bold
           )
           Text(text = profileDescription)
           Text(text = profileID)
           Spacer(modifier = Modifier.height(10.dp))
       }
    }
}
@Composable
fun ProfileImage(){
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp
    ){
            Image(
                painter = painterResource(id = R.drawable.avatar_img),
                contentDescription = "Avatar Image",
                modifier = Modifier.size(135.dp),
                contentScale = ContentScale.Crop
            )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        CreateBizCard()
    }
}