package sis104.tareas.sis104kotlin

class Operaciones(a: Float, b:Float) {
    var a: Float = 0.0f
        private set

    var b: Float = 0.0f
        private set

    init {
        this.a=a
        this.b=b
    }

    fun suma():Float{
        return this.a + this.b
    }

    fun resta():Float{
        return this.a - this.b
    }

    fun producto():Float{
        return this.a * this.b
    }

    fun division():Float{
        return this.a / this.b
    }
}