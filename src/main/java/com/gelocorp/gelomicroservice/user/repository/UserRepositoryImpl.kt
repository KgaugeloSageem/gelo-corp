package com.gelocorp.gelomicroservice.user.repository

import com.gelocorp.gelomicroservice.user.model.request.*
import com.gelocorp.gelomicroservice.user.model.User
import com.gelocorp.gelomicroservice.user.model.User.Companion.toUser
import com.gelocorp.gelomicroservice.user.repository.UserDatabaseConstant.DATABASE_COLLECTION
import com.gelocorp.gelomicroservice.user.repository.UserDatabaseConstant.USER_DATABASE_EMAIL
import com.gelocorp.gelomicroservice.user.repository.UserDatabaseConstant.USER_DATABASE_NAME
import com.gelocorp.gelomicroservice.user.repository.UserDatabaseConstant.USER_DATABASE_PASSWORD
import com.gelocorp.gelomicroservice.user.repository.UserDatabaseConstant.USER_DATABASE_SURNAME
import com.gelocorp.gelomicroservice.user.model.request.*
import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.QuerySnapshot
import com.google.cloud.firestore.WriteResult
import com.google.firebase.cloud.FirestoreClient
import org.springframework.stereotype.Repository
import java.util.*


@Repository
class UserRepositoryImpl: UserRepository {

    override fun create(userRegistrationRequest: UserRegistrationRequest): String {
        val database = FirestoreClient.getFirestore()
        val docRef = database.collection(DATABASE_COLLECTION).document(userRegistrationRequest.username)
        val data: MutableMap<String, Any> = HashMap()
        data["name"] = userRegistrationRequest.name
        data["surname"] = userRegistrationRequest.surname
        data["email"] = userRegistrationRequest.email
        data["password"] = userRegistrationRequest.password

        val result: ApiFuture<WriteResult> = docRef.set(data)
        return  result.get().updateTime.toString()
    }

    override fun getByUsername(username: String): User? {
        val database = FirestoreClient.getFirestore()
        val query: ApiFuture<QuerySnapshot> = database.collection(DATABASE_COLLECTION).get()
        val querySnapshot = query.get()
        val documents = querySnapshot.documents

        return documents.find { it.id == username }?.toUser()
    }

    override fun deleteByUsername(username: String): String {
        val database = FirestoreClient.getFirestore()
        val writeResult: ApiFuture<WriteResult> = database.collection(DATABASE_COLLECTION).document(username).delete()
        return writeResult.get().updateTime.toString()
    }

    override fun updateName(username: String, userUpdateNameRequest: UserUpdateNameRequest): String {
        val database = FirestoreClient.getFirestore()
        val docRef: DocumentReference = database.collection(DATABASE_COLLECTION).document(username)
        val future = docRef.update(USER_DATABASE_NAME, userUpdateNameRequest.newName)
        val result: WriteResult = future.get()
        return result.toString()
    }
    override fun updateSurname(username: String, userUpdateNameRequest: UserUpdateSurnameRequest): String {
        val database = FirestoreClient.getFirestore()
        val docRef: DocumentReference = database.collection(DATABASE_COLLECTION).document(username)
        val future = docRef.update(USER_DATABASE_SURNAME, userUpdateNameRequest.newSurname)
        val result: WriteResult = future.get()
        return result.toString()
    }
    override fun updateEmail(username: String, userUpdateNameRequest: UserUpdateEmailRequest): String {
        val database = FirestoreClient.getFirestore()
        val docRef: DocumentReference = database.collection(DATABASE_COLLECTION).document(username)
        val future = docRef.update(USER_DATABASE_EMAIL, userUpdateNameRequest.newEmail)
        val result: WriteResult = future.get()
        return result.toString()
    }
    override fun updatePassword(username: String, userUpdateNameRequest: UserUpdatePasswordRequest): String {
        val database = FirestoreClient.getFirestore()
        val docRef: DocumentReference = database.collection(DATABASE_COLLECTION).document(username)
        val future = docRef.update(USER_DATABASE_PASSWORD, userUpdateNameRequest.newPassword)
        val result: WriteResult = future.get()
        return result.toString()
    }


}

