package levelup.scvngr.architecturesample.viewmodel

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = arrayOf(ViewModelSubComponent::class))
class ViewModelModule {

    @Provides
    @Singleton
    fun provideViewModelComponent(builder: ViewModelSubComponent.Builder) : ViewModelSubComponent {
        return builder.build()
    }
}
