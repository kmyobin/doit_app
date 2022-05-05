package org.techtown.ch18_network

import android.content.Context
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.techtown.ch18_network.databinding.FragmentRetrofitBinding
import org.techtown.ch18_network.model.PageListModel
import org.techtown.ch18_network.recycler.MyAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// retrofit을 이용해 서버와 연동하고 서버에서 받은 데이터를 어댑터를 활용해 리사이클러 뷰에 출력하는 코드
class RetrofitFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRetrofitBinding.inflate(inflater, container, false)

        val call: Call<PageListModel> =MyApplication.networkService.getList(
            MyApplication.QUERY,
            MyApplication.API_KEY,
            1,
            10
        )
        call?.enqueue(object: Callback<PageListModel>{
            override fun onResponse(call: Call<PageListModel>, response: Response<PageListModel>) {
                if(response.isSuccessful()){
                    binding.retrofitRecyclerView.layoutManager=
                        LinearLayoutManager(activity)
                    binding.retrofitRecyclerView.adapter=
                        MyAdapter(activity as Context, response.body()?.articles)
                }
            }

            override fun onFailure(call: Call<PageListModel>, t: Throwable) {
            }
        })
        return binding.root
    }
}