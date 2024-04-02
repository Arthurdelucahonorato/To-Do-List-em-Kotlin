package br.edu.satc.todolistbase

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import br.edu.satc.todolistbase.roomdatabase.AppDatabase
import br.edu.satc.todolistbase.roomdatabase.ToDoItem
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    private lateinit var db:AppDatabase
    private lateinit var etTitle : EditText
    private lateinit var etDescription : EditText
    private lateinit var btSave : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        initDatabase()

        etTitle = findViewById<EditText>(R.id.editText_title)
        etDescription = findViewById<EditText>(R.id.editText_description)
        btSave = findViewById<Button>(R.id.bt_save)

        //CLICK DO BOTAO SALVAR
        btSave.setOnClickListener {
            save()
        }

    }

    private fun save() {
        val toDoItem = ToDoItem (
            null,
            etDescription.text.toString(),
            etTitle.text.toString(),
            complete = false,
        )

        db.toDoItemDao().insertAll(toDoItem)

        Toast.makeText(this,"TAREFA SALVA COM SUCESSO",Toast.LENGTH_LONG)
        finish()

    }
    private fun initDatabase() {
        // Inicializar nosso banco de dados Android Room Persistence com SQLITE
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-todolist"
        )
            .allowMainThreadQueries()
            .build()

        // Utilizar a interface DAO para interagir com o database
//        db.toDoItemDao().getAll()
//        db.toDoItemDao().getToDoItem(itemId)
//        db.toDoItemDao().insertAll(toDoItem)

    }


}