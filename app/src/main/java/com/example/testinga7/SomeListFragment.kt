package com.example.testinga7

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val TEXT_ARRAY_KEY = "param11"

class SomeListFragment : Fragment() {
    private lateinit var textArray: ArrayList<Book>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getSerializable(TEXT_ARRAY_KEY, textArray::class.java)?.let{
                textArray = it
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_some_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view as RecyclerView){
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = BookListAdapter(textArray){

            }
        }
    }
    companion object {

        @JvmStatic
        fun newInstance(textArray: ArrayList<Book>) =
            SomeListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(TEXT_ARRAY_KEY, textArray::class.java)
                }
            }
    }
}


class BookListAdapter(private val _books: ArrayList<Book>, private val cBack: (Book)->Unit) : RecyclerView.Adapter<BookListAdapter.MyViewHolder>() {

    private val books = _books
    private val callback = cBack
    inner class MyViewHolder(layout: View) : RecyclerView.ViewHolder(layout){
        val title = layout.findViewById<TextView>(R.id.bookTitleTextView)
        val author = layout.findViewById<TextView>(R.id.bookAuthorTextView)

        init {
            title.setOnClickListener{callback(books[adapterPosition])}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_some_list,parent,false))
    }

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = books[position].title
        holder.author.text = books[position].author
    }


}