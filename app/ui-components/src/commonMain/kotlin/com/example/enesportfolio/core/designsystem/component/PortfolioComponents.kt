package com.example.enesportfolio.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.example.enesportfolio.core.designsystem.theme.Palette

@Composable
fun PortfolioCard(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(22.dp),
    contentPadding: PaddingValues = PaddingValues(22.dp),
    backgroundColor: Color = Palette.BackgroundElevated,
    borderColor: Color = Palette.Line,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = modifier
            .clip(shape)
            .background(backgroundColor)
            .border(1.dp, borderColor, shape)
            .padding(contentPadding),
    ) {
        content()
    }
}

@Composable
fun OverlineText(
    text: String,
    languageCode: String = "en",
    modifier: Modifier = Modifier,
) {
    Text(
        text = text.asOverline(languageCode),
        modifier = modifier,
        style = MaterialTheme.typography.labelLarge,
        color = Palette.Gold,
    )
}

internal fun String.asOverline(languageCode: String): String =
    when (languageCode.lowercase()) {
        "tr" -> replace('i', 'İ').replace('ı', 'I').uppercase()
        else -> uppercase()
    }

@Composable
fun SectionTitle(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.headlineLarge,
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ChipRow(
    chips: List<String>,
    modifier: Modifier = Modifier,
) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        chips.forEach { chip ->
            Text(
                text = chip,
                modifier = Modifier
                    .clip(RoundedCornerShape(999.dp))
                    .background(Palette.ChipBackground)
                    .border(1.dp, Palette.Line, RoundedCornerShape(999.dp))
                    .padding(horizontal = 11.dp, vertical = 6.dp),
                style = MaterialTheme.typography.bodySmall,
                color = Palette.Ink,
            )
        }
    }
}

@Composable
fun LanguageToggle(
    selected: String,
    onLanguageSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(999.dp))
            .background(Palette.BackgroundElevated)
            .border(1.dp, Palette.Line, RoundedCornerShape(999.dp))
            .padding(3.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        listOf("tr", "en").forEach { code ->
            val selectedLanguage = code == selected
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(999.dp))
                    .background(if (selectedLanguage) Palette.Ink else Color.Transparent)
                    .clickable { onLanguageSelected(code) }
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = code.uppercase(),
                    style = MaterialTheme.typography.labelMedium,
                    color = if (selectedLanguage) Palette.Background else Palette.Muted,
                )
            }
        }
    }
}

@Composable
fun StatusDot(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .size(16.dp)
                .clip(CircleShape)
                .background(Palette.MintGlow),
        )
        Box(
            modifier = modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(Palette.Mint),
        )
    }
}

@Composable
fun SocialLinkChip(
    label: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(999.dp))
            .hoverable(interactionSource)
            .background(if (hovered) Palette.BackgroundElevated2 else Palette.BackgroundElevated)
            .border(
                width = 1.dp,
                color = if (hovered) Palette.Violet.copy(alpha = 0.45f) else Palette.Line,
                shape = RoundedCornerShape(999.dp),
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 9.dp),
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(16.dp),
            tint = Palette.Ink,
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = Palette.Ink,
        )
    }
}

object SocialIcons {
    val LinkedIn: ImageVector
        get() = linkedInIcon
    val GitHub: ImageVector
        get() = githubIcon
    val Medium: ImageVector
        get() = mediumIcon
    val Email: ImageVector
        get() = emailIcon
    val Cv: ImageVector
        get() = cvIcon
}

private val linkedInIcon: ImageVector by lazy {
    imageVector("LinkedIn") {
        moveTo(6.5f, 9f)
        lineTo(3.7f, 9f)
        verticalLineToRelative(11.3f)
        horizontalLineToRelative(2.8f)
        close()
        moveTo(5.3f, 5.8f)
        arcToRelative(1.62f, 1.62f, 0f, false, false, -1.6f, -1.6f)
        arcToRelative(1.62f, 1.62f, 0f, false, false, -1.6f, 1.6f)
        arcToRelative(1.62f, 1.62f, 0f, false, false, 1.6f, 1.6f)
        arcToRelative(1.62f, 1.62f, 0f, false, false, 1.6f, -1.6f)
        close()
        moveTo(20.3f, 20.3f)
        horizontalLineToRelative(-2.8f)
        verticalLineToRelative(-5.5f)
        curveToRelative(0f, -1.3f, 0f, -3f, -1.8f, -3f)
        reflectiveCurveToRelative(-2.1f, 1.4f, -2.1f, 2.9f)
        verticalLineToRelative(5.6f)
        horizontalLineToRelative(-2.7f)
        verticalLineTo(9f)
        horizontalLineToRelative(2.7f)
        verticalLineToRelative(1.5f)
        horizontalLineToRelative(0.1f)
        curveToRelative(0.4f, -0.7f, 1.3f, -1.8f, 3.1f, -1.8f)
        curveToRelative(3.3f, 0f, 3.6f, 2.2f, 3.6f, 5f)
        verticalLineToRelative(6.6f)
        close()
    }
}

