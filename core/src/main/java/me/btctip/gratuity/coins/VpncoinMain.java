package me.btctip.gratuity.coins;

import me.btctip.gratuity.coins.families.PeerFamily;
import me.btctip.gratuity.coins.families.VpncoinFamily;

/**
 * @author John L. Jegutanis
 */
public class VpncoinMain extends CoinType {
    private VpncoinMain() {
        id = "vpncoin.main";

        addressHeader = 71;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;

        family = VpncoinFamily.get();
        name = "Vpncoin (beta)";
        symbol = "VPN";
        uriScheme = "vpncoin";
        bip44Index = 33;
        unitExponent = 8;
        feePerKb = value(10000); // 0.0001VPN
        minNonDust = value(1); // 0.00000001VPN
        softDustLimit = value(1000000); // 0.01VPN
        softDustPolicy = SoftDustPolicy.AT_LEAST_BASE_FEE_IF_SOFT_DUST_TXO_PRESENT;
    }

    private static VpncoinMain instance = new VpncoinMain();
    public static synchronized VpncoinMain get() {
        return instance;
    }
}
