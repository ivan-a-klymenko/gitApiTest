package ru.bk.klim9.xingtest.ui.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.bk.klim9.xingtest.R
import ru.bk.klim9.xingtest.ui.repos.ReposFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ReposFragment.newInstance())
                .commitNow()
        }
    }
}