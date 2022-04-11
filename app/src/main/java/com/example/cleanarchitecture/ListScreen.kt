package com.example.cleanarchitecture

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cleanarchitecture.model.Name
import com.example.cleanarchitecture.model.Picture
import com.example.cleanarchitecture.model.Users
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import androidx.activity.viewModels


@Composable
fun Screen(navController: NavController, viewModel: UsersViewModel = hiltViewModel()){

    val usersList by viewModel._users.observeAsState(initial = emptyList())
    ListScreen(usersList)
}

@Composable
fun ListScreen(users: List<Users>){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Random Users")}
            )
        }
    ) {
        LazyColumn{
            items(users) { it ->
                Card(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clickable {

                        }
                ){
                    Column {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(19f / 9f),
                            painter = rememberImagePainter(data = it.picture.large,
                                builder = {
                                    placeholder(R.drawable.placeholder)
                                    error(R.drawable.placeholder)
                                }
                            ),
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth
                        )
                        Column(Modifier.padding(8.dp)) {
                            Text(it.name.first)
                            Text(it.email ?: "", maxLines = 2)

                        }
                    }
                }
            }
        }
    }
}

