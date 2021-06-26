package com.mackhartley.simpletodo.todoList

import android.view.HapticFeedbackConstants
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mackhartley.simpletodo.R
import com.mackhartley.simpletodo.TodoItem

class TodoListAdapter(private val clickListener: (TodoItem) -> Unit) : RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>() {

    private var data: List<TodoItem> = emptyList()

    fun setData(newData: List<TodoItem>) {
        data = newData
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view) {
            clickListener(data.getOrElse(it) { TodoItem.getDefault() })
        }
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val dataForHolder = data.getOrElse(position) { TodoItem.getDefault() }
        holder.bind(dataForHolder)
    }

    inner class TodoViewHolder(itemView: View, private val clickListener: (Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val textField = itemView.findViewById<TextView>(R.id.todo_text)

        init {
            itemView.setOnClickListener { clickListener(adapterPosition) }
        }

        fun bind(todoItem: TodoItem) {
            textField.text = todoItem.text
        }
    }
}