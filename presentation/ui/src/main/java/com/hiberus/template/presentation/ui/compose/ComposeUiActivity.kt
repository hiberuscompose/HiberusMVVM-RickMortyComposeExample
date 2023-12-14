package com.hiberus.template.presentation.ui.compose

import android.content.res.Configuration.UI_MODE_NIGHT_MASK
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import coil.compose.AsyncImage
import com.hiberus.template.core.ui.theme.AppTheme
import com.hiberus.template.domain.models.characters.RickAndMortyCharacter
import com.hiberus.template.domain.models.common.UrlObject
import com.hiberus.template.presentation.R
import com.hiberus.template.presentation.ui.compose.ui.theme.HiberusTemplateTheme
import com.hiberus.template.presentation.viewmodels.features.characters.RickAndMortyCharactersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Calendar

@AndroidEntryPoint
class ComposeUiActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HiberusTemplateTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    CharactersList()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersList(
    viewModel: RickAndMortyCharactersViewModel = hiltViewModel()
) {
    val characters = viewModel.paginatedCharacters.collectAsLazyPagingItems()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier
                    .fillMaxWidth(),
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
            )
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
        ){
            items(
                count = characters.itemCount,
                key = characters.itemKey { character -> character.id }
            ){ characterIndex ->
                characters[characterIndex]?.let { item ->
                    RickAndMortyCharacterItem(
                        character = item,
                        modifier = Modifier.fillMaxWidth()
                    ){ currentCharacter ->
                        scope.launch {
                            withContext(Dispatchers.Main){
                                Toast.makeText(
                                    context,
                                    "Personaje: ${currentCharacter.name}",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RickAndMortyCharacterItem(
    character: RickAndMortyCharacter,
    modifier: Modifier = Modifier,
    onClick: (RickAndMortyCharacter) -> Unit = {}
){
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        onClick = { onClick(character) }
    ) {
        ConstraintLayout(modifier = modifier.padding(4.dp)) {
            val (
                nameView,
                genderView,
                speciesView,
                photoView,
            ) = createRefs()

            Text(
                text = character.name,
                modifier = Modifier.constrainAs(nameView){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
                style = MaterialTheme.typography.titleLarge
            )
            AsyncImage(
                model = character.image,
                contentDescription = null,
                modifier = Modifier.constrainAs(photoView){
                    top.linkTo(nameView.bottom, 4.dp)
                    bottom.linkTo(parent.bottom, 4.dp)
                    width = Dimension.value(96.dp)
                }
            )
            Text(
                text = character.species,
                modifier = Modifier.constrainAs(speciesView){
                    top.linkTo(nameView.bottom)
                    start.linkTo(photoView.end, 16.dp)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
                style = MaterialTheme.typography.titleMedium
            )
            Icon(
                imageVector = ImageVector.vectorResource(id =
                if (character.gender.lowercase() == "male")
                    R.drawable.ic_male
                else
                    R.drawable.ic_female
                ),
                contentDescription = null,
                tint = if (character.gender.lowercase() == "male")
                    Color.Blue
                else
                    Color.Magenta,
                modifier = Modifier.constrainAs(genderView){
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    width = Dimension.value(64.dp)
                    height = Dimension.value(64.dp)
                }
            )
        }
    }
    Spacer(modifier = Modifier.height(4.dp))
}

@Preview(showBackground = true)
@Preview(showSystemUi = true, device = Devices.NEXUS_5, uiMode = UI_MODE_NIGHT_YES)
@Preview(showSystemUi = true, device = Devices.NEXUS_5)
@Composable
fun PreviewItem(
    @PreviewParameter(CharacterPreviewParameter::class)
    character: RickAndMortyCharacter
){
    AppTheme {
        Surface {
            RickAndMortyCharacterItem(
                modifier = Modifier
                    .fillMaxWidth().height(128.dp),
                character = character
            )
        }
    }
}

class CharacterPreviewParameter: PreviewParameterProvider<RickAndMortyCharacter> {
    override val values: Sequence<RickAndMortyCharacter>
        get() = sequenceOf(
            RickAndMortyCharacter(
                id = 1,
                name = "name bla bla",
                status = "status bla bla",
                species = "species bla bla",
                type = "type bla bla",
                gender = "gender bla bla",
                origin = UrlObject("miLocalizacion", "https"),
                location = UrlObject("miLocalizacion", "https"),
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2Sm6WtxxfkDF52q2jEViT_m_TdoaEqui3ODP6lZcrMVlARZSYDwl_7y_tMbC9sqOOb-s&usqp=CAU",
                episode = listOf("episode bla bla"),
                url = "url bla bla",
                created = Calendar.getInstance().time,
            ),
            RickAndMortyCharacter(
                id = 2,
                name = "name 2 bla bla",
                status = "status bla bla",
                species = "species bla bla",
                type = "type bla bla",
                gender = "male",
                origin = UrlObject("miLocalizacion", "https"),
                location = UrlObject("miLocalizacion", "https"),
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2Sm6WtxxfkDF52q2jEViT_m_TdoaEqui3ODP6lZcrMVlARZSYDwl_7y_tMbC9sqOOb-s&usqp=CAU",
                episode = listOf("episode bla bla"),
                url = "url bla bla",
                created = Calendar.getInstance().time,
            )
        )

}