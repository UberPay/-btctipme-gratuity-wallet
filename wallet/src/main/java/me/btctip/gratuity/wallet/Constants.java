package me.btctip.gratuity.wallet;

import android.text.format.DateUtils;

import me.btctip.gratuity.coins.BitcoinMain;
import me.btctip.gratuity.coins.BitcoinTest;
import me.btctip.gratuity.coins.BlackcoinMain;
import me.btctip.gratuity.coins.CannacoinMain;
import me.btctip.gratuity.coins.CoinID;
import me.btctip.gratuity.coins.CoinType;
import me.btctip.gratuity.coins.DashMain;
import me.btctip.gratuity.coins.DigibyteMain;
import me.btctip.gratuity.coins.DigitalcoinMain;
import me.btctip.gratuity.coins.DogecoinMain;
import me.btctip.gratuity.coins.DogecoinTest;
import me.btctip.gratuity.coins.FeathercoinMain;
import me.btctip.gratuity.coins.LitecoinMain;
import me.btctip.gratuity.coins.LitecoinTest;
import me.btctip.gratuity.coins.MonacoinMain;
import me.btctip.gratuity.coins.NamecoinMain;
import me.btctip.gratuity.coins.NuBitsMain;
import me.btctip.gratuity.coins.NuSharesMain;
import me.btctip.gratuity.coins.PeercoinMain;
import me.btctip.gratuity.coins.ReddcoinMain;
import me.btctip.gratuity.coins.RubycoinMain;
import me.btctip.gratuity.coins.UroMain;
import me.btctip.gratuity.coins.NeoscoinMain;
import me.btctip.gratuity.coins.JumbucksMain;
import me.btctip.gratuity.coins.VertcoinMain;
import me.btctip.gratuity.coins.VpncoinMain;
import me.btctip.gratuity.network.CoinAddress;
import me.btctip.stratumj.ServerAddress;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author John L. Jegutanis
 * @author Andreas Schildbach
 */
public class Constants {

    public static final int SEED_ENTROPY_DEFAULT = 160;
    public static final int SEED_ENTROPY_EXTRA = 256;

    public static final String ARG_SEED = "seed";
    public static final String ARG_PASSWORD = "password";
    public static final String ARG_SEED_PASSWORD = "seed_password";
    public static final String ARG_EMPTY_WALLET = "empty_wallet";
    public static final String ARG_SEND_TO_ADDRESS = "send_to_address";
    public static final String ARG_SEND_TO_COIN_TYPE = "send_to_coin_type";
    public static final String ARG_SEND_TO_ACCOUNT_ID = "send_to_account_id";
    public static final String ARG_SEND_VALUE = "send_value";
    public static final String ARG_COIN_ID = "coin_id";
    public static final String ARG_ACCOUNT_ID = "account_id";
    public static final String ARG_MULTIPLE_COIN_IDS = "multiple_coin_ids";
    public static final String ARG_MULTIPLE_CHOICE = "multiple_choice";
    public static final String ARG_TRANSACTION_ID = "transaction_id";
    public static final String ARG_ERROR = "error";
    public static final String ARG_MESSAGE = "message";
    public static final String ARG_ADDRESS = "address";
    public static final String ARG_ADDRESS_STRING = "address_string";
    public static final String ARG_EXCHANGE_ENTRY = "exchange_entry";
    public static final String ARG_TEST_WALLET = "test_wallet";
    public static final String ARG_URI = "test_wallet";

    public static final String WALLET_FILENAME_PROTOBUF = "wallet";
    public static final long WALLET_WRITE_DELAY = 3;
    public static final TimeUnit WALLET_WRITE_DELAY_UNIT = TimeUnit.SECONDS;

    public static final long STOP_SERVICE_AFTER_IDLE_SECS = 30 * 60; // 30 mins

    public static final String HTTP_CACHE_DIR = "http_cache";
    public static final int HTTP_CACHE_SIZE = 256 * 1024; // 256 KiB
    public static final int HTTP_TIMEOUT_MS = 15 * (int) DateUtils.SECOND_IN_MILLIS;

    public static final long RATE_UPDATE_FREQ_MS = 30 * DateUtils.SECOND_IN_MILLIS;

    /** Default currency to use if all default mechanisms fail. */
    public static final String DEFAULT_EXCHANGE_CURRENCY = "USD";

    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Charset US_ASCII = Charset.forName("US-ASCII");

