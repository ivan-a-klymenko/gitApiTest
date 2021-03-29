package ru.bk.klim9.xingtest.ui.common

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ru.bk.klim9.xingtest.repository.IDataRepository
import javax.inject.Inject

/**
 * @author ivan.a.klymenko@gmail.com on 3/20/21
 */
open class BaseViewModel @Inject constructor(val repository: IDataRepository) : ViewModel() {

    protected open val cd = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        cd.clear()
    }
}