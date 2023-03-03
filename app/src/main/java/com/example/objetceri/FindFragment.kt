package com.example.objetceri

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.objetceri.ItemRepository.Singleton.itemList
import com.example.objetceri.adapter.ItemAdapter

/**
// TOD0: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
**/
/**
 * A simple [Fragment] subclass.
 * Use the [FindFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FindFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_find, container, false)




        /** ex part, we add manually items
        // add a first item
        itemList.add(
            ItemModel(
                "https://cdn.discordapp.com/attachments/689544653594296370/1076083386633945088/C67F1199-D4B6-4BD0-9F1F-41D7C6431D0E.jpg",
                "montre",
                "j'ai trouvé cette montre ",
                "02/17/23",
                "CERI",
                "C129"
            )
        )

        // add a second item
        itemList.add(
            ItemModel(
                "https://cdn.discordapp.com/attachments/689544653594296370/1073642110735110304/IMG_20230210_160633.jpg",
                "telephone",
                "j'ai trouvé ce telephone ",
                "02/10/23",
                "CERI",
                "Amphi Ada"

            )

        )

**/



        //get recycler view
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ItemAdapter(this,itemList)


        return view
    }



    /**
    // TOD0: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FindFragment.
         */
        // TOD0: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FindFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    **/
}