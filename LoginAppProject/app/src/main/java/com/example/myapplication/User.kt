package com.example.myapplication

import java.util.UUID

class User()
{
    var name: String? = null
    lateinit var email: String
    lateinit var password: String
    lateinit var id: UUID

    constructor (name: String,
                 email: String,
                 password: String,
                 id: UUID = UUID.randomUUID()) : this()
    {
        this.name = name
        this.email = email
        this.password = password
        this.id = id
    }
}