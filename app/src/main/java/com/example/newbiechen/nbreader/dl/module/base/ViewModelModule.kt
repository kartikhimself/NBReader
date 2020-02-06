package com.example.newbiechen.nbreader.dl.module.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newbiechen.nbreader.dl.annotation.key.ViewModelKey
import com.example.newbiechen.nbreader.ui.page.bookdetail.BookDetailViewModel
import com.example.newbiechen.nbreader.ui.page.booklist.BookListViewModel
import com.example.newbiechen.nbreader.ui.page.bookshelf.BookShelfViewModel
import com.example.newbiechen.nbreader.ui.page.filesystem.FileSystemViewModel
import com.example.newbiechen.nbreader.ui.page.find.FindViewModel
import com.example.newbiechen.nbreader.ui.page.main.MainViewModel
import com.example.newbiechen.nbreader.ui.page.smartlookup.SmartLookupViewModel
import com.example.newbiechen.nbreader.uilts.factory.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

/**
 * 所有用到依赖注入的 ViewModel 都需要在这里注册
 */
@Module
abstract class ViewModelModule {
    @Singleton
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(model: MainViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(FindViewModel::class)
    abstract fun bindFindViewModel(model: FindViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(BookListViewModel::class)
    abstract fun bindBookListViewModel(model: BookListViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(BookDetailViewModel::class)
    abstract fun bindBookDetailViewModel(model: BookDetailViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(BookShelfViewModel::class)
    abstract fun bindBookShelfViewModel(model: BookShelfViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(SmartLookupViewModel::class)
    abstract fun bindSmartLookupViewModel(model: SmartLookupViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(FileSystemViewModel::class)
    abstract fun bindFileSystemViewModel(model: FileSystemViewModel): ViewModel
}