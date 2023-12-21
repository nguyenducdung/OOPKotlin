package com.example.project2.ui.people
import android.widget.AdapterView.OnItemClickListener

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project2.databinding.FragmentPeopleBinding

// Define a class named "PeopleFragment" that extends Fragment.
class PeopleFragment : Fragment() {

    // Private property to hold the binding for the fragment.
    private var _binding: FragmentPeopleBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    // Access the binding property safely using the binding getter.
    private val binding get() = _binding!!

    // Declare a property to hold the PeopleAdapter instance.
    private lateinit var adapter: PeopleAdapter

    // Override the onCreateView method to create and return the fragment's view.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Create a ViewModel instance for handling people-related data.
        val peopleViewModel = ViewModelProvider(this).get(PeopleViewModel::class.java)

        // Inflate the layout for the fragment using the binding.
        _binding = FragmentPeopleBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Observe changes in personDetails LiveData and update the UI accordingly.
        peopleViewModel.personDetails.observe(viewLifecycleOwner) {
            it?.let {
                // Set up the RecyclerView with a LinearLayoutManager and the PeopleAdapter.
                binding.recyclerviewNotification.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = PeopleAdapter(it)
                }
            }
        }

        // Initialize the adapter with an empty list and fetch person details.
        adapter = PeopleAdapter(arrayListOf())
        peopleViewModel.getPersonDetails()

        // Return the root view of the fragment.
        return root
    }

    // Override the onDestroyView method to release the binding when the view is destroyed.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

