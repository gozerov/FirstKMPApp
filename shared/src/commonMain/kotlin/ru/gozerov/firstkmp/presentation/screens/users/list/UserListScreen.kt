package ru.gozerov.firstkmp.presentation.screens.users.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.adeo.kviewmodel.odyssey.StoredViewModel
import kotlinx.coroutines.launch
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.gozerov.firstkmp.domain.models.User
import ru.gozerov.firstkmp.presentation.navigation.Screen
import ru.gozerov.firstkmp.presentation.screens.users.list.models.UsersListEffect
import ru.gozerov.firstkmp.presentation.screens.users.list.models.UsersListViewState


@Composable
fun UserListItem(user: User, onClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            .clickable(remember { MutableInteractionSource() }, indication = null) {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier.padding(horizontal = 16.dp).size(48.dp).clip(CircleShape),
            model = "https://e7.pngegg.com/pngimages/84/165/png-clipart-united-states-avatar-organization-information-user-avatar-service-computer-wallpaper-thumbnail.png",
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            text = user.username
        )
    }
}

@Composable
fun UserListScreen() {
    val rootController = LocalRootController.current
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }) {
        StoredViewModel(factory = { UsersListViewModel() }) { viewModel ->

            LaunchedEffect(null) {
                viewModel.obtainEvent(UsersListEffect.LoadUsers)
            }

            val viewState = viewModel.viewStates().collectAsState().value

            when (viewState) {
                is UsersListViewState.Empty -> {}
                is UsersListViewState.LoadedUsers -> {
                    val users = viewState.users
                    LazyColumn {
                        items(users.size) { ind ->
                            UserListItem(users[ind]) {
                                rootController.parentRootController?.parentRootController?.launch(
                                    Screen.UserDetailsScreen.route,
                                    params = users[ind].id
                                )
                            }
                            if (ind != users.size - 1)
                                Divider(modifier = Modifier.fillMaxWidth())
                        }
                    }
                }

                is UsersListViewState.Error -> {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(viewState.message)
                    }
                }
            }
        }
    }
}