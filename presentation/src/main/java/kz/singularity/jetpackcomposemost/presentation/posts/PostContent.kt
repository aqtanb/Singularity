package kz.singularity.jetpackcomposemost.presentation.posts

import kz.singularity.jetpackcomposemost.presentation.ui.components.LoadingState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kz.singularity.jetpackcomposemost.presentation.ui.components.PostCard
import kz.singularity.jetpackcomposemost.util.Routes

@Composable
fun PostContent(state: PostState, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        if(state.isLoadingPosts) {
            LoadingState()
        } else {
            PostList(state = state, navController)
        }
    }
}

@Composable
fun PostList(state: PostState, navController: NavHostController) {
    LazyColumn (
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ){
        items(state.posts) { item ->
            PostCard(
                title = item.title,
                body = item.body,
                modifier = Modifier.clickable {
                    val route = Routes.POST_DETAIL
                        .replace("{postId}", item.id.toString())
                        .replace("{userId}", item.userId.toString())
                    navController.navigate(route)
                }
            )
        }
    }
}
