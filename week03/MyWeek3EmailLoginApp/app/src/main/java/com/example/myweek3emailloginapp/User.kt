package com.example.myweek3emailloginapp

import java.util.UUID

class User()
{
    var name: String? = null
    lateinit var email: String
    lateinit var id: UUID

    constructor (name: String,
                 email: String,
                 id: UUID = UUID.randomUUID()) : this()
    {
        this.name = name
        this.email = email
        this.id = id
    }
}