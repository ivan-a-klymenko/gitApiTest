package ru.bk.klim9.xingtest.requests.repos


data class Permissions(
    val admin: Boolean,
    val push: Boolean,
    val pull: Boolean
)