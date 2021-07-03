package com.mackhartley.simpletodo.todoList

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mackhartley.simpletodo.R
import com.mackhartley.simpletodo.TodoItem
import com.mackhartley.simpletodo.common.ext.showError
import com.mackhartley.simpletodo.common.ext.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class TodoListFragment : Fragment() {

    private val todoListViewModel: TodoListViewModel by viewModel()
    private val todoAdapter = TodoListAdapter {
        val action = TodoListFragmentDirections.actionTodoListFragmentToTodoDetailsFragment(it)
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_todo_list, container, false)
        val emptyView = view.findViewById<TextView>(R.id.empty_todo_list_label)

        setUpRV(view, todoAdapter)
        setUpFab(view)
        setUpObserver(emptyView)

        setHasOptionsMenu(true)
        return view
    }

    private fun setUpObserver(emptyView: TextView) {
        val todoListObserver = Observer<List<TodoItem>?> {
            if (it != null) {
                if (it.isNotEmpty()) {
                    emptyView.visibility = View.GONE
                } else {
                    emptyView.visibility = View.VISIBLE
                }
                todoAdapter.setData(it)
            } else {
                showError()
            }
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
            R.id.refreshData -> {
                todoAdapter.setData(emptyList())
                showToast(getString(R.string.refreshing))
                todoListViewModel.refreshData()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}