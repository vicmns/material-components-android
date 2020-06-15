/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

/**
 * A delegate interface for drawing the graphics in different drawable classes used in {@link
 * ProgressIndicator}.
 */
interface DrawingDelegate {

  /**
   * Prepares the bound of the canvas for the actual drawing. Should be called before any drawing.
   *
   * @param canvas Canvas to draw.
   * @param progressIndicator The component currently serving.
   * @param widthFraction A fraction representing how wide the drawing should be.
   */
  void adjustCanvas(
      @NonNull Canvas canvas,
      @NonNull ProgressIndicator progressIndicator,
      @FloatRange(from = 0.0, to = 1.0) float widthFraction);

  /**
   * Fills a part of the track with input color. The filling part is defined with two fractions
   * normalized to [0, 1] representing the start and the end of the track.
   *
   * @param canvas Canvas to draw.
   * @param paint Paint used to draw.
   * @param color The filled color.
   * @param startFraction A fraction representing where to start the drawing along the track.
   * @param endFraction A fraction representing where to end the drawing along the track.
   * @param trackWidth The width of the track in px.
   * @param cornerRadius The radius of corners in px, if rounded corners are applied.
   */
  void fillTrackWithColor(
      @NonNull Canvas canvas,
      @NonNull Paint paint,
      @ColorInt int color,
      @FloatRange(from = 0.0, to = 1.0) float startFraction,
      @FloatRange(from = 0.0, to = 1.0) float endFraction,
      float trackWidth,
      float cornerRadius);
}
