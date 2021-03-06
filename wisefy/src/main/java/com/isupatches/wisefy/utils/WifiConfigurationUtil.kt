/*
 * Copyright 2018 Patches Klinefelter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.isupatches.wisefy.utils

import android.net.wifi.WifiConfiguration

import com.isupatches.wisefy.constants.QUOTE

/**
 * To generate a configuration for an open network.
 *
 * @param ssid The ssid for the open network's configuration
 *
 * @return WifiConfiguration - The open network configuration
 *
 * @see [com.isupatches.wisefy.WiseFy.addOpenNetwork]
 * @see [WifiConfiguration]
 *
 * @author Patches
 * @since 3.0
 */
internal fun generateOpenNetworkConfiguration(ssid: String): WifiConfiguration {
    val wifiConfiguration = WifiConfiguration()
    wifiConfiguration.SSID = convertSSIDForConfig(ssid)
    wifiConfiguration.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE)
    wifiConfiguration.allowedProtocols.set(WifiConfiguration.Protocol.RSN)
    wifiConfiguration.allowedProtocols.set(WifiConfiguration.Protocol.WPA)
    wifiConfiguration.allowedAuthAlgorithms.clear()
    wifiConfiguration.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP)
    wifiConfiguration.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP)
    wifiConfiguration.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40)
    wifiConfiguration.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP104)
    wifiConfiguration.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP)
    wifiConfiguration.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP)
    return wifiConfiguration
}

/**
 * To generate a configuration for a WEP network.
 *
 * @param ssid The ssid for the WEP network's configuration
 * @param password The password for the WEP network's configuration
 *
 * @return WifiConfiguration - The WEP network configuration
 *
 * @see [com.isupatches.wisefy.WiseFy.addWEPNetwork]
 * @see [WifiConfiguration]
 *
 * @author Patches
 * @since 3.0
 */
internal fun generateWEPNetworkConfiguration(ssid: String, password: String): WifiConfiguration {
    val wifiConfiguration = WifiConfiguration()
    wifiConfiguration.SSID = convertSSIDForConfig(ssid)
    wifiConfiguration.wepKeys[0] = QUOTE + password + QUOTE
    wifiConfiguration.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE)
    wifiConfiguration.allowedProtocols.set(WifiConfiguration.Protocol.RSN)
    wifiConfiguration.allowedProtocols.set(WifiConfiguration.Protocol.WPA)
    wifiConfiguration.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.OPEN)
    wifiConfiguration.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.SHARED)
    wifiConfiguration.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP)
    wifiConfiguration.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP)
    wifiConfiguration.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40)
    wifiConfiguration.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP104)
    return wifiConfiguration
}

/**
 * To generate a configuration for a WPA2 network.
 *
 * @param ssid The ssid for the WPA2 network's configuration
 * @param password The password for the WPA2 network's configuration
 *
 * @return WifiConfiguration - The WPA2 network configuration
 *
 * @see [com.isupatches.wisefy.WiseFy.addWPA2Network]
 * @see [WifiConfiguration]
 *
 * @author Patches
 * @since 3.0
 */
internal fun generateWPA2NetworkConfiguration(ssid: String, password: String): WifiConfiguration {
    val wifiConfiguration = WifiConfiguration()
    wifiConfiguration.SSID = convertSSIDForConfig(ssid)
    wifiConfiguration.preSharedKey = QUOTE + password + QUOTE
    wifiConfiguration.allowedProtocols.set(WifiConfiguration.Protocol.RSN)
    wifiConfiguration.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK)
    wifiConfiguration.status = WifiConfiguration.Status.ENABLED
    wifiConfiguration.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP)
    wifiConfiguration.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP)
    wifiConfiguration.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP)
    wifiConfiguration.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP)
    wifiConfiguration.allowedProtocols.set(WifiConfiguration.Protocol.RSN)
    wifiConfiguration.allowedProtocols.set(WifiConfiguration.Protocol.WPA)

    wifiConfiguration.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP)
    wifiConfiguration.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP)
    return wifiConfiguration
}
