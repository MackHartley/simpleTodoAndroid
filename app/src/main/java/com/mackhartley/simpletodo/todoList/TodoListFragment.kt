package com.mackhartley.simpletodo.todoList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mackhartley.simpletodo.R
import com.mackhartley.simpletodo.TodoItem
import org.koin.androidx.viewmodel.ext.android.viewModel

class TodoListFragment : Fragment() {

    val todoListViewModel: TodoListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_todo_list, container, false)

        val todoAdapter = TodoListAdapter {
            val action = TodoListFragmentDirections.actionTodoListFragmentToTodoDetailsFragment(it)
            findNavController().navigate(action)
        }
        setUpRV(view, todoAdapter)
        setUpFab(view)
        setUpObserver(todoAdapter)

        setHasOptionsMenu(true)
        return view
    }

    private fun setUpObserver(todoAdapter: TodoListAdapter) {
        val todoListObserver = Observer<List<TodoItem>> {
            todoAdapter.setData(it)
        }
        todoListViewModel.todoList.observe(viewLifecycleOwner, todoListObserver)
    }

    private fun setUpFab(view: View) {
        val fab = view.findViewById<FloatingActionButton>(R.id.fab_add_todo)
        fab.setOnClickListener {
            findNavController().navigate(R.id.action_todoListFragment_to_addTodoFragment)
        }
    }

    private fun setUpRV(view: View, todoAdapter: TodoListAdapter) {
        val todoRv = view.findViewById<RecyclerView>(R.id.todo_rv)
        todoRv.layoutManager = LinearLayoutManager(context)
        todoRv.adapter = todoAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.todo_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settingsFragment -> findNavController().navigate(R.id.action_todoListFragment_to_settingsFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}