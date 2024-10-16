// Generated by view binder compiler. Do not edit!
package com.armand.batikhub.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armand.batikhub.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentPindaiBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonCamera;

  @NonNull
  public final Button buttonGallery;

  @NonNull
  public final Button buttonPindai;

  @NonNull
  public final ImageView imgPreviewPhoto;

  private FragmentPindaiBinding(@NonNull ConstraintLayout rootView, @NonNull Button buttonCamera,
      @NonNull Button buttonGallery, @NonNull Button buttonPindai,
      @NonNull ImageView imgPreviewPhoto) {
    this.rootView = rootView;
    this.buttonCamera = buttonCamera;
    this.buttonGallery = buttonGallery;
    this.buttonPindai = buttonPindai;
    this.imgPreviewPhoto = imgPreviewPhoto;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentPindaiBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentPindaiBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_pindai, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentPindaiBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_camera;
      Button buttonCamera = ViewBindings.findChildViewById(rootView, id);
      if (buttonCamera == null) {
        break missingId;
      }

      id = R.id.button_gallery;
      Button buttonGallery = ViewBindings.findChildViewById(rootView, id);
      if (buttonGallery == null) {
        break missingId;
      }

      id = R.id.buttonPindai;
      Button buttonPindai = ViewBindings.findChildViewById(rootView, id);
      if (buttonPindai == null) {
        break missingId;
      }

      id = R.id.img_preview_photo;
      ImageView imgPreviewPhoto = ViewBindings.findChildViewById(rootView, id);
      if (imgPreviewPhoto == null) {
        break missingId;
      }

      return new FragmentPindaiBinding((ConstraintLayout) rootView, buttonCamera, buttonGallery,
          buttonPindai, imgPreviewPhoto);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
