package com.example.atlandroidexamples.practices.practice10.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.atlandroidexamples.db.dao.PersonDAO
import com.example.atlandroidexamples.db.entities.PersonEntity

class NoteViewModel(private val personDAO: PersonDAO?): ViewModel() {

    var allUsers: LiveData<List<PersonEntity>>? = null

    init {
        allUsers = personDAO?.getAllPersons()
    }

    fun insert() {
        val p = PersonEntity(
            firstName = "Ilgar",
            lastName = "Habibov",
            address = "Baku",
            age = 31
        )

        personDAO?.addPerson(p)

    }

    fun getUsers(){
        val persons = personDAO?.getAllPersons()
//        persons?.let {
//            allUsers.postValue(it)
//        }

    }

}

class NoteViewModelFactory(val personDAO: PersonDAO?): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(personDAO) as T
    }
}