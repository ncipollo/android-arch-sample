package levelup.scvngr.architecturesample.ui.repo

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import levelup.scvngr.architecturesample.R
import levelup.scvngr.architecturesample.api.GithubApi
import levelup.scvngr.architecturesample.injection.InjectionRule
import levelup.scvngr.architecturesample.model.repo.createRepoListObservable
import levelup.scvngr.architecturesample.model.repo.repoPrefix
import levelup.scvngr.architecturesample.ui.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito


class RepoFragmentTest {
    lateinit var githubApi: GithubApi
    val testUser = "test"

    @JvmField @Rule
    val activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java, true, true)
    @JvmField @Rule
    val injectionRule = InjectionRule()
    @JvmField @Rule
    val instantTask = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        githubApi = injectionRule.appComponent.githubApi
        Mockito.`when`(githubApi.repos(testUser)).thenReturn(
                createRepoListObservable())
    }

    @Test
    fun testLoad() {
        setUser(testUser)
        onView(withText("$repoPrefix 0")).check(matches(isDisplayed()))
    }

    fun setUser(user: String) {
        onView(withId(R.id.userField)).perform(typeText(user))
        onView(withId(R.id.submitButton)).perform(click())
    }

}
