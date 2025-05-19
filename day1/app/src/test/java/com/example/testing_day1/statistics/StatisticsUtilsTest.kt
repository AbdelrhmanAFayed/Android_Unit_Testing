package com.example.testing_day1.statistics

import com.example.testing_day1.data.Task
import org.junit.Test
import org.junit.Assert.*


class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompleteStats_noComplete_hundredActiveZeroComplete()
    {
        //Given
        val tasks = listOf<Task>(Task(isCompleted = false))
        //When
        val result = getActiveAndCompletedStats(tasks)
        //Then
        assertEquals(0f,result.completedTasksPercent)
        assertEquals(100f,result.activeTasksPercent)

    }

}