package com.example.kotlinmovies

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.BuildConfig
import com.bumptech.glide.Glide
import com.example.kotlinmovies.api.Movies
import com.example.kotlinmovies.api.RetrofitBuilder.movieApi
import com.example.kotlinmovies.databinding.FragmentResponceBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentResponce : Fragment() {

    lateinit var bindingFragmentResponce: FragmentResponceBinding

    //val apiKey = BuildConfig.API_KEY

    lateinit var apiKey: String
    lateinit var baseUrl: String
    private var kinopoiskId: String? = null
    //lateinit var kinopoiskId: String

    companion object {
        private const val KINOPOISK_ID = "kinopoiskId"
        fun newInstance(kinopoiskId: String) =
            FragmentResponce().apply {
                arguments = Bundle().apply {
                    putString(KINOPOISK_ID, kinopoiskId)
                    Log.d(TAG, "fragmentResponce получение kinopoiskId " + kinopoiskId)
                }
            }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingFragmentResponce = FragmentResponceBinding.inflate(inflater, container, false)
        return bindingFragmentResponce.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        apiKey = "e728b8f7-f3b5-417f-bddf-b8ff2ff2e6c6"
        baseUrl = "https://kinopoiskapiunofficial.tech"

        arguments?.let {
            kinopoiskId = it.getString(KINOPOISK_ID)
        }

        // request() в самом реквесте херачу поля
        request()
    }

    fun request() {
        val call: Call<Movies> =
            movieApi.loadMovie(kinopoiskId.toString(), apiKey)

        Log.d(TAG, "request() loadMovie kinopoiskId " + kinopoiskId)

        call.enqueue(object : Callback<Movies> {

            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<Movies>?,
                response: Response<Movies>?
            ) {
                Log.d(TAG, "request()")
                val info: Movies? = response?.body()
                Log.d(TAG, "val info " + info)
                if (info != null) {
                    Log.d(TAG, "сюда не зайдет")
                    bindingFragmentResponce.tvKinopoiskId.text = ("kinopoiskId: ${info.kinopoiskId}").toString()
                    bindingFragmentResponce.tvNameRu.text = ("NameRu: ${info.nameRu}").toString()
                    bindingFragmentResponce.tvNameEn.text = ("NameEn: ${info.nameEn}").toString()

//                    view?.let {
//                        Glide
//                            .with(it.context)
//                            .load(info.posterUrl)
//                            .into(it.)
//                    }

                    bindingFragmentResponce.tvRatingImdb.text = ("RatingImdb: ${info.ratingImdb}").toString()
                    bindingFragmentResponce.tvShortDescription.text = ("ShortDescription: ${info.shortDescription}").toString()

                    Log.d(TAG, "вывод информации" + info.kinopoiskId + info.nameEn + info.nameRu)
                }
            }

            override fun onFailure(call: Call<Movies>?, t: Throwable?) {

            }

        })
    }
}