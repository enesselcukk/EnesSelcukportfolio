package com.example.enesportfolio.feature.portfolio.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.enesportfolio.core.designsystem.component.OverlineText
import com.example.enesportfolio.core.designsystem.component.SocialIcons
import com.example.enesportfolio.core.designsystem.component.SocialLinkChip
import com.example.enesportfolio.core.designsystem.component.StatusDot
import com.example.enesportfolio.core.designsystem.theme.Palette
import com.example.enesportfolio.core.designsystem.theme.PortfolioFonts
import com.example.enesportfolio.core.model.Links
import com.example.enesportfolio.core.model.PortfolioCopy
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.Res
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.avatar
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun HeroSection(
    copy: PortfolioCopy,
    languageCode: String,
    onOpenLink: (String) -> Unit,
    onDownloadCv: () -> Unit,
    modifier: Modifier = Modifier,
) {
    BoxWithConstraints(modifier = modifier.fillMaxWidth()) {
        val stacked = maxWidth < PortfolioLayout.StackBreakpoint
        val compactHero = maxWidth < PortfolioLayout.CompactBreakpoint
        val portraitWidth = if (stacked) {
            minOf(maxWidth * 0.54f, 200.dp)
        } else {
            minOf(maxWidth * 0.72f, 320.dp)
        }
        if (stacked) {
            Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
                PortraitBlock(caption = copy.portraitCaption, width = portraitWidth)
                HeroCopy(
                    copy = copy,
                    languageCode = languageCode,
                    onOpenLink = onOpenLink,
                    onDownloadCv = onDownloadCv,
                    compact = compactHero,
                )
            }
        } else {
            Row(
                horizontalArrangement = Arrangement.spacedBy(32.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                HeroCopy(
                    copy = copy,
                    languageCode = languageCode,
                    onOpenLink = onOpenLink,
                    onDownloadCv = onDownloadCv,
                    modifier = Modifier.weight(1.2f),
                )
                PortraitBlock(
                    caption = copy.portraitCaption,
                    width = portraitWidth,
                    modifier = Modifier.weight(0.72f),
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun HeroCopy(
    copy: PortfolioCopy,
    languageCode: String,
    onOpenLink: (String) -> Unit,
    onDownloadCv: () -> Unit,
    modifier: Modifier = Modifier,
    compact: Boolean = false,
) {
    BoxWithConstraints(modifier = modifier) {
        val titleSize = if (compact) {
            (maxWidth.value * 0.14f).coerceIn(43f, 64f).sp
        } else {
            (maxWidth.value * 0.084f).coerceIn(51f, 102f).sp
        }
        val roleSize = (maxWidth.value * 0.02f).coerceIn(17f, 20.5f).sp
        val serif = PortfolioFonts.serifFamily
        val sans = PortfolioFonts.sansFamily

        Column {
            OverlineText(copy.heroOverline, languageCode = languageCode)
            Text(
                text = "Enes Selçuk",
                style = TextStyle(
                    fontFamily = serif,
                    fontWeight = FontWeight.Medium,
                    fontSize = titleSize,
                    lineHeight = titleSize * 0.92f,
                    letterSpacing = titleSize * -0.045f,
                    color = Palette.Ink,
                ),
                modifier = Modifier.padding(top = 7.dp),
            )
            Text(
                text = copy.heroRole,
                style = TextStyle(
                    fontFamily = sans,
                    fontWeight = FontWeight.Medium,
                    fontSize = roleSize,
                    lineHeight = roleSize * 1.2f,
                    color = Palette.Mint,
                ),
                modifier = Modifier.padding(top = 17.dp),
            )
            Text(
                text = copy.heroLede,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 14.dp).widthIn(max = 608.dp),
            )
            FlowRow(
                modifier = Modifier.padding(top = 26.dp),
                horizontalArrangement = Arrangement.spacedBy(9.dp),
                verticalArrangement = Arrangement.spacedBy(9.dp),
            ) {
                SocialLinkChip("LinkedIn", SocialIcons.LinkedIn, onClick = { onOpenLink(Links.LinkedIn) })
                SocialLinkChip("GitHub", SocialIcons.GitHub, onClick = { onOpenLink(Links.GitHub) })
                SocialLinkChip("Medium", SocialIcons.Medium, onClick = { onOpenLink(Links.Medium) })
                SocialLinkChip("Email", SocialIcons.Email, onClick = { onOpenLink(Links.Email) })
                SocialLinkChip(copy.downloadCv, SocialIcons.Cv, onClick = onDownloadCv)
            }
        }
    }
}

@Composable
private fun PortraitBlock(
    caption: String,
    width: Dp,
    modifier: Modifier = Modifier,
) {
    val shape = portraitShape(width)
    Column(
        modifier = modifier.width(width),
        horizontalAlignment = Alignment.Start,
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .offset(x = 18.dp, y = 22.dp)
                    .clip(shape)
                    .background(Palette.GoldGlow),
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(shape)
                    .background(Palette.VioletGlow)
                    .padding(8.dp),
            ) {
                Image(
                    painter = painterResource(Res.drawable.avatar),
                    contentDescription = "Portrait of Enes Selçuk",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape)
                        .border(1.dp, Palette.Line, shape),
                    contentScale = ContentScale.Crop,
                )
            }
        }
        Row(
            modifier = Modifier.padding(top = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            StatusDot()
            Text(
                text = caption,
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 13.8.sp),
                color = Palette.Muted,
            )
        }
    }
}

private fun portraitShape(size: Dp) = RoundedCornerShape(
    topStart = size * 0.28f,
    topEnd = size * 0.12f,
    bottomEnd = size * 0.32f,
    bottomStart = size * 0.16f,
)
