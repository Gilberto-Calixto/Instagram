package co.tiagoaguiar.course.instagram.view.data.login

import co.tiagoaguiar.course.instagram.view.common.model.UserAuth

interface LoginCallback {
    fun onSucess(auth: UserAuth )
    fun onFailure(message: String)
    fun onComplete()
}