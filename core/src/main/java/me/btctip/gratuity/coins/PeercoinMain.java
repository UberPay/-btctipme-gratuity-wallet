package me.btctip.gratuity.coins;

import me.btctip.gratuity.coins.families.BitFamily;
import me.btctip.gratuity.coins.families.PeerFamily;

import org.bitcoinj.core.Coin;

/**
 * @author John L. Jegutanis
 */
public class PeercoinMain extends CoinType {
    private PeercoinMain() {
        id = "peercoin.main";

        addressHeader = 55;
        p2shHeader = 117;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 500;

        family = PeerFamily.get();
        name = "Peercoin";
        symbol = "PPC";
        uriScheme = "peercoin"; // TODO verify, could be ppcoin?
        bip44Index = 6;
        unitExponent = 6;
        feePerKb = value(10000); // 0.01PPC, careful Peercoin has 1000000 units per coin
        minNonDust = value(10000); // 0.01PPC
        softDustLimit = minNonDust;
        softDustPolicy = SoftDustPolicy.NO_POLICY;
    }

    private static PeercoinMain instance = new PeercoinMain();
    public static synchronized PeercoinMain get() {
        return instance;
    }
}
