package ru.bk.klim9.xingtest.ui.repos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.bk.klim9.xingtest.repository.DataRepository
import ru.bk.klim9.xingtest.repository.IDataRepository
import ru.bk.klim9.xingtest.requests.repos.ReposItem
import javax.inject.Inject

private const val TAG = "ReposViewModel"

class ReposViewModel @Inject constructor(val repository: IDataRepository) : ViewModel() {

    private val _actionLd = MutableLiveData<Action>()
    val actionLd: LiveData<Action> = _actionLd
    private val _reposLd = MutableLiveData<Action>()
    val reposLd: LiveData<Action> = _reposLd
    private val _errorLd = MutableLiveData<Action>()
    val errorLd: LiveData<Action> = _errorLd
    private val cd = CompositeDisposable()

    private val workScheduler by lazy {
        if (repository is DataRepository) Schedulers.io() else Schedulers.trampoline()
    }

    private val resultScheduler by lazy {
        if (repository is DataRepository) AndroidSchedulers.mainThread() else Schedulers.trampoline()
    }

    override fun onCleared() {
        super.onCleared()
        cd.clear()
    }

    fun getRemoteData() {
        cd.add(repository.getRemoteData()
            .subscribeOn(workScheduler)
            .observeOn(resultScheduler)
            .doOnSubscribe{_actionLd.value = Action.ShowProgress}
            .doFinally { setActionValue() }
            .subscribe({
                Log.d(TAG, "getRemoteData success: $it")
            }, {
                Log.d(TAG, "getRemoteData error: ${it.message}", it)
                setErrorValue(it)
            }))
    }

    fun setErrorValue(it: Throwable) {
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
        data class Error(val message: String) : Action()
    }
}