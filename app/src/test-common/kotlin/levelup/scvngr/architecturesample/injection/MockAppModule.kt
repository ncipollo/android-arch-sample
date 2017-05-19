package levelup.scvngr.architecturesample.injection

import dagger.Module
import dagger.Provides
import levelup.scvngr.architecturesample.rx.Schedulers
import rx.Scheduler

@Module
class MockAppModule {
    @Provides
    fun provideSchedulers() : Schedulers {
        return object: Schedulers {
            override val io: Scheduler
                get() = rx.schedulers.Schedulers.immediate()
            override val mainThread: Scheduler
                get() = rx.schedulers.Schedulers.immediate()
        }
    }
}
