package com.kyanro.okoraredaggerdrill.ui.home.dagger

import androidx.lifecycle.ViewModelProvider
import com.kyanro.okoraredaggerdrill.dagger.FragmentScope
import com.kyanro.okoraredaggerdrill.domain.fortune.FortuneTextCreator
import com.kyanro.okoraredaggerdrill.ui.home.HomeSecondFragment
import com.kyanro.okoraredaggerdrill.ui.home.HomeSecondFragmentArgs
import com.kyanro.okoraredaggerdrill.ui.home.HomeSecondViewModel
import com.kyanro.okoraredaggerdrill.ui.home.HomeSecondViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [HomeSecondViewModelModule::class])
interface HomeSecondSubComponent {
    fun getHomeSecondViewModel(): HomeSecondViewModel

    @Subcomponent.Factory
    interface Factory {
        fun create(homeSecondViewModelModule: HomeSecondViewModelModule): HomeSecondSubComponent
    }

    fun inject(homeSecondFragment: HomeSecondFragment)
}

@Module(subcomponents = [HomeSecondSubComponent::class])
object HomeSecondSubComponentModule

@Module
class HomeSecondViewModelModule(
    private val fragment: HomeSecondFragment,
    private val args: HomeSecondFragmentArgs
) {
    @FragmentScope
    @Provides
    fun provideViewModel(fortuneTextCreator: FortuneTextCreator): HomeSecondViewModel {
        val factory = HomeSecondViewModelFactory(fortuneTextCreator, args)
        return ViewModelProvider(fragment, factory).get(HomeSecondViewModel::class.java)
    }
}