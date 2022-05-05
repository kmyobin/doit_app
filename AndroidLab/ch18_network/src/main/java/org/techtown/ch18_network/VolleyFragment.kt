package org.techtown.ch18_network

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.techtown.ch18_network.databinding.FragmentVolleyBinding
import org.techtown.ch18_network.model.ItemModel
import org.techtown.ch18_network.recycler.MyAdapter
import org.json.JSONObject


class VolleyFragment : Fragment() {

// volley를 이용해 서버와 연동하고 서버에서 받은 데이터를 어댑터를 활용해 리사이클러 뷰에 출력함

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentVolleyBinding.inflate(inflater, container, false)

        val url=
            MyApplication.BASE_URL+"/v2/everything?q="+
                    "${MyApplication.QUERY}&apiKey="+
                    "${MyApplication.API_KEY}&page=1&pageSize=5"
        val queue=Volley.newRequestQueue(activity)
        val jsonRequest=
            object : JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                Response.Listener<JSONObject> { response ->
                    val jsonArray=response.getJSONArray("articles")
                    val mutableList= mutableListOf<ItemModel>()
                    for(i in 0 until jsonArray.length()){
                        ItemModel().run {
                            val article = jsonArray.getJSONObject(i)
                            author=article.getString("author")
                            title=article.getString("title")
                            description=article.getString("description")
                            urlToImage=article.getString("urlToImage")
                            publishedAt=article.getString("publishedAt")
                            mutableList.add(this)
                        }
                    }
                    binding.volleyRecyclerView.layoutManager=
                        LinearLayoutManager(activity)
                    binding.volleyRecyclerView.adapter=
                        MyAdapter(activity as Context, mutableList)
                },
                Response.ErrorListener { error->
                    println("error........$error")}){
                override fun getHeaders(): MutableMap<String, String> {
                    val map= mutableMapOf<String, String>(
                        "User-agent" to MyApplication.USER_AGENT
                    )
                    return map
                }
            }
        queue.add(jsonRequest)
        return binding.root
    }
}