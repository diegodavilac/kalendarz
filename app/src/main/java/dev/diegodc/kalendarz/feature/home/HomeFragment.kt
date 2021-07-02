package dev.diegodc.kalendarz.feature.home

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.diegodc.kalendarz.R
import dev.diegodc.kalendarz.databinding.FragmentHomeBinding
import dev.diegodc.kalendarz.feature.home.viewmodel.HomeViewModel
import java.util.*

@AndroidEntryPoint
class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        initRecyclerView()
        initObs()

        binding.calendarViewHome.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)
            viewModel.getEvents(calendar.time)
        }

        return binding.root
    }

    private fun initRecyclerView() {
        binding.recyclerViewEvents.apply {
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun initObs() {
        activity?.let {
            viewModel.events.observe(it) { events ->
                Log.d("HomeFragment", "Events : ${events.size}")
            }
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarFragmentHome.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menuItem_add -> {
                    findNavController().navigate(R.id.action_fragment_home_to_fragment_add_event)
                }
                else -> {
                }
            }
            true
        }
    }

}