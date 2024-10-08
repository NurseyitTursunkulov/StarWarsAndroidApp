/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.myapplication.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.designsystem.icon.Icon_Dark_Vaider
import com.example.designsystem.icon.Icon_Light_Vader
import com.example.designsystem.icon.AppIcons
import com.example.myapplication.R
import com.example.actors.R as actorsR
import com.example.films.R as filmsR

/**
 * Type for the top level destinations in the application. Each of these destinations
 * can contain one or more screens (based on the window size). Navigation from one screen to the
 * next within a single destination will be handled directly in composables.
 */
enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    ACTORS(
        selectedIcon = Icon_Dark_Vaider,
        unselectedIcon = Icon_Light_Vader,
        iconTextId = actorsR.string.actors_title,
        titleTextId = R.string.app_name,
    ),
    INTERESTS(
        selectedIcon = AppIcons.Grid3x3,
        unselectedIcon = AppIcons.Grid3x3,
        iconTextId = filmsR.string.films_interests_title,
        titleTextId = filmsR.string.films_interests_title,
    ),
}
