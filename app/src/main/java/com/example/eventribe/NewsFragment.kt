package com.example.eventribe

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.AuthFailureError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.eventribe.databinding.FragmentNewsBinding
import com.example.eventribe.model.News

class NewsFragment : Fragment() {

    private var _binding:FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getNewsData(view.context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getNewsData(context:Context){
        binding.progressCircular.visibility = View.VISIBLE
        binding.errorPage.visibility = View.GONE
        val newsList:MutableList<News> = mutableListOf()
        val url = "https://tech-news3.p.rapidapi.com/techcrunch"
        val queue = Volley.newRequestQueue(context)
        val jsonObjectRequest = object : JsonArrayRequest(
            Method.GET, url, null,
            { response ->
                Log.d("success","got it")
                for (i in 0 until response.length()) {
                    val news = response.getJSONObject(i)
                    newsList.add(News(url = news["link"].toString(), urlImage = news["img"].toString(), title = news["title"].toString()))
                }
                binding.progressCircular.visibility = View.GONE
                binding.newsRecyclerView.layoutManager = LinearLayoutManager(context)
                binding.newsRecyclerView.adapter = NewsAdapter(context = context, newsList = newsList)

            },
            { error ->
                Log.d("error", error.toString())
                binding.progressCircular.visibility = View.GONE
                binding.errorPage.visibility = View.VISIBLE
            }) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers["x-rapidapi-host"] = "tech-news3.p.rapidapi.com"
                headers["x-rapidapi-key"] = "59f45eae03mshfa6935742b980a4p1ded79jsna1d91946c0e7"
                return headers
            }
        }
        queue.add(jsonObjectRequest)
    }

}