package com.hiberus.template.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.annotation.StringRes
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
import com.hiberus.template.core.ui.compose.setUiContent
import com.hiberus.template.core.ui.theme.AppTheme
import com.hiberus.template.presentation.R
import com.hiberus.template.presentation.ui.classic.ClassicUiActivity
import com.hiberus.template.presentation.ui.compose.ComposeUiActivity
import com.hiberus.template.presentation.ui.composetesting.TestingComposeActivity
import com.hiberus.template.presentation.ui.paparazzi.TestingPaparazziActivity
import dagger.hilt.android.AndroidEntryPoint

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

        ButtonContainer(text = R.string.launch_classic_screen) {
            context.startActivity(Intent(context, ClassicUiActivity::class.java))
        }

        ButtonContainer(text = R.string.launch_compose_screen) {
            context.startActivity(Intent(context, ComposeUiActivity::class.java))
        }

        ButtonContainer(text = R.string.launch_composable_testing) {
            context.startActivity(Intent(context, TestingComposeActivity::class.java))
        }

        ButtonContainer(text = R.string.launch_paparazzi) {
            context.startActivity(Intent(context, TestingPaparazziActivity::class.java))
        }
    }
}

@Composable
private fun ButtonContainer(
    @StringRes text: Int,
    onClick: () -> Unit,
) {
    Spacer(
        modifier = Modifier.size(AppTheme.dimens.appMargin)
    )
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(AppTheme.dimens.buttonHeight),

        ) {
        Text(text = stringResource(id = text))
    }
}
