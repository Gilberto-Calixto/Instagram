package co.tiagoaguiar.course.instagram.view.common.model

import java.util.*

object Database {

    val usersAuth = hashSetOf<UserAuth>()
    var sessionAuth: UserAuth? = null



    init {
        usersAuth.add( UserAuth( UUID.randomUUID().toString(), "afb@gmail.com", "12345678"))
        usersAuth.add( UserAuth( UUID.randomUUID().toString(), "ania@gmail.com", "234190412"))
        usersAuth.add( UserAuth( UUID.randomUUID().toString(), "mir@gmail.com", "87654321"))

    }
}