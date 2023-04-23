package com.yanyan.github_user.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.yanyan.github_user.R
import com.yanyan.github_user.Screen
import com.yanyan.github_user.domain.User

@Composable
fun HomeScreen(
    navController: NavController
){

    val categoryList = remember {
        mutableStateListOf("Flutter","Programming","Jetpack Compose","React","Vue")
    }
    Column(
        modifier = Modifier.fillMaxSize(),

    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SearchBar(
                text = "",
                onChanged = {},
                modifier = Modifier.fillMaxWidth(fraction = 0.9f),
            )
            Icon(
                painter = painterResource(id =R.drawable.noti_icon),
                contentDescription = "Notification Icon",
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Categories", style = TextStyle(
         fontSize = 16.sp,
            fontWeight = FontWeight(600)
        ),
            modifier= Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        LazyRow(
            contentPadding = PaddingValues(start = 20.dp)
        ){
            items(categoryList){
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .background(
                            color = Color.Gray.copy(0.2f),
                            shape = RoundedCornerShape(24.dp)

                        )

                ) {
                    Text(text = "$it", modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                    )

                }
             Spacer(modifier = Modifier.width(10.dp))
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Total 10 users available",
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            fontStyle = FontStyle.Italic,
        ),
            modifier = Modifier.padding(horizontal = 20.dp)
            )
        Spacer(modifier = Modifier.height(20.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding= PaddingValues(start = 10.dp, end = 10.dp, bottom = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ){
            items(5){
                UserView(
                    modifier = Modifier,
                    user = User("1","mojombo",""),
                    onClick = {
                        navController.navigate(Screen.DetailScreen.route+"/1/mojombo")
                    }
                )
            }
        }

    }
}

@Composable
fun UserView(
    modifier: Modifier,
    user:User,
    onClick:()->Unit
){
    Box (
        modifier = Modifier
            .height(239.dp)
            .clickable {
                onClick()
            }
            .clip(shape = RoundedCornerShape(20.dp))

    ){
        Image(
            painter = painterResource(id = R.drawable.user_img),
            contentDescription = user.name,
            modifier = Modifier
                .fillMaxSize()
        )
        Box (
            modifier= Modifier
                .height(86.dp)
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .background(Color.Black.copy(0.5f))
                .padding(horizontal = 10.dp)
                .align(Alignment.BottomCenter)

        ){
            Text(text=user.name?:"",
                style= TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    color = Color.White,

                    ),
                modifier= Modifier
                    .align(Alignment.CenterStart)

            )

        }

    }
}

@Composable
fun SearchBar(
    modifier: Modifier,
    text:String,
    onChanged: (String)->Unit,
){
    val searchTextState by remember { mutableStateOf(TextFieldValue(text=text)) }

    OutlinedTextField(
        modifier=modifier
            .background(Color.Transparent),
       shape=RoundedCornerShape(20.dp),
        value = searchTextState,
        onValueChange = {
            onChanged(it.text)
        },
        label = { Text(text = "Search")},
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search Icon")},
    )
}

