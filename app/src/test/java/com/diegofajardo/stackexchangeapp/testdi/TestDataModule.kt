package com.diegofajardo.stackexchangeapp.testdi

import com.diegofajardo.stackexchangeapp.data.repository.UserRepository
import com.diegofajardo.stackexchangeapp.data.source.server.StackExchangeRemoteDataSource
import com.diegofajardo.stackexchangeapp.data.source.server.adapter.GetUsersQueryAdapter

object TestDataModule {

    val fakeUserRepository by lazy { UserRepository(fakeRemoteDataSource) }

    private val fakeRemoteDataSource by lazy { StackExchangeRemoteDataSource(getUsersQueryAdapter) }

    private val getUsersQueryAdapter by lazy { GetUsersQueryAdapter(TestNetworkModule.fakeStackExchangeServerEndpoints) }
}