package iut.montpellier.booklibrary.presentation.uiComponent

import androidx.navigation.NavHostController
import androidx.compose.runtime.Composable
import androidx.compose.material3.Card
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import coil.compose.SubcomposeAsyncImage
import androidx.compose.ui.draw.clip
import iut.montpellier.booklibrary.presentation.navigation.Route
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import iut.montpellier.booklibrary.presentation.effects.imageAni

@Composable
fun BookCategoryCard(
    imageUrl: String,
    category: String,
    navHostController: NavHostController
) {
    Card(
        modifier = Modifier.padding(8.dp)
            .clickable{

                navHostController.navigate(Route.BooksByCategory(category))
            }
    ){
        Column(
            modifier = Modifier.size(200.dp)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            SubcomposeAsyncImage(
                model = imageUrl,
                contentDescription = null,
                contentScale =  ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp)),
                loading = {

                    imageAni()
                },
                error =  {
                    Text(text = "Error loading Image")
                }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = category,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}