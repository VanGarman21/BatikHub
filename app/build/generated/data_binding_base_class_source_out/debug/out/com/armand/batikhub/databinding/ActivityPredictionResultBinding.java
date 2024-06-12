// Generated by view binder compiler. Do not edit!
package com.armand.batikhub.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armand.batikhub.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPredictionResultBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageViewScannedBatik;

  @NonNull
  public final TextView textViewPredictionResult;

  private ActivityPredictionResultBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView imageViewScannedBatik, @NonNull TextView textViewPredictionResult) {
    this.rootView = rootView;
    this.imageViewScannedBatik = imageViewScannedBatik;
    this.textViewPredictionResult = textViewPredictionResult;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPredictionResultBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPredictionResultBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_prediction_result, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPredictionResultBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageViewScannedBatik;
      ImageView imageViewScannedBatik = ViewBindings.findChildViewById(rootView, id);
      if (imageViewScannedBatik == null) {
        break missingId;
      }

      id = R.id.textViewPredictionResult;
      TextView textViewPredictionResult = ViewBindings.findChildViewById(rootView, id);
      if (textViewPredictionResult == null) {
        break missingId;
      }

      return new ActivityPredictionResultBinding((ConstraintLayout) rootView, imageViewScannedBatik,
          textViewPredictionResult);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}