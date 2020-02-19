package com.mayankkasera.triviaapp.ui.main.result


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mayankkasera.triviaapp.R
import com.mayankkasera.triviaapp.pojo.Result
import com.mayankkasera.triviaapp.ui.main.que.QueFragment
import kotlinx.android.synthetic.main.fragment_result.view.*

/**
 * A simple [Fragment] subclass.
 */
class ResultFragment : Fragment() {


    lateinit var mView: View
    lateinit var result: Result

    companion object {
        private const val RESULT = "result"
        fun newInstance(result: Result): ResultFragment {
            val bundle = Bundle()
            bundle.putParcelable(RESULT, result)
            val fragment = ResultFragment()
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_result, container, false)

        init()


        return mView;
    }

    private fun init() {
        result = arguments?.getParcelable<Result>(RESULT) as Result
        mView.name.text = result.name
        var qa = result.list
        if(qa?.size!! >=1)
        mView.ans1.text = "Ans1 :- "+ qa?.get(0)?.ans
        if(qa?.size!! >=2)
        mView.ans2.text = "Ans2 :- "+qa?.get(1)?.ans


    }


}