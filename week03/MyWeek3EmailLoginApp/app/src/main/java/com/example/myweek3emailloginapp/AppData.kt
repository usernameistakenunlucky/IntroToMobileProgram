package com.example.myweek3emailloginapp

class AppData
{
    companion object
    {
        var users: Array<User> = arrayOf()

        fun populate()
        {
            User("Alice", "alice@example.com"),
            User("Bob", "bob@example.com"),
            User("Charlie", "charlie@example.com"),
            User("Diana", "diana@example.com"),
            User("Ethan", "ethan@example.com")
        }
    }
}