package com.leshu.superbrain.app

import com.leshu.superbrain.data.repository.*
import com.leshu.superbrain.data.repository.datasource.RemoteDataSource
import com.leshu.superbrain.vm.*
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
    viewModel { WeChatNumViewModel(get(),get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { SystemViewModel(get(),get()) }
}
val repositoryModule = module {
    single { RemoteDataSource() }
    single { MainRepository(get()) }
    single { WeChatNumRepository(get()) }
    single { ArticleUserCase(get()) }
    single { ProjectRepository(get()) }
    single { LoginRepository(get()) }
    single { SystemRepository(get()) }

}
val appModule = listOf(viewModelModule, repositoryModule)