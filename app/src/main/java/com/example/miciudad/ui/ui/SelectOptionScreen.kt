package com.example.miciudad.ui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.miciudad.R
import com.example.miciudad.model.Category
import com.example.miciudad.model.Item
import com.example.miciudad.model.Place

@Composable
fun SelectCategoryScreen(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    onClicked: (Item) -> Unit,
) {
    val itemLists: List<Item> = categories.map { category ->
        Item(
            image = category.image,
            name = category.name
        )
    }
    SelectOptionScreen(
        modifier = modifier,
        options = itemLists,
        onClicked = onClicked
    )
}

@Composable
fun SelectPlaceScreen(
    modifier: Modifier = Modifier,
    places: List<Place>,
    onClicked: (Item) -> Unit={}, // Cambiado el tipo de devolución de llamada a Item
) {
    val itemList: List<Item> = places.map { place ->
        Item(
            image = place.imageResourceId,
            name = place.nameResourceId
        )
    }
    SelectOptionScreen(
        modifier = modifier,
        options = itemList,
        onClicked = onClicked,
    )
}

@Composable
fun SelectOptionScreen(
    modifier: Modifier = Modifier,
    options: List<Item>,
    onClicked: (Item) -> Unit,
) {
    LazyColumn(modifier = modifier.background(MaterialTheme.colorScheme.tertiary)) {
        items(options) { option ->
            ItemCard(
                item = option,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
                onClicked = onClicked,
            )
        }
    }
}
@Composable
fun ItemCard(
    item: Item,
    modifier: Modifier = Modifier,
    onClicked: (Item) -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClicked(item) },
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
                    .alignByBaseline()
            ) {
                Text(
                    text = stringResource(id = item.name),
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black,
                )
            }
        }
    }
}




