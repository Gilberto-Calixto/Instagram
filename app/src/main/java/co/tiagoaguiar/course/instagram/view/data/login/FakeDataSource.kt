package co.tiagoaguiar.course.instagram.view.data.login

import android.os.Handler
import android.os.Looper

class FakeDataSource: LoginDataSource {
    override fun login(email: String, password: String, callback: LoginCallback) {
        Handler(Looper.getMainLooper()).postDelayed({
            if (email == "a@a.com" && password == "12345678") {
                callback.onSucess()
            } else {
                callback.onFailure("Usuário não encontrado")
            }
            callback.onComplete()
        }, 2000)
    }
}