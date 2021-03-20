package ru.bk.klim9.xingtest.ui.repos

import android.util.Log
import ru.bk.klim9.xingtest.ui.common.BaseViewModel
import javax.inject.Inject

private const val TAG = "ReposViewModel"

class ReposViewModel @Inject constructor() : BaseViewModel() {

    fun start() {
        Log.d("$TAG TTT17", "start")
    }
}