package com.example.designsystem.icon


import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val Icon_Dark_Vaider: ImageVector
    get() {
        if (_DarkVeider != null) {
            return _DarkVeider!!
        }
        _DarkVeider = ImageVector.Builder(
            name = "DarkVeider",
            defaultWidth = 38.dp,
            defaultHeight = 38.dp,
            viewportWidth = 45f,
            viewportHeight = 45f
        ).apply {
            path(fill = SolidColor(Color(0xFF303030))) {
                moveTo(22.55f, 30.229f)
                lineToRelative(-0.994f, 1.29f)
                lineToRelative(0f, 3.969f)
                lineToRelative(1.192f, 0f)
                lineToRelative(0f, -5.26f)
                close()
            }
            path(fill = SolidColor(Color(0xFF303030))) {
                moveTo(23.348f, 30.229f)
                horizontalLineToRelative(1.252f)
                verticalLineToRelative(5.26f)
                horizontalLineToRelative(-1.252f)
                close()
            }
            path(fill = SolidColor(Color(0xFF303030))) {
                moveTo(27.091f, 32.342f)
                verticalLineToRelative(3.147f)
                horizontalLineToRelative(0.949f)
                curveToRelative(-0.003f, -0.04f, -0.012f, -0.078f, -0.012f, -0.119f)
                curveToRelative(0f, -0.462f, 0.184f, -0.879f, 0.478f, -1.19f)
                lineTo(27.091f, 32.342f)
                close()
            }
            path(fill = SolidColor(Color(0xFF303030))) {
                moveTo(29.765f, 35.37f)
                moveToRelative(-1.137f, 0f)
                arcToRelative(1.137f, 1.137f, 0f, isMoreThanHalf = true, isPositiveArc = true, 2.274f, 0f)
                arcToRelative(1.137f, 1.137f, 0f, isMoreThanHalf = true, isPositiveArc = true, -2.274f, 0f)
            }
            path(fill = SolidColor(Color(0xFF303030))) {
                moveTo(18.249f, 35.37f)
                moveToRelative(-1.137f, 0f)
                arcToRelative(1.137f, 1.137f, 0f, isMoreThanHalf = true, isPositiveArc = true, 2.274f, 0f)
                arcToRelative(1.137f, 1.137f, 0f, isMoreThanHalf = true, isPositiveArc = true, -2.274f, 0f)
            }
            path(fill = SolidColor(Color(0xFF303030))) {
                moveTo(22.702f, 27.9f)
                lineToRelative(0f, 1.73f)
                lineToRelative(2.611f, 0f)
                lineToRelative(0f, -1.648f)
                lineToRelative(-1.259f, -1.248f)
                close()
            }
            path(fill = SolidColor(Color(0xFF303030))) {
                moveTo(25.465f, 30.229f)
                lineToRelative(-0.266f, 0f)
                lineToRelative(0f, 5.26f)
                lineToRelative(1.292f, 0f)
                lineToRelative(0f, -3.926f)
                close()
            }
            path(fill = SolidColor(Color(0xFF303030))) {
                moveTo(20.957f, 35.489f)
                verticalLineTo(32.298f)
                lineToRelative(-1.449f, 1.882f)
                curveToRelative(0.295f, 0.311f, 0.478f, 0.729f, 0.478f, 1.19f)
                curveToRelative(0f, 0.041f, -0.009f, 0.079f, -0.012f, 0.119f)
                horizontalLineTo(20.957f)
                close()
            }
            path(fill = SolidColor(Color(0xFF303030))) {
                moveTo(28.188f, 36.089f)
                horizontalLineToRelative(-8.362f)
                curveToRelative(-0.151f, 0.331f, -0.405f, 0.602f, -0.719f, 0.783f)
                lineToRelative(5.086f, 4.307f)
                lineToRelative(2.979f, -2.775f)
                curveToRelative(0.002f, -0.002f, 0.003f, -0.003f, 0.005f, -0.004f)
                lineToRelative(1.673f, -1.559f)
                curveTo(28.561f, 36.66f, 28.331f, 36.4f, 28.188f, 36.089f)
                close()
            }
            path(fill = SolidColor(Color(0xFF303030))) {
                moveTo(25.415f, 6.821f)
                horizontalLineToRelative(-2.485f)
                curveToRelative(-0.16f, 0f, -0.29f, 0.13f, -0.29f, 0.29f)
                verticalLineToRelative(11.817f)
                horizontalLineToRelative(3.064f)
                verticalLineTo(7.111f)
                curveTo(25.705f, 6.951f, 25.575f, 6.821f, 25.415f, 6.821f)
                close()
            }
            path(fill = SolidColor(Color(0xFF303030))) {
                moveTo(26.368f, 7.926f)
                curveToRelative(-0.023f, -0.005f, -0.041f, 0.012f, -0.064f, 0.012f)
                curveToRelative(0f, 0f, 0.001f, 0.483f, 0f, 0.589f)
                verticalLineToRelative(1.503f)
                curveToRelative(0.732f, 0.168f, 2.96f, 0.732f, 3.958f, 1.581f)
                curveToRelative(0.126f, 0.107f, 0.142f, 0.297f, 0.034f, 0.423f)
                curveToRelative(-0.06f, 0.07f, -0.144f, 0.105f, -0.229f, 0.105f)
                curveToRelative(-0.069f, 0f, -0.138f, -0.023f, -0.194f, -0.071f)
                curveToRelative(-0.836f, -0.712f, -2.769f, -1.23f, -3.569f, -1.421f)
                verticalLineToRelative(7.089f)
                curveToRelative(0f, 0f, 0.017f, -0.001f, 0.029f, -0.004f)
                curveToRelative(5.315f, -1.317f, 8.494f, 1.932f, 9.658f, 3.462f)
                curveToRelative(0f, 0f, 0.344f, 0.476f, 0.553f, 0.86f)
                curveTo(36.625f, 21.118f, 37.31f, 10.146f, 26.368f, 7.926f)
                close()
            }
            path(fill = SolidColor(Color(0xFF303030))) {
                moveTo(11.922f, 21.615f)
                curveToRelative(0f, 0f, 0.409f, -0.648f, 0.624f, -0.93f)
                curveToRelative(1.164f, -1.409f, 4.112f, -4.014f, 9.404f, -2.904f)
                curveToRelative(0.039f, 0.008f, 0.09f, 0.023f, 0.09f, 0.023f)
                verticalLineToRelative(-7.152f)
                curveToRelative(-0.87f, 0.299f, -3.57f, 1.376f, -4.722f, 3.545f)
                curveToRelative(-0.054f, 0.102f, -0.158f, 0.16f, -0.266f, 0.16f)
                curveToRelative(-0.047f, 0f, -0.095f, -0.012f, -0.14f, -0.035f)
                curveToRelative(-0.146f, -0.078f, -0.202f, -0.259f, -0.125f, -0.406f)
                curveToRelative(1.372f, -2.582f, 4.598f, -3.694f, 5.252f, -3.897f)
                verticalLineToRelative(-1.46f)
                verticalLineTo(7.951f)
                curveTo(20.752f, 8.196f, 11.945f, 10.29f, 11.922f, 21.615f)
                close()
                moveTo(16.458f, 15.646f)
                lineToRelative(-0.472f, 0.886f)
                curveToRelative(-0.054f, 0.101f, -0.158f, 0.159f, -0.265f, 0.159f)
                curveToRelative(-0.047f, 0f, -0.096f, -0.012f, -0.141f, -0.036f)
                curveToRelative(-0.146f, -0.078f, -0.202f, -0.26f, -0.124f, -0.406f)
                lineToRelative(0.472f, -0.886f)
                curveToRelative(0.077f, -0.146f, 0.258f, -0.203f, 0.406f, -0.124f)
                curveTo(16.48f, 15.318f, 16.536f, 15.5f, 16.458f, 15.646f)
                close()
            }
            path(fill = SolidColor(Color(0xFF303030))) {
                moveTo(11.922f, 21.615f)
                lineToRelative(0.624f, -0.93f)
                curveTo(12.331f, 20.967f, 11.922f, 21.615f, 11.922f, 21.615f)
                close()
            }
            path(fill = SolidColor(Color(0xFF303030))) {
                moveTo(36.545f, 22.056f)
                curveToRelative(-0.209f, -0.384f, -0.553f, -0.86f, -0.553f, -0.86f)
                lineTo(36.545f, 22.056f)
                close()
            }
            path(fill = SolidColor(Color(0xFF303030))) {
                moveTo(26.304f, 7.938f)
                verticalLineToRelative(0.589f)
                curveTo(26.306f, 8.421f, 26.304f, 7.938f, 26.304f, 7.938f)
                close()
            }
            path(fill = SolidColor(Color(0xFF303030))) {
                moveTo(39.251f, 34.165f)
                curveToRelative(-0.278f, 0.106f, -0.752f, 0.277f, -1.328f, 0.45f)
                curveToRelative(-0.001f, 0f, -0.001f, 0.002f, -0.003f, 0.002f)
                curveToRelative(-0.003f, 0.001f, -0.006f, 0.001f, -0.009f, 0.001f)
                curveToRelative(-0.929f, 0.278f, -2.11f, 0.556f, -3.13f, 0.556f)
                curveToRelative(-0.166f, 0f, -0.3f, -0.134f, -0.3f, -0.3f)
                reflectiveCurveToRelative(0.134f, -0.3f, 0.3f, -0.3f)
                curveToRelative(0.847f, 0f, 1.838f, -0.215f, 2.676f, -0.451f)
                lineToRelative(-2.401f, -7.932f)
                curveToRelative(-0.048f, -0.159f, 0.041f, -0.326f, 0.2f, -0.374f)
                curveToRelative(0.158f, -0.048f, 0.326f, 0.042f, 0.374f, 0.2f)
                lineToRelative(2.402f, 7.934f)
                curveToRelative(0.592f, -0.187f, 1.035f, -0.358f, 1.19f, -0.419f)
                lineToRelative(0.569f, -0.208f)
                curveToRelative(-0.028f, -0.176f, -0.045f, -0.347f, -0.093f, -0.531f)
                lineToRelative(-2.495f, -8.495f)
                curveToRelative(-0.076f, -0.258f, -0.189f, -0.502f, -0.337f, -0.726f)
                lineToRelative(-0.903f, -1.367f)
                curveToRelative(-0.234f, -0.411f, -3.245f, -5.435f, -9.485f, -3.889f)
                curveToRelative(-0.062f, 0.016f, -0.174f, 0.063f, -0.174f, 0.063f)
                verticalLineToRelative(0.85f)
                curveToRelative(0f, 0.166f, -0.134f, 0.3f, -0.3f, 0.3f)
                horizontalLineToRelative(-3.664f)
                curveToRelative(-0.166f, 0f, -0.3f, -0.134f, -0.3f, -0.3f)
                verticalLineToRelative(-0.807f)
                curveToRelative(0f, 0f, -0.137f, -0.038f, -0.213f, -0.054f)
                curveToRelative(-6.452f, -1.347f, -9.086f, 2.98f, -9.323f, 3.395f)
                lineToRelative(-0.95f, 1.39f)
                curveToRelative(-0.118f, 0.173f, -0.209f, 0.362f, -0.269f, 0.562f)
                lineToRelative(-2.946f, 9.704f)
                lineToRelative(0.57f, 0.187f)
                curveToRelative(0.306f, 0.115f, 0.86f, 0.312f, 1.514f, 0.5f)
                lineToRelative(2.449f, -8.088f)
                curveToRelative(0.047f, -0.158f, 0.218f, -0.249f, 0.374f, -0.2f)
                curveToRelative(0.159f, 0.048f, 0.248f, 0.215f, 0.2f, 0.374f)
                lineToRelative(-2.443f, 8.069f)
                curveToRelative(0.71f, 0.176f, 1.479f, 0.314f, 2.156f, 0.314f)
                curveToRelative(0.166f, 0f, 0.3f, 0.134f, 0.3f, 0.3f)
                reflectiveCurveToRelative(-0.134f, 0.3f, -0.3f, 0.3f)
                curveToRelative(-1.604f, 0f, -4.752f, -1.097f, -4.975f, -1.166f)
                curveToRelative(-0.059f, 0.366f, -0.08f, 0.998f, 0.274f, 1.672f)
                curveToRelative(0.486f, 0.926f, 1.499f, 1.601f, 3.031f, 2.013f)
                curveToRelative(0.038f, 0.008f, 3.884f, 0.742f, 8.935f, 1.08f)
                lineToRelative(-0.776f, -0.657f)
                lineToRelative(-1.213f, -1.028f)
                curveToRelative(-0.062f, 0.007f, -0.122f, 0.019f, -0.185f, 0.019f)
                curveToRelative(-0.958f, 0f, -1.737f, -0.779f, -1.737f, -1.737f)
                curveToRelative(0f, -0.408f, 0.147f, -0.778f, 0.383f, -1.074f)
                lineToRelative(-2.031f, -3.168f)
                curveToRelative(-0.089f, -0.14f, -0.049f, -0.325f, 0.09f, -0.415f)
                curveToRelative(0.14f, -0.091f, 0.325f, -0.049f, 0.415f, 0.09f)
                lineToRelative(1.98f, 3.089f)
                curveToRelative(0.263f, -0.161f, 0.569f, -0.259f, 0.9f, -0.259f)
                curveToRelative(0.28f, 0f, 0.54f, 0.073f, 0.774f, 0.191f)
                lineToRelative(3.078f, -3.997f)
                verticalLineToRelative(-2.065f)
                curveToRelative(0.036f, -0.079f, 0.068f, -0.148f, 0.104f, -0.227f)
                lineToRelative(1.666f, -1.437f)
                curveToRelative(0.119f, -0.102f, 0.296f, -0.096f, 0.407f, 0.014f)
                lineToRelative(1.544f, 1.531f)
                curveToRelative(0.031f, 0.074f, 0.058f, 0.139f, 0.088f, 0.212f)
                verticalLineToRelative(1.972f)
                lineToRelative(3.078f, 3.997f)
                curveToRelative(0.234f, -0.118f, 0.495f, -0.191f, 0.775f, -0.191f)
                curveToRelative(0.331f, 0f, 0.636f, 0.098f, 0.9f, 0.259f)
                lineToRelative(1.981f, -3.089f)
                curveToRelative(0.089f, -0.138f, 0.275f, -0.18f, 0.415f, -0.09f)
                curveToRelative(0.139f, 0.089f, 0.18f, 0.275f, 0.09f, 0.415f)
                lineToRelative(-2.032f, 3.168f)
                curveToRelative(0.236f, 0.297f, 0.383f, 0.667f, 0.383f, 1.074f)
                curveToRelative(0f, 0.958f, -0.779f, 1.737f, -1.736f, 1.737f)
                curveToRelative(-0.099f, 0f, -0.195f, -0.013f, -0.29f, -0.029f)
                lineToRelative(-1.273f, 1.186f)
                lineToRelative(-0.683f, 0.636f)
                curveToRelative(3.396f, -0.104f, 6.411f, -0.51f, 8.925f, -1.206f)
                curveToRelative(0.079f, -0.013f, 1.945f, -0.333f, 2.894f, -1.788f)
                curveToRelative(0.365f, -0.559f, 0.524f, -1.213f, 0.511f, -1.938f)
                lineTo(39.251f, 34.165f)
                close()
                moveTo(23.057f, 23.665f)
                curveToRelative(-0.058f, 0.519f, -0.258f, 0.994f, -0.56f, 1.391f)
                curveToRelative(-0.002f, 0.004f, 0f, 0.008f, -0.002f, 0.011f)
                curveToRelative(-0.076f, 0.121f, -1.868f, 2.909f, -5.698f, 2.909f)
                curveToRelative(-0.062f, 0f, -0.125f, -0.001f, -0.188f, -0.002f)
                curveToRelative(-0.166f, -0.004f, -0.297f, -0.141f, -0.293f, -0.307f)
                curveToRelative(0.004f, -0.164f, 0.137f, -0.293f, 0.3f, -0.293f)
                curveToRelative(0.002f, 0f, 0.005f, 0f, 0.007f, 0f)
                curveToRelative(1.767f, 0.05f, 3.064f, -0.544f, 3.942f, -1.18f)
                curveToRelative(-0.659f, 0.156f, -1.341f, 0.213f, -1.98f, 0.213f)
                curveToRelative(-1.564f, 0f, -2.872f, -0.334f, -2.955f, -0.356f)
                curveToRelative(-0.79f, -0.387f, -1.224f, -0.886f, -1.349f, -1.503f)
                curveToRelative(-0.211f, -1.041f, 0.526f, -2.099f, 0.985f, -2.636f)
                curveToRelative(0.144f, -0.169f, 0.304f, -0.317f, 0.476f, -0.442f)
                curveToRelative(1.934f, -1.413f, 4f, -1.151f, 5.394f, -0.683f)
                curveTo(22.375f, 21.202f, 23.183f, 22.413f, 23.057f, 23.665f)
                close()
                moveTo(34.233f, 24.547f)
                curveToRelative(-0.125f, 0.618f, -0.56f, 1.116f, -1.291f, 1.482f)
                curveToRelative(-0.122f, 0.036f, -1.449f, 0.376f, -3.023f, 0.376f)
                curveToRelative(-0.612f, 0f, -1.261f, -0.054f, -1.891f, -0.195f)
                curveToRelative(0.85f, 0.604f, 2.078f, 1.165f, 3.725f, 1.165f)
                curveToRelative(0.057f, 0f, 0.114f, -0f, 0.173f, -0.002f)
                curveToRelative(0.002f, 0f, 0.004f, 0f, 0.007f, 0f)
                curveToRelative(0.163f, 0f, 0.296f, 0.129f, 0.3f, 0.293f)
                curveToRelative(0.004f, 0.166f, -0.127f, 0.303f, -0.293f, 0.307f)
                curveToRelative(-0.063f, 0.001f, -0.125f, 0.002f, -0.188f, 0.002f)
                curveToRelative(-3.291f, 0f, -5.073f, -2.054f, -5.559f, -2.71f)
                curveToRelative(-0.399f, -0.427f, -0.666f, -0.967f, -0.732f, -1.556f)
                curveToRelative(-0.131f, -1.297f, 0.677f, -2.509f, 1.916f, -2.925f)
                curveToRelative(1.394f, -0.469f, 3.46f, -0.73f, 5.395f, 0.684f)
                curveToRelative(0.17f, 0.124f, 0.331f, 0.272f, 0.476f, 0.441f)
                curveTo(33.707f, 22.448f, 34.444f, 23.506f, 34.233f, 24.547f)
                close()
            }
        }.build()

        return _DarkVeider!!
    }

@Suppress("ObjectPropertyName")
private var _DarkVeider: ImageVector? = null
// ... your existing code ...

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun DarkVeiderPreview() {
    Icon(
        imageVector = Icon_Dark_Vaider,
        contentDescription = "Dark Veider Icon",
        tint =Color.Black // You can set a tint for preview if needed
    )
}