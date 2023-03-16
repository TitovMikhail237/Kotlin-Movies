package com.example.kotlinmovies

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinmovies.databinding.FragmentRequestBinding

class FragmentRequest : Fragment(), OnItemClickListener {

    lateinit var bindingFragmentRequest: FragmentRequestBinding
    lateinit var listenerNavigation: Navigation

    fun newInstance(): FragmentRequest {
        Log.d(TAG, "newInstance fragmentRequest")
        return FragmentRequest()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Navigation) {
            listenerNavigation = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingFragmentRequest = FragmentRequestBinding.inflate(inflater, container, false)
        return bindingFragmentRequest.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {

        }

        bindingFragmentRequest.buttonRequest.setOnClickListener {

            onItemClick(bindingFragmentRequest.etRequest.text.toString())

            Log.d(TAG, "fragmentRequest onViewCreated нажатие кнопки при вводе kinopoiskId "+bindingFragmentRequest.etRequest.text.toString())
        }
    }

    override fun onItemClick(idOfKinopoisk: String) {
        listenerNavigation.openFragmentResponce(idOfKinopoisk)
    }

}

interface OnItemClickListener{
    fun onItemClick(idOfKinopoisk: String)
}