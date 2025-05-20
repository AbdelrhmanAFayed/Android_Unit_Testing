package com.example.testing_day1.data.source

import androidx.lifecycle.LiveData
import com.example.testing_day1.data.Result
import com.example.testing_day1.data.Task

class FakeTasksDataSource(var tasksList : MutableList<Task> = mutableListOf()) : TasksDataSource {

    override fun observeTasks(): LiveData<Result<List<Task>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTasks(): Result<List<Task>> {
        return Result.Success(tasksList.toList())
    }

    override suspend fun refreshTasks() {
        TODO("Not yet implemented")
    }

    override fun observeTask(taskId: String): LiveData<Result<Task>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTask(taskId: String): Result<Task> {
        val task = tasksList.find { it.id == taskId }

        return if (task != null) {
            Result.Success(task)
        } else {
            Result.Error(Exception("Task with ID $taskId not found"))
        }
    }

    override suspend fun refreshTask(taskId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun saveTask(task: Task) {
        tasksList.add(task)
    }

    override suspend fun completeTask(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun completeTask(taskId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun activateTask(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun activateTask(taskId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun clearCompletedTasks() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllTasks() {
tasksList.clear()
    }

    override suspend fun deleteTask(taskId: String) {
        }
}