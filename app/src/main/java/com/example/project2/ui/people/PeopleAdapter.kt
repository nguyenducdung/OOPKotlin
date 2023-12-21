package com.example.project2.ui.people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project2.R
import com.example.project2.databinding.ItemPeopleBinding
import com.example.project2.ui.people.data.PeopleInfoItemModel

// Declare a class named PeopleAdapter that extends RecyclerView.Adapter
// The adapter is responsible for managing the data and creating views for the RecyclerView.
class PeopleAdapter(
    private val pplData: ArrayList<PeopleInfoItemModel>,
) : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {


    // Inner class representing a view holder for each item in the RecyclerView.
    inner class PeopleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Bind the XML layout for each item in the RecyclerView.
        val binding = ItemPeopleBinding.bind(view)

        // Set up the UI for a specific item using the provided peopleData and position.
        fun setUpUI(peopleData: PeopleInfoItemModel, position: Int) {
            // Set the first name and last name to the corresponding TextView.
            binding.firstName.text = "${peopleData.firstName} ${peopleData.lastName}"
            // Set the job title and email to the corresponding TextView.
            binding.email.text = "${peopleData.jobtitle}\n${peopleData.email}"

            // Get the avatar URL from the data.
            val avatarUrl = peopleData.avatar

            // Load the avatar image using Glide and set it to the ImageView.
            Glide.with(itemView.context)
                .load(avatarUrl)
                .placeholder(R.drawable.person_icon)
                .into(binding.personImage)
        }
    }

    // Override the onCreateViewHolder method to create a new PeopleViewHolder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PeopleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_people, parent, false)
        )

    // Override the onBindViewHolder method to bind data to a specific PeopleViewHolder.
    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        // Get the current person's data at the given position.
        val currentPerson = pplData[position]

        // Set up the UI for the current person using the holder's setUpUI method.
        holder.setUpUI(currentPerson, position)

        // Set a click listener for the item view.
        // Set a click listener for the item view
        holder.itemView.setOnClickListener {

        }
    }
    // Override the getItemCount method to return the total number of items in pplData.
    override fun getItemCount() = pplData.size

    fun updatePeopleList(peopleDetails: java.util.ArrayList<PeopleInfoItemModel>){
        pplData.addAll(peopleDetails)
        notifyDataSetChanged()
    }
}
