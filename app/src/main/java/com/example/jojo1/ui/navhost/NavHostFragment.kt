package com.example.jojo1.ui.navhost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.jojo1.R
import com.example.jojo1.databinding.FragmentNavHostBinding
import com.example.jojo1.local.room.AppDataBase
import com.example.jojo1.model.Task
import com.example.jojo1.ui.navhost.adapter.TaskAdapter
import com.example.jojo1.ui.task.TaskFragment.Companion.SET_DATA_RESULT_KEY
import com.example.jojo1.ui.task.TaskFragment.Companion.TV_ESER_NAME_DATA_KEY

@Suppress("DEPRECATION")
class NavHostFragment : Fragment() {
    private lateinit var binding: FragmentNavHostBinding
    private val adapter = TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentNavHostBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTask.adapter = adapter
        getUserData()

        binding.btnFab.setOnClickListener {
            findNavController().navigate(R.id.navigate_task)
        }

    }

    private fun getUserData() {

        val db = Room.databaseBuilder(
            requireContext(),
            AppDataBase::class.java,    "database-name"
            ).build()

        val userDao=db.userDao()


        setFragmentResultListener(SET_DATA_RESULT_KEY) { _, bundle ->
            val userData = bundle.getSerializable(TV_ESER_NAME_DATA_KEY) as Task
            adapter.addTask(userData)
        }
    }
}