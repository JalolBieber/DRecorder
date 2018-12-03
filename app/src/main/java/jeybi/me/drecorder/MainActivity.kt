package jeybi.me.drecorder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val titles = arrayListOf<String>("Java","Kotlin","C++","Balo battar","Blah blah","Java","Kotlin","C++","Balo battar","Blah blah","Java","Kotlin","C++","Balo battar","Blah blah")
    val paths = arrayListOf<String>("sd://videos/","sd://movies","C++","Balo battar","Blah blah","Java","Kotlin","C++","Balo battar","Blah blah","Java","Kotlin","C++","Balo battar","Blah blah")


    val data = ArrayList<RecordedVideo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)


        for (i in 0..10){

            val video = RecordedVideo(titles[i],paths[i],0f)

            data.add(video)

        }


        recyclerView.adapter = VideosAdapter(this,data)


    }


}
