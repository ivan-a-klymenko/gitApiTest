package ru.bk.klim9.xingtest.requests.repos

/**
 * @author ivan.a.klymenko@gmail.com on 3/20/21
 */
data class ReposItem(
    val name: String,
    val ownerLogin: String,
    val ownerLogo: String,
    val description: String
)