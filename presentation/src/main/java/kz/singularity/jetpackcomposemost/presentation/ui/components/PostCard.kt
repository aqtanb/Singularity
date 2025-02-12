package kz.singularity.jetpackcomposemost.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PostCard(title: String, body: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
        ,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column (
            modifier = Modifier.padding(16.dp).fillMaxWidth()
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = body,
                fontSize = 16.sp,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PostCardPreview() {
    PostCard(
        "Sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        "Quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum" +
                "\\nreprehenderit molestiae ut ut quas totam" +
                "\\nnostrum rerum est autem sunt rem eveniet architecto"
    )
}