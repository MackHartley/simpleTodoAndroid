package com.mackhartley.simpletodo.todoList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider
import com.mackhartley.simpletodo.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class TodoListFragment : Fragment() {

    val todoViewModel: TodoViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_todo_list, container, false)

        val todoRv = view.findViewById<RecyclerView>(R.id.todo_rv)
        todoRv.layoutManager = LinearLayoutManager(context)
        val todoAdapter = TodoListAdapter {
            val action = TodoListFragmentDirections.viewDetails(it)
            findNavController().navigate(action)
        }
        todoRv.adapter = todoAdapter

        val logOutBtn = view.findViewById<Button>(R.id.log_out_btn)
        logOutBtn.setOnClickListener {
            logout()
        }

        val fakeData = todoViewModel.getTodos()
        todoAdapter.setData(fakeData)

        return view
    }

    private fun logout() {
        WebAuthProvider.logout(todoViewModel.getAuthAccount())
            .withScheme(getString(R.string.auth_scheme))
            .start(requireContext(), object: Callback<Void?, AuthenticationException> {
                override fun onSuccess(payload: Void?) {
                    findNavController().navigate(R.id.logout)
                }

                override fun onFailure(error: AuthenticationException) {
                    // Something went wrong!
                }
            })
    }
}