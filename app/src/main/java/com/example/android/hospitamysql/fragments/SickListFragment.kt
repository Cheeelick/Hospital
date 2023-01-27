package com.example.android.hospitamysql.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.hospitamysql.R
import com.example.android.hospitamysql.RetrofitClient
import com.example.android.hospitamysql.api.Sick
import org.w3c.dom.Text
import retrofit2.Call


private const val TAG = "SickListFragment"

class SickListFragment: Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SickAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val flickrLiveData: LiveData<List<Sick>> = RetrofitClient().listSick()
        flickrLiveData.observe(
            this,
            Observer { sick ->
                recyclerView.adapter = SickAdapter(sick)
                Log.d(TAG, "Response received: $sick")
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_sick, container, false)

        recyclerView = view.findViewById(R.id.recycler_sick) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)


        return view
    }



    private inner class SickAdapter(var sick: List<Sick>): RecyclerView.Adapter<SickHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SickHolder {
            val view = layoutInflater.inflate(R.layout.item_list_sick, parent, false)
            return SickHolder(view)
        }

        override fun onBindViewHolder(holder: SickHolder, position: Int) {
            val result = sick[position]
            holder.bind(result)
        }

        override fun getItemCount(): Int = sick.size

    }



    private inner class SickHolder(view: View): RecyclerView.ViewHolder(view){

        private lateinit var sick: Sick
        private val fioTitle: TextView = itemView.findViewById(R.id.fio_Sick)
        private val numberText: TextView = itemView.findViewById(R.id.number_Sick)
        private val adressText: TextView = itemView.findViewById(R.id.adress_Sick)



        fun bind(result: Sick){
            this.sick = result
            fioTitle.text = this.sick.fioSick
            numberText.text = this.sick.numberSick
            adressText.text = this.sick.adressSick
        }
    }



    companion object{
        fun newInstance(): SickListFragment{
            return SickListFragment()
        }
    }
}