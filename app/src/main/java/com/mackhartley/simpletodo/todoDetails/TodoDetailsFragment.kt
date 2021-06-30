package com.mackhartley.simpletodo.todoDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mackhartley.simpletodo.R
import com.mackhartley.simpletodo.TodoItem
import com.mackhartley.simpletodo.common.ext.showError
import org.koin.androidx.viewmodel.ext.android.viewModel

class TodoDetailsFragment : Fragment() {
    private val todoDetailsViewModel: TodoDetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val todoData = arguments?.getParcelable<TodoItem>("todoItem")

        val view = inflater.inflate(R.layout.fragment_todo_details, container, false)

        if (todoData != null) {
            val fab = view.findViewById<FloatingActionButton>(R.id.fab_done)
            val todoView = view.findViewById<TextView>(R.id.todo_item_text)
            todoView?.text = todoData.text
            fab?.setOnClickListener { deleteTodo(todoData) }
        }

        return view
    }

    private fun deleteTodo(todoData: TodoItem) {
        showCompletionConfirmation {
            val observer = Observer<Boolean> { isSuccess ->
                if (isSuccess) findNavController().navigate(R.id.action_todoDetailsFragment_to_todoListFragment)
                else showError()
            }
            todoDetailsViewModel.deleteTodo(todoData.id).observe(viewLifecycleOwner, observer)
        }
    }

    private fun showCompletionConfirmation(confirmationCallback: () -> Unit) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.complete_task))
            .setMessage(getString(R.string.complete_task_desc))
            .setPositiveButton(getString(R.string.ok)) { _, _ -> confirmationCallback() }
            .setNegativeButton(getString(R.string.cancel)) { _, _ -> }
            .show()
    }
}