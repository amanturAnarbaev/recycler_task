import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclertask.CarAdapter
import com.example.recyclertask.ItemCar
import com.example.recyclertask.R

class ManFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: CarAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_man, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        itemAdapter = CarAdapter(getItems()) { item ->
            val bundle = Bundle().apply {
                putString("name", item.name)
                putString("year", item.year)
            }
            findNavController().navigate(R.id.action_manFragment_to_detailFragment, bundle)
        }
        recyclerView.adapter = itemAdapter
        return view
    }

    private fun getItems(): List<ItemCar> {
        return listOf(
            ItemCar("https://example.com/image1.jpg", "Name 1", "2021"),
            ItemCar("https://example.com/image2.jpg", "Name 2", "2022"),
            ItemCar("https://example.com/image3.jpg", "Name 3", "2023")
        )
    }
}
