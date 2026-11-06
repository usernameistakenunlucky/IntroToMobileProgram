package com.example.myapplication

class AppData
{
    companion object
    {
        var users: Array<User> = arrayOf()

        // whoever is logged in right now
        var currentUser: User? = null

        fun populate()
        {
            // test users with filler items
            val testUser = User("TestUser", "A", "A")
            testUser.items.add(Item("Milk"))
            testUser.items.add(Item("Eggs"))
            testUser.items.add(Item("Bread", true))

            val ethan = User("Ethan", "ethan@example.com", "ethan123")
            ethan.items.add(Item("Bananas"))
            ethan.items.add(Item("Coffee"))

            users = arrayOf(testUser, ethan)
        }
    }
}