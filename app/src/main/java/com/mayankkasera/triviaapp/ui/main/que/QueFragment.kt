package com.mayankkasera.triviaapp.ui.main.que


import android.os.Bundle
import android.util.Log
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
import com.codeinger.moviestack.utils.gone
import com.codeinger.moviestack.utils.visible
import com.mayankkasera.triviaapp.R
import com.mayankkasera.triviaapp.data.que.QueRepo
import com.mayankkasera.triviaapp.pojo.Que
import com.mayankkasera.triviaapp.pojo.Result
import com.mayankkasera.triviaapp.ui.main.result.ResultFragment
import kotlinx.android.synthetic.main.fragment_que.*
import kotlinx.android.synthetic.main.fragment_que.view.*


/**
 * A simple [Fragment] subclass.
 */
class QueFragment : Fragment() {

    lateinit var mView: View
    lateinit var result: Result
    lateinit var queViewModel: QueViewModel

    companion object {
        private const val RESULT = "result"
        fun newInstance(result: Result): QueFragment {
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

    /*
     For initialization
    */
    private fun init() {
        result = arguments?.getParcelable<Result>(RESULT) as Result
        val factory = QueViewModel(QueRepo()).createFactory()
        queViewModel = ViewModelProvider(this, factory).get(QueViewModel::class.java)
        queViewModel.loadQue()
    }

    /*
      For Observe Live Data
   */
    fun setObserver() {
        queViewModel.mutableLiveData.observe(this, Observer { list ->

            setData(list)

            setListener(list)


        })
    }

    /*
       For set Listener
    */
    private fun setListener(list: List<Que>) {
        mView.next.setOnClickListener {

            var qa = result.list
            when (result.list?.size) {
                0 -> {
                    if (mView.singleOption.checkedRadioButtonId != -1) {
                        var radio: RadioButton? = mView.singleOption.findViewById(mView.singleOption.checkedRadioButtonId)
                        qa?.add(Result.QA(list.get(0).quesition, radio?.text.toString()))
                        result.list = qa
                        replace(QueFragment.newInstance(result))
                    } else {
                        Toast.makeText(context, "Select option.", Toast.LENGTH_SHORT).show()
                    }

                }
                1 -> {

                    var selectedOptions: String = ""

                    if (mView.multipleSelect1.isChecked)
                        selectedOptions =
                            selectedOptions + "," + mView.multipleSelect1.text.toString()

                    if (mView.multipleSelect2.isChecked)
                        selectedOptions =
                            selectedOptions + "," + mView.multipleSelect2.text.toString()

                    if (mView.multipleSelect3.isChecked)
                        selectedOptions =
                            selectedOptions + "," + mView.multipleSelect3.text.toString()

                    if (mView.multipleSelect4.isChecked)
                        selectedOptions =
                            selectedOptions + "," + mView.multipleSelect4.text.toString()


                    if (!selectedOptions.equals("")) {
                        selectedOptions = selectedOptions.substring(1, selectedOptions.length)
                        qa?.add(Result.QA(list.get(1).quesition, selectedOptions))
                        result.list = qa
                        replace(ResultFragment.newInstance(result))
                    } else {
                        Toast.makeText(context, "Select option.", Toast.LENGTH_SHORT).show()
                    }

                }
            }


        }
    }


    /*
       For set data in views
    */
    private fun setData(list: List<Que>) {
        when (result.list?.size) {
            0 -> {
                mView.que.text = "Que 1 : ${list.get(0).quesition}"
                mView.singleOption1.text = "${list.get(0).option1}"
                mView.singleOption2.text = "${list.get(0).option2}"
                mView.singleOption3.text = "${list.get(0).option3}"
                mView.singleOption4.text = "${list.get(0).option4}"

                mView.singleOption.visible()
                mView.group.gone()

            }
            1 -> {
                mView.que.text = "Que 1 : ${list.get(1).quesition}"
                mView.multipleSelect1.text = "${list.get(1).option1}"
                mView.multipleSelect2.text = "${list.get(1).option2}"
                mView.multipleSelect3.text = "${list.get(1).option3}"
                mView.multipleSelect4.text = "${list.get(1).option4}"

                mView.singleOption.gone()
                mView.group.visible()


            }
        }
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
