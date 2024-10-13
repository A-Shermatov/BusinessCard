package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ComposeBusinessCard()
                }
            }
        }
    }
}


@Composable
fun ComposeBusinessCard() {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff67e46f)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),

            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            PersonalInfo(
                logo = painterResource(R.drawable.android_logo),
                fullName = stringResource(R.string.full_name_text),
                title = stringResource(R.string.title_text),
                color = Color(0xFFF6EDFF),

                )
            ContactsColumn(
                color = Color(0xFFF6EDFF),
                phoneNumber = stringResource(R.string.phone_text),
                shareNickName = stringResource(R.string.nick_name_text),
                emailAddress = stringResource(R.string.email_text),
                callIcon = painterResource(R.drawable.call_24dp_e8eaed),
                shareIcon = painterResource(R.drawable.share_24dp_e8eaed),
                emailIcon = painterResource(R.drawable.email_24dp_e8eaed),
            )
        }
    }

}

@Composable
private fun PersonalInfo(
    logo: Painter,
    fullName: String,
    title: String,
    color: Color,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(start = 16.dp, top = 200.dp, end = 16.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = logo,
            contentDescription = null,
            modifier = Modifier
                .padding(start = 20.dp, top = 8.dp, end = 20.dp)
                .width(100.dp)
                .height(100.dp)
                .background(color = Color(0xff008209)),
        )
        Text(
            text = fullName,
            fontSize = 42.sp,
            color = color,
            modifier = modifier
                .padding(start = 20.dp, end = 20.dp, bottom = 8.dp),
        )
        Text(
            text = title,
            color = color,
            fontSize = 22.sp,
            fontStyle = FontStyle.Italic,
            modifier = modifier
                .padding(start = 20.dp, end = 20.dp, bottom = 8.dp),
        )
    }
}

@Composable
private fun ContactsColumn(
    color: Color,
    callIcon: Painter,
    shareIcon: Painter,
    emailIcon: Painter,
    phoneNumber: String,
    shareNickName: String,
    emailAddress: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
    ) {
        ContactRow(
            icon = callIcon,
            contactText = phoneNumber,
            color = color,
        )
        ContactRow(
            icon = shareIcon,
            contactText = shareNickName,
            color = color,
        )
        ContactRow(
            icon = emailIcon,
            contactText = emailAddress,
            color = color,
        )
    }
}

@Composable
private fun ContactRow(
    icon: Painter,
    contactText: String,
    color: Color,
    modifier: Modifier = Modifier,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = color,
        )
        Text(
            text = contactText,
            color = color,
            modifier = modifier
                .padding(start = 10.dp),
        )
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        ComposeBusinessCard()
    }
}