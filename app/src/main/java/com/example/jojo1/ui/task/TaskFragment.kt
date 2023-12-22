package com.example.jojo1.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.jojo1.databinding.FragmentTaskBinding
import com.example.jojo1.local.pref.Pref
import com.example.jojo1.model.Task

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding
    private lateinit var preferences: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentTaskBinding.inflate(inflater, container, false)
        preferences = Pref(requireContext())
        loaUserName()
        return binding.root
    }

    private fun loaUserName() {
        val nameData = preferences.setUserName()
        binding.tvTitle.text = nameData
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSend.setOnClickListener {
            val userName = binding.etTitle.text.toString()
            val userFamily = binding.etDesc.text.toString()

            findNavController().navigateUp()
            val userData = Task(
                title = userName,
                desc = userFamily,
            )
            setFragmentResult(SET_DATA_RESULT_KEY, bundleOf(TV_ESER_NAME_DATA_KEY to userData))
        }

        binding.btnSetData.setOnClickListener {
            val userName = binding.etTitle.text.toString()
            preferences.saveUserName(userName)
        }
    }

    companion object {
        const val SET_DATA_RESULT_KEY = "set.data.result.ky"
        const val TV_ESER_NAME_DATA_KEY = "tv.user.name.data.key"
    }
}