package com.example.designsystem.icon


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val StarWarsIcon: ImageVector
    get() {
        if (_StarWars != null) {
            return _StarWars!!
        }
        _StarWars = ImageVector.Builder(
            name = "StarWars",
            defaultWidth = 2500.dp,
            defaultHeight = 2500.dp,
            viewportWidth = 192.76f,
            viewportHeight = 192.76f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(0f, 0f)
                horizontalLineToRelative(192.76f)
                verticalLineToRelative(192.76f)
                horizontalLineTo(0f)
                verticalLineTo(0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF000000)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(5.67f, 81.21f)
                verticalLineToRelative(12.65f)
                horizontalLineToRelative(37f)
                curveToRelative(4.3f, 0f, 9.8f, -3.98f, 9.8f, -10.56f)
                curveToRelative(0f, -2.65f, 1.01f, -4.37f, -2.1f, -7.87f)
                lineToRelative(-4.73f, -5.61f)
                curveToRelative(-2.71f, -2.53f, 0.32f, -2.53f, 2.6f, -2.53f)
                horizontalLineToRelative(15.62f)
                verticalLineToRelative(26.57f)
                horizontalLineToRelative(12.39f)
                lineTo(76.25f, 67.3f)
                horizontalLineToRelative(16.7f)
                lineTo(92.95f, 55.92f)
                lineTo(38.88f, 55.92f)
                curveToRelative(-6.58f, 0f, -9.8f, 6.32f, -9.61f, 9.61f)
                curveToRelative(0.18f, 3.29f, 0.79f, 7.43f, 6.25f, 12.4f)
                curveToRelative(4.99f, 4.53f, -2.47f, 3.29f, -3.22f, 3.29f)
                lineTo(5.67f, 81.22f)
                close()
                moveTo(120.35f, 55.92f)
                lineTo(100.36f, 55.92f)
                lineTo(89.15f, 93.87f)
                horizontalLineToRelative(12.47f)
                lineToRelative(2.02f, -5.31f)
                horizontalLineToRelative(13.16f)
                lineToRelative(1.95f, 5.31f)
                horizontalLineToRelative(12.22f)
                lineToRelative(-10.62f, -37.94f)
                close()
                moveTo(106.43f, 79.44f)
                lineToRelative(4.3f, -13.92f)
                lineToRelative(4.05f, 13.92f)
                horizontalLineToRelative(-8.35f)
                close()
                moveTo(170.44f, 81.21f)
                curveToRelative(-4.81f, 0f, -4.81f, -1.77f, -4.81f, -1.77f)
                curveToRelative(4.12f, 0f, 7.77f, -6f, 7.77f, -12.15f)
                reflectiveCurveToRelative(-6f, -11.38f, -10.81f, -11.38f)
                horizontalLineToRelative(-26.89f)
                verticalLineToRelative(37.94f)
                horizontalLineToRelative(13.66f)
                verticalLineToRelative(-12.65f)
                reflectiveCurveToRelative(5.82f, 6.83f, 8.85f, 9.61f)
                curveToRelative(3.04f, 2.78f, 3.29f, 3.04f, 7.41f, 3.04f)
                horizontalLineToRelative(21.45f)
                verticalLineToRelative(-12.65f)
                curveToRelative(0f, -0f, -11.83f, -0f, -16.64f, -0f)
                close()
                moveTo(158.04f, 72.36f)
                horizontalLineToRelative(-8.67f)
                verticalLineToRelative(-6.83f)
                horizontalLineToRelative(8.67f)
                curveToRelative(3.98f, 0f, 4.66f, 6.83f, 0f, 6.83f)
                close()
                moveTo(5.67f, 98.67f)
                horizontalLineToRelative(13.98f)
                lineToRelative(3.54f, 12.65f)
                lineToRelative(3.29f, -12.65f)
                horizontalLineToRelative(14.68f)
                lineToRelative(3.8f, 12.65f)
                lineToRelative(3.8f, -12.65f)
                horizontalLineToRelative(12.14f)
                lineToRelative(-11.13f, 37.95f)
                lineTo(38.62f, 136.63f)
                lineToRelative(-4.88f, -17.97f)
                lineToRelative(-5.5f, 17.97f)
                lineTo(16.86f, 136.63f)
                lineTo(5.67f, 98.67f)
                close()
                moveTo(89.58f, 98.89f)
                lineTo(69.59f, 98.89f)
                lineToRelative(-11.2f, 37.94f)
                horizontalLineToRelative(12.47f)
                lineToRelative(2.02f, -5.31f)
                horizontalLineToRelative(13.16f)
                lineToRelative(1.95f, 5.31f)
                horizontalLineToRelative(12.22f)
                lineTo(89.58f, 98.89f)
                close()
                moveTo(75.66f, 122.41f)
                lineToRelative(4.3f, -13.92f)
                lineToRelative(4.05f, 13.92f)
                horizontalLineToRelative(-8.35f)
                close()
                moveTo(170.7f, 110.06f)
                curveToRelative(-2.28f, 0f, -4.76f, 0.27f, -2.04f, 2.8f)
                lineToRelative(4.73f, 5.61f)
                curveToRelative(3.11f, 3.5f, 3.06f, 4.96f, 3.06f, 7.61f)
                curveToRelative(0f, 6.58f, -6.51f, 10.56f, -10.81f, 10.56f)
                lineToRelative(-29.9f, 0.2f)
                curveToRelative(-4.12f, 0f, -4.37f, -0.25f, -7.41f, -3.04f)
                curveToRelative(-3.04f, -2.78f, -8.85f, -9.61f, -8.85f, -9.61f)
                verticalLineToRelative(12.65f)
                horizontalLineToRelative(-13.66f)
                lineTo(105.82f, 98.88f)
                horizontalLineToRelative(26.89f)
                curveToRelative(4.81f, 0f, 10.81f, 5.23f, 10.81f, 11.38f)
                curveToRelative(0f, 6.14f, -3.65f, 12.15f, -7.77f, 12.15f)
                curveToRelative(0f, 0f, 1.81f, 1.82f, 4.85f, 1.82f)
                curveToRelative(3.04f, 0f, 14.73f, 0.01f, 14.73f, 0.01f)
                curveToRelative(0.75f, 0f, 8.2f, 1.24f, 3.22f, -3.29f)
                curveToRelative(-5.47f, -4.97f, -6.07f, -9.11f, -6.25f, -12.4f)
                reflectiveCurveToRelative(2.66f, -9.88f, 9.24f, -9.88f)
                horizontalLineToRelative(25.57f)
                verticalLineToRelative(11.39f)
                horizontalLineToRelative(-16.39f)
                verticalLineToRelative(-0f)
                close()
                moveTo(128.15f, 115.32f)
                horizontalLineToRelative(-8.67f)
                verticalLineToRelative(-6.83f)
                horizontalLineToRelative(8.67f)
                curveToRelative(3.98f, 0f, 4.66f, 6.83f, 0f, 6.83f)
                close()
            }
        }.build()

        return _StarWars!!
    }

@Suppress("ObjectPropertyName")
private var _StarWars: ImageVector? = null
