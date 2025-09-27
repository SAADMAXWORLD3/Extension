
package com.yourname.unityads;

import android.app.Activity;
import android.content.Context;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds.UnityAdsError;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.*;

@DesignerComponent(version = 1,
    description = "Unity Ads Extension for MIT App Inventor",
    category = ComponentCategory.EXTENSION,
    nonVisible = true,
    iconName = "")
@SimpleObject(external = true)
public class UnityAdsExtension extends AndroidNonvisibleComponent implements Component {

    private final Context context;
    private final Activity activity;

    public UnityAdsExtension(ComponentContainer container) {
        super(container.$form());
        this.context = container.$context();
        this.activity = (Activity) context;
}

    @SimpleFunction(description = "Initialize Unity Ads with Game ID and Test Mode")
    public void Initialize(String gameId, boolean testMode) {
        UnityAds.initialize(context, gameId, testMode);
}

    @SimpleFunction(description = "Show Interstitial Ad with Placement ID")
    public void ShowInterstitial(String placementId) {
        if (UnityAds.isReady(placementId)) {
            UnityAds.show(activity, placementId);
}
}

    @SimpleEvent(description = "Called when an ad is ready")
    public void AdReady(String placementId) {
        EventDispatcher.dispatchEvent(this, "AdReady", placementId);
}

    @SimpleEvent(description = "Called when an ad fails to load")
    public void AdFailed(String placementId, String error) {
        EventDispatcher.dispatchEvent(this, "AdFailed", placementId, error);
}
}