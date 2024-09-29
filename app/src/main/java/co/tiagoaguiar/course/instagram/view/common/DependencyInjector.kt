package co.tiagoaguiar.course.instagram.view.common

import co.tiagoaguiar.course.instagram.view.data.login.FakeDataSource
import co.tiagoaguiar.course.instagram.view.data.login.LoginRepository

object DependencyInjector {

    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }
}