package com.example.project2.ui.rooms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project2.databinding.FragmentRoomsBinding
import com.example.project2.ui.people.PeopleViewModel
import com.example.project2.ui.rooms.data.RoomDetailsItemModel
import java.util.ArrayList


class RoomsFragment : Fragment() {

    private var _binding: FragmentRoomsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var adapter: RoomAdapter

    override  fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val roomsViewModel =
            ViewModelProvider(this).get(RoomsViewModel::class.java)


        _binding = FragmentRoomsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        roomsViewModel.roomDetails.observe(viewLifecycleOwner) {
            it?.let {
//                showData(it)

                binding.recyclerviewNotification.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = RoomAdapter(it)
            }
        } }

        adapter = RoomAdapter(arrayListOf())


        roomsViewModel.getDetails()

        return root
    }

    private fun showData(roomDetails: ArrayList<RoomDetailsItemModel>) {
        adapter.updateRoomList(roomDetails)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}