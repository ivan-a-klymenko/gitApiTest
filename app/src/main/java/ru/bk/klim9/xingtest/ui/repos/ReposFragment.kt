package ru.bk.klim9.xingtest.ui.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.repos_fragment.*
import ru.bk.klim9.xingtest.R
import javax.inject.Inject

class ReposFragment : Fragment() {

    companion object {
        fun newInstance() = ReposFragment()
    }

    @Inject
    lateinit var viewModel: ReposViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.repos_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
        initObservers()

    }

    override fun onResume() {
        super.onResume()
        viewModel.observeRepos()
        viewModel.getRemoteData()
    }

    private fun initObservers() {
        viewModel.actionLd.observe(viewLifecycleOwner, {
            when (it) {
                is ReposViewModel.Action.ShowProgress -> reposProgress.visibility = View.VISIBLE
                else -> reposProgress.visibility = View.GONE
            }
        })
        viewModel.reposLd.observe(viewLifecycleOwner, {

        })
    }

    private fun initUi() {

    }

}