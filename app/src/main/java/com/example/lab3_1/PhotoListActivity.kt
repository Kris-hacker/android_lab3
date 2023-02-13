package com.example.lab3_1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

data class Candidate(val name : String, val detail : String, val photo : Int)

class CandidateAdapter(
    context: Context,
    resource: Int,
    objects: MutableList<Candidate>
) : ArrayAdapter<Candidate>(context, resource, objects) {
    private var resource = resource
    private var candidates = objects
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var v = convertView
        if (v == null){
            val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            v = layoutInflater.inflate(resource, parent, false)
        }
        var imageView = v!!.findViewById<ImageView>(R.id.imageView)
        var textViewName = v!!.findViewById<TextView>(R.id.textViewName)
        var textViewDetail = v!!.findViewById<TextView>(R.id.textViewDetail)
        imageView.setImageResource(candidates[position].photo)
        textViewName.text = candidates[position].name
        textViewDetail.text = candidates[position].detail
        return v!!
    }
}

class PhotoListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_list)
        var candidateNames = resources.getStringArray(R.array.candidateNames)
        var candidateDetails = resources.getStringArray(R.array.candidateNames)
        var candidatePhotos: Array<Int> = arrayOf(
            R.drawable.clinton,
            R.drawable.sanders,
            R.drawable.omalley,
            R.drawable.chafee,
            R.drawable.trump,
            R.drawable.carson,
            R.drawable.rubio,
            R.drawable.bush
        )
        var candidates = ArrayList<Candidate>()
        @Override
        for (i in 0 until candidateNames.size) {
            val c = Candidate(candidateNames[i], candidateDetails[i], candidatePhotos[i])
            candidates.add(c)
        }

        val listView: ListView = this.findViewById(R.id.listViewComplex)
        val listAdapter =
            CandidateAdapter(this, R.layout.list_item, candidates)
        listView.adapter = listAdapter
//using lambda syntax
        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "You clicked ${candidates[position].name}", Toast.LENGTH_LONG).show()
        }
    }
}