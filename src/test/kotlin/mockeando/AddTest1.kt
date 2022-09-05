package mockeando

import mockeando.Add
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito


class AddTest1 {
    private var add: Add? = null
    private var print: Print? = null
    private var validNumber : ValidNumber? = null



    @BeforeEach
    fun setUp()
    {
        validNumber = Mockito.mock(ValidNumber::class.java)
        print = Mockito.mock(Print::class.java)
        add = Add(validNumber!!, print!!)
    }

    @AfterEach
    fun tearDown()
    {
        validNumber = null
        add = null
    }

    @Test
    fun addTest()
    {
        add?.add(3,2)
        Mockito.verify(validNumber)?.check(3)
        //Mockito.verify(validNumber)?.check(2)
    }




}