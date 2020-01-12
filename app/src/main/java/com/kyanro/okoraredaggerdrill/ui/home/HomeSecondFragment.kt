package com.kyanro.okoraredaggerdrill.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kyanro.okoraredaggerdrill.MyApp
import com.kyanro.okoraredaggerdrill.R
import com.kyanro.okoraredaggerdrill.databinding.FragmentHomeSecondBinding
import com.kyanro.okoraredaggerdrill.ui.home.dagger.HomeSecondViewModelModule

class HomeSecondFragment : Fragment() {

    private lateinit var binding: FragmentHomeSecondBinding
    private lateinit var viewModel: HomeSecondViewModel

    private val args: HomeSecondFragmentArgs by navArgs()
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val appComponent = (requireActivity().applicationContext as MyApp).appComponent
        val homeSecondSubComponent = appComponent.getHomeSecondSubComponentFactory()
            .create(HomeSecondViewModelModule(this, args))
        viewModel = homeSecondSubComponent.getHomeSecondViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textviewHomeSecond.text = it
        })

        binding.buttonHomeSecond.setOnClickListener {
            findNavController().navigate(R.id.action_HomeSecondFragment_to_HomeFragment)
        }
    }
}
