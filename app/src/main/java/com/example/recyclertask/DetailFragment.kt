package com.example.recyclertask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.recyclertask.databinding.FragmentDetaileBinding


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetaileBinding

    private var name: String? = null
    private var year: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString("name")
            year = it.getString("year")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetaileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        name?.let { name ->
            year?.let { year ->
                binding.nameTextView.text = name
                binding.yearTextView.text = year
            }
        }

        Glide.with(requireContext())
            .load("https://example.com/image.jpg")
            .into(binding.imageView)
    }
}
