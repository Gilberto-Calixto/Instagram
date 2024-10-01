package co.tiagoaguiar.course.instagram.view.common

import co.tiagoaguiar.course.instagram.view.data.login.FakeDataSource
import co.tiagoaguiar.course.instagram.view.data.login.LoginRepository
import co.tiagoaguiar.course.instagram.view.data.register.FakeRegisterEmailDataSource
import co.tiagoaguiar.course.instagram.view.data.register.RegisterRepository

object DependencyInjector {

    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository(): RegisterRepository {
        return RegisterRepository(FakeRegisterEmailDataSource())
    }
}