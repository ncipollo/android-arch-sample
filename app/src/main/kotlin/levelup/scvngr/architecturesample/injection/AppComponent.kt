package levelup.scvngr.architecturesample.injection

import dagger.Component
import levelup.scvngr.architecturesample.api.ApiModule
import levelup.scvngr.architecturesample.viewmodel.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApiModule::class, AppModule::class, ViewModelModule::class))
interface AppComponent {
    val fragmentComponent: FragmentSubComponent
}
