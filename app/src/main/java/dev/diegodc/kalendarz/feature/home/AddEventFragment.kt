package dev.diegodc.kalendarz.feature.home

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import dev.diegodc.kalendarz.R
import dev.diegodc.kalendarz.databinding.FragmentAddEventBinding

class AddEventFragment : DialogFragment() {

    lateinit var binding : FragmentAddEventBinding

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