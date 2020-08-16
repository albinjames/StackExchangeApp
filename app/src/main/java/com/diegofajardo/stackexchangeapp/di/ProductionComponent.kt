package com.diegofajardo.stackexchangeapp.di

import android.app.Application
import com.diegofajardo.stackexchangeapp.App
import com.diegofajardo.stackexchangeapp.domain.User
import com.diegofajardo.stackexchangeapp.ui.detail.DetailActivityViewModel
import com.diegofajardo.stackexchangeapp.ui.main.MainActivityViewModel
import com.diegofajardo.stackexchangeapp.ui.main.adapter.UsersAdapterUiManagerImpl
import com.diegofajardo.stackexchangeapp.usecase.GetUsersUsecase

class ProductionComponent (private val app: Application) : DIComponentImpl {

    override fun provideMainActivityViewModelFactory() = MainActivityViewModel.Factory(
        app = app,
        getUsersUsecase = UsecaseModule.usersUsecase,
        schedulerProvider = RxModule.schedulerProvider,
        errorMapper = UtilsModule.provideErrorMapper(app)
    )

    override fun provideDetailActivityViewModelFactory(user: User) = DetailActivityViewModel.Factory(
        app = app,
        dateConverter = UtilsModule.provideDateConverter(),
        user = user
    )

    override fun provideUsersAdapterUiManagerImpl(): UsersAdapterUiManagerImpl {
        return UiModule.provideUsersAdapterUiManagerImpl()
    }

}