package com.hiberus.template.presentation.ui.paparazzi.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hiberus.template.core.common.entities.HBComponent
import com.hiberus.template.core.common.entities.hbComponents
import com.hiberus.template.presentation.R

@Composable
internal fun StorybookView(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    val list = hbComponents
    LazyVerticalGrid(
        modifier = modifier
            .padding(paddingValues)
            .fillMaxSize(),
        columns = GridCells.Fixed(2)
    ) {
        items(list.size) {
            val item = list[it]
            Item(thumbnail = item.thumbnailResource(), title = item.title)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Item(
    thumbnail: Int,
    title: String
) {
    Card(
        onClick = {

        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(150.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.Black.copy(0.2f))
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .weight(1f),
            painter = painterResource(id = thumbnail),
            contentDescription = null
        )

        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@Composable
private fun HBComponent.thumbnailResource(): Int {
    val context = LocalContext.current

    fun getResourceId(name: String): Int {
        return context.resources.getIdentifier(
            name,
            "drawable",
            context.packageName
        )
    }

    val resId = getResourceId(this.thumbnail)

    return resId.takeIf { it != 0 } ?: R.drawable.logo
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StorybookViewPreview() {
    StorybookView(paddingValues = PaddingValues())
}