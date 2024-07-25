package ru.gozerov.firstkmp.presentation.screens.users.list

import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.gozerov.firstkmp.domain.use_cases.GetUsersUseCase
import ru.gozerov.firstkmp.presentation.screens.users.list.models.UsersListAction
import ru.gozerov.firstkmp.presentation.screens.users.list.models.UsersListEffect
import ru.gozerov.firstkmp.presentation.screens.users.list.models.UsersListViewState

class UsersListViewModel :
    BaseSharedViewModel<UsersListViewState, UsersListAction, UsersListEffect>(UsersListViewState.Empty),
    KoinComponent {

    private val getUsersUseCase: GetUsersUseCase by inject()

    override fun obtainEvent(viewEvent: UsersListEffect) {
        viewModelScope.launch {
            when (viewEvent) {
                is UsersListEffect.LoadUsers -> {
                    val users = getUsersUseCase.invoke()
                    viewState = UsersListViewState.LoadedUsers(users)
                }
            }
        }
    }

}