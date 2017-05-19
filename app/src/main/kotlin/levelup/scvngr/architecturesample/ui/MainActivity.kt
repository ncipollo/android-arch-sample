package levelup.scvngr.architecturesample.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import levelup.scvngr.architecturesample.R
import levelup.scvngr.architecturesample.ui.repo.RepoFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.content, RepoFragment())
                    .commit()
        }
    }
}
