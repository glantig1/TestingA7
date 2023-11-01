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
private const val OG_TEXT_KEY2 = "param2"


class SomeDisplayFragment : Fragment() {

    private val CURRENT_TEXT_KEY = "parram"
    private var currentTextId = "test"

    private val CURRENT_TEXT_KEY2 = "parram"
    private var currentTextId2 = "test"

    private lateinit var textView: TextView
    private lateinit var textView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState == null) {
            arguments?.run {
                currentTextId = getString(OG_TEXT_KEY).toString()
                currentTextId2 = getString(OG_TEXT_KEY2).toString()
            }
        }
        else{
            currentTextId = savedInstanceState.getString(OG_TEXT_KEY).toString()
            currentTextId2 = savedInstanceState.getString(OG_TEXT_KEY2).toString()
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_some_display, container, false).apply{
            textView = findViewById(R.id.textView)
            textView2 = findViewById(R.id.textView2)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savedInstanceState?.run{
            currentTextId = getString(CURRENT_TEXT_KEY).toString()
            currentTextId2 = getString(CURRENT_TEXT_KEY2).toString()
            if(currentTextId == "test") changeText(currentTextId,currentTextId2)
        }
        changeText(currentTextId,currentTextId2)
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(CURRENT_TEXT_KEY, currentTextId.toString())
    }
    fun changeText(textID:String, textID2:String){
        textView.setText(textID)
        textView2.setText(textID2)
    }
    companion object {
        @JvmStatic
        fun newInstance(someText: String, someText2: String) =
            SomeDisplayFragment().apply {
                arguments = Bundle().apply {
                    putString(OG_TEXT_KEY, someText)
                    putString(OG_TEXT_KEY2, someText2)
                }
            }
    }
}