package com.sesame.module_kotlin.sealed

sealed class Result

class Success(val msg: String) : Result()
class Failure(val error: Exception) : Result()