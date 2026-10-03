/*
 * SPDX-FileCopyrightText: 2023 Andrew Gunnerson
 * SPDX-License-Identifier: GPL-3.0-only
 */

package com.chiller3.custota.wrapper

import android.annotation.SuppressLint

object SystemPropertiesProxy {
    @SuppressLint("PrivateApi")
    fun get(key: String): String {
        val cls = Class.forName("android.os.SystemProperties")
        val method = cls.getDeclaredMethod("get", String::class.java)
        return method.invoke(null, key) as String
    }

    /** Optional display data only. OTA validation must continue to use the strict getter. */
    fun getOrNull(key: String): String? = try {
        get(key).takeIf { it.isNotEmpty() }
    } catch (_: Exception) {
        null
    } catch (_: LinkageError) {
        null
    }
}
