package com.mackhartley.simpletodo.todoDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mackhartley.simpletodo.R
import com.mackhartley.simpletodo.TodoItem
import com.mackhartley.simpletodo.common.models.NewTodoItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.IO_PARALLELISM_PROPERTY_NAME
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.coroutines.CoroutineContext

class TodoDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val todoDetailsViewModel: TodoDetailsViewModel by viewModel()

        val view = inflater.inflate(R.layout.fragment_todo_details, container, false)
        view.findViewById<TextView>(R.id.todo_item_text).text = arguments?.getParcelable<TodoItem>("todoItem")?.text
        val fab = view.findViewById<FloatingActionButton>(R.id.fab_done)
        fab?.let {
            it.setOnClickListener {
                CoroutineScope(IO).launch {
//                    val x = todoDetailsViewModel.getTodos()
//                    println(x)
                    todoDetailsViewModel.makecall()
                }
            }
        }
        return view
    }
}