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

    /**
     * Return the configured OTA source URI, or an empty string if unset.
     */
    String getOtaSource();

    /**
     * Configure the OTA source URI.
     *
     * The caller must grant this package read access before invoking
     * this method for content:// URIs.
     */
    void setOtaSource(String uri);

    /**
     * Clear the configured OTA source.
     */
    void clearOtaSource();

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
