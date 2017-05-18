package levelup.scvngr.architecturesample.injection

import dagger.Module
import dagger.Provides
import levelup.scvngr.architecturesample.rx.Schedulers
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers

@Module
class AppModule {
    @Provides
    fun provideSchedulers() : Schedulers {
        return object: Schedulers {
            override val io: Scheduler
                get() = rx.schedulers.Schedulers.io()
            override val mainThread: Scheduler
                get() = AndroidSchedulers.mainThread()
        }
    }
}
