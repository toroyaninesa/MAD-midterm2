package com.mobileappdev.midterm2.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mobileappdev.midterm2.R
import com.mobileappdev.midterm2.models.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListItem(user: User) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(
                color = colorResource(id = R.color.violet),
                shape = RoundedCornerShape(16.dp)
            )

    )
    {
        ListItem(
            headlineText = {
                Column {
                    Text(
                        "${user.name} ${user.username}",
                        color = colorResource(id = R.color.dark_violet),
                        modifier = Modifier.padding(16.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.email, user.email),
                        color = Color.Gray, // Adjust the text color as needed
                        modifier = Modifier.padding(8.dp)
                    )
                }
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()

        )
    }
}