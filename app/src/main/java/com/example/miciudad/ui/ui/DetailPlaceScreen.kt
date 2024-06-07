package com.example.miciudad.ui.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.miciudad.R
import com.example.miciudad.data.DataSource
import com.example.miciudad.model.Place


@Composable
fun DetailedPlaceScreen(
    modifier: Modifier=Modifier,
    onBackButtonClicked:() ->Unit={},
    place: Place,
){
    val context = LocalContext.current
    val addressText= stringResource(id = place.addressResourceId)

    Column(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.tertiary)
            .padding(dimensionResource(R.dimen.padding_small)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Card {
            Image(
                painter = painterResource(id = place.imageResourceId),
                contentDescription = stringResource(id = place.nameResourceId
                ),
                modifier= modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
                )
                Text(
                    text = stringResource(id = place.descriptionResourceId),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier= modifier.padding(dimensionResource(R.dimen.padding_small))
                )
                Row(
                    modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                        .clickable {
                            val intent = Intent(Intent.ACTION_VIEW).apply {
                                data = Uri.parse("geo:0,8?q=${addressText}")
                            }
                            context.startActivity(intent)
                        }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.address), 
                        contentDescription = stringResource(id = place.addressResourceId)
                    )
                    Text(
                        text = stringResource(id = place.addressResourceId),
                        style = MaterialTheme.typography.bodyLarge,
                        )

                }
        }
        Button(
            onClick = { onBackButtonClicked() },
            modifier.padding(dimensionResource(R.dimen.padding_small))
        ) {
            Text(text = stringResource(R.string.back))
        }

    }
}
@Preview
@Composable
fun DetailedPlacePreview(){
    DetailedPlaceScreen(place = DataSource.hotels[0])
}