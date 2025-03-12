package fi.oamk.todo.viewmodel
import android.util.Log
import  fi.oamk.todo.model.Todo
import  fi.oamk.todo.model.TodosApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TodoViewModel: ViewModel(){
    var todos = mutableStateListOf<Todo>()
    private set
    init{
        getTodosList()
    }

    private fun getTodosList(){
        viewModelScope.launch {
            var todosApi: TodosApi ? = null
            try{
                todosApi = TodosApi.getInstance()
                todos.clear()
                todos.addAll(todosApi.getTodos())
            }catch (e: Exception){
                Log.d("ERROR",e.message.toString())
            }
        }
    }

}