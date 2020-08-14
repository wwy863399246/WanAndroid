package com.wwy.android.app

import com.wwy.android.data.repository.*
import com.wwy.android.data.repository.datasource.RemoteDataSource
import com.wwy.android.vm.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *@创建者wwy
 *@创建时间 2020/6/3 11:25
 *@描述
 */
val viewModelModule = module {
    viewModel { HomePageViewModel(get(), get()) }
    viewModel { HomeProjectViewModel(get(), get()) }
    viewModel { HomePlazaViewModel(get()) }
    viewModel { WeChatNumViewModel(get(), get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { SystemViewModel(get(), get()) }
    viewModel { NavigationViewModel(get()) }
    viewModel { MyHomePageViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}
val repositoryModule = module {
    single { RemoteDataSource() }
    single { MainRepository(get()) }
    single { WeChatNumRepository(get()) }
    single { ArticleUserCase(get()) }
    single { ProjectRepository(get()) }
    single { LoginRepository(get()) }
    single { SystemRepository(get()) }
    single { NavigationRepository(get()) }
    single { GetUserMsgUserCase() }
    single { CollectUserCase(get()) }

}
val appModule = listOf(viewModelModule, repositoryModule)