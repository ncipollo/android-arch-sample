package levelup.scvngr.architecturesample.injection

import dagger.Component
import levelup.scvngr.architecturesample.viewmodel.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ViewModelModule::class))
interface AppComponent {
    val fragmentComponent: FragmentSubComponent
}
