package levelup.scvngr.architecturesample

import android.app.Application
import levelup.scvngr.architecturesample.injection.DaggerAppComponent
import levelup.scvngr.architecturesample.injection.Injector


class SampleApp: Application() {
    override fun onCreate() {
        val appComponent = DaggerAppComponent.builder().build()
        Injector.fragmentComponent = appComponent.fragmentComponent
    }
}
