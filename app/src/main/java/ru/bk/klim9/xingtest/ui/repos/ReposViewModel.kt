package ru.bk.klim9.xingtest.ui.repos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.bk.klim9.xingtest.requests.repos.ReposItem
import ru.bk.klim9.xingtest.ui.common.BaseViewModel
import javax.inject.Inject

private const val TAG = "ReposViewModel"

class ReposViewModel @Inject constructor() : BaseViewModel() {

    private val _actionLd = MutableLiveData<Action>()
    val actionLd: LiveData<Action> = _actionLd
    private val _reposLd = MutableLiveData<Action>()
    val reposLd: LiveData<Action> = _reposLd
    private val _errorLd = MutableLiveData<Action>()
    val errorLd: LiveData<Action> = _errorLd

    fun getRemoteData() {
        cd.add(repository.getRemoteData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{_actionLd.value = Action.ShowProgress}
            .subscribe({
                setActionValue()
            }, {
                Log.d(TAG, "observeRepos error: ${it.message}", it)
                setActionValue()
                setErrorValue(it)
            }))
    }

    private fun setErrorValue(it: Throwable) {
        _errorLd.value = it.message?.let { it1 -> Action.Error(it1) }
    }

    private fun setActionValue() {
        _actionLd.value = Action.HideProgress
    }

    fun observeRepos() {
        cd.add(repository.observeRepos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                setReposValue(it)
            }, {
                Log.d(TAG, "observeRepos error: ${it.message}", it)
            }))
    }

    fun setReposValue(it: List<ReposItem>) {
        _reposLd.value = Action.Repos(it)
    }

    sealed class Action {
        object ShowProgress : Action()
        object HideProgress : Action()
        class Repos(val reposList: List<ReposItem>) : Action()
        class Error(val message: String) : Action()
    }
}