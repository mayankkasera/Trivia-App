package com.mayankkasera.triviaapp.ui.main.username


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.mayankkasera.triviaapp.R
import com.mayankkasera.triviaapp.pojo.Result
import com.mayankkasera.triviaapp.ui.main.que.QueFragment
import kotlinx.android.synthetic.main.fragment_user_name.view.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class UserNameFragment : Fragment() {

    lateinit var mView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_user_name, container, false)


        mView.next.setOnClickListener {
            if (mView.username.text.toString().length > 0)
                replace(QueFragment.newInstance(
                    Result(
                        calendar = Calendar.getInstance(),
                        name = mView.username.text.toString(),
                        list =  arrayListOf()
                    )))
            else
                Toast.makeText(context, "Enter user name", Toast.LENGTH_SHORT).show()
        }

        return mView
    }

    fun replace(fragment: Fragment) {
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.frame, fragment)
        transaction?.commit()
    }


}
