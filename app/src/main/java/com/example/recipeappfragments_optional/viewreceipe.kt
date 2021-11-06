package com.example.recipeappfragments_optional

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [viewreceipe.newInstance] factory method to
 * create an instance of this fragment.
 */
class viewreceipe : Fragment() {
    // TODO: Rename and change types of parameters
    var TAG = "viewreceipe"
    private var param1: String? = null
    private var param2: String? = null
    lateinit var rv:RecyclerView
    lateinit var btn:Button
    lateinit var view1:View

    private val vm by lazy{ ViewModelProvider(this).get(VM::class.java)}



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        view1 = inflater.inflate(R.layout.fragment_viewreceipe, container, false)
        init()
        updaterv()

        btn.setOnClickListener { Navigation.findNavController(view1).navigate(R.id.action_viewreceipe_to_addreceipe) }
        // Inflate the layout for this fragment

        return view1
    }
    fun init(){
        rv = view1.findViewById(R.id.rv)
        btn = view1.findViewById(R.id.vi)

    }

    private fun updaterv(){
        vm.retrive().observe(viewLifecycleOwner) {
                note ->
            rv.adapter = MyAdapter(note)
            rv.layoutManager = GridLayoutManager(requireContext(),2)

        }

    }
    }
