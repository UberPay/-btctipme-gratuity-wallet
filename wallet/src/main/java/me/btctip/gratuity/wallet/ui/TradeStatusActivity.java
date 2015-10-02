package me.btctip.gratuity.wallet.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import me.btctip.gratuity.coins.Value;
import me.btctip.gratuity.wallet.WalletAccount;
import me.btctip.gratuity.wallet.Constants;
import me.btctip.gratuity.wallet.R;

import org.bitcoinj.core.Address;

import javax.annotation.Nullable;


public class TradeStatusActivity extends BaseWalletActivity implements TradeStatusFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_status);

        if (savedInstanceState == null) {
            Fragment fragment = new TradeStatusFragment();
            fragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }
    }

    @Override
    public void onFinish() {
        finish();
    }
}
