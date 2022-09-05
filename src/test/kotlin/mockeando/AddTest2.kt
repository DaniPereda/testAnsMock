package mockeando

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatcher
import org.mockito.BDDMockito.*
import org.mockito.Captor
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import org.mockito.stubbing.Answer
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith


class AddTest2 {


    @InjectMocks
    private val add: Add? = null


    @Mock
    private var validNumber: ValidNumber? = null
    @Mock
    private var print: Print? = null

    @Captor
    private var captor: ArgumentCaptor<Int>? = null



    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun addTest() {
        `when`(validNumber!!.check(3)).thenReturn(true)
        var checkNumber = validNumber!!.check(3)
        assertEquals(true, checkNumber)

        `when`(validNumber!!.check(-33)).thenReturn(false)
        checkNumber = validNumber!!.check(-33)
        assertEquals(false, checkNumber)
    }

    @Test
    fun checkZeroTest(){
        `when`(validNumber!!.checkZero(0)).thenThrow(ArithmeticException("no admite cero"))
         assertFailsWith<ArithmeticException>(
            message = "no admite cero",
            block = {
                validNumber!!.checkZero(0)
            }
        )
    }

    @Test
    fun addRealMethodTest(){
        `when`(validNumber!!.check(3)).thenCallRealMethod()
        var checkNumber = validNumber!!.check(3)
        assertEquals(true, checkNumber)
    }

    @Test
    fun doubleToIntTest(){
        assertEquals(9, ValidNumber().doubleToInt(9.999))
    }

    @Test
    fun doubleToIntTest2(){
        assertEquals(0, ValidNumber().doubleToInt("9.999"))
    }

    @Test
    fun addDoubleToIntTest(){
        val answer: Answer<Int> = Answer {7}
        `when`(add!!.addInt(7.7777)).thenAnswer(answer)
        var checkNumber = add!!.addInt(7.7777)
        assertEquals(14, checkNumber)

    }
    @Test
    fun aaaPatternTest(){
        //Arrange
        `when`(validNumber!!.check(4)).thenReturn(true)
        `when`(validNumber!!.check(5)).thenReturn(true)
        //Act
        var result = add!!.add(4,5)

        //Assert
        assertEquals(9, result)

    }
    @Test
    fun bddPatterTest(){
        //Given
        given(validNumber!!.check(4)).willReturn(true)
        given(validNumber!!.check(5)).willReturn(true)
        //When
        var result = add!!.add(4,5)

        //Then
        assertEquals(9, result)
    }

    @Test
    fun argumentMatcherTest(){
        //Given
        given(validNumber!!.check(anyInt())).willReturn(true)
        //When
        var result = add!!.add(4,5)
        //Then
        assertEquals(9, result)
    }

    @Test
    fun `testear cuando el método no devuelve nada`(){
        //Given
        given(validNumber!!.check(4)).willReturn(true)
        given(validNumber!!.check(5)).willReturn(true)
        //When
        var result = add!!.add(4,5)
        //Then
        assertEquals(9, result)
    }

    @Test
    fun addPrintTest(){
        //Given
        given(validNumber!!.check(4)).willReturn(true)
        given(validNumber!!.check(5)).willReturn(true)
        //When
        var result = add!!.addPrint(4,5)
        //Then
        Mockito.verify(validNumber)!!.check(4)
        Mockito.verify(validNumber)!!.check(5)
        Mockito.verify(validNumber, Mockito.never())!!.check(9)
        Mockito.verify(validNumber, Mockito.atLeast(1))!!.check(4)
        Mockito.verify(validNumber, Mockito.atMost(3))!!.check(4)
        Mockito.verify(validNumber, Mockito.atMostOnce())!!.check(4)

        Mockito.verify(print)!!.showMessage(9)

    }

    @Test
    fun addPrintErrorTest(){
        //Given
        given(validNumber!!.check(4.555)).willReturn(false)
        given(validNumber!!.check(5)).willReturn(true)
        //When
        var result = add!!.addPrint(4.555,5)
        //Then
        Mockito.verify(print)!!.showError()

    }

    @Test
    fun argumentCaptorTest(){
        //Given
        given(validNumber!!.check(4)).willReturn(true)
        given(validNumber!!.check(5)).willReturn(true)
        //When
        var result = add!!.addPrint(4,5)
        //Then
        Mockito.verify(print)!!.showMessage(captor!!.capture())
        assertEquals(9, captor!!.value)

    }

    @Spy
    var spyList: MutableList<String> = ArrayList()

    @Mock
    var mockList: MutableList<String> = ArrayList()

    @Test
    fun mockTest()
    {
        //Given
        given(mockList.size).willReturn(2)

        mockList.add("1")
        mockList.add("2")
        Mockito.verify(mockList).add("1")
        Mockito.verify(mockList).add("2")

        //When
        var size = mockList.size

        //Then
        assertEquals(2, size)

    }

    @Test
    fun spyTest()
    {
        spyList.add("1")
        spyList.add("2")
        Mockito.verify(spyList).add("1")
        Mockito.verify(spyList).add("2")

        assertEquals(2, spyList.size)
    }


}