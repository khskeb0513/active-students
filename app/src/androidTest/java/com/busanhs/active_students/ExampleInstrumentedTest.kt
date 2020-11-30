package com.busanhs.active_students

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.busanhs.active_students.api.RetrofitService
import com.busanhs.active_students.ui.home.HomeViewModel

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import kotlin.reflect.typeOf

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.busanhs.active_students", appContext.packageName)
    }
}