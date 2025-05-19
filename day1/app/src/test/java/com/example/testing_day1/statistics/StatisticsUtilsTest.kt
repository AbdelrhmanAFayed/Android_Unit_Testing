package com.example.testing_day1.statistics

import com.example.testing_day1.data.Task
import org.junit.Assert.assertEquals
import org.junit.Test


class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompleteStats_zeroComplete_returnAllActiveZeroComplete()
    {
        //Given
        val tasks = listOf<Task>(Task(isCompleted = false))
        //When
        val result = getActiveAndCompletedStats(tasks)
        //Then
        assertEquals(0f,result.completedTasksPercent)
        assertEquals(100f,result.activeTasksPercent)

    }

    @Test
    fun getActiveAndCompleteStats_twoComplete_returnSixtyActiveFortyComplete()
    {
        //Given
        val tasks = listOf<Task>(Task(isCompleted = true),Task(isCompleted = true),Task(isCompleted = false),Task(isCompleted = false),Task(isCompleted = false))
        //When
        val result = getActiveAndCompletedStats(tasks)
        //Then
        assertEquals(40f,result.completedTasksPercent)
        assertEquals(60f,result.activeTasksPercent)

    }
    @Test
    fun getActiveAndCompleteStats_emptyList_returnZeroActiveZeroComplete()
    {
        //Given
        val tasks = emptyList<Task>()
        //When
        val result = getActiveAndCompletedStats(tasks)
        //Then
        assertEquals(0f,result.completedTasksPercent)
        assertEquals(0f,result.activeTasksPercent)
    }
    @Test
    fun getActiveAndCompleteStats_nullList__returnZeroActiveZeroComplete()
    {
        //Given
        val tasks = null
        //When
        val result = getActiveAndCompletedStats(tasks)
        //Then
        assertEquals(0f,result.completedTasksPercent)
        assertEquals(0f,result.activeTasksPercent)
    }

}