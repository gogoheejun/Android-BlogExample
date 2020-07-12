package tech.thdev.app.ui.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import tech.thdev.app.R
import tech.thdev.app.databinding.FirstFragmentBinding
import tech.thdev.app.ui.second.SecondFragment

class FirstFragment : Fragment() {

    private var _binding: FirstFragmentBinding? = null
    private val binding: FirstFragmentBinding get() = _binding!!

    private val viewModel: FirstViewModel by viewModels<FirstViewModel>()

    private val pagerAdapter: SampleViewPager by lazy {
        SampleViewPager(fragmentManager = parentFragmentManager, lifecycle = lifecycle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FirstFragmentBinding.inflate(inflater).also {
            _binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.updateViewItem.observe(viewLifecycleOwner, Observer {
            binding.tvMessage.text = "Add update $it"
        })

        viewModel.load()

        pagerAdapter.addItem(FirstSharedFragment())
        pagerAdapter.addItem(FirstSharedFragment())
        pagerAdapter.addItem(FirstSharedFragment())

        binding.viewPager.adapter = pagerAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
