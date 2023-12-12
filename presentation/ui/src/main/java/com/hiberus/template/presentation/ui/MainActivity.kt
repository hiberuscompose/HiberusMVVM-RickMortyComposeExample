package com.hiberus.template.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hiberus.template.core.ui.compose.setUiContent
import com.hiberus.template.core.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import com.hiberus.template.presentation.R
import com.hiberus.template.presentation.ui.classic.ClassicUiActivity
import com.hiberus.template.presentation.ui.compose.ComposeUiActivity

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUiContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun HomeScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppTheme.dimens.appMargin)
    ) {

        Image(
            painter = painterResource(
                id = R.drawable.logo
            ),
            modifier = Modifier.padding(
                all = AppTheme.dimens.appMargin
            ),
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(AppTheme.dimens.largeBottomSurface)
        )

        Button(
            onClick = {
                context.startActivity(Intent(context, ClassicUiActivity::class.java))
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(AppTheme.dimens.buttonHeight),

        ) {
            Text(text = stringResource(id = R.string.launch_classic_screen))
        }
        Spacer(
            modifier = Modifier.size(AppTheme.dimens.appMargin)
        )
        Button(
            onClick = {
                context.startActivity(Intent(context, ComposeUiActivity::class.java))
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(AppTheme.dimens.buttonHeight),

            ) {
            Text(text = stringResource(id = R.string.launch_compose_screen))
        }
    }
}
