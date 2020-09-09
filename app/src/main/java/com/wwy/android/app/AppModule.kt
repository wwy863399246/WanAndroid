package com.wwy.android.app

import com.wwy.android.data.repository.*
import com.wwy.android.data.repository.datasource.RemoteDataSource
import com.wwy.android.view.loadpage.BasePageViewForStatus
import com.wwy.android.view.loadpage.LoadPageViewForStatus
import com.wwy.android.view.loadpage.SimplePageViewForStatus
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
    viewModel { MyHomePageViewModel(get(), get()) }
    viewModel { DetailViewModel(get(), get()) }
    viewModel { MyCollectAndShareViewModel(get(), get(), get()) }
    viewModel { PointViewModel(get()) }
    viewModel { PointRankingViewModel(get()) }
    viewModel { SettingViewModel(get()) }
    viewModel { KuTuViewModel(get()) }
    viewModel { ReadHistoryViewMode(get()) }
    viewModel { SearchViewModel(get(), get()) }
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
    single { ShareRepository(get()) }
    single { PointRepository(get()) }
    single { PointRankRepository(get()) }
    single { KuTuRepository(get()) }
    single { ReadHistoryUserCase() }
    single { SearchRepository(get()) }
    single<BasePageViewForStatus> { SimplePageViewForStatus() }
}
val appModule = listOf(viewModelModule, repositoryModule)