package ru.bk.klim9.xingtest.ui.repos

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.bk.klim9.xingtest.requests.repos.ReposItem
import ru.bk.klim9.xingtest.ui.common.BaseViewModel
import javax.inject.Inject

private const val TAG = "ReposViewModel"

class ReposViewModel @Inject constructor() : BaseViewModel() {

    val actionLd = MutableLiveData<Action>()
    val reposLd = MutableLiveData<Action>()

    fun getRemoteData() {
        cd.add(repository.getRemoteData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{actionLd.value = Action.ShowProgress}
            .subscribe({
                actionLd.value = Action.HideProgress
            }, {
                Log.d(TAG, "observeRepos error: ${it.message}", it)
                actionLd.value = Action.HideProgress
            }))
    }

    fun observeRepos() {
        cd.add(repository.observeRepos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                reposLd.value = Action.Repos(it)
                Log.d("$TAG TTT17", "$it")
            }, {
                Log.d(TAG, "observeRepos error: ${it.message}", it)
            }))
    }

    sealed class Action {
        object ShowProgress : Action()
        object HideProgress : Action()
        class Repos(val reposList: List<ReposItem>) : Action()
    }
}