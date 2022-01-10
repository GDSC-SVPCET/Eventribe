package com.example.eventribe

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eventribe.databinding.FragmentMainPageBinding
import com.gdsc.eventribe.homeadapter.FeaturedAdapter
import com.gdsc.eventribe.homeadapter.FeaturedhelperClass
import com.gdsc.eventribe.mvadapter.mvhelperclass
import com.gdsc.eventribe.mvadapteradapter.mvadapter
import com.google.android.material.navigation.NavigationView
import java.util.ArrayList

class mainPageFragment : Fragment(){

    private var _binding: FragmentMainPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainPageBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mostViewedRecycler(view.context)
        featuredRecycler(view.context)
        binding.viewAllNews.setOnClickListener {
            view.findNavController().navigate(mainPageFragmentDirections.actionMainPageFragmentToNewsFragment())
        }
        binding.threeLinesImage.setOnClickListener {
            view.findNavController().navigate(mainPageFragmentDirections.actionMainPageFragmentToDeveloperFragment())
        }
        binding.row1col1.setOnClickListener { view.findNavController().navigate(mainPageFragmentDirections.actionMainPageFragmentToClubNameFragment()) }
        binding.row1col2.setOnClickListener { view.findNavController().navigate(mainPageFragmentDirections.actionMainPageFragmentToClubNameFragment()) }
        binding.row1col3.setOnClickListener { view.findNavController().navigate(mainPageFragmentDirections.actionMainPageFragmentToClubNameFragment()) }
        binding.row1col4.setOnClickListener { view.findNavController().navigate(mainPageFragmentDirections.actionMainPageFragmentToClubNameFragment()) }
        binding.row2col1.setOnClickListener { view.findNavController().navigate(mainPageFragmentDirections.actionMainPageFragmentToClubNameFragment()) }
        binding.row2col2.setOnClickListener { view.findNavController().navigate(mainPageFragmentDirections.actionMainPageFragmentToClubNameFragment()) }
        binding.row2col3.setOnClickListener { view.findNavController().navigate(mainPageFragmentDirections.actionMainPageFragmentToClubNameFragment()) }
        binding.row2col4.setOnClickListener { view.findNavController().navigate(mainPageFragmentDirections.actionMainPageFragmentToClubNameFragment()) }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun mostViewedRecycler(context: Context) {
        binding.upcommingEvent.setHasFixedSize(true)
        binding.upcommingEvent.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val mostViewedLocations: ArrayList<mvhelperclass> =
            ArrayList<mvhelperclass>()
        mostViewedLocations.add(mvhelperclass(R.drawable.club_logo,"McDonald's"))
        mostViewedLocations.add(mvhelperclass(R.drawable.peng_logo, "Edenrobe"))
        mostViewedLocations.add(mvhelperclass(R.drawable.copyrightsymbol, "J."))
        mostViewedLocations.add(mvhelperclass(R.drawable.peng_logo, "Walmart"))
        val adapter = mvadapter(mostViewedLocations)
        binding.upcommingEvent.adapter = adapter
    }

    private fun featuredRecycler(context: Context) {
        binding.featuredRecycler.setHasFixedSize(true)
        binding.featuredRecycler.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        val featuredLocations: ArrayList<FeaturedhelperClass> = ArrayList<FeaturedhelperClass>()
        featuredLocations.add(
            FeaturedhelperClass(
                R.drawable.club_logo,
                "GDSC",
                "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"
            )
        )
        featuredLocations.add(
            FeaturedhelperClass(
                R.drawable.peng_logo,
                "R-Labs",
                "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"
            )
        )
        featuredLocations.add(
            FeaturedhelperClass(
                R.drawable.club_logo,
                "E-Yantra",
                "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"
            )
        )
        val adapter = FeaturedAdapter(featuredLocations)
        binding.featuredRecycler.adapter = adapter
    }
}