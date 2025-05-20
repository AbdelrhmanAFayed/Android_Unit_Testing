package com.example.testing_day1.tasks

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.testing_day1.data.source.DefaultTasksRepository
import getOrAwaitValue
import io.mockk.mockk
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {

    lateinit var tasksViewModel : TasksViewModel
    private lateinit var repository: DefaultTasksRepository


    @Before
    fun setup(){
        repository =mockk(relaxed = true)
        tasksViewModel = TasksViewModel(repository)
    }

    @Test
    fun addNewTask_newTaskEventIsNotNull()
    {
        //Given
        //When
        tasksViewModel.addNewTask()
        //Then
        val result = tasksViewModel.newTaskEvent.getOrAwaitValue{}

        assertThat(result,(not(nullValue())))
    }

    @Test
    fun setFilter_AllTask()
    {
        //Given
        //When
        tasksViewModel.setFiltering(TasksFilterType.ALL_TASKS)
        //Then
        val result = tasksViewModel.currentFilteringLabel.getOrAwaitValue{}

        assertThat(result,(not(nullValue())))
    }

}