package com.mackhartley.simpletodo.addTodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.mackhartley.simpletodo.R
import com.mackhartley.simpletodo.common.ext.showError
import com.mackhartley.simpletodo.common.ext.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddTodoFragment : Fragment() {

    private val addTodoViewModel: AddTodoViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_todo, container, false)

        val addTodoBtn = view.findViewById<Button>(R.id.add_todo_btn)
        val addTodoTextField = view.findViewById<EditText>(R.id.add_todo_text_field)

        addTodoBtn.setOnClickListener {
            val text = addTodoTextField.text.toString()
            onAddButtonClicked(addTodoBtn, text)
        }

        return view
    }

    private fun onAddButtonClicked(button: Button, newTodoText: String) {
        button.isEnabled = false
        val addTodoObserver = Observer<Boolean> { isSuccess ->
            if (isSuccess) {
                findNavController().navigate(R.id.action_addTodoFragment_to_todoListFragment)
                showToast(getString(R.string.todo_item_added))
            } else {
                button.isEnabled = true
                showError()
            }
        }

        addTodoViewModel.addTodo(newTodoText).observe(viewLifecycleOwner, addTodoObserver)
    }
}