    public static final char CHAR_HAIR_SPACE = '\u200a';
    public static final char CHAR_THIN_SPACE = '\u2009';
    public static final char CHAR_ALMOST_EQUAL_TO = '\u2248';
    public static final char CHAR_CHECKMARK = '\u2713';
    public static final char CURRENCY_PLUS_SIGN = '+';
    public static final char CURRENCY_MINUS_SIGN = '-';

    public static final String MARKET_APP_URL = "market://details?id=%s";
    public static final String BINARY_URL = "https://github.com/UberPay/btctipme-gratuity-wallet/releases";

    public static final String VERSION_URL = "http://btctip.me/version";

    // TODO move to resource files
    public static final List<CoinAddress> DEFAULT_COINS_SERVERS = ImmutableList.of(
            new CoinAddress(BitcoinMain.get(),      new ServerAddress("btc-cce-1.coinomi.net", 5001),
                                                    new ServerAddress("btc-cce-2.coinomi.net", 5001)),
            new CoinAddress(BitcoinTest.get(),      new ServerAddress("btc-testnet-cce-1.coinomi.net", 15001),
                                                    new ServerAddress("btc-testnet-cce-2.coinomi.net", 15001)),
            new CoinAddress(DogecoinMain.get(),     new ServerAddress("doge-cce-1.coinomi.net", 5003),
                                                    new ServerAddress("doge-cce-2.coinomi.net", 5003)),
            new CoinAddress(DogecoinTest.get(),     new ServerAddress("doge-testnet-cce-1.coinomi.net", 15003),
                                                    new ServerAddress("doge-testnet-cce-2.coinomi.net", 15003)),
            new CoinAddress(LitecoinMain.get(),     new ServerAddress("ltc-cce-1.coinomi.net", 5002),
                                                    new ServerAddress("ltc-cce-2.coinomi.net", 5002)),
            new CoinAddress(LitecoinTest.get(),     new ServerAddress("ltc-testnet-cce-1.coinomi.net", 15002),
                                                    new ServerAddress("ltc-testnet-cce-2.coinomi.net", 15002)),
            new CoinAddress(PeercoinMain.get(),     new ServerAddress("ppc-cce-1.coinomi.net", 5004),
                                                    new ServerAddress("ppc-cce-2.coinomi.net", 5004)),
            new CoinAddress(NuSharesMain.get(),     new ServerAddress("nsr-cce-1.coinomi.net", 5011),
                                                    new ServerAddress("nsr-cce-2.coinomi.net", 5011)),
            new CoinAddress(NuBitsMain.get(),       new ServerAddress("nbt-cce-1.coinomi.net", 5012),
                                                    new ServerAddress("nbt-cce-2.coinomi.net", 5012)),
            new CoinAddress(DashMain.get(),         new ServerAddress("drk-cce-1.coinomi.net", 5013),
                                                    new ServerAddress("drk-cce-2.coinomi.net", 5013)),
            new CoinAddress(ReddcoinMain.get(),     new ServerAddress("rdd-cce-1.coinomi.net", 5014),
                                                    new ServerAddress("rdd-cce-2.coinomi.net", 5014)),
            new CoinAddress(BlackcoinMain.get(),    new ServerAddress("blk-cce-1.coinomi.net", 5015),
                                                    new ServerAddress("blk-cce-2.coinomi.net", 5015)),
            new CoinAddress(NamecoinMain.get(),     new ServerAddress("nmc-cce-1.coinomi.net", 5016),
                                                    new ServerAddress("nmc-cce-2.coinomi.net", 5016)),
            new CoinAddress(FeathercoinMain.get(),  new ServerAddress("ftc-cce-1.coinomi.net", 5017),
                                                    new ServerAddress("ftc-cce-2.coinomi.net", 5017)),
            new CoinAddress(RubycoinMain.get(),     new ServerAddress("rby-cce-1.coinomi.net", 5018),
                                                    new ServerAddress("rby-cce-2.coinomi.net", 5018)),
            new CoinAddress(UroMain.get(),          new ServerAddress("uro-cce-1.coinomi.net", 5019),
                                                    new ServerAddress("uro-cce-2.coinomi.net", 5019)),
            new CoinAddress(DigitalcoinMain.get(),  new ServerAddress("dgc-cce-1.coinomi.net", 5020),
                                                    new ServerAddress("dgc-cce-2.coinomi.net", 5020)),
            new CoinAddress(CannacoinMain.get(),    new ServerAddress("ccn-cce-1.coinomi.net", 5021),
                                                    new ServerAddress("ccn-cce-2.coinomi.net", 5021)),
            new CoinAddress(MonacoinMain.get(),     new ServerAddress("mona-cce-1.coinomi.net", 5022),
                                                    new ServerAddress("mona-cce-2.coinomi.net", 5022)),
            new CoinAddress(DigibyteMain.get(),     new ServerAddress("dgb-cce-1.coinomi.net", 5023),
                                                    new ServerAddress("dgb-cce-2.coinomi.net", 5023)),
            // 5024 primecoin
            // 5025 clams
            // 5026 shadowcoin
            new CoinAddress(NeoscoinMain.get(),     new ServerAddress("neos-cce-1.coinomi.net", 5027),
                                                    new ServerAddress("neos-cce-2.coinomi.net", 5027)),
            new CoinAddress(VertcoinMain.get(),     new ServerAddress("vtc-cce-1.coinomi.net", 5028),
                                                    new ServerAddress("vtc-cce-2.coinomi.net", 5028)),
            new CoinAddress(JumbucksMain.get(),     new ServerAddress("jbs-cce-1.coinomi.net", 5029),
                                                    new ServerAddress("jbs-cce-2.coinomi.net", 5029)),
            new CoinAddress(VpncoinMain.get(),      new ServerAddress("vpn-cce-1.coinomi.net", 5032),
                                                    new ServerAddress("vpn-cce-2.coinomi.net", 5032))
    );

