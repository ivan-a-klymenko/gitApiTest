package ru.bk.klim9.xingtest.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.bk.klim9.xingtest.requests.repos.License
import ru.bk.klim9.xingtest.requests.repos.Owner
import ru.bk.klim9.xingtest.requests.repos.Permissions
import java.util.*

/**
 * @author ivan.a.klymenko@gmail.com on 3/20/21
 */
class TypeConverter {

    @TypeConverter
    fun fromOwner(value: Owner?): String {
        if (value == null) {
            return ""
        }
        val type = object : TypeToken<Owner>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toOwner(json: String?): Owner? {
        if (json == null || "" == json) {
            return null
        }
        val type = object : TypeToken<Owner>() {}.type
        return Gson().fromJson<Owner>(json, type)
    }

    @TypeConverter
    fun fromPermissions(value: Permissions?): String {
        if (value == null) {
            return ""
        }
        val type = object : TypeToken<Permissions>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toPermissions(json: String?): Permissions? {
        if (json == null || "" == json) {
            return null
        }
        val type = object : TypeToken<Permissions>() {}.type
        return Gson().fromJson<Permissions>(json, type)
    }

    @TypeConverter
    fun fromLicense(value: License?): String {
        if (value == null) {
            return ""
        }
        val type = object : TypeToken<License>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toLicense(json: String?): License? {
        if (json == null || "" == json) {
            return null
        }
        val type = object : TypeToken<License>() {}.type
        return Gson().fromJson<License>(json, type)
    }

    @TypeConverter
    fun fromAny(value: Any?): String {
        if (value == null) {
            return ""
        }
        val type = object : TypeToken<Any>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toAny(json: String?): Any? {
        if (json == null || "" == json) {
            return null
        }
        val type = object : TypeToken<Any>() {}.type
        return Gson().fromJson<Any>(json, type)
    }

    @TypeConverter
    fun fromDate(value: Date?): String {
        if (value == null) {
            return ""
        }
        val type = object : TypeToken<Date>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toDate(json: String?): Date? {
        if (json == null || "" == json) {
            return null
        }
        val type = object : TypeToken<Date>() {}.type
        return Gson().fromJson<Date>(json, type)
    }
}