package fi.oamk.todo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fi.oamk.todo.ui.theme.TodoTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fi.oamk.todo.model.Todo
import fi.oamk.todo.viewmodel.TodoViewModel
//import com.example.todo.viewmodel.TodoViewModel
//import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TodoScreen(modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TodoScreen(modifier: Modifier = Modifier,todoViewModel: TodoViewModel= viewModel()){
    TodoList(modifier,todoViewModel.todos)
}

@Composable
fun TodoList (modifier: Modifier, todos: List<Todo>) {
    LazyColumn (
        modifier = modifier
    ){
        items(todos) { todo ->
            Text(
                text = todo.title,
                modifier = Modifier.padding(top=4.dp,bottom=4.dp)
            )
            HorizontalDivider(color = Color.LightGray, thickness = 2.dp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//    val fakeViewModel = TodoViewModel()
//
//    TodoTheme {
//        TodoScreen(todoViewModel = fakeViewModel)
//    }
    TodoTheme {
        TodoList(
            modifier = Modifier,
            todos = listOf(
                Todo(userId = 1, id = 1, title = "Buy milk", completed = false),
                Todo(userId = 1, id = 2, title = "Walk the dog", completed = true),
                Todo(userId = 2, id = 3, title = "Read a book", completed = false)
            )
        )
    }
}
