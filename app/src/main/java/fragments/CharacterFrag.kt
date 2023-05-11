package fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Intents
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uts_botnavrecview.*


class CharacterFrag : Fragment() {
    companion object {
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: CharactersAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var charArrayList: ArrayList<Characters>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvChar)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CharactersAdapter(charArrayList){
        val intent = Intent(context,DetailCharacterActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        charArrayList = arrayListOf<Characters>()

        image = arrayOf(
            R.drawable.jihyo,
            R.drawable.nayeon,
            R.drawable.chaeyoung,
            R.drawable.jeongyeon,
            R.drawable.mina,
            R.drawable.momo,
            R.drawable.ningning,
            R.drawable.sana,
            R.drawable.tzuyu,
            R.drawable.jisooo,
        )

        title = arrayOf(
            "Jihyo",
            "Nayeon",
            "Chaeyoung",
            "Jeongyeon",
            "Mina",
            "Momo",
            "Ningning",
            "Sana",
            "Tzuyu",
            "Jisooo",

        )
        description = arrayOf(
            "Annyeonghi kaseyo Saya Jihyo",
            "Annyeonghi kaseyo Saya Nayeon",
            "Annyeonghi kaseyo Saya Chaeyoung",
            "Annyeonghi kaseyo Saya Jeongyeon",
            "Annyeonghi kaseyo Saya Mina",
            "Annyeonghi kaseyo Saya Momo",
            "Annyeonghi kaseyo Saya Ningning",
            "Annyeonghi kaseyo Saya Sana",
            "Annyeonghi kaseyo Saya Tzuyu",
            "Annyeonghi kaseyo Saya Jisooo",
        )

        for (i in image.indices) {
            val char = Characters(image[i], title[i], description[i])
            charArrayList.add(char)
        }

    }
}
