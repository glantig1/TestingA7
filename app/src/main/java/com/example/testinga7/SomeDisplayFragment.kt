package com.example.testinga7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.lang.reflect.Array.getInt

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val OG_TEXT_KEY = "param1"


class SomeDisplayFragment : Fragment() {

    private val CURRENT_TEXT_KEY = "parram"
    private var currentTextId = 0

    private lateinit var textView: TextView
    private lateinit var textView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState == null) {
            arguments?.run {
                currentTextId = getInt(OG_TEXT_KEY)
            }
        }
        else{
            currentTextId = savedInstanceState.getInt(OG_TEXT_KEY)
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_some_display, container, false).apply{
            textView = findViewById(R.id.textView)
            //textView2 = findViewById(R.id.textView)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savedInstanceState?.run{
            currentTextId = getInt(CURRENT_TEXT_KEY)
            if(currentTextId == 0) changeText(currentTextId)
        }
        changeText(currentTextId)
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(CURRENT_TEXT_KEY, currentTextId.toString())
    }
    fun changeText(textID:Int){
        textView.setText(textID.toString())
    }
    companion object {
        @JvmStatic
        fun newInstance(someText: String) =
            SomeDisplayFragment().apply {
                arguments = Bundle().apply {
                    putString(OG_TEXT_KEY, someText)
                }
            }
    }
}