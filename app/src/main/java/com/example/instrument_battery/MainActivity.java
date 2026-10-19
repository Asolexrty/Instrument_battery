package com.example.instrument_battery;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private final int NR_OF_SIMULTANEOUS_SOUND = 7;
    private final float LEFT_VOLUME = 1.0f;
    private final float RIGHT_VOLUME = 1.0f;
    private final int NO_LOOP = 0;
    private final int PRIORITY = 0;
    private final float NORMAL_PLAY_RATE = 1.0f;

    private SoundPool mSoundPool;

    private int mCassaSound;
    private int mRullanteSound;
    private int mHiHatChiusoSound;
    private int mHiHatApertoSound;
    private int mTomBassoSound;
    private int mTomSound;
    private int mTomAltoSound;
    private int mPiattiSound;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();

        mSoundPool = new SoundPool.Builder()
                .setMaxStreams(NR_OF_SIMULTANEOUS_SOUND)
                .setAudioAttributes(attributes)
                .build();

        mCassaSound=mSoundPool.load(this, R.raw.cassa,1);
        mRullanteSound=mSoundPool.load(this,R.raw.rullante,1);
        mHiHatChiusoSound=mSoundPool.load(this,R.raw.hi_hat_chiuso,1);
        mHiHatApertoSound=mSoundPool.load(this,R.raw.hi_hat_aperto,1);
        mTomBassoSound=mSoundPool.load(this,R.raw.tom_basso,1);
        mTomSound=mSoundPool.load(this,R.raw.tom,1);
        mTomAltoSound=mSoundPool.load(this,R.raw.tom_alto,1);
        mPiattiSound=mSoundPool.load(this,R.raw.piatti,1);

        View.OnClickListener tastoListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();

                if (id == R.id.button_cassa) {
                    play(mCassaSound);
                } else if (id == R.id.button_rullante) {
                    play(mRullanteSound);
                } else if (id == R.id.button_Hi_hat_chiuso) {
                    play(mHiHatChiusoSound);
                } else if (id == R.id.button_Hi_hat_aperto) {
                    play(mHiHatApertoSound);
                } else if (id == R.id.buttonTom_basso) {
                    play(mTomBassoSound);
                } else if (id == R.id.button_Tom_button) {
                    play(mTomSound);
                } else if (id == R.id.button_Tom_alto) {
                    play(mTomAltoSound);
                } else if (id == R.id.button_Piatti) {
                    play(mPiattiSound);
                }
            }
        };

        findViewById(R.id.button_cassa).setOnClickListener(tastoListener);
        findViewById(R.id.button_rullante).setOnClickListener(tastoListener);
        findViewById(R.id.button_Hi_hat_chiuso).setOnClickListener(tastoListener);
        findViewById(R.id.button_Hi_hat_aperto).setOnClickListener(tastoListener);
        findViewById(R.id.buttonTom_basso).setOnClickListener(tastoListener);
        findViewById(R.id.button_Tom_button).setOnClickListener(tastoListener);
        findViewById(R.id.button_Tom_alto).setOnClickListener(tastoListener);
        findViewById(R.id.button_Piatti).setOnClickListener(tastoListener);
    }

    private void play(int soundId) {
        mSoundPool.play(soundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSoundPool.release();
    }

}