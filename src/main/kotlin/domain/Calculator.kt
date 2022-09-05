package domain

class Calculator {
    fun add(n1: Int, n2: Int):Int{
        return n1 + n2
    }

    fun substract(n1: Int, n2: Int):Int{
        return n1 - n2
    }

    fun divide(n1: Int, n2: Int):Int{
        if(n2 == 0)
            throw ArithmeticException("No se puede dividir entre 0")
        return n1/n2
    }
}