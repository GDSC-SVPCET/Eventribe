package com.example.eventribe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eventribe.databinding.FragmentClubNameBinding

class ClubNameFragment : Fragment() {

    private var _binding:FragmentClubNameBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClubNameBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.clubImage.setImageResource(R.drawable.gdscsvpcet)
        binding.clubEventRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.clubEventRecyclerView.adapter = ClubEventAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}