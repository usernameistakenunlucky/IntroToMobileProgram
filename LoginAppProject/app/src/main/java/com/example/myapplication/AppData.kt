package com.example.myapplication

class AppData
{
    companion object
    {
        var users: Array<User> = arrayOf()

        fun populate()
        {
            users = arrayOf(
                User("TestUser", "A", "A"),
                User("Ethan", "ethan@example.com", "ethan123")
            )
        }
    }
}