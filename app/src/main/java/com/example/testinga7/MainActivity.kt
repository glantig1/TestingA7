package com.example.testinga7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleRes: Array<String> = resources.getStringArray(R.array.title_array_name)
        val authorRes: Array<String> = resources.getStringArray(R.array.author_array_name)

        val bArray = arrayListOf<Book>(
            Book(titleRes[0],authorRes[0]),
            Book(titleRes[1],authorRes[1]),
            Book(titleRes[2],authorRes[2]),
            Book(titleRes[3],authorRes[3]),
            Book(titleRes[4],authorRes[4]),
            Book(titleRes[5],authorRes[5]),
            Book(titleRes[6],authorRes[6]),
            Book(titleRes[7],authorRes[7]),
            Book(titleRes[8],authorRes[8]),
            Book(titleRes[9],authorRes[9]),
        )

        //val fragment1 = SomeListFragment.newInstance(bArray)
        val fragment2 = SomeDisplayFragment.newInstance(bArray[0].title,bArray[0].author)

        //.add(R.id.fragmentContainerView,fragment1)
        //.add(R.id.fragmentContainerView2,fragment2)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView2,fragment2)
            .addToBackStack(null)
            .setReorderingAllowed(true)
            .commit()

    }
}