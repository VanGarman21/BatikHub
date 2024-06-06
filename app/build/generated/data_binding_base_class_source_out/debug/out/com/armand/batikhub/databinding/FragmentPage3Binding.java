// Generated by view binder compiler. Do not edit!
package com.armand.batikhub.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armand.batikhub.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentPage3Binding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonFinish;

  @NonNull
  public final Button buttonPrevious;

  private FragmentPage3Binding(@NonNull ConstraintLayout rootView, @NonNull Button buttonFinish,
      @NonNull Button buttonPrevious) {
    this.rootView = rootView;
    this.buttonFinish = buttonFinish;
    this.buttonPrevious = buttonPrevious;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentPage3Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentPage3Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_page3, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentPage3Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonFinish;
      Button buttonFinish = ViewBindings.findChildViewById(rootView, id);
      if (buttonFinish == null) {
        break missingId;
      }

      id = R.id.buttonPrevious;
      Button buttonPrevious = ViewBindings.findChildViewById(rootView, id);
      if (buttonPrevious == null) {
        break missingId;
      }

      return new FragmentPage3Binding((ConstraintLayout) rootView, buttonFinish, buttonPrevious);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
