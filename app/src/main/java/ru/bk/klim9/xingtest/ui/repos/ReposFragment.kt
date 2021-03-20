package ru.bk.klim9.xingtest.ui.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.repos_fragment.*
import ru.bk.klim9.xingtest.R
import javax.inject.Inject


class ReposFragment : Fragment(), ReposAdapter.Action {

    companion object {
        fun newInstance() = ReposFragment()
    }

    @Inject
    lateinit var viewModel: ReposViewModel
    private val reposAdapter = ReposAdapter(this)

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
            if (it is ReposViewModel.Action.Repos) {
                reposAdapter.setData(it.reposList)
            }

        })
    }

    private fun initUi() {
        if (reposRv.adapter == null) {
            reposRv.adapter = reposAdapter
        }
        reposRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val dividerItemDecoration = DividerItemDecoration(
            reposRv.context,
            (reposRv.layoutManager as LinearLayoutManager).orientation
        )
        reposRv.addItemDecoration(dividerItemDecoration)

    }

    override fun onReposItemLongClick() {

    }

}