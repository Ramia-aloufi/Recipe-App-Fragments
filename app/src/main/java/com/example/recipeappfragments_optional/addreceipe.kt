package com.example.recipeappfragments_optional

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [addreceipe.newInstance] factory method to
 * create an instance of this fragment.
 */
class addreceipe : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var title:EditText
    lateinit var author:EditText
    lateinit var ingredients:EditText
    lateinit var instructions:EditText
    lateinit var view1: View
    lateinit var vieww:Button
    lateinit var save:Button
    private val vm by lazy{ ViewModelProvider(this).get(VM::class.java)}




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_addreceipe, container, false)
        init()
        save.setOnClickListener {vm.addNote(gettext()) }
        vieww.setOnClickListener {Navigation.findNavController(view1).navigate(R.id.action_addreceipe_to_viewreceipe)
        }
        return view1
    }

    private fun init() {
        title = view1.findViewById(R.id.title)
        author = view1.findViewById(R.id.author)
        ingredients = view1.findViewById(R.id.ingredients)
        instructions = view1.findViewById(R.id.instructions)
        vieww = view1.findViewById(R.id.View)
        save = view1.findViewById(R.id.Save)
    }

    fun gettext(): Receipes {
        val aa = title.text.toString()
        val bb = author.text.toString()
        val cc = ingredients.text.toString()
        val dd = instructions.text.toString()
        return Receipes(null,aa,bb,cc,dd)
    }

}