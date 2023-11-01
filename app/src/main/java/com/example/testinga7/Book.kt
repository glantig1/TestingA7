package com.example.testinga7

import java.io.Serializable

class Book (val title: String, val author: String): Serializable

class BookList(_bookArray: ArrayList<Book>): Serializable {

    private var bookArray = _bookArray
    fun add(book: Book){
        bookArray.add(book)
    }
    fun get(position:Int):Book{
        return bookArray[position]
    }
    fun size(): Int{
        return bookArray.size
    }
}