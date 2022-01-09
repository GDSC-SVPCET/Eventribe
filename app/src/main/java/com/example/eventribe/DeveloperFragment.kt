package com.example.eventribe

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eventribe.databinding.FragmentDeveloperBinding
import com.example.eventribe.databinding.FragmentMainPageBinding
import com.example.mycontacts.Contacts
import com.example.mycontacts.ContactsAdapter

class DeveloperFragment : Fragment() {
    private var _binding: FragmentDeveloperBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDeveloperBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getContacts(view.context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getContacts(context:Context)
    {
        //adapater expect a list of courses which we will need to create
        val contactList= listOf(
            Contacts("Priyanshu Paliwal","priyanshupaliwal078@gmail.com"),
            Contacts("Kshitij Gavhane","gavhanekshitij8@gmail.com"),
            Contacts("Eshant Sonune","eshantsonune52@gmail.com"),
            Contacts("Parth Shrungarpawar","parthshrungarpawar@gmail.com"),
            Contacts("Shrija Bhongirwar","bongirwarshrija@gmail.com"),
            Contacts("Akshata","null")
        )

        val coursesAdapter= ContactsAdapter(contactList)
        binding.rvContacts.layoutManager = LinearLayoutManager(context)
        binding.rvContacts.adapter=coursesAdapter
    }
}