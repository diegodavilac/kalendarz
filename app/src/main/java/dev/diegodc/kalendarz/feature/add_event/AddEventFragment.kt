package dev.diegodc.kalendarz.feature.add_event

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.diegodc.kalendarz.databinding.FragmentAddEventBinding
import dev.diegodc.kalendarz.feature.add_event.viewmodel.AddEventViewModel

@AndroidEntryPoint
class AddEventFragment : DialogFragment() {

    lateinit var binding : FragmentAddEventBinding

    private val viewModel : AddEventViewModel by viewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return this.activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            binding = FragmentAddEventBinding.inflate(inflater,null,false)
            builder.setView(binding.root)

            val alertDialog = builder.create()
            alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            alertDialog
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}