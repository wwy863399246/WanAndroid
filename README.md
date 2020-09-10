#### 学习Kotlin,JetPack,协程的Wanandroid客户端
- **Kotlin语言编程，JetPack组件架构，Material Design风格**
- **Repository层实现业务逻辑，ViewModel控制视图逻辑，并用Koin框架依赖注入**
- **使用Retrofit，Room（用户信息，阅读历史）,协程构建数据层**
#### 亮点功能
- 参考bilili启动页style适配
- 仿酷安动态换肤，夜间模式(灵活使用theme及系统属性,用最少的资源文件和代码实现动态换肤，可参考https://juejin.im/post/6844904200673968141)
- 用户信息，阅读历史使用room数据库，配合flow,livedata,实现可观察性
#### 效果图展示 
![项目效果图](https://source.acexy.cn/view/XQXWOxb)
 #### APK下载：
- [Github下载](https://github.com/wwy863399246/WanAndroid/releases/download/1.0.0/app-debug.apk)
## 添加依赖后如何使用koin依赖注入viewmodel,repository
- **1.1 新建AppModulel类**
```
val viewModelModule = module {
    viewModel { HomePageViewModel(get(), get()) }
}
val repositoryModule = module {
    single { RemoteDataSource() }
    single { ArticleUserCase(get()) }
    single { MainRepository(get()) }
}
val appModule = listOf(viewModelModule, repositoryModule)
```
- **1.2 MyApplication**
```
startKoin {
            androidLogger(Level.INFO)
            androidContext(this@MyApplication)
            modules(appModule)
        }
```
- **1.3 Repository，Viewmodel**
```
class ArticleUserCase(private val remoteDataSource: RemoteDataSource) {
}
class MainRepository(private val homeRemoteDataSource: RemoteDataSource) {
}
class HomePageViewModel(private val mainRepository : MainRepository, private val articleUserCase:ArticleUserCase) : BaseViewModel() {
}
```
- **1.4 Activity,Fragment中**
```
class HomePageFragment : BaseVMFragment<HomePageViewModel>(), OnLoadMoreListener {
   override fun initVM(): HomePageViewModel = getViewModel()
}
```
## 关于Android应用架构指南可参考文章
- [把 "格子衫" 改造得更时尚 | Kotlin & Jetpack 最佳实践技巧](https://juejin.im/post/6844903961384714248#heading-3)
## 开源库
- [ImmersionBar -- android 4.4以上沉浸式实现](https://github.com/gyf-dev/ImmersionBar)
- [一个依赖注入框架koin](https://github.com/InsertKoinIO/koin)
- [处理网络请求的框架-Okhttp](https://github.com/square/okhttp)
- [一个基于OKHttp封装的网络加载框架-Retrofit](https://github.com/square/retrofit)
- [EventBus for Android，消息总线，基于LiveData-LiveEventBus](https://github.com/JeremyLiao/LiveEventBus)
- [Android智能下拉刷新框架-SmartRefreshLayout](https://github.com/scwang90/SmartRefreshLayout)
- [屏幕适配AndroidAutoSize](https://github.com/JessYanCoding/AndroidAutoSize)
- [Toast & Snackbar & TopBar & Dialog-smart-sho](https://github.com/opensource-zhuzhiqiang/smart-show)
- [Android界最万能的TabLayout(不仅仅是TabLayout). 高能自绘控件, 继承自ViewGroup, 非组合控件.](https://github.com/angcyo/DslTabLayout)
- [anko](https://github.com/Kotlin/anko)
- [一个强大的轮播库-BGABanner-Android](https://github.com/bingoogolapple/BGABanner-Android)
- [一个强大并且灵活的RecyclerViewAdapter-BaseRecyclerViewAdapterHelper](https://github.com/CymChad/BaseRecyclerViewAdapterHelper))
- [基于Android WebView的一个强大的库-Agentweb](https://github.com/Justson/AgentWeb)
- [基于mmap内存映射的移动端通用 key-value 组件-MMKV](https://github.com/Tencent/MMKV)

## 特别感谢
- 感谢[鸿洋大神](https://github.com/hongyangAndroid)提供的[WanAndroid开放API](https://www.wanandroid.com/blog/show/2),和里面的一些优秀开源项目和文章
