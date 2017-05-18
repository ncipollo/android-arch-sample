package levelup.scvngr.architecturesample.rx

import rx.Scheduler

interface Schedulers {
    val mainThread: Scheduler
    val io: Scheduler
}
