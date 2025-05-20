package com.example.testing_day1.data.source

import com.example.testing_day1.data.Result
import com.example.testing_day1.data.Task
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test


class DefaultTasksRepositoryTest {

    lateinit var  remoteDataSource: FakeTasksDataSource
    lateinit var localDataSource: FakeTasksDataSource
    lateinit var repo :DefaultTasksRepository


    @Before
    fun init()
    {
        remoteDataSource = FakeTasksDataSource(mutableListOf(Task(id = "1", title = "Remote Task"),Task(id = "2"),Task(id = "3")))
        localDataSource = FakeTasksDataSource(mutableListOf(Task(id = "5"),Task(id = "6"),Task(id = "7")))
        repo = DefaultTasksRepository(remoteDataSource,localDataSource)
    }

    @Test
    fun getTask_ForceUpdateRemoteDataSource() {
        runBlocking {
            val result = repo.getTask("1",forceUpdate = true)
            assertTrue(result is Result.Success)
            val tasks = (result as Result.Success).data
            assertEquals("Remote Task", tasks.title)
            assertTrue(localDataSource.tasksList.isEmpty().not())
        }
    }
}