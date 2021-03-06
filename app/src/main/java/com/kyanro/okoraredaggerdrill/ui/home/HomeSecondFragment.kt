package com.kyanro.okoraredaggerdrill.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        val fortuneText = appComponent.getFortuneTextCreator().fortuneText()

        binding.textviewHomeSecond.text = fortuneText
        binding.buttonHomeSecond.setOnClickListener {
            findNavController().navigate(R.id.action_HomeSecondFragment_to_HomeFragment)
        }
    }
}
