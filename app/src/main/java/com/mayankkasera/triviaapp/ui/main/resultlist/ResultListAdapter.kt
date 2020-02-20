package com.mayankkasera.triviaapp.ui.main.resultlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codeinger.moviestack.utils.toFormattedDisplay
import com.mayankkasera.triviaapp.R
import com.mayankkasera.triviaapp.pojo.Result
import kotlinx.android.synthetic.main.result_list.view.*

class ResultListAdapter(var list : List<Result>) : RecyclerView.Adapter<ResultListAdapter.ResultListViewHolder>() {


    /*
      ViewHolder
    */
    inner class ResultListViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bind(result : Result,i : Int){
               view.date.text = "Game ${i+1} : "+result.calendar.toFormattedDisplay()
               view.name.text = "Name : "+result.name
               if(result.list!!.size>=2){
                   view.que1.text = result.list?.get(0)?.que
                   view.ans1.text = result.list?.get(0)?.ans
                   view.que2.text = result.list?.get(1)?.que
                   view.ans2.text = result.list?.get(1)?.ans
               }
        }


    }

    /*
       For Create ViewHolder
    */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultListViewHolder {
        return ResultListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.result_list,
                parent,
                false
            )
        )
    }

    /*
      For geting ItemCount
   */
    override fun getItemCount(): Int {
        return list.size
    }

    /*
    For Binding ViewHolder
   */
    override fun onBindViewHolder(holder: ResultListViewHolder, position: Int) {
        holder.bind(list[position],position)
    }
}