    public static final HashMap<CoinType, Integer> COINS_ICONS;
    public static final HashMap<CoinType, String> COINS_BLOCK_EXPLORERS;
    static {
        COINS_ICONS = new HashMap<>();
        COINS_ICONS.put(CoinID.BITCOIN_MAIN.getCoinType(), R.drawable.bitcoin);
        COINS_ICONS.put(CoinID.BITCOIN_TEST.getCoinType(), R.drawable.bitcoin_test);
        COINS_ICONS.put(CoinID.DOGECOIN_MAIN.getCoinType(), R.drawable.dogecoin);
        COINS_ICONS.put(CoinID.DOGECOIN_TEST.getCoinType(), R.drawable.dogecoin_test);
        COINS_ICONS.put(CoinID.LITECOIN_MAIN.getCoinType(), R.drawable.litecoin);
        COINS_ICONS.put(CoinID.LITECOIN_TEST.getCoinType(), R.drawable.litecoin_test);
        COINS_ICONS.put(CoinID.PEERCOIN_MAIN.getCoinType(), R.drawable.peercoin);
        COINS_ICONS.put(CoinID.DASH_MAIN.getCoinType(), R.drawable.dash);
        COINS_ICONS.put(CoinID.REDDCOIN_MAIN.getCoinType(), R.drawable.reddcoin);
        COINS_ICONS.put(CoinID.NUSHARES_MAIN.getCoinType(), R.drawable.nushares);
        COINS_ICONS.put(CoinID.NUBITS_MAIN.getCoinType(), R.drawable.nubits);
        COINS_ICONS.put(CoinID.BLACKCOIN_MAIN.getCoinType(), R.drawable.blackcoin);
        COINS_ICONS.put(CoinID.MONACOIN_MAIN.getCoinType(), R.drawable.monacoin);
        COINS_ICONS.put(CoinID.RUBYCOIN_MAIN.getCoinType(), R.drawable.rubycoin);
        COINS_ICONS.put(CoinID.NAMECOIN_MAIN.getCoinType(), R.drawable.namecoin);
        COINS_ICONS.put(CoinID.FEATHERCOIN_MAIN.getCoinType(), R.drawable.feathercoin);
//        COINS_ICONS.put(CoinID.URO_MAIN.getCoinType(), R.drawable.uro);
        COINS_ICONS.put(CoinID.DIGITALCOIN_MAIN.getCoinType(), R.drawable.digitalcoin);
        COINS_ICONS.put(CoinID.CANNACOIN_MAIN.getCoinType(), R.drawable.cannacoin);
        COINS_ICONS.put(CoinID.DIGIBYTE_MAIN.getCoinType(), R.drawable.digibyte);
        COINS_ICONS.put(CoinID.NEOSCOIN_MAIN.getCoinType(), R.drawable.neoscoin);
        COINS_ICONS.put(CoinID.VERTCOIN_MAIN.getCoinType(), R.drawable.vertcoin);
        COINS_ICONS.put(CoinID.JUMBUCKS_MAIN.getCoinType(), R.drawable.jumbucks);
        COINS_ICONS.put(CoinID.VPNCOIN_MAIN.getCoinType(), R.drawable.vpncoin);

        COINS_BLOCK_EXPLORERS = new HashMap<CoinType, String>();
        COINS_BLOCK_EXPLORERS.put(CoinID.BITCOIN_MAIN.getCoinType(), "https://blockchain.info/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.BITCOIN_TEST.getCoinType(), "https://chain.so/tx/BTCTEST/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.DOGECOIN_MAIN.getCoinType(), "https://chain.so/tx/DOGE/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.DOGECOIN_TEST.getCoinType(), "https://chain.so/tx/DOGETEST/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.LITECOIN_MAIN.getCoinType(), "http://ltc.blockr.io/tx/info/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.LITECOIN_TEST.getCoinType(), "https://chain.so/tx/LTCTEST/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.PEERCOIN_MAIN.getCoinType(), "http://ppc.blockr.io/tx/info/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.DASH_MAIN.getCoinType(), "https://bitinfocharts.com/darkcoin/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.NUSHARES_MAIN.getCoinType(), "http://blockexplorer.nu/transactions/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.NUBITS_MAIN.getCoinType(), "http://blockexplorer.nu/transactions/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.REDDCOIN_MAIN.getCoinType(), "http://live.reddcoin.com/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.BLACKCOIN_MAIN.getCoinType(), "https://chainz.cryptoid.info/blk/tx.dws?%s.htm");
        // TODO find a non Japanese block explorer
        COINS_BLOCK_EXPLORERS.put(CoinID.MONACOIN_MAIN.getCoinType(), "http://abe.monash.pw:3000/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.RUBYCOIN_MAIN.getCoinType(), "https://chainz.cryptoid.info/rby/tx.dws?%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.NAMECOIN_MAIN.getCoinType(), "https://explorer.namecoin.info/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.FEATHERCOIN_MAIN.getCoinType(), "http://explorer.feathercoin.com/tx/%s");
//        COINS_BLOCK_EXPLORERS.put(CoinID.URO_MAIN.getCoinType(), "https://chainz.cryptoid.info/uro/tx.dws?%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.DIGITALCOIN_MAIN.getCoinType(), "https://chainz.cryptoid.info/dgc/tx.dws?%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.CANNACOIN_MAIN.getCoinType(), "https://chainz.cryptoid.info/ccn/tx.dws?%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.DIGIBYTE_MAIN.getCoinType(), "https://digiexplorer.info/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.NEOSCOIN_MAIN.getCoinType(), "http://explorer.infernopool.com/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.VERTCOIN_MAIN.getCoinType(), "https://bitinfocharts.com/vertcoin/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.JUMBUCKS_MAIN.getCoinType(), "http://explorer.getjumbucks.com/tx/%s");
        COINS_BLOCK_EXPLORERS.put(CoinID.VPNCOIN_MAIN.getCoinType(), "https://blockexperts.com/vpn/tx/%s");
    }

    public static final CoinType DEFAULT_COIN = BitcoinMain.get();
    public static final List<CoinType> DEFAULT_COINS = ImmutableList.of((CoinType) BitcoinMain.get());
    public static final ArrayList<String> DEFAULT_TEST_COIN_IDS = Lists.newArrayList(
            BitcoinTest.get().getId(),
            LitecoinTest.get().getId(),
            DogecoinTest.get().getId()
    );

    public static final List<CoinType> SUPPORTED_COINS = ImmutableList.of(
            BitcoinMain.get(),
            DogecoinMain.get(),
            LitecoinMain.get(),
            DashMain.get(),
            NamecoinMain.get(),
            BlackcoinMain.get(),
            FeathercoinMain.get(),
            ReddcoinMain.get(),
            BitcoinTest.get(),
            LitecoinTest.get(),
            DogecoinTest.get()
    );
}
