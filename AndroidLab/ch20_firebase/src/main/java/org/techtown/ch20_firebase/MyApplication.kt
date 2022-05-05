package org.techtown.ch20_firebase

import androidx.multidex.MultiDexApplication
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage

class MyApplication: MultiDexApplication() {
    companion object{
        lateinit var auth: FirebaseAuth
        var email: String? = null
        lateinit var db: FirebaseFirestore
        lateinit var storage: FirebaseStorage
        fun checkAuth(): Boolean{ // FirebaseAuth와 인증된 사용자의 이메일 정보, 인증 상태를 파악하는 함수, manifest에 등록해야함
            val currentUser=auth.currentUser
            return currentUser?.let {
                email = currentUser.email
                currentUser.isEmailVerified
            } ?: let{
                false
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(auth)
        auth=Firebase.auth
        db=FirebaseFirestore.getInstance()
        storage=Firebase.storage
    }
}