package com.sesame.codelab

val User.userFormattedName: String
    get() {
        return "userFormattedName: $firstName == $lastName"
    }

fun User.getFormattedName(): String {
    return "getFormattedName(): $firstName == $lastName"
}

object Repository {
    private var users = mutableListOf<User>()
    fun getUsers(): List<User?> {
        return users
    }

    val formattedUserNames: List<String>
        get() {
            val userNames = mutableListOf<String>()
//            for (user in users) {
//                var name: String?
//                name = if (user.lastName != null) {
//                    user.firstName + " " + user.lastName
//                } else if (user.firstName != null) {
//                    user.firstName
//                } else {
//                    "Unknown"
//                }
//                userNames.add(name)
//            }

//            for ((firstName, lastName) in users){
//                val name = "$firstName $lastName"
//                userNames.add(name)
//            }

            for (user in users) {
                var name: String
                if (user.lastName != null) {
                    name = user.firstName + " " + user.lastName
                } else if (user.firstName != null) {
                    name = user.firstName
                } else {
                    name = "Unknown"
                }
                userNames.add(name)
            }

            for ((firstName, lastName) in users) {
                println("$firstName == $lastName")
            }

            return userNames
        }

    val myUsers: List<String>
        get() {
            return users.map { user ->
                "${user.firstName} == ${user.lastName}"
            }
        }

//    companion object {
//        private var INSTANCE: Repository? = null
//        val instance: Repository?
//            get() {
//                if (INSTANCE == null) {
//                    synchronized(Repository::class.java) {
//                        if (INSTANCE == null) {
//                            INSTANCE = Repository()
//                        }
//                    }
//                }
//                return INSTANCE
//            }
//    }

    // keeping the constructor private to enforce the usage of getInstance
    init {
        val user1 = User("Jane", "")
        val user2 = User("John", null)
        val user3 = User("Anne", "Doe")
//        users = ArrayList()
        users.add(user1)
        users.add(user2)
        users.add(user3)
    }
}