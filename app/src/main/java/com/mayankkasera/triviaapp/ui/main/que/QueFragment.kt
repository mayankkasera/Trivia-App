package com.mayankkasera.triviaapp.ui.main.que


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.codeinger.moviestack.utils.createFactory
import com.codeinger.moviestack.utils.visible
import com.mayankkasera.triviaapp.R
import com.mayankkasera.triviaapp.data.que.QueRepo
import com.mayankkasera.triviaapp.pojo.Result
import kotlinx.android.synthetic.main.fragment_que.*
import kotlinx.android.synthetic.main.fragment_que.view.*


/**
 * A simple [Fragment] subclass.
 */
class QueFragment : Fragment() {

    lateinit var mView : View
    lateinit var result : Result
    lateinit var queViewModel: QueViewModel

    companion object {
        private const val RESULT = "result"
        fun newInstance(result : Result): QueFragment {
            val bundle = Bundle()
            bundle.putParcelable(RESULT, result)
            val fragment = QueFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_que, container, false)

        init()
        setObserver()






        return mView
    }

    private fun init() {
        result = arguments?.getParcelable<Result>(RESULT) as Result
        val factory = QueViewModel(QueRepo()).createFactory()
        queViewModel = ViewModelProvider(this, factory).get(QueViewModel::class.java)
        queViewModel.loadQue()
    }

    fun setObserver() {
        queViewModel.mutableLiveData.observe(this, Observer{list ->


            // Get option selected item using on checked change listener
            mView.next.setOnClickListener{


                when(result.list?.size){
                    0 -> {
                        mView.que.text = "Que 1 : ${list.get(0).quesition}"
                        mView.singleOption1.text = "1 ${list.get(0).option1}"
                        mView.singleOption2.text = "2 ${list.get(0).option2}"
                        mView.singleOption3.text = "3 ${list.get(0).option3}"
                        mView.singleOption4.text = "4 ${list.get(0).option4}"

                        mView.singleOption.visible()
                        val radio: RadioButton = mView.singleOption.findViewById(mView.singleOption.checkedRadioButtonId )
                        var qa = result.list
                        qa?.add(Result.QA(list.get(0).quesition,radio.text.toString()))
                        result.list = qa
                        replace(QueFragment.newInstance(result))
                    }
                    1 -> {
                        mView.que.text = "Que 1 : ${list.get(1).quesition}"
                        mView.singleOption1.text = "1 ${list.get(1).option1}"
                        mView.singleOption2.text = "2 ${list.get(1).option2}"
                        mView.singleOption3.text = "3 ${list.get(1).option3}"
                        mView.singleOption4.text = "4 ${list.get(1).option4}"



                    }
                }


            }
        })
    }

    fun replace(fragment: Fragment) {
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.frame, fragment)
        transaction?.commit()
    }



}
