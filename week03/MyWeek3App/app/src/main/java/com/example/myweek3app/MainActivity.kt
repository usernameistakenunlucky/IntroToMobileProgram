package com.example.myweek3app

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.UUID
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }

    fun test ()
    {
        val am = User ("Amir", "e@gmail.com")
        val an = User (null, "e@gmail.com")

        Log.d("Tag", "Name is: ${am.name}")
    }
}

// struct -> first begin with a data class
class User()
{
    var name: String? = null
    lateinit var email: String
    lateinit var id: UUID

    init {
        // your base constrictor initialization
    }

    init {
        // for modularization
    }

    constructor (name: String?,
                email: String,
                id: UUID = UUID.randomUUID()) : this()
    {
        this.name = name
        this.email = email
        this.id = id
    }

    constructor(name: String) : this()
    {

    }

    constructor(myMap: HashMap<String, Any>) : this()
    {
        name = myMap["name"] as String?
        email = myMap["email"] as String
        if (myMap["email"] != null)
        {
            email = myMap["email"] as String
        }
    }

}









        /*
        val myInt: int = 34 // Explicitly int
        val myInt2 = 32 // this is implicit or inferred

        var myFloat = 123.4f
        val mtBool: Boolean = true

        val myStr = "Hello"
        val firstChar = myStr[0]
        val lastChar = myStr[myStr.length - 1]

        val multiLine = """
            This is Android
            This is line 2
            """.trimIndent()

        var a: String = "ABC"
        a = "XYZ"

        val b: String = "XYZ"
        // cant change val

        var c: String? = "Hello" // nullable
        c = null
        val l: int = c.length

        val l2 = if (c != null) c.length else 0

        val myList : List<String?> = listOf("Hello", "Amir", "Vancouver, null")
        val zerothElem = myList[0]

        for (each in myList)
        {
            each?.let {theValueFromInEach ->
                Log.d("Tag", theValueFoundInEach)
           }
        }

        val numbers: Array<Int> = arrayOf(1,2,3,4)
        val mixedArray: Array<Any?> = arrayOf(1, "Hello", true, null)

        val myMap: HashMap<String, String> = hashMapOf(
            "Vancouver" to "city",
            "Teacher" to "role")

        myMap.keys
        myMap.values
        myMap.size

        if (myMap.contains()) {}

        myMpa["Mexico"] = "some value"
        myMap.remove("some key")

        // +, -, *, /, %,
        // ++, --  -> increment / decrement
        // =+, -=, *=, /=, %=   -> augmented assignment
        // =   -> assignmentgnemnt
        // ==   -> equality

        var myAge = 20
        if (myAge > 45) {}
        else if (myAge < 10) {}
        else if (myAge > 3 && myAge < 34 || myAge == 20) {}
        else {}

        when (myAge)
        {
            5 -> Log.d("TAG", "It's 5")
            in 1 .. 10 -> Log.d("TAG", "Do something else")
            is Int -> Log.d("TAG", "It's an int")
            !in -10 .. 10 -> Log.d("TAG", "It's not in this range")
            else -> Log.d("TAG", "It's something else")
        }

        for (i in 0..10)
        {

        }

        repeat(30) {}

        while (myAge > 2)
        {

        }

        do {; myAge --}
            while (myAge > 10)


        iloop@ for (i in 1..10)
        {
            iloop@ for (j in 20..30)
            {
                if (j>5)
                {
                    break@iloop
                }
            }
        }
        Log.d("Tag", "I need this line")

        val text: Int = Random.nextInt(0, 100)
        // normal vs uniform random?

//        val max = 1000000
//        val dieSides = 6
//        val rolls = IntArray(dieSides)
//
//        for (i in 1 .. max)
//        {
//            rolls[Random.nextInt(1, +1)]++
//        }
                            // 0, 1, 2, 3, 4, 5, 6
        var counters = arrayOf(-1,0,0,0,0,0,0)
        repeat (1_000_000)
        {
            when (Random.nextInt(1,7))
            {
                1 -> counters[1]++
                2 -> counters[2]++
                3 -> counters[3]++
                4 -> counters[4]++
                5 -> counters[5]++
                6 -> counters[6]++
            }
        }


        var ctrs = arrayOf(-1,0,0,0,0,0,0)
        repeat (1_000_000)
        {
            when (Random.nextInt(1,7))
            {
                ctrs[Random.nextInt(1,7)]++
            }
        }

        // abstracted
        List(1_000_000) {Random.nextInt(1,7)}}.groupingBy {it}.eachCount()
        /*


    }
}


