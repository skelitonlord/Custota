/*
 * SPDX-License-Identifier: GPL-3.0-only
 */

package com.chiller3.custota.external;

/**
 * Stable external control interface for compatible privileged frontends.
 */
interface ICustotaExternalService {
    int getApiVersion();

    String getVersionName();

    int getVersionCode();

    String getStatusJson();

    void monitor();

    void check();

    void install();

    void installFull();

    void revert();

    void pause();

    void resume();

    void cancel();

    void reboot();
}
