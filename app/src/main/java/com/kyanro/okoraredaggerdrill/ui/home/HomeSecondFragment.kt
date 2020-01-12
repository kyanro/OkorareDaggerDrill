package com.kyanro.okoraredaggerdrill.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kyanro.okoraredaggerdrill.MyApp
import com.kyanro.okoraredaggerdrill.R
import com.kyanro.okoraredaggerdrill.databinding.FragmentHomeSecondBinding

class HomeSecondFragment : Fragment() {

    private lateinit var binding: FragmentHomeSecondBinding
    private val args: HomeSecondFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appComponent = (requireActivity().applicationContext as MyApp).appComponent
        val viewModel = ViewModelProvider(
            this, HomeSecondViewModelFactory(appComponent.getFortuneTextCreator())
        ).get(HomeSecondViewModel::class.java)

        viewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textviewHomeSecond.text = it
        })

        binding.buttonHomeSecond.setOnClickListener {
            findNavController().navigate(R.id.action_HomeSecondFragment_to_HomeFragment)
        }
    }
}
