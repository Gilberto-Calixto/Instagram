package co.tiagoaguiar.course.instagram.view.data.register

import android.os.Handler
import android.os.Looper
import co.tiagoaguiar.course.instagram.view.common.model.Database
import co.tiagoaguiar.course.instagram.view.common.model.UserAuth
import java.util.UUID

class FakeRegisterEmailDataSource: RegisterEmailDataSource {

    override fun create(email: String, callback: RegisterCallback) {
        Handler(Looper.getMainLooper()).postDelayed({
            val userAuth = Database.usersAuth.firstOrNull { email == it.email }

            if (userAuth == null) {
                callback.onSucess(email)
            } else {
                callback.onFailure("Usuário já cadastrado")
            }
        }, 2000)
    }
}