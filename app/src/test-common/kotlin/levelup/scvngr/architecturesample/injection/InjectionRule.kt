package levelup.scvngr.architecturesample.injection

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class InjectionRule : TestRule {
    lateinit var appComponent: TestAppComponent
        private set

    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement() {
            override fun evaluate() {
                appComponent = DaggerTestAppComponent.builder().build()
                Injector.fragmentComponent = appComponent.fragmentComponent
                base?.evaluate()
            }
        }
    }
}
