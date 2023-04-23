package com.yanyan.github_user.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.yanyan.github_user.R
import com.yanyan.github_user.domain.User

@Composable
fun DetailScreen(
    navController: NavController,
    user:User
) {
    val scaffoldState = rememberScaffoldState()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 10.dp, top = 20.dp)
            ) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back Icon")
            }

            Image(
                painter = painterResource(id = R.drawable.user_img),
                contentDescription = "User Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "${user.name}",
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight(700)
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Mobile Developer",
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight(400)
                )
            )
            Spacer(modifier = Modifier.height(28.dp))
            Row {
                Box(
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .background(
                            color = Color.Black,
                            shape = RoundedCornerShape(18.dp)
                        )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.chat_icon),
                        contentDescription = "Chat Icon",
                        tint = Color.White,
                        modifier = Modifier
                            .height(29.dp)
                            .width(29.dp)
                            .align(Alignment.Center)
                    )

                }
                Spacer(modifier = Modifier.width(9.dp))
                Box(
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .background(
                            color = Color.Black,
                            shape = RoundedCornerShape(18.dp)
                        )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.see_more_icon),
                        contentDescription = "See More Icon",
                        tint = Color.White,
                        modifier = Modifier
                            .height(29.dp)
                            .width(29.dp)
                            .align(Alignment.Center)

                    )

                }
            }
            Spacer(modifier = Modifier.height(28.dp))
            Row {
                FollowerBoxView(
                    modifier = Modifier,
                    icon = R.drawable.eye_empty,
                    count = 12,
                    title = "followers",
                    color = 0xFFF178B6,
                )
                Spacer(modifier = Modifier.width(8.dp))
                FollowerBoxView(
                    modifier = Modifier,
                    icon = R.drawable.medal,
                    count = 30, title = "following",
                    color = 0xFFB8ECEF,
                )
            }
        }
        Box(
            modifier = Modifier
                .padding(horizontal = 39.dp, vertical = 20.dp)
                .height(66.dp)
                .background(
                    color = Color.Black,
                    shape = RoundedCornerShape(20.dp)
                )
        ) {

                Row(modifier = Modifier.fillMaxSize()) {

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Go To Profile",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight(700),
                                color = Color.White
                            ),

                            )
                    }
                    Box(
                        modifier = Modifier

                            .padding(end = 20.dp)
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.send),
                            contentDescription = "Go To Profile",
                            tint = Color.White,

                            )
                    }

                }



        }

    }
}
@Composable
fun FollowerBoxView(
    modifier: Modifier,
    icon:Int,
    count:Int,
    title:String,
    color: Long
) {
    Box(
        modifier = modifier
            .width(150.dp)
            .height(180.dp)
            .background(
                color = Color(color),
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Icon",
                modifier = Modifier
                    .width(24.dp)
            )
            Spacer(modifier = Modifier.height(13.dp))
            Text(
                text = "$count",
                style = TextStyle(
                    fontSize = 38.sp,
                    fontWeight = FontWeight(800)
                )
            )
            Spacer(modifier = Modifier.height(13.dp))
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600)
                )
            )
        }
    }
}