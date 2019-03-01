package com.masterfabela.homepanion;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

public class CustomBarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        putCustomActionBar(getCustomBar(R.layout.custom_bar));
    }


    public void putCustomActionBar(View customBar) {
        ActionBar actualActionBar = getActionBar();
        assert actualActionBar != null;
        actualActionBar.setDisplayOptions(
                ActionBar.DISPLAY_SHOW_CUSTOM,
                ActionBar.DISPLAY_SHOW_CUSTOM
                        | ActionBar.DISPLAY_SHOW_HOME
                        | ActionBar.DISPLAY_SHOW_TITLE);
        actualActionBar.setCustomView(customBar, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(customBar.getId());
    }

    public View getCustomBar(int customBarID) {
        LayoutInflater inflater = (LayoutInflater) Objects.requireNonNull(getActionBar())
                .getThemedContext()
                .getSystemService(LAYOUT_INFLATER_SERVICE);
        View customBarView = inflater.inflate(getResources().getLayout(customBarID), null);
        customBarView.findViewById(R.id.actionbar_done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        return customBarView;
    }

}
