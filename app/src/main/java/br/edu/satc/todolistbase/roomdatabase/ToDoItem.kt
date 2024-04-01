package br.edu.satc.todolistbase.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * O código abaixo define uma entidade de dados. Cada instância dessa entidade representa uma
 * linha em uma tabela "entidade" no banco de dados do app.
 */
@Entity(tableName = "todoitens")
data class ToDoItem(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "description") val description: String?

    //AQUI ACRESCENTAR MAIS COLUNAS
) {}