private val githubIcon: ImageVector by lazy {
    imageVector("GitHub") {
        moveTo(12f, 2f)
        arcTo(10f, 10f, 0f, false, false, 3.2f, 19.5f)
        curveToRelative(0.5f, 0.1f, 0.7f, -0.2f, 0.7f, -0.5f)
        verticalLineToRelative(-1.7f)
        curveToRelative(-2.8f, 0.6f, -3.4f, -1.2f, -3.4f, -1.2f)
        curveToRelative(-0.5f, -1.1f, -1.1f, -1.4f, -1.1f, -1.4f)
        curveToRelative(-0.9f, -0.6f, 0.1f, -0.6f, 0.1f, -0.6f)
        curveToRelative(1f, 0.1f, 1.5f, 1f, 1.5f, 1f)
        curveToRelative(0.9f, 1.5f, 2.4f, 1.1f, 3f, 0.8f)
        curveToRelative(0.1f, -0.6f, 0.4f, -1.1f, 0.6f, -1.3f)
        curveToRelative(-2.2f, -0.3f, -4.6f, -1.1f, -4.6f, -5f)
        arcToRelative(3.9f, 3.9f, 0f, false, true, 1f, -2.7f)
        arcToRelative(3.6f, 3.6f, 0f, false, true, 0.1f, -2.6f)
        reflectiveCurveToRelative(0.8f, -0.3f, 2.8f, 1f)
        arcToRelative(9.6f, 9.6f, 0f, false, true, 5f, 0f)
        curveToRelative(2f, -1.3f, 2.8f, -1f, 2.8f, -1f)
        arcToRelative(3.6f, 3.6f, 0f, false, true, 0.1f, 2.6f)
        arcToRelative(3.9f, 3.9f, 0f, false, true, 1f, 2.7f)
        curveToRelative(0f, 3.9f, -2.4f, 4.7f, -4.6f, 5f)
        curveToRelative(0.4f, 0.3f, 0.7f, 1f, 0.7f, 2f)
        verticalLineToRelative(2.3f)
        curveToRelative(0f, 0.3f, 0.2f, 0.6f, 0.7f, 0.5f)
        arcTo(10f, 10f, 0f, false, false, 12f, 2f)
        close()
    }
}

private val mediumIcon: ImageVector by lazy {
    imageVector("Medium") {
        moveTo(7.2f, 7.5f)
        arcToRelative(6.3f, 6.3f, 0f, true, false, 0f, 9f)
        arcToRelative(6.3f, 6.3f, 0f, false, false, 0f, -9f)
        close()
        moveTo(15.8f, 7.9f)
        curveToRelative(-1.8f, 0f, -3.3f, 2f, -3.3f, 4.6f)
        reflectiveCurveToRelative(1.5f, 4.6f, 3.3f, 4.6f)
        reflectiveCurveToRelative(3.3f, -2f, 3.3f, -4.6f)
        reflectiveCurveToRelative(-1.5f, -4.6f, -3.3f, -4.6f)
        close()
        moveTo(21f, 8.5f)
        curveToRelative(-0.7f, 0f, -1.2f, 1.8f, -1.2f, 4f)
        reflectiveCurveToRelative(0.5f, 4f, 1.2f, 4f)
        reflectiveCurveToRelative(1.2f, -1.8f, 1.2f, -4f)
        reflectiveCurveToRelative(-0.5f, -4f, -1.2f, -4f)
        close()
    }
}

private val emailIcon: ImageVector by lazy {
    imageVector("Email") {
        moveTo(4f, 6.5f)
        arcToRelative(1.5f, 1.5f, 0f, false, true, 1.5f, -1.5f)
        horizontalLineToRelative(13f)
        arcToRelative(1.5f, 1.5f, 0f, false, true, 1.5f, 1.5f)
        verticalLineToRelative(11f)
        arcToRelative(1.5f, 1.5f, 0f, false, true, -1.5f, 1.5f)
        horizontalLineToRelative(-13f)
        arcToRelative(1.5f, 1.5f, 0f, false, true, -1.5f, -1.5f)
        close()
        moveTo(6.2f, 7f)
        lineTo(12f, 11.1f)
        lineTo(17.8f, 7f)
        close()
        moveTo(18.5f, 8.3f)
        lineTo(12.8f, 12.3f)
        arcToRelative(1.5f, 1.5f, 0f, false, true, -1.6f, 0f)
        lineTo(5.5f, 8.3f)
        verticalLineToRelative(8.7f)
        horizontalLineToRelative(13f)
        close()
    }
}

private val cvIcon: ImageVector by lazy {
    imageVector("Cv") {
        moveTo(7f, 3.5f)
        arcToRelative(1.5f, 1.5f, 0f, false, false, -1.5f, 1.5f)
        verticalLineToRelative(14f)
        arcToRelative(1.5f, 1.5f, 0f, false, false, 1.5f, 1.5f)
        horizontalLineToRelative(10f)
        arcToRelative(1.5f, 1.5f, 0f, false, false, 1.5f, -1.5f)
        verticalLineTo(8.4f)
        lineTo(13.6f, 3.5f)
        close()
        moveTo(13f, 4.4f)
        lineTo(17.1f, 8.5f)
        horizontalLineTo(13f)
        close()
        moveTo(8.5f, 12f)
        horizontalLineToRelative(7f)
        verticalLineToRelative(1.3f)
        horizontalLineToRelative(-7f)
        close()
        moveTo(8.5f, 15f)
        horizontalLineToRelative(7f)
        verticalLineToRelative(1.3f)
        horizontalLineToRelative(-7f)
        close()
    }
}

private fun imageVector(
    name: String,
    block: androidx.compose.ui.graphics.vector.PathBuilder.() -> Unit,
): ImageVector =
    ImageVector.Builder(
        name = name,
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f,
    ).apply {
        path(
            fill = SolidColor(Color.Black),
            pathFillType = androidx.compose.ui.graphics.PathFillType.EvenOdd,
            pathBuilder = block,
        )
    }.build()
