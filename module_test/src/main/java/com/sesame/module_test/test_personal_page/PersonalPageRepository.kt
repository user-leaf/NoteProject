package com.sesame.module_test.test_personal_page

class PersonalPageRepository(val network: PersonalPageNetwork) {
    suspend fun getInfo(): UserInfo{
        return network.fetchUserInfo()
    }
}