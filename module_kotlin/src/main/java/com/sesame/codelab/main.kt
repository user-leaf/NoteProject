package com.sesame.codelab

val str by lazy {
    println("in str by lazy")
    "hello"
}

private lateinit var str2: String

fun main() {
//    println(User(lastName = "lastName", firstName = ""))

//    val users = Repository.getUsers()
//    val formattedUserNames = Repository.formattedUserNames
//    println(formattedUserNames)

//    println(Repository.myUsers)

//    val user = User("haha", "hehe")
//    println(user.userFormattedName)
//    println(user.getFormattedName())

//    val number = Random.nextInt(100)
//    val evenOrNull = number.takeIf { it % 2 == 0 }
//    val oddOrNull = number.takeUnless { it % 2 == 0 }
//    println("even: $evenOrNull, odd: $oddOrNull")


//    val str = "000011"
//
//    val result1 = str.takeIf { it.contains("11") }
//    println("$result1")
//
//    // takeUnless如果不匹配谓词，则返回对象，如果匹配则返回 null
//    val result2 = str.takeUnless { it.contains("11") }
//    println(result2)
//    val result3 = str.takeLast(4)
//    println(result3)

//    println(str)
//    println()
//    println(str)
//    str2 = "Hello"
//    println(str2)
//    str2 = "Hello2"

//    val stringLengthFunc: (String) -> Int = { input ->
//        input.length
//    }
//    println(stringLengthFunc("hello"))
//
//    val length = stringMapper("Android") { input ->
//        input.length
//    }
//    println(length)

    val car = Car("haha")
    println(car.gallonsOfFuelInTank)
}

fun generateAnswerString(countThreshold: Int): String {
    return if (countThreshold > 5) {
        "I have the answer"
    } else {
        "The answer eludes me"
    }
}

fun generateAnswerString2(countThreshold: Int): String = if (countThreshold > 5) {
    "I have the answer"
} else {
    "The answer eludes me"
}

fun stringMapper(str: String, mapper: (String) -> Int): Int {
    return mapper(str)
}