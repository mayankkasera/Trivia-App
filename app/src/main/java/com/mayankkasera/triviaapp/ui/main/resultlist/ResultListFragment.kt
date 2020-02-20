package com.mayankkasera.triviaapp.ui.main.resultlist


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinger.moviestack.utils.createFactory

import com.mayankkasera.triviaapp.R
import com.mayankkasera.triviaapp.data.RoomDatabaseHelper
import com.mayankkasera.triviaapp.data.que.QueRepo
import com.mayankkasera.triviaapp.data.results.ResultsRepo
import com.mayankkasera.triviaapp.ui.main.username.UserNameFragment
import kotlinx.android.synthetic.main.fragment_result_list.view.*

/**
 * A simple [Fragment] subclass.
 */
class ResultListFragment : Fragment() {


    lateinit var mView: View
    lateinit var resultListViewModel: ResultListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_result_list, container, false)

        init()

        setObserver()

        mView.again.setOnClickListener{
            replace(UserNameFragment())
        }

        return mView
    }

    /*
       For Observe live data
    */
    private fun setObserver() {
        resultListViewModel.mutableLiveData.observe(this, Observer{
            Log.i("jsbc",it.toString())
            var adapter = ResultListAdapter(it)
            mView.recyclerView.adapter = adapter
        })
    }

    /*
       For initialization
    */
    private fun init() {
        mView.recyclerView.layoutManager = LinearLayoutManager(context)
        val factory = ResultListViewModel(ResultsRepo(RoomDatabaseHelper().localeDataBase)).createFactory()
        resultListViewModel = ViewModelProvider(this, factory).get(ResultListViewModel::class.java)
        resultListViewModel.loadQue()
    }

    /*
      For replaceing fragment
  */
    fun replace(fragment: Fragment) {
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.frame, fragment)
        transaction?.commit()
    }


}
