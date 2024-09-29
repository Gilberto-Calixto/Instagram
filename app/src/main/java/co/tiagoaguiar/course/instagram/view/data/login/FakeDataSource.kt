package co.tiagoaguiar.course.instagram.view.data.login

import android.os.Handler
import android.os.Looper
import co.tiagoaguiar.course.instagram.view.common.model.Database
import co.tiagoaguiar.course.instagram.view.common.model.UserAuth

class FakeDataSource: LoginDataSource {
    override fun login(email: String, password: String, callback: LoginCallback) {
        Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = Database.usersAuth.firstOrNull { email == it.email }

            if (userAuth == null) {
                callback.onFailure("Usuário não encontrado")
            } else if ( userAuth.password != password) {
                callback.onFailure("Senha inválida")
            } else {
                Database.sessionAuth = userAuth
                callback.onSucess(userAuth)
            }
        }, 2000)
    }
}