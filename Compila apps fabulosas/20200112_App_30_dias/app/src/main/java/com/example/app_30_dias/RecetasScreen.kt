package com.example.app_30_dias

import android.content.ClipData.Item
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.app_30_dias.model.Receta

@Composable
fun ListReceta(
    recetas: List<Receta>,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    LazyColumn(
        contentPadding = contentPadding
    ){
        items(recetas){ receta ->
            RecetaItem(
                receta = receta,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioNoBouncy,
                            stiffness = Spring.StiffnessMedium
                        )
                    )
            )
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecetaItem(
    receta: Receta,
    modifier: Modifier = Modifier
){
    var expanded by remember { mutableStateOf(false) }
    Card(
        onClick = {expanded = !expanded},
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Text(text = stringResource(id = receta.day))
            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )
            Text(text = stringResource(id = receta.name))
            Box(

            ){
                Image(
                    painter = painterResource(id = receta.image), 
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }
            if(expanded) Text(text = stringResource(id = receta.description))
        }
    }
}