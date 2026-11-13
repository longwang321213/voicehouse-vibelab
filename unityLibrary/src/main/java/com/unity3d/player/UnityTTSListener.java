package com.unity3d.player;

import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;

public class UnityTTSListener extends UtteranceProgressListener implements TextToSpeech.OnInitListener {
    private final String unityGameObjectName;
    public UnityTTSListener(String gameObjectName) { unityGameObjectName = gameObjectName; }
    @Override public void onInit(int status) {
        UnityPlayer.UnitySendMessage(unityGameObjectName, "OnTTSInitialized", status == TextToSpeech.SUCCESS ? "SUCCESS" : "FAILED");
    }
    @Override public void onStart(String id) { UnityPlayer.UnitySendMessage(unityGameObjectName, "OnTTSStarted", id); }
    @Override public void onDone(String id) { UnityPlayer.UnitySendMessage(unityGameObjectName, "OnTTSFinished", id); }
    @Override public void onError(String id) { UnityPlayer.UnitySendMessage(unityGameObjectName, "OnTTSError", id); }
    @Override public void onError(String id, int code) { onError(id); }
}
