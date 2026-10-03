/*
 * SPDX-FileCopyrightText: 2023 Andrew Gunnerson
 * SPDX-License-Identifier: GPL-3.0-only
 * Based on BCR code.
 */

package com.chiller3.custota.wrapper

import android.annotation.SuppressLint
import android.os.IBinder

object ServiceManagerProxy {
    @SuppressLint("PrivateApi", "SoonBlockedPrivateApi")
    fun getServiceOrThrow(name: String): IBinder {
        // A denied hidden API must be a normal call failure. Resolving it in an object
        // initializer instead throws ExceptionInInitializerError and poisons future calls.
        val cls = Class.forName("android.os.ServiceManager")
        val method = cls.getDeclaredMethod("getServiceOrThrow", String::class.java)
        return method.invoke(null, name) as IBinder
    }